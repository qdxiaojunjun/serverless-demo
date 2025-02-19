/* eslint-disable arrow-body-style */
/* eslint-disable no-param-reassign */
/* eslint-disable no-underscore-dangle */
const ListConsumerTransformStream = require('./ListConsumerTransformStream');
const SummaryConsumer = require('./SummaryConsumer');
const {
  checkExpression,
  processValue,
  formatValue,
} = require('./analyzeUtils');

class AnalyzeTransformStream extends ListConsumerTransformStream {
  constructor(
    {
      rowDelimiter = '\n',
      colDelimiter = ' ',
      targetRowDelimiter = '\n',
      targetColDelimiter = ',',
      targetSetHeader,
      columns,
      where,
      select,
      groupBy,
      having,
      orderBy,
      limit,
      destroySource = () => null,
      ...args
    },
    ...resArgs
  ) {
    super(args, ...resArgs);
    Object.assign(this, {
      rowDelimiter,
      colDelimiter,
      targetRowDelimiter,
      targetColDelimiter,
      targetSetHeader,
      columns,
      where,
      select: select || columns,
      groupBy,
      having,
      orderBy,
      limit,
      destroySource,
      lineCount: 0,
      summaryConsumer: null,
    });
    this.initSummaryConsumer();
  }
  initSummaryConsumer() {
    const { select, groupBy, having, orderBy, limit } = this;
    if (groupBy || orderBy) {
      this.summaryConsumer = new SummaryConsumer({
        select,
        groupBy,
        having,
        orderBy,
        limit,
        processValue: (...args) => this.processValue(...args),
        formatValue: (...args) => this.formatValue(...args),
        getFilterResults: (...args) => this.getFilterResults(...args),
      });
    }
  }
  processValue({ process, value }) {
    process = process || [];
    return process.reduce((res, processItem) => {
      return processValue({
        value: res,
        process: processItem,
      });
    }, value);
  }
  formatValue({ format, value }) {
    format = format || [];
    return format.reduce((res, formatItem) => {
      return formatValue({
        value: res,
        format: formatItem,
      });
    }, value);
  }
  checkFilterExpression(
    item,
    { expression, key, process, params, not = false },
  ) {
    if (params !== null && params !== undefined) {
      if (!(params instanceof Array)) {
        params = [params];
      }
    }
    if (expression === 'and') {
      return params.every(param => this.checkFilterExpression(item, param));
    }
    if (expression === 'or') {
      return params.some(param => this.checkFilterExpression(item, param));
    }
    const value = this.processValue({ process, value: item[key] });
    const allow = checkExpression({ value, params, expression });
    return not ? !allow : allow;
  }
  getFilterResults({ filter, list = [] }) {
    if (!filter) {
      return list;
    }
    return list.filter(item => this.checkFilterExpression(item, filter));
  }
  getContent({ columns = [], list = [] }) {
    if (this.limit && this.lineCount + list.length > this.limit) {
      list = list.slice(0, this.limit - this.lineCount);
      process.nextTick(() => this.destroySource());
    }
    if (list.length === 0) {
      return '';
    }
    this.lineCount += list.length;
    const { targetRowDelimiter, targetColDelimiter } = this;
    const rows = list.map((item) => {
      const cols = columns.map(({ key, ...args }) => {
        if (args.format) {
          return this.formatValue({ ...args, value: item[key] });
        }
        return this.processValue({ ...args, value: item[key] });
      });
      return cols.join(targetColDelimiter);
    });
    return rows.join(targetRowDelimiter) + targetRowDelimiter;
  }
  _presetList(list) {
    return list;
  }
  _getListContent(list) {
    list = this._presetList(list);
    const filterResults = this.getFilterResults({
      filter: this.where,
      list,
    });
    if (this.summaryConsumer) {
      this.summaryConsumer.consume({
        list: filterResults,
      });
      return '';
    }
    return this.getContent({
      columns: this.select,
      list: filterResults,
    });
  }
  _getFinalContent() {
    if (this.summaryConsumer) {
      const { columns, list } = this.summaryConsumer.getResult();
      return this.getContent({ columns, list });
    }
    return null;
  }
}

module.exports = AnalyzeTransformStream;

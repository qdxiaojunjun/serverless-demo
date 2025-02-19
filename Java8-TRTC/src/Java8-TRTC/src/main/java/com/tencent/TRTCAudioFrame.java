/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.tencent;

public class TRTCAudioFrame {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected TRTCAudioFrame(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(TRTCAudioFrame obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        trtcenginewarperJNI.delete_TRTCAudioFrame(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setAudioFormat(TRTCAudioFrameFormat value) {
    trtcenginewarperJNI.TRTCAudioFrame_audioFormat_set(swigCPtr, this, value.swigValue());
  }

  public TRTCAudioFrameFormat getAudioFormat() {
    return TRTCAudioFrameFormat.swigToEnum(trtcenginewarperJNI.TRTCAudioFrame_audioFormat_get(swigCPtr, this));
  }

  public void setData(byte[] value) {
    trtcenginewarperJNI.TRTCAudioFrame_data_set(swigCPtr, this, value);
  }

  public byte[] getData() {
    return trtcenginewarperJNI.TRTCAudioFrame_data_get(swigCPtr, this);
}

  public void setLength(long value) {
    trtcenginewarperJNI.TRTCAudioFrame_length_set(swigCPtr, this, value);
  }

  public long getLength() {
    return trtcenginewarperJNI.TRTCAudioFrame_length_get(swigCPtr, this);
  }

  public void setSampleRate(long value) {
    trtcenginewarperJNI.TRTCAudioFrame_sampleRate_set(swigCPtr, this, value);
  }

  public long getSampleRate() {
    return trtcenginewarperJNI.TRTCAudioFrame_sampleRate_get(swigCPtr, this);
  }

  public void setChannel(long value) {
    trtcenginewarperJNI.TRTCAudioFrame_channel_set(swigCPtr, this, value);
  }

  public long getChannel() {
    return trtcenginewarperJNI.TRTCAudioFrame_channel_get(swigCPtr, this);
  }

  public void setTimestamp(java.math.BigInteger value) {
    trtcenginewarperJNI.TRTCAudioFrame_timestamp_set(swigCPtr, this, value);
  }

  public java.math.BigInteger getTimestamp() {
    return trtcenginewarperJNI.TRTCAudioFrame_timestamp_get(swigCPtr, this);
  }

  public TRTCAudioFrame() {
    this(trtcenginewarperJNI.new_TRTCAudioFrame(), true);
  }

  public void initData(int data_length_init) {
    trtcenginewarperJNI.TRTCAudioFrame_initData(swigCPtr, this, data_length_init);
  }

  public void uninitData(int data_length_uninit) {
    trtcenginewarperJNI.TRTCAudioFrame_uninitData(swigCPtr, this, data_length_uninit);
  }

}

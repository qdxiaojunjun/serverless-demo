/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.tencent;

public final class TRTCVideoResolutionMode {
  public final static TRTCVideoResolutionMode TRTCVideoResolutionModeLandscape = new TRTCVideoResolutionMode("TRTCVideoResolutionModeLandscape", 0);
  public final static TRTCVideoResolutionMode TRTCVideoResolutionModePortrait = new TRTCVideoResolutionMode("TRTCVideoResolutionModePortrait", 1);

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static TRTCVideoResolutionMode swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + TRTCVideoResolutionMode.class + " with value " + swigValue);
  }

  private TRTCVideoResolutionMode(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private TRTCVideoResolutionMode(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private TRTCVideoResolutionMode(String swigName, TRTCVideoResolutionMode swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static TRTCVideoResolutionMode[] swigValues = { TRTCVideoResolutionModeLandscape, TRTCVideoResolutionModePortrait };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}


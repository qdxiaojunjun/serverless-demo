/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.tencent;

public class ITRTCVideoRecvCallback {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ITRTCVideoRecvCallback(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ITRTCVideoRecvCallback obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        trtcenginewarperJNI.delete_ITRTCVideoRecvCallback(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  protected void swigDirectorDisconnect() {
    swigCMemOwn = false;
    delete();
  }

  public void swigReleaseOwnership() {
    swigCMemOwn = false;
    trtcenginewarperJNI.ITRTCVideoRecvCallback_change_ownership(this, swigCPtr, false);
  }

  public void swigTakeOwnership() {
    swigCMemOwn = true;
    trtcenginewarperJNI.ITRTCVideoRecvCallback_change_ownership(this, swigCPtr, true);
  }

  public void onRecvVideoFrame(String userId, TRTCVideoStreamType streamType, TRTCVideoFrame frame) {
    if (getClass() == ITRTCVideoRecvCallback.class) trtcenginewarperJNI.ITRTCVideoRecvCallback_onRecvVideoFrame(swigCPtr, this, userId, streamType.swigValue(), TRTCVideoFrame.getCPtr(frame), frame); else trtcenginewarperJNI.ITRTCVideoRecvCallback_onRecvVideoFrameSwigExplicitITRTCVideoRecvCallback(swigCPtr, this, userId, streamType.swigValue(), TRTCVideoFrame.getCPtr(frame), frame);
  }

  public ITRTCVideoRecvCallback() {
    this(trtcenginewarperJNI.new_ITRTCVideoRecvCallback(), true);
    trtcenginewarperJNI.ITRTCVideoRecvCallback_director_connect(this, swigCPtr, swigCMemOwn, true);
  }

}

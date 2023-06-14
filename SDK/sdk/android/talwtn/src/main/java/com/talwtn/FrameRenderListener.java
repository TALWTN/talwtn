package com.talwtn;

import org.webrtc.VideoFrame;

public interface FrameRenderListener{
    void onFirstFrameRendered();
    void onFrame(VideoFrame frame);
    public void onFrameResolutionChanged(int videoWidth, int videoHeight, int rotation);
}


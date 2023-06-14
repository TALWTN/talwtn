package com.talwtn;

import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

import org.webrtc.EglBase;
import org.webrtc.EglRenderer.FrameListener;
import org.webrtc.GlRectDrawer;
import org.webrtc.Logging;
import org.webrtc.RendererCommon.GlDrawer;
import org.webrtc.RendererCommon.RendererEvents;
import org.webrtc.RendererCommon.ScalingType;
import org.webrtc.RendererCommon.VideoLayoutMeasure;
import org.webrtc.SurfaceEglRenderer;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.VideoTrack;


public class SurfaceHolderWrapper implements Callback, VideoSink, RendererEvents {

    private SurfaceHolder mHolder;
    private static final String TAG = "SurfaceHolderWarpper";
    private final String resourceName = "";
    private final VideoLayoutMeasure videoLayoutMeasure = new VideoLayoutMeasure();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private final SurfaceEglRenderer eglRenderer;
    private RendererEvents rendererEvents;
    private int rotatedFrameWidth;
    private int rotatedFrameHeight;
    private boolean enableFixedSize;
    private int surfaceWidth;
    private int surfaceHeight;
    private VideoTrack videoTrack;


    public SurfaceHolderWrapper(SurfaceHolder holder){
        mHolder = holder;
        this.eglRenderer = new SurfaceEglRenderer(this.resourceName);
        mHolder.addCallback(this);
        mHolder.addCallback(this.eglRenderer);
    }

    private RendererEvents mRenderEvents = new RendererEvents() {
        @Override
        public void onFirstFrameRendered() {
            if(mFrameRenderListener!=null){
                mFrameRenderListener.onFirstFrameRendered();
            }
        }

        @Override
        public void onFrameResolutionChanged(int i, int i1, int i2) {
            if(mFrameRenderListener!=null){
                mFrameRenderListener.onFrameResolutionChanged(i,i1,i2);
            }
        }
    };


    public void init(org.webrtc.EglBase.Context sharedContext, FrameRenderListener listener) {
        mFrameRenderListener = listener;
        this.init(sharedContext, mRenderEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());

    }

    public void init(org.webrtc.EglBase.Context sharedContext, RendererEvents rendererEvents, int[] configAttributes, GlDrawer drawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(sharedContext, this, configAttributes, drawer);
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void addFrameListener(FrameListener listener, float scale, GlDrawer drawerParam) {
        this.eglRenderer.addFrameListener(listener, scale, drawerParam);
    }

    public void addFrameListener(FrameListener listener, float scale) {
        this.eglRenderer.addFrameListener(listener, scale);
    }

    public void removeFrameListener(FrameListener listener) {
        this.eglRenderer.removeFrameListener(listener);
    }

    public void setEnableHardwareScaler(boolean enabled) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = enabled;
    }

    public void setMirror(boolean mirror) {
        this.eglRenderer.setMirror(mirror);
    }

    public void setScalingType(ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        // this.eglRenderer.scalingType = scalingType;
    }

    public void setScalingType(ScalingType scalingTypeMatchOrientation, ScalingType scalingTypeMismatchOrientation) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingTypeMatchOrientation, scalingTypeMismatchOrientation);
    }

    public void setFpsReduction(float fps) {
        this.eglRenderer.setFpsReduction(fps);
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void onFrame(VideoFrame frame) {
        this.eglRenderer.onFrame(frame);
        if(mFrameRenderListener!=null){
            mFrameRenderListener.onFrame(frame);
        }
    }



    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((float)(right - left) / (float)(bottom - top));
    }


    public void surfaceCreated(SurfaceHolder holder) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceWidth = this.surfaceHeight = 0;
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        surfaceWidth = width;
        surfaceHeight = height;
    }

    private String getResourceName() {
        return "";
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void onFirstFrameRendered() {
        if (this.rendererEvents != null) {
            this.rendererEvents.onFirstFrameRendered();
        }

    }

    public void onFrameResolutionChanged(int videoWidth, int videoHeight, int rotation) {
        if (this.rendererEvents != null) {
            this.rendererEvents.onFrameResolutionChanged(videoWidth, videoHeight, rotation);
        }

        final int rotatedWidth = rotation != 0 && rotation != 180 ? videoHeight : videoWidth;
        final int rotatedHeight = rotation != 0 && rotation != 180 ? videoWidth : videoHeight;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                SurfaceHolderWrapper.this.rotatedFrameWidth = rotatedWidth;
                SurfaceHolderWrapper.this.rotatedFrameHeight = rotatedHeight;
                //SurfaceHolderWarpper.this.updateSurfaceSize();
            }
        });
    }

    private void logD(String string) {
        Logging.d("SurfaceViewRenderer", this.resourceName + ": " + string);
    }


    public void setVideoTrack(VideoTrack videoTrack) {
        VideoTrack oldValue = this.videoTrack;

        if (oldValue != videoTrack) {
            if (oldValue != null) {
                removeRendererFromVideoTrack();
            }
            if (null == videoTrack)
                release();
            this.videoTrack = videoTrack;

            if (videoTrack != null) {
                videoTrack.addSink(this);
            }
        }
    }

    private void removeRendererFromVideoTrack() {
        if (null != videoTrack) {
            videoTrack.removeSink(this);
            videoTrack = null;
        }
        //release();
    }


    /**
     * listener
     * */

    private FrameRenderListener mFrameRenderListener;
    public void setFrameRenderListener(FrameRenderListener listener){
        mFrameRenderListener = listener;
    }
}


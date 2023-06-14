/*
 * Copyright 2022 Beijing TAL Technology Ltd. All Rights Reserved.
 * SPDX-license-identifier: BSD-3-Clause
 */
package com.eaydu.talwtn.demo.publish;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eaydu.talwtn.demo.engine.EngineHelper;
import com.talwtn.AudioFrame;
import com.talwtn.EncodedVideoFrame;
import com.talwtn.Publisher;
import com.eaydu.talwtn.demo.utils.Logger;
import com.talwtn.RTCAudioStats;
import com.talwtn.RTCVideoStats;
import com.talwtn.RtcDefines;
import com.talwtn.RtcEventHandler;
import com.talwtn.StallInfo;
import com.talwtn.VideoConfig;
import com.talwtn.VideoFrame;
import com.talwtn.internal.RtcEventHandlerImpl;

public class PublishViewModel extends ViewModel {
    private static final String TAG = "PushViewModel";

    final MutableLiveData<Boolean> micStatus = new MutableLiveData<>(true);
    final MutableLiveData<Boolean> cameraStatus = new MutableLiveData<>(true);

    /**
     * 记录开始推送的时间，限制 Demo 体验时间使用
     */
    long publishStartTime = 0;

    private String mStreamId;

    /**
     * 是否发布成功
     * 基于目前的交互逻辑；已经设置的情况下，不会主动设置为 False
     */
    final MutableLiveData<Boolean> isPublishSuccess = new MutableLiveData<>(false);

    final MutableLiveData<PublishEvent> events = new MutableLiveData<>();

    @Nullable
    private Publisher publisher;

    public boolean isPublishing() {
        return publisher != null && publisher.isPublishing();
    }

    boolean micPermission = false;
    boolean cameraPermission = false;

    public void toggleMic() {
        if (!micPermission) {
            return;
        }
        if (micStatus.getValue() == Boolean.TRUE) {
            // Change to False
            micStatus.postValue(false);

            if (publisher != null) publisher.stopAudioCapture();
        } else {
            // Change to True
            micStatus.postValue(true);

            if (publisher != null) publisher.startAudioCapture();
        }
    }

    public void toggleMicCamera() {
        if (!cameraPermission) {
            return;
        }
        if (cameraStatus.getValue() == Boolean.TRUE) {
            // Change to False
            cameraStatus.postValue(false);

            if (publisher != null) publisher.stopVideoCapture();
        } else {
            // Change to True
            cameraStatus.postValue(true);

            if (publisher != null) publisher.startVideoCapture();
        }
    }

    public void updatePermission(boolean cameraPermission, boolean micPermission) {
        this.cameraPermission = cameraPermission;
        this.micPermission = micPermission;

        Logger.d(TAG, "updatePermission: camera=" + cameraPermission + "; micPermission=" + micPermission);
        if (cameraPermission) {
            if (cameraStatus.getValue() == Boolean.TRUE && publisher != null) {
                Logger.d(TAG, "updatePermission: startVideoCapture");
                publisher.startVideoCapture();
            }
        } else {
            cameraStatus.postValue(false);
        }

        if (micPermission) {
            if (micStatus.getValue() == Boolean.TRUE && publisher != null) {
                publisher.startAudioCapture();
            }
        } else {
            micStatus.postValue(false);
        }
    }

    public void initPublisher(Context context, String streamId, View remoteView) {
        if (publisher == null) {
            //publisher = Publisher.create(context, publisherEventHandler);
            publisher = EngineHelper.createPublisher(streamId, publisherEventHandler);
            VideoConfig videoConfig = new VideoConfig();
            videoConfig.width = 640;
            videoConfig.height = 480;
            videoConfig.maxFPS = 15;
            publisher.setVideoConfig(videoConfig);
        }
        mStreamId = streamId;
        publisher.setLocalView(remoteView);
    }

    public void startPublish(String publishUrl) {
        if (publisher != null && !publisher.isPublishing()) {
            publisher.startPublish(publishUrl);

            publishStartTime = SystemClock.uptimeMillis();
        }
    }

    public void switchCamera() {
        if (publisher != null) {
            publisher.switchCamera();
        }
    }

    public void stopPublish() {
        if (publisher != null) {
            publisher.stopPublish();
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        stopPublish();

        EngineHelper.destroyPublisher(mStreamId, publisher);

    }


    private static class RtcEventHandlerImpl extends RtcEventHandler {

        public PublishViewModel mModel = null;
        public RtcEventHandlerImpl(PublishViewModel model) {
            mModel = model;
        }
        @Override
        public void onPublishStateChanged(String streamId, RtcDefines.State state, RtcDefines.Reason reason) {
            super.onPublishStateChanged(streamId, state, reason);
            Logger.d(TAG, "onPublishStateChanged: state=" + state + "; reason=" + reason);
            mModel.events.postValue(new PublishEvent(state, reason));
            if (state == RtcDefines.State.StartSuccess) {
                mModel.isPublishSuccess.postValue(true);
            }
        }

        @Override
        public void onSubscribeStateChanged(String streamId, RtcDefines.State state, RtcDefines.Reason reason) {
            super.onSubscribeStateChanged(streamId, state, reason);
        }

        @Override
        public void onLocalStats(String streamId, RTCAudioStats audioStats, RTCVideoStats videoStats) {
            super.onLocalStats(streamId, audioStats, videoStats);
        }

        @Override
        public void onMuteAudioSuccess(String streamId) {
            super.onMuteAudioSuccess(streamId);
        }

        @Override
        public void onMuteAudioFailed(String streamId, RtcDefines.Reason reason) {
            super.onMuteAudioFailed(streamId, reason);
        }

        @Override
        public void onMuteVideoSuccess(String streamId) {
            super.onMuteVideoSuccess(streamId);
        }

        @Override
        public void onMuteVideoFailed(String streamId, RtcDefines.Reason reason) {
            super.onMuteVideoFailed(streamId, reason);
        }

        @Override
        public void onRemoteStats(String streamId, RTCAudioStats audioStats, RTCVideoStats videoStats) {
            super.onRemoteStats(streamId, audioStats, videoStats);
        }

        @Override
        public void onFirstRemoteVideoFrameRendered(String streamId) {
            super.onFirstRemoteVideoFrameRendered(streamId);
        }

        @Override
        public void onStallInfo(String streamId, StallInfo stallInfo) {
            super.onStallInfo(streamId, stallInfo);
        }

        @Override
        public void onEncodedVideoFrame(String streamId, EncodedVideoFrame encodedFrame) {
            super.onEncodedVideoFrame(streamId, encodedFrame);
        }

        @Override
        public void onVideoFrame(String streamId, VideoFrame videoFrame) {
            super.onVideoFrame(streamId, videoFrame);
        }

        @Override
        public void onAudioFrame(String streamId, AudioFrame audioFrame) {
            super.onAudioFrame(streamId, audioFrame);
        }
    }

    private final RtcEventHandlerImpl publisherEventHandler = new RtcEventHandlerImpl(this);

    //  private final RtcEventHandlerImpl publisherEventHandler = new RtcEventHandler() {


//        @Override
//        public void onPublishStateChanged(PublishState state, Reason reason) {
//            Logger.d(TAG, "onPublishStateChanged: state=" + state + "; reason=" + reason);
//            events.postValue(new PublishEvent(state, reason));
//            if (state == PublishState.StartPublishSuccess) {
//                isPublishSuccess.postValue(true);
//            }
//        }
//    };
}

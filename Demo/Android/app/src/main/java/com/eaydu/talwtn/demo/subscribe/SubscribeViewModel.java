/*
 * Copyright 2022 Beijing TAL Technology Ltd. All Rights Reserved.
 * SPDX-license-identifier: BSD-3-Clause
 */
package com.eaydu.talwtn.demo.subscribe;

import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eaydu.talwtn.demo.engine.EngineHelper;
import com.talwtn.AudioFrame;
import com.talwtn.EncodedVideoFrame;
import com.talwtn.RTCAudioStats;
import com.talwtn.RTCVideoStats;
import com.talwtn.RtcDefines;
import com.talwtn.RtcEventHandler;
import com.talwtn.StallInfo;
import com.talwtn.Subscriber;
import com.eaydu.talwtn.demo.utils.Logger;
import com.talwtn.VideoFrame;

public class SubscribeViewModel extends ViewModel {
    private static final String TAG = "SubscriberVM";

    /**
     * 输入 URL 模式
     */
    public static final int MODE_INPUT = 0;
    /**
     * 订阅成功，显示远端视频流页面
     */
    public static final int MODE_SUBSCRIBE = 2;
    /**
     * 订阅错误，显示重试页面
     */
    public static final int MODE_ERROR = 4;

    final MutableLiveData<Integer> viewMode = new MutableLiveData<>(MODE_INPUT);

    final MutableLiveData<SubscribeEvent> events = new MutableLiveData<>();

    @Nullable
    private Subscriber subscriber;

    @Nullable
    private String subscribeUrl;

    private String mStreamId;

    public void initSubscribe(Context context, String streamId, View remoteView) {

        mStreamId = streamId;
        subscriber = EngineHelper.createSubscriber(streamId, handler);
        //subscriber = Subscriber.create(context, eventHandler);
        subscriber.setRemoteView(remoteView);
    }

    public void startSubscribe(String url) {
        subscribeUrl = url;
        if (subscriber != null) {
            subscriber.startSubscribe(url);
        }
    }

    public void resumeSubscribe() {
        if (subscriber != null && subscribeUrl != null) {
            subscriber.startSubscribe(subscribeUrl);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (subscriber != null) {
            subscriber.stopSubscribe();
            //subscriber.destroy();
        }

        EngineHelper.destroySubscriber(mStreamId, subscriber);
    }


    public static class RtcEventHandlerImpl extends RtcEventHandler {

        private SubscribeViewModel mModel;
        public RtcEventHandlerImpl(SubscribeViewModel m) {
            mModel = m;
        }
        @Override
        public void onPublishStateChanged(String streamId, RtcDefines.State state, RtcDefines.Reason reason) {
            super.onPublishStateChanged(streamId, state, reason);
        }

        @Override
        public void onSubscribeStateChanged(String streamId, RtcDefines.State state, RtcDefines.Reason reason) {
            super.onSubscribeStateChanged(streamId, state, reason);
            Logger.d(TAG, "onSubscribeStateChanged: state=" + state + "; reason=" + reason);
            mModel.events.postValue(new SubscribeEvent(state, reason));
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


    final RtcEventHandler handler = new RtcEventHandlerImpl(this);

//    final SubscriberEventHandler eventHandler = new SubscriberEventHandler() {
//
//        @Override
//        public void onSubscribeStateChanged(SubscribeState state, Reason reason) {
//            Logger.d(TAG, "onSubscribeStateChanged: state=" + state + "; reason=" + reason);
//            events.postValue(new SubscribeEvent(state, reason));
//        }
//    };

    public boolean isSubscribing() {
        return subscriber != null && subscriber.isSubscribed();
    }

    /**
     * 停止拉流，不在接受后续的消息
     */
    public void stopSubscribe() {
        if (subscriber != null) {
            subscriber.stopSubscribe();
        }
    }
}

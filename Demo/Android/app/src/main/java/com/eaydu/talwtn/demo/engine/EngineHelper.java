package com.eaydu.talwtn.demo.engine;

import android.content.Context;

import androidx.annotation.NonNull;

import com.talwtn.AudioFrame;
import com.talwtn.EncodedVideoFrame;
import com.talwtn.PubExtraParam;
import com.talwtn.Publisher;
import com.talwtn.RTCAudioStats;
import com.talwtn.RTCVideoStats;
import com.talwtn.RtcDefines;
import com.talwtn.RtcEngine;
import com.talwtn.RtcEventHandler;
import com.talwtn.StallInfo;
import com.talwtn.SubExtraParam;
import com.talwtn.Subscriber;
import com.talwtn.VideoFrame;

import java.util.ArrayList;
import java.util.HashMap;

public class EngineHelper {
    public static RtcEngine engine = null;

    public static RtcEventHandlerImpl rtcEventHandler = new RtcEventHandlerImpl();

    public static void initEngine(Context context) {
        engine = RtcEngine.createRtcEngine(context, rtcEventHandler);
    }


    public static final HashMap<String, RtcEventHandler> handlers = new HashMap<String, RtcEventHandler>();


    public static Publisher createPublisher(String streamId, RtcEventHandler handler) {
        handlers.put(streamId, handler);
        return engine.createPublisher(new PubExtraParam());
    }


    public static Subscriber createSubscriber(String streamId, RtcEventHandler handler) {
        handlers.put(streamId, handler);
        return engine.createSubscriber(new SubExtraParam());
    }


    public static void destroyPublisher(String streamId, Publisher publisher) {
        engine.destroyPublisher(publisher);
        handlers.remove(streamId);
    }

    public static void destroySubscriber(String streamId, Subscriber subscriber) {
        engine.destroySubscriber(subscriber);
        handlers.remove(streamId);
    }

    public static class RtcEventHandlerImpl extends RtcEventHandler {

        @Override
        public void onPublishStateChanged(String streamId, RtcDefines.State state, RtcDefines.Reason reason) {
            super.onPublishStateChanged(streamId, state, reason);

            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onPublishStateChanged(streamId, state, reason);
            }
        }

        @Override
        public void onSubscribeStateChanged(String streamId, RtcDefines.State state, RtcDefines.Reason reason) {
            super.onSubscribeStateChanged(streamId, state, reason);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onSubscribeStateChanged(streamId, state, reason);
            }
        }

        @Override
        public void onLocalStats(String streamId, RTCAudioStats audioStats, RTCVideoStats videoStats) {
            super.onLocalStats(streamId, audioStats, videoStats);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onLocalStats(streamId, audioStats, videoStats);
            }
        }

        @Override
        public void onMuteAudioSuccess(String streamId) {
            super.onMuteAudioSuccess(streamId);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onMuteAudioSuccess(streamId);
            }
        }

        @Override
        public void onMuteAudioFailed(String streamId, RtcDefines.Reason reason) {
            super.onMuteAudioFailed(streamId, reason);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onMuteAudioFailed(streamId, reason);
            }
        }

        @Override
        public void onMuteVideoSuccess(String streamId) {
            super.onMuteVideoSuccess(streamId);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onMuteVideoSuccess(streamId);
            }
        }

        @Override
        public void onMuteVideoFailed(String streamId, RtcDefines.Reason reason) {
            super.onMuteVideoFailed(streamId, reason);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onMuteVideoFailed(streamId, reason);
            }
        }

        @Override
        public void onRemoteStats(String streamId, RTCAudioStats audioStats, RTCVideoStats videoStats) {
            super.onRemoteStats(streamId, audioStats, videoStats);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onRemoteStats(streamId, audioStats, videoStats);
            }
        }

        @Override
        public void onFirstRemoteVideoFrameRendered(String streamId) {
            super.onFirstRemoteVideoFrameRendered(streamId);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onFirstRemoteVideoFrameRendered(streamId);
            }
        }

        @Override
        public void onStallInfo(String streamId, StallInfo stallInfo) {
            super.onStallInfo(streamId, stallInfo);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onStallInfo(streamId, stallInfo);
            }
        }

        @Override
        public void onEncodedVideoFrame(String streamId, EncodedVideoFrame encodedFrame) {
            super.onEncodedVideoFrame(streamId, encodedFrame);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onEncodedVideoFrame(streamId, encodedFrame);
            }
        }

        @Override
        public void onVideoFrame(String streamId, VideoFrame videoFrame) {
            super.onVideoFrame(streamId, videoFrame);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onVideoFrame(streamId, videoFrame);
            }
        }

        @Override
        public void onAudioFrame(String streamId, AudioFrame audioFrame) {
            super.onAudioFrame(streamId, audioFrame);
            RtcEventHandler handler = handlers.get(streamId);
            if(handler != null) {
                handler.onAudioFrame(streamId, audioFrame);
            }
        }
    }
}

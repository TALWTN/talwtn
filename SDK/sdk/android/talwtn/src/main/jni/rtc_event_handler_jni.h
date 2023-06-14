/*
 *  Copyright 2022 Beijing Volcanoengine Technology Ltd. All Rights Reserved.
 *
 *  SPDX-license-identifier: BSD-3-Clause
 */

#ifndef DEMO_RTC_EVENT_HANDLER_JNI_H
#define TALWTNDEMO_RTC_EVENT_HANDLER_JNI_H


#include <jni.h>
#include <memory>

#include "wtn_interface.h"
#include "sdk/android/src/jni/jni_helpers.h"

namespace webrtc {
namespace jni {

class RtcEventHandler : public talwtn::IRtcEventHandler {
public:
    RtcEventHandler(JNIEnv *env,
                    const webrtc::JavaParamRef<jobject> &j_board_event_handler);

    ~RtcEventHandler();

    void OnPublishStateChanged(const char *stream_id, talwtn::State state,
                               talwtn::Reason reason) override;

    void OnLocalStats(const char *stream_id, talwtn::RTCAudioStats audio_stats,
                      talwtn::RTCVideoStats video_stats) override;

    void OnMuteAudioSuccess(const char *stream_id) override;

    void OnMuteAudioFailed(const char *stream_id, talwtn::Reason reason) override;

    void OnMuteVideoSuccess(const char *stream_id) override;

    void OnMuteVideoFailed(const char *stream_id, talwtn::Reason reason) override;

    void OnSubscribeStateChanged(const char *stream_id, talwtn::State state,
                                 talwtn::Reason reason) override;

    void OnRemoteStats(const char *stream_id, talwtn::RTCAudioStats audio_stats,
                       talwtn::RTCVideoStats video_stats) override;

    void OnFirstRemoteVideoFrameRendered(const char *stream_id) override;

    void OnStallInfo(const char *stream_id, talwtn::StallInfo stall_info) override;

    void OnEncodedVideoFrame(const char *stream_id,
                             talwtn::EncodedVideoFrame encodedFrame) override;

    void OnVideoFrame(const char *stream_id,
                      talwtn::VideoFrame video_frame) override;

    void OnAudioFrame(const char *stream_id,
                      talwtn::AudioFrame audio_frame) override;

private:
    webrtc::ScopedJavaGlobalRef<jobject> j_handler_;
};

}
}


#endif //TALWTNDEMO_RTC_EVENT_HANDLER_JNI_H

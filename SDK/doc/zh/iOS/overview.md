# 方法
## 发布

| 方法 | 描述 |
| --- | --- |
| [startVideoCapture](api.md#TALWTNPublisher-startvideocapture) | 开启摄像头采集。默认为关闭状态。  <br> |
| [stopVideoCapture](api.md#TALWTNPublisher-stopvideocapture) | 关闭摄像头采集。 |
| [switchCamera](api.md#TALWTNPublisher-switchcamera) | 切换摄像头采集时使用的前置/后置摄像头。 |
| [startAudioCapture](api.md#TALWTNPublisher-startaudiocapture) | 开启麦克风采集。默认为关闭状态。  <br> |
| [stopAudioCapture](api.md#TALWTNPublisher-stopaudiocapture) | 关闭麦克风采集。 |
| [stopPublish](api.md#TALWTNPublisher-stoppublish) | 停止发布音视频流 |
| [isPublishing](api.md#TALWTNPublisher-ispublishing) | 查询音视频流发布状态 |

## 订阅

| 方法 | 描述 |
| --- | --- |
| [stopSubscribe](api.md#TALWTNSubscriber-stopsubscribe) | 停止订阅音视频流 |
| [isSubscribed](api.md#TALWTNSubscriber-issubscribed) | 查询音视频流订阅状态 |

# 回调
## 发布

| 回调 | 描述 |
| --- | --- |
| [onLocalStats:audioStats:videoStats:](callback.md#TALWTNEngineDelegate-onlocalstats-audiostats-videostats) | 发布流状态的周期回调，周期1秒。 |
| [onPublishStateChanged:publishState:reason:](callback.md#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason) | 音视频流的发布状态发生改变时，收到此回调。 |
| [onMuteAudioSuccess:](callback.md#TALWTNEngineDelegate-onmuteaudiosuccess) | Mute 音频成功回调。 |
| [onMuteAudioFailed:reason:](callback.md#TALWTNEngineDelegate-onmuteaudiofailed-reason) | Mute 音频失败回调。 |
| [onMuteVideoSuccess:](callback.md#TALWTNEngineDelegate-onmutevideosuccess) | Mute 视频成功回调。 |
| [onMuteVideoFailed:reason:](callback.md#TALWTNEngineDelegate-onmutevideofailed-reason) | Mute 视频失败回调。 |

## 订阅

| 回调 | 描述 |
| --- | --- |
| [onRemoteStats:audioStats:videoStats:](callback.md#TALWTNEngineDelegate-onremotestats-audiostats-videostats) | 订阅流状态的周期回调，周期1秒。 |
| [onSubscribeStateChanged:subscribeState:reason:](callback.md#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason) | 音视频流的订阅状态发生改变时，收到此回调。 |
| [onFirstRemoteVideoFrameRendered:](callback.md#TALWTNEngineDelegate-onfirstremotevideoframerendered) | 订阅的远端视频流的首帧完成渲染时，收到此回调。 |
| [onVideoFrame:frame:](callback.md#TALWTNEngineDelegate-onvideoframe-frame) | 编码视频帧周期回调。周期是帧率的倒数。 |
| [onAudioFrame:frame:](callback.md#TALWTNEngineDelegate-onaudioframe-frame) | 音频帧回调。周期是 10ms。 |
| [onEncodedVideoFrame:frame:](callback.md#TALWTNEngineDelegate-onencodedvideoframe-frame) | 编码视频帧周期回调。周期是帧率的倒数。 |
| [onStallInfo:stallInfo:](callback.md#TALWTNEngineDelegate-onstallinfo-stallinfo) | 卡顿信息回调，周期1秒。 |


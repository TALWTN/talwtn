# API
## Publish

| API | Description |
| --- | --- |
| [startVideoCapture](api.md#TALWTNPublisher-startvideocapture) | Enable video capture. The default setting is off.   <br> |
| [stopVideoCapture](api.md#TALWTNPublisher-stopvideocapture) | Stop video capture. |
| [switchCamera](api.md#TALWTNPublisher-switchcamera) | Switch the camera for video capture between front-facing/back-facing cameras. |
| [startAudioCapture](api.md#TALWTNPublisher-startaudiocapture) | Start audio capture. The default is off. |
| [stopAudioCapture](api.md#TALWTNPublisher-stopaudiocapture) | Stop audio capture. |
| [stopPublish](api.md#TALWTNPublisher-stoppublish) | Stops publishing the media stream. |
| [isPublishing](api.md#TALWTNPublisher-ispublishing) | Inspect the media stream publishing status. |

## Subscribe

| API | Description |
| --- | --- |
| [stopSubscribe](api.md#TALWTNSubscriber-stopsubscribe) | Stop subscribing to the media stream. |
| [isSubscribed](api.md#TALWTNSubscriber-issubscribed) | Inspect the subscribing state. |

# Callback
## Publish

| Callback | Description |
| --- | --- |
| [onLocalStats:audioStats:videoStats:](callback.md#TALWTNEngineDelegate-onlocalstats-audiostats-videostats) | Periodic callback of the stats of locally published stream in every second. |
| [onPublishStateChanged:publishState:reason:](callback.md#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason) | Callback of media stream publishing state change. |
| [onMuteAudioSuccess:](callback.md#TALWTNEngineDelegate-onmuteaudiosuccess) | Success to mute audio callback. |
| [onMuteAudioFailed:reason:](callback.md#TALWTNEngineDelegate-onmuteaudiofailed-reason) | Failure to mute audio callback. |
| [onMuteVideoSuccess:](callback.md#TALWTNEngineDelegate-onmutevideosuccess) | Success to mute video callback. |
| [onMuteVideoFailed:reason:](callback.md#TALWTNEngineDelegate-onmutevideofailed-reason) | Failure to mute video callback. |

## Subscribe

| Callback | Description |
| --- | --- |
| [onRemoteStats:audioStats:videoStats:](callback.md#TALWTNEngineDelegate-onremotestats-audiostats-videostats) | Periodic callback of the stats of the subscribed remote stream in every second. |
| [onSubscribeStateChanged:subscribeState:reason:](callback.md#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason) | Callback of media stream subscribing state change. |
| [onFirstRemoteVideoFrameRendered:](callback.md#TALWTNEngineDelegate-onfirstremotevideoframerendered) | Receive the callback when the first frame of the subscribed remote frame is rendered. |
| [onVideoFrame:frame:](callback.md#TALWTNEngineDelegate-onvideoframe-frame) | Periodic encoded video frame callback. The period is the reciprocal of the framerate. |
| [onAudioFrame:frame:](callback.md#TALWTNEngineDelegate-onaudioframe-frame) | Periodic audio frame callback in every 10ms. |
| [onEncodedVideoFrame:frame:](callback.md#TALWTNEngineDelegate-onencodedvideoframe-frame) | Periodic encoded video frame callback. The period is the reciprocal of the framerate. |
| [onStallInfo:stallInfo:](callback.md#TALWTNEngineDelegate-onstallinfo-stallinfo) | Periodic callback of the stall information in every second. |


# TALWTNEngineDelegate
```objectivec
@protocol TALWTNEngineDelegate <NSObject>
```

Event handler for engine (include pub & sub)


## Member Functions

| Return | Name |
| --- | --- |
| **void** | [onPublishStateChanged:publishState:reason:](#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason) |
| **void** | [onLocalStats:audioStats:videoStats:](#TALWTNEngineDelegate-onlocalstats-audiostats-videostats) |
| **void** | [onMuteAudioSuccess:](#TALWTNEngineDelegate-onmuteaudiosuccess) |
| **void** | [onMuteAudioFailed:reason:](#TALWTNEngineDelegate-onmuteaudiofailed-reason) |
| **void** | [onMuteVideoSuccess:](#TALWTNEngineDelegate-onmutevideosuccess) |
| **void** | [onMuteVideoFailed:reason:](#TALWTNEngineDelegate-onmutevideofailed-reason) |
| **void** | [onSubscribeStateChanged:subscribeState:reason:](#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason) |
| **void** | [onRemoteStats:audioStats:videoStats:](#TALWTNEngineDelegate-onremotestats-audiostats-videostats) |
| **void** | [onFirstRemoteVideoFrameRendered:](#TALWTNEngineDelegate-onfirstremotevideoframerendered) |
| **void** | [onStallInfo:stallInfo:](#TALWTNEngineDelegate-onstallinfo-stallinfo) |
| **void** | [onEncodedVideoFrame:frame:](#TALWTNEngineDelegate-onencodedvideoframe-frame) |
| **void** | [onVideoFrame:frame:](#TALWTNEngineDelegate-onvideoframe-frame) |
| **void** | [onAudioFrame:frame:](#TALWTNEngineDelegate-onaudioframe-frame) |


## Instructions
<span id="TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason"></span>
### onPublishStateChanged:publishState:reason:
```objectivec

- (void)onPublishStateChanged:(NSString*)stream_id publishState:(TALWTNState)state reason:(TALWTNReason)reason;
```
Callback of media stream publishing state change.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | stream ID |
| state | **TALWTNState** | The current state. See [TALWTNState](keytype.md#talwtnstate). |
| reason | **TALWTNReason** | Error code for the change. See [TALWTNReason](keytype.md#talwtnreason). |


<span id="TALWTNEngineDelegate-onlocalstats-audiostats-videostats"></span>
### onLocalStats:audioStats:videoStats:
```objectivec

- (void)onLocalStats:(NSString*)stream_id audioStats:(TALWTNRTCAudioStats*)audio_stats videoStats:(TALWTNRTCVideoStats*)video_stats;
```
Periodic callback of the stats of locally published stream in every second.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| audio_stats | **TALWTNRTCAudioStats*** | Stats of audio stream. See [TALWTNRTCAudioStats](keytype.md#talwtnrtcaudiostats). |
| video_stats | **TALWTNRTCVideoStats*** | Stats of video stream. See [TALWTNRTCVideoStats](keytype.md#talwtnrtcvideostats). |


<span id="TALWTNEngineDelegate-onmuteaudiosuccess"></span>
### onMuteAudioSuccess:
```objectivec

- (void)onMuteAudioSuccess:(NSString*)stream_id;
```
Success to mute audio callback.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |


<span id="TALWTNEngineDelegate-onmuteaudiofailed-reason"></span>
### onMuteAudioFailed:reason:
```objectivec

- (void)onMuteAudioFailed:(NSString*)stream_id reason:(TALWTNReason)reason;
```
Failure to mute audio callback.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| reason | **TALWTNReason** | See [TALWTNReason](keytype.md#talwtnreason). |


<span id="TALWTNEngineDelegate-onmutevideosuccess"></span>
### onMuteVideoSuccess
```objectivec
- (void)onMuteVideoSuccess:(NSString*)stream_id;
```
Success to mute video callback.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |


<span id="TALWTNEngineDelegate-onmutevideofailed-reason"></span>
### onMuteVideoFailed:reason:
```objectivec

- (void)onMuteVideoFailed:(NSString*)stream_id reason:(TALWTNReason)reason;
```
Failure to mute video callback.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| reason | **TALWTNReason** | See [TALWTNReason](keytype.md#talwtnreason). |


<span id="TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason"></span>
### onSubscribeStateChanged:subscribeState:reason:
```objectivec

- (void)onSubscribeStateChanged:(NSString*)stream_id subscribeState:(TALWTNState)state reason:(TALWTNReason)reason;
```
Callback of media stream subscribing state change.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | stream ID |
| state | **TALWTNState** | The current subscribing state. See [TALWTNState](keytype.md#talwtnstate). |
| reason | **TALWTNReason** | Error code when subscribing state changes. See [TALWTNReason](keytype.md#talwtnreason). |


<span id="TALWTNEngineDelegate-onremotestats-audiostats-videostats"></span>
### onRemoteStats:audioStats:videoStats:
```objectivec

- (void)onRemoteStats:(NSString*)stream_id audioStats:(TALWTNRTCAudioStats*)audio_stats videoStats:(TALWTNRTCVideoStats*)video_stats;
```
Periodic callback of the stats of the subscribed remote stream in every second.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| audio_stats | **TALWTNRTCAudioStats*** | Audio stream information. See [TALWTNRTCAudioStats](keytype.md#talwtnrtcaudiostats). |
| video_stats | **TALWTNRTCVideoStats*** | Video stream information. See [TALWTNRTCVideoStats](keytype.md#talwtnrtcvideostats). |


<span id="TALWTNEngineDelegate-onfirstremotevideoframerendered"></span>
### onFirstRemoteVideoFrameRendered:
```objectivec

- (void)onFirstRemoteVideoFrameRendered:(NSString*)stream_id;
```
Receive the callback when the first frame of the subscribed remote frame is rendered.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |


<span id="TALWTNEngineDelegate-onstallinfo-stallinfo"></span>
### onStallInfo:stallInfo:
```objectivec

- (void)onStallInfo:(NSString*)stream_id stallInfo:(TALWTNStallInfo*)stall_info;
```
Periodic callback of the stall information in every second.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| stall_info | **TALWTNStallInfo*** | The stall information. See [TALWTNStallInfo](keytype.md#talwtnstallinfo). |


<span id="TALWTNEngineDelegate-onencodedvideoframe-frame"></span>
### onEncodedVideoFrame:frame:
```objectivec

- (void)onEncodedVideoFrame:(NSString*)stream_id frame:(TALWTNEncodedVideoFrame*)encoded_frame;
```
Periodic encoded video frame callback. The period is the reciprocal of the framerate.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| encoded_frame | **TALWTNEncodedVideoFrame*** | Video frame information, see [TALWTNEncodedVideoFrame](keytype.md#talwtnencodedvideoframe). |


<span id="TALWTNEngineDelegate-onvideoframe-frame"></span>
### onVideoFrame:frame:
```objectivec

- (void)onVideoFrame:(NSString*)stream_id frame:(TALWTNVideoFrame*)video_frame;
```
Periodic encoded video frame callback. The period is the reciprocal of the framerate.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| video_frame | **TALWTNVideoFrame*** | Video frame information, see [TALWTNVideoFrame](keytype.md#talwtnvideoframe). |


<span id="TALWTNEngineDelegate-onaudioframe-frame"></span>
### onAudioFrame:frame:
```objectivec

- (void)onAudioFrame:(NSString*)stream_id frame:(TALWTNAudioFrame*)audio_frame;
```
Periodic audio frame callback in every 10ms.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| stream_id | **NSString*** | Stream ID |
| audio_frame | **TALWTNAudioFrame*** | Audio frame information, see [TALWTNAudioFrame](keytype.md#talwtnaudioframe). |



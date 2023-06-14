# TALWTNEngineDelegate
```objectivec
@protocol TALWTNEngineDelegate <NSObject>
```

事件回调接口


## 成员函数

| 返回 | 名称 |
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


## 函数说明
<span id="TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason"></span>
### onPublishStateChanged:publishState:reason:
```objectivec

- (void)onPublishStateChanged:(NSString*)stream_id publishState:(TALWTNState)state reason:(TALWTNReason)reason;
```
音视频流的发布状态发生改变时，收到此回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| state | **TALWTNState** | 当前发布状态，参看 [TALWTNState](keytype.md#talwtnstate)。 |
| reason | **TALWTNReason** | 发布状态发生改变的原因，参看 [TALWTNReason](keytype.md#talwtnreason)。 |


<span id="TALWTNEngineDelegate-onlocalstats-audiostats-videostats"></span>
### onLocalStats:audioStats:videoStats:
```objectivec

- (void)onLocalStats:(NSString*)stream_id audioStats:(TALWTNRTCAudioStats*)audio_stats videoStats:(TALWTNRTCVideoStats*)video_stats;
```
发布流状态的周期回调，周期1秒。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| audio_stats | **TALWTNRTCAudioStats*** | 音频流数据，参看 [TALWTNRTCAudioStats](keytype.md#talwtnrtcaudiostats)。 |
| video_stats | **TALWTNRTCVideoStats*** | 视频流数据，参看 [TALWTNRTCVideoStats](keytype.md#talwtnrtcvideostats)。 |


<span id="TALWTNEngineDelegate-onmuteaudiosuccess"></span>
### onMuteAudioSuccess:
```objectivec

- (void)onMuteAudioSuccess:(NSString*)stream_id;
```
Mute 音频成功回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |


<span id="TALWTNEngineDelegate-onmuteaudiofailed-reason"></span>
### onMuteAudioFailed:reason:
```objectivec

- (void)onMuteAudioFailed:(NSString*)stream_id reason:(TALWTNReason)reason;
```
Mute 音频失败回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| reason | **TALWTNReason** | 参看 [TALWTNReason](keytype.md#talwtnreason)。 |


<span id="TALWTNEngineDelegate-onmutevideosuccess"></span>
### onMuteVideoSuccess:
```objectivec

- (void)onMuteVideoSuccess:(NSString*)stream_id;
```
Mute 视频成功回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |


<span id="TALWTNEngineDelegate-onmutevideofailed-reason"></span>
### onMuteVideoFailed:reason:
```objectivec

- (void)onMuteVideoFailed:(NSString*)stream_id reason:(TALWTNReason)reason;
```
Mute 视频失败回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| reason | **TALWTNReason** | 参看 [TALWTNReason](keytype.md#talwtnreason)。 |


<span id="TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason"></span>
### onSubscribeStateChanged:subscribeState:reason:
```objectivec

- (void)onSubscribeStateChanged:(NSString*)stream_id subscribeState:(TALWTNState)state reason:(TALWTNReason)reason;
```
音视频流的订阅状态发生改变时，收到此回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| state | **TALWTNState** | 当前订阅状态，参看 [TALWTNState](keytype.md#talwtnstate)。 |
| reason | **TALWTNReason** | 订阅状态发生改变的原因。参看 [TALWTNReason](keytype.md#talwtnreason)。 |


<span id="TALWTNEngineDelegate-onremotestats-audiostats-videostats"></span>
### onRemoteStats:audioStats:videoStats:
```objectivec

- (void)onRemoteStats:(NSString*)stream_id audioStats:(TALWTNRTCAudioStats*)audio_stats videoStats:(TALWTNRTCVideoStats*)video_stats;
```
订阅流状态的周期回调，周期1秒。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| audio_stats | **TALWTNRTCAudioStats*** | 音频流数据，参看 [TALWTNRTCAudioStats](keytype.md#talwtnrtcaudiostats)。 |
| video_stats | **TALWTNRTCVideoStats*** | 视频流数据，参看 [TALWTNRTCVideoStats](keytype.md#talwtnrtcvideostats)。 |


<span id="TALWTNEngineDelegate-onfirstremotevideoframerendered"></span>
### onFirstRemoteVideoFrameRendered:
```objectivec

- (void)onFirstRemoteVideoFrameRendered:(NSString*)stream_id;
```
订阅的远端视频流的首帧完成渲染时，收到此回调。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |


<span id="TALWTNEngineDelegate-onstallinfo-stallinfo"></span>
### onStallInfo:stallInfo:
```objectivec

- (void)onStallInfo:(NSString*)stream_id stallInfo:(TALWTNStallInfo*)stall_info;
```
卡顿信息回调，周期1秒。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| stall_info | **TALWTNStallInfo*** | 卡顿信息，参看 [TALWTNStallInfo](keytype.md#talwtnstallinfo)。 |


<span id="TALWTNEngineDelegate-onencodedvideoframe-frame"></span>
### onEncodedVideoFrame:frame:
```objectivec

- (void)onEncodedVideoFrame:(NSString*)stream_id frame:(TALWTNEncodedVideoFrame*)encoded_frame;
```
编码视频帧周期回调。周期是帧率的倒数。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| encoded_frame | **TALWTNEncodedVideoFrame*** | 视频帧信息，参看 [TALWTNEncodedVideoFrame](keytype.md#talwtnencodedvideoframe)。 |


<span id="TALWTNEngineDelegate-onvideoframe-frame"></span>
### onVideoFrame:frame:
```objectivec

- (void)onVideoFrame:(NSString*)stream_id frame:(TALWTNVideoFrame*)video_frame;
```
编码视频帧周期回调。周期是帧率的倒数。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| video_frame | **TALWTNVideoFrame*** | 视频帧信息，参看 [TALWTNVideoFrame](keytype.md#talwtnvideoframe)。 |


<span id="TALWTNEngineDelegate-onaudioframe-frame"></span>
### onAudioFrame:frame:
```objectivec

- (void)onAudioFrame:(NSString*)stream_id frame:(TALWTNAudioFrame*)audio_frame;
```
音频帧回调。周期是 10ms。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| stream_id | **NSString*** | 流 ID |
| audio_frame | **TALWTNAudioFrame*** | 音频帧信息，参看 [TALWTNAudioFrame](keytype.md#talwtnaudioframe)。 |



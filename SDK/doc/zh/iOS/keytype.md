# TALWTNPubAudioSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNPubAudioSource)
```

发布的音频源类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNPubAudioSourceInternalRecord | 0 | 内部麦克风采集的数据。默认值。 |
| TALWTNPubAudioSourcePushExternalPCM | 1 | 推送的外部 PCM 数据 |


# TALWTNPubVideoSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNPubVideoSource)
```

发布的视频源类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNPubVideoSourceInternalCamera | 0 | 内部摄像头采集的数据。默认值。 |
| TALWTNPubVideoSourcePushExternalYUV | 1 | 推送的外部 YUV 数据 |
| TALWTNPubVideoSourcePushExternalH264 | 2 | 推送的外部 H.264 编码的数据 |


# TALWTNSubAudioSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNSubAudioSource)
```

订阅的音频源类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNSubAudioSourceInternalPlay | 0 | 内部采集的音频数据。默认值。 |
| TALWTNSubAudioSourceCallbackPCM | 1 | PCM 音频数据。 |


# TALWTNSubVideoSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNSubVideoSource)
```

订阅的视频源类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNSubVideoSourceInternalRender | 0 | 内部采集的视频数据。默认值。 |
| TALWTNSubVideoSourceCallbackYUV | 1 | YUV 格式的视频数据。 |
| TALWTNSubVideoSourceCallbackH264 | 2 | H.264 格式封装的视频数据。 |


# TALWTNEncodedVideoFrameType
```objectivec
typedef NS_ENUM(NSInteger, TALWTNEncodedVideoFrameType)
```

外部编码视频帧的编码类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNCodceH264 | 0 | H.264 |


# TALWTNVideoFrameType
```objectivec
typedef NS_ENUM(NSInteger, TALWTNVideoFrameType)
```

视频帧类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNYuvI420 | 0 | YUV-I420 |


# TALWTNAudioFrameType
```objectivec
typedef NS_ENUM(NSInteger, TALWTNAudioFrameType)
```

音频帧类型


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNPcm16 | 0 | PCM 16 |


# TALWTNState
```objectivec
typedef NS_ENUM(NSInteger, TALWTNState)
```

音视频流状态


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNStateStartSuccess | 0 | 开始发布/订阅成功 |
| TALWTNStateStartFailed | 1 | 开始发布/订阅失败 |
| TALWTNStateStopSuccess | 2 | 停止发布/订阅成功 |
| TALWTNStateStopFailed | 3 | 停止发布/订阅失败 |


# TALWTNReason
```objectivec
typedef NS_ENUM(NSInteger, TALWTNReason)
```

发布成功或失败的原因


### 枚举值

| 类型 | 值 | 说明 |
| --- | --- | --- |
| TALWTNReasonSuccess | 0 | 成功 |
| TALWTNReasonParameterError | 1 | 失败。参数错误。 |
| TALWTNReasonTokenError | 2 | 失败。Token 错误。包括 Token 错误、Token 过期、Token 鉴权失败等。 |
| TALWTNReasonResourcesNotFound | 3 | 失败。未找到资源。 |
| TALWTNReasonServerInternalError | 4 | 失败。服务器内部错误。请重试。 |
| TALWTNReasonSDKInternalError | 5 | 失败。SDK 内部错误。请重试。 |
| TALWTNReasonNetworkError | 6 | 失败。网络错误。 |
| TALWTNReasonUnknowError | 7 | 失败。未知错误。请重试。 |
| TALWTNReasonStreamNotExist | 8 | 失败。订阅的流不存在。 |


# TALWTNPubExtraParam
```objectivec
@interface TALWTNPubExtraParam : NSObject
```

发布参数


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **TALWTNPubAudioSource** | [pub_audio_source](#TALWTNPubExtraParam-pub_audio_source) |
| **TALWTNPubVideoSource** | [pub_video_source](#TALWTNPubExtraParam-pub_video_source) |


## 变量说明
<span id="TALWTNPubExtraParam-pub_audio_source"></span>
### pub_audio_source
```objectivec
@property (nonatomic, assign) TALWTNPubAudioSource pub_audio_source;
```
音频源发布


<span id="TALWTNPubExtraParam-pub_video_source"></span>
### pub_video_source
```objectivec
@property (nonatomic, assign) TALWTNPubVideoSource pub_video_source;
```
视频源发布



# TALWTNSubExtraParam
```objectivec
@interface TALWTNSubExtraParam: NSObject
```

订阅额外参数


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **TALWTNSubAudioSource** | [sub_audio_source](#TALWTNSubExtraParam-sub_audio_source) |
| **TALWTNSubVideoSource** | [sub_video_source](#TALWTNSubExtraParam-sub_video_source) |


## 变量说明
<span id="TALWTNSubExtraParam-sub_audio_source"></span>
### sub_audio_source
```objectivec
@property (nonatomic, assign) TALWTNSubAudioSource sub_audio_source;
```
音频源订阅。参看 [TALWTNSubAudioSource](#talwtnsubaudiosource)。


<span id="TALWTNSubExtraParam-sub_video_source"></span>
### sub_video_source
```objectivec
@property (nonatomic, assign) TALWTNSubVideoSource sub_video_source;
```
视频源订阅。参看 [TALWTNSubVideoSource](#talwtnsubvideosource)。



# TALWTNEncodedVideoFrame
```objectivec
@interface TALWTNEncodedVideoFrame: NSObject
```

编码后的视频帧


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **TALWTNEncodedVideoFrameType** | [codec_type](#TALWTNEncodedVideoFrame-codec_type) |
| **const uint8_t*** | [data](#TALWTNEncodedVideoFrame-data) |
| **int** | [size](#TALWTNEncodedVideoFrame-size) |
| **int** | [width](#TALWTNEncodedVideoFrame-width) |
| **int** | [height](#TALWTNEncodedVideoFrame-height) |
| **unsigned** | [timestamp_ms](#TALWTNEncodedVideoFrame-timestamp_ms) |
| **int** | [rotation](#TALWTNEncodedVideoFrame-rotation) |
| **BOOL** | [is_key_frame](#TALWTNEncodedVideoFrame-is_key_frame) |


## 变量说明
<span id="TALWTNEncodedVideoFrame-codec_type"></span>
### codec_type
```objectivec
@property (nonatomic, assign) TALWTNEncodedVideoFrameType codec_type;
```
帧类型。目前仅支持 H.264，且必须是 Annex B 格式。


<span id="TALWTNEncodedVideoFrame-data"></span>
### data
```objectivec
@property (nonatomic, assign) const uint8_t * data;
```
数据缓存


<span id="TALWTNEncodedVideoFrame-size"></span>
### size
```objectivec
@property (nonatomic, assign) int size;
```
数据缓存大小


<span id="TALWTNEncodedVideoFrame-width"></span>
### width
```objectivec
@property (nonatomic, assign) int width;
```
宽度（px）


<span id="TALWTNEncodedVideoFrame-height"></span>
### height
```objectivec
@property (nonatomic, assign) int height;
```
高度（px）


<span id="TALWTNEncodedVideoFrame-timestamp_ms"></span>
### timestamp_ms
```objectivec
@property (nonatomic, assign) unsigned long timestamp_ms;
```
时间戳，单位毫秒


<span id="TALWTNEncodedVideoFrame-rotation"></span>
### rotation
```objectivec
@property (nonatomic, assign) int rotation;
```
逆时针旋转角度，单位为度。可选值为 0，90，180，270。


<span id="TALWTNEncodedVideoFrame-is_key_frame"></span>
### is_key_frame
```objectivec
@property (nonatomic, assign) BOOL is_key_frame;
```
是否为关键帧。如果是关键帧，那么，必须包含 SPS 和 PPS 信息。



# TALWTNVideoFrame
```objectivec
@interface TALWTNVideoFrame: NSObject
```

视频帧


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **TALWTNVideoFrameType** | [type](#TALWTNVideoFrame-type) |
| **const uint8_t*** | [y_buffer](#TALWTNVideoFrame-y_buffer) |
| **const uint8_t*** | [u_buffer](#TALWTNVideoFrame-u_buffer) |
| **const uint8_t*** | [v_buffer](#TALWTNVideoFrame-v_buffer) |
| **int** | [y_stride](#TALWTNVideoFrame-y_stride) |
| **int** | [u_stride](#TALWTNVideoFrame-u_stride) |
| **int** | [v_stride](#TALWTNVideoFrame-v_stride) |
| **int** | [width](#TALWTNVideoFrame-width) |
| **int** | [height](#TALWTNVideoFrame-height) |
| **unsigned** | [timestamp_ms](#TALWTNVideoFrame-timestamp_ms) |
| **int** | [rotation](#TALWTNVideoFrame-rotation) |


## 变量说明
<span id="TALWTNVideoFrame-type"></span>
### type
```objectivec
@property (nonatomic, assign) TALWTNVideoFrameType type;
```
帧类型。目前仅支持YUV I420。


<span id="TALWTNVideoFrame-y_buffer"></span>
### y_buffer
```objectivec
@property (nonatomic, assign) const uint8_t * y_buffer;
```
Y 分量数据缓存


<span id="TALWTNVideoFrame-u_buffer"></span>
### u_buffer
```objectivec
@property (nonatomic, assign) const uint8_t * u_buffer;
```
U 分量数据缓存


<span id="TALWTNVideoFrame-v_buffer"></span>
### v_buffer
```objectivec
@property (nonatomic, assign) const uint8_t * v_buffer;
```
V 分量数据缓存


<span id="TALWTNVideoFrame-y_stride"></span>
### y_stride
```objectivec
@property (nonatomic, assign) int y_stride;
```
Y 分量 stride


<span id="TALWTNVideoFrame-u_stride"></span>
### u_stride
```objectivec
@property (nonatomic, assign) int u_stride;
```
U 分量 stride


<span id="TALWTNVideoFrame-v_stride"></span>
### v_stride
```objectivec
@property (nonatomic, assign) int v_stride;
```
V 分量 stride


<span id="TALWTNVideoFrame-width"></span>
### width
```objectivec
@property (nonatomic, assign) int width;
```
宽度（px）


<span id="TALWTNVideoFrame-height"></span>
### height
```objectivec
@property (nonatomic, assign) int height;
```
高度（px）


<span id="TALWTNVideoFrame-timestamp_ms"></span>
### timestamp_ms
```objectivec
@property (nonatomic, assign) unsigned long timestamp_ms;
```
时间戳，单位毫秒。


<span id="TALWTNVideoFrame-rotation"></span>
### rotation
```objectivec
@property (nonatomic, assign) int rotation;
```
逆时针旋转角度，可选值为 0，90，180，270



# TALWTNAudioFrame
```objectivec
@interface TALWTNAudioFrame: NSObject
```

音频帧


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **TALWTNAudioFrameType** | [type](#TALWTNAudioFrame-type) |
| **const uint8_t*** | [data](#TALWTNAudioFrame-data) |
| **int** | [sample_length](#TALWTNAudioFrame-sample_length) |
| **unsigned** | [timestamp_ms](#TALWTNAudioFrame-timestamp_ms) |
| **int** | [sample_rate](#TALWTNAudioFrame-sample_rate) |
| **int** | [channels](#TALWTNAudioFrame-channels) |


## 变量说明
<span id="TALWTNAudioFrame-type"></span>
### type
```objectivec
@property (nonatomic, assign) TALWTNAudioFrameType type;
```
帧类型。目前仅支持 PCM16。


<span id="TALWTNAudioFrame-data"></span>
### data
```objectivec
@property (nonatomic, assign) const uint8_t * data;
```
数据缓存


<span id="TALWTNAudioFrame-sample_length"></span>
### sample_length
```objectivec
@property (nonatomic, assign) int sample_length;
```
数据缓存大小


<span id="TALWTNAudioFrame-timestamp_ms"></span>
### timestamp_ms
```objectivec
@property (nonatomic, assign) unsigned long timestamp_ms;
```
时间戳，单位：毫秒。


<span id="TALWTNAudioFrame-sample_rate"></span>
### sample_rate
```objectivec
@property (nonatomic, assign) int sample_rate;
```
采样率


<span id="TALWTNAudioFrame-channels"></span>
### channels
```objectivec
@property (nonatomic, assign) int channels;
```
通道数



# TALWTNVideoConfig
```objectivec
@interface TALWTNVideoConfig: NSObject
```

视频配置


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **int** | [width](#TALWTNVideoConfig-width) |
| **int** | [height](#TALWTNVideoConfig-height) |
| **int** | [max_fps](#TALWTNVideoConfig-max_fps) |


## 变量说明
<span id="TALWTNVideoConfig-width"></span>
### width
```objectivec
@property (nonatomic, assign) int width;
```
宽度（px）。默认值是 640。


<span id="TALWTNVideoConfig-height"></span>
### height
```objectivec
@property (nonatomic, assign) int height;
```
高度（px）。默认值是 960。


<span id="TALWTNVideoConfig-max_fps"></span>
### max_fps
```objectivec
@property (nonatomic, assign) int max_fps;
```
最大帧率（fps）。默认值是 15。



# TALWTNStallInfo
```objectivec
@interface TALWTNStallInfo: NSObject
```

视频卡顿信息


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **int** | [stall_count_500](#TALWTNStallInfo-stall_count_500) |
| **int** | [stall_duration_500](#TALWTNStallInfo-stall_duration_500) |
| **int** | [stall_count_200](#TALWTNStallInfo-stall_count_200) |
| **int** | [stall_duration_200](#TALWTNStallInfo-stall_duration_200) |
| **int** | [frame_rate](#TALWTNStallInfo-frame_rate) |


## 变量说明
<span id="TALWTNStallInfo-stall_count_500"></span>
### stall_count_500
```objectivec
@property (nonatomic, assign) int stall_count_500;
```
500 毫秒卡顿次数


<span id="TALWTNStallInfo-stall_duration_500"></span>
### stall_duration_500
```objectivec
@property (nonatomic, assign) int stall_duration_500;
```
500 毫秒卡顿时长


<span id="TALWTNStallInfo-stall_count_200"></span>
### stall_count_200
```objectivec
@property (nonatomic, assign) int stall_count_200;
```
200 毫秒卡顿次数


<span id="TALWTNStallInfo-stall_duration_200"></span>
### stall_duration_200
```objectivec
@property (nonatomic, assign) int stall_duration_200;
```
200 毫秒卡顿时长


<span id="TALWTNStallInfo-frame_rate"></span>
### frame_rate
```objectivec
@property (nonatomic, assign) int frame_rate;
```
帧率



# TALWTNRTCAudioStats
```objectivec
@interface TALWTNRTCAudioStats: NSObject
```

音频流数据


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **int64_t** | [bytes_sent](#TALWTNRTCAudioStats-bytes_sent) |
| **int64_t** | [bytes_received](#TALWTNRTCAudioStats-bytes_received) |
| **double** | [bytes_sent_per_second](#TALWTNRTCAudioStats-bytes_sent_per_second) |
| **double** | [bytes_received_per_second](#TALWTNRTCAudioStats-bytes_received_per_second) |
| **double** | [audio_level](#TALWTNRTCAudioStats-audio_level) |
| **double** | [total_audio_energy](#TALWTNRTCAudioStats-total_audio_energy) |
| **NSString*** | [codec_id](#TALWTNRTCAudioStats-codec_id) |
| **uint64_t** | [round_trip_time_measurements](#TALWTNRTCAudioStats-round_trip_time_measurements) |
| **double** | [total_round_trip_time](#TALWTNRTCAudioStats-total_round_trip_time) |
| **uint32_t** | [packets_sent](#TALWTNRTCAudioStats-packets_sent) |
| **uint32_t** | [packets_received](#TALWTNRTCAudioStats-packets_received) |
| **uint32_t** | [packets_lost](#TALWTNRTCAudioStats-packets_lost) |
| **double** | [franction_loss](#TALWTNRTCAudioStats-franction_loss) |
| **double** | [jitter](#TALWTNRTCAudioStats-jitter) |


## 变量说明
<span id="TALWTNRTCAudioStats-bytes_sent"></span>
### bytes_sent
```objectivec
@property (nonatomic, assign) int64_t bytes_sent;
```
发送字节数，单位：字节。


<span id="TALWTNRTCAudioStats-bytes_received"></span>
### bytes_received
```objectivec
@property (nonatomic, assign) int64_t bytes_received;
```
接收字节数，单位：字节。


<span id="TALWTNRTCAudioStats-bytes_sent_per_second"></span>
### bytes_sent_per_second
```objectivec
@property (nonatomic, assign) double bytes_sent_per_second;
```
每秒发送字节数，单位：字节。


<span id="TALWTNRTCAudioStats-bytes_received_per_second"></span>
### bytes_received_per_second
```objectivec
@property (nonatomic, assign) double bytes_received_per_second;
```
每秒接收字节数，单位：字节。


<span id="TALWTNRTCAudioStats-audio_level"></span>
### audio_level
```objectivec
@property (nonatomic, assign) double audio_level;
```
音量强度。<br>
取值范围：`[0, 1.0]`。值为 `1.0` 时，表示 0dBov；值为 `0.5` 时，表示 6dB SPL。


<span id="TALWTNRTCAudioStats-total_audio_energy"></span>
### total_audio_energy
```objectivec
@property (nonatomic, assign) double total_audio_energy;
```
总音量强度。值越大，强度越高。


<span id="TALWTNRTCAudioStats-codec_id"></span>
### codec_id
```objectivec
@property (nonatomic, strong) NSString* codec_id;
```
编码器 ID


<span id="TALWTNRTCAudioStats-round_trip_time_measurements"></span>
### round_trip_time_measurements
```objectivec
@property (nonatomic, assign) uint64_t round_trip_time_measurements;
```
收到的 RTCP RR 包的总个数。


<span id="TALWTNRTCAudioStats-total_round_trip_time"></span>
### total_round_trip_time
```objectivec
@property (nonatomic, assign) double total_round_trip_time;
```
总 rtt 时间。单位：秒。除以 `roundTripTimeMeasurements` 可以获得平均时间。


<span id="TALWTNRTCAudioStats-packets_sent"></span>
### packets_sent
```objectivec
@property (nonatomic, assign) uint32_t packets_sent;
```
发送包个数


<span id="TALWTNRTCAudioStats-packets_received"></span>
### packets_received
```objectivec
@property (nonatomic, assign) uint32_t packets_received;
```
接收包个数


<span id="TALWTNRTCAudioStats-packets_lost"></span>
### packets_lost
```objectivec
@property (nonatomic, assign) uint32_t packets_lost;
```
发布过程中的丢包数


<span id="TALWTNRTCAudioStats-franction_loss"></span>
### franction_loss
```objectivec
@property (nonatomic, assign) double franction_loss;
```
丢包率。取值范围：`[0, 1.0]`。


<span id="TALWTNRTCAudioStats-jitter"></span>
### jitter
```objectivec
@property (nonatomic, assign) double jitter;
```
jitter 抖动。单位：秒。



# TALWTNRTCVideoStats
```objectivec
@interface TALWTNRTCVideoStats: NSObject
```

视频流数据


## 成员变量

| 类型 | 名称 |
| --- | --- |
| **int64_t** | [bytes_sent](#TALWTNRTCVideoStats-bytes_sent) |
| **int64_t** | [bytes_received](#TALWTNRTCVideoStats-bytes_received) |
| **int64_t** | [bytes_sent_per_second](#TALWTNRTCVideoStats-bytes_sent_per_second) |
| **int64_t** | [bytes_received_per_second](#TALWTNRTCVideoStats-bytes_received_per_second) |
| **int64_t** | [frame_width](#TALWTNRTCVideoStats-frame_width) |
| **int64_t** | [frame_height](#TALWTNRTCVideoStats-frame_height) |
| **double** | [frames_per_second](#TALWTNRTCVideoStats-frames_per_second) |
| **NSString*** | [codec_id](#TALWTNRTCVideoStats-codec_id) |
| **uint64_t** | [round_trip_time_measurements](#TALWTNRTCVideoStats-round_trip_time_measurements) |
| **double** | [total_round_trip_time](#TALWTNRTCVideoStats-total_round_trip_time) |
| **uint32_t** | [packets_sent](#TALWTNRTCVideoStats-packets_sent) |
| **uint32_t** | [packets_received](#TALWTNRTCVideoStats-packets_received) |
| **uint32_t** | [packets_lost](#TALWTNRTCVideoStats-packets_lost) |
| **double** | [franction_loss](#TALWTNRTCVideoStats-franction_loss) |
| **double** | [jitter](#TALWTNRTCVideoStats-jitter) |


## 变量说明
<span id="TALWTNRTCVideoStats-bytes_sent"></span>
### bytes_sent
```objectivec
@property (nonatomic, assign) int64_t bytes_sent;
```
发送字节数，单位字节


<span id="TALWTNRTCVideoStats-bytes_received"></span>
### bytes_received
```objectivec
@property (nonatomic, assign) int64_t bytes_received;
```
接收字节数，单位字节


<span id="TALWTNRTCVideoStats-bytes_sent_per_second"></span>
### bytes_sent_per_second
```objectivec
@property (nonatomic, assign) int64_t bytes_sent_per_second;
```
每秒发送字节数，单位字节


<span id="TALWTNRTCVideoStats-bytes_received_per_second"></span>
### bytes_received_per_second
```objectivec
@property (nonatomic, assign) int64_t bytes_received_per_second;
```
每秒接收字节数，单位字节


<span id="TALWTNRTCVideoStats-frame_width"></span>
### frame_width
```objectivec
@property (nonatomic, assign) int64_t frame_width;
```
视频帧宽度。单位：px。


<span id="TALWTNRTCVideoStats-frame_height"></span>
### frame_height
```objectivec
@property (nonatomic, assign) int64_t frame_height;
```
视频帧高度。单位：px。


<span id="TALWTNRTCVideoStats-frames_per_second"></span>
### frames_per_second
```objectivec
@property (nonatomic, assign) double frames_per_second;
```
帧率


<span id="TALWTNRTCVideoStats-codec_id"></span>
### codec_id
```objectivec
@property (nonatomic, strong) NSString* codec_id;
```
编码器 ID


<span id="TALWTNRTCVideoStats-round_trip_time_measurements"></span>
### round_trip_time_measurements
```objectivec
@property (nonatomic, assign) uint64_t round_trip_time_measurements;
```
收到的 RTCP RR 包的总个数。


<span id="TALWTNRTCVideoStats-total_round_trip_time"></span>
### total_round_trip_time
```objectivec
@property (nonatomic, assign) double total_round_trip_time;
```
总 rtt 时间。单位：秒。除以 `roundTripTimeMeasurements` 可以获得平均时间。


<span id="TALWTNRTCVideoStats-packets_sent"></span>
### packets_sent
```objectivec
@property (nonatomic, assign) uint32_t packets_sent;
```
发送包个数


<span id="TALWTNRTCVideoStats-packets_received"></span>
### packets_received
```objectivec
@property (nonatomic, assign) uint32_t packets_received;
```
接收包个数


<span id="TALWTNRTCVideoStats-packets_lost"></span>
### packets_lost
```objectivec
@property (nonatomic, assign) uint32_t packets_lost;
```
发布过程中的丢包数


<span id="TALWTNRTCVideoStats-franction_loss"></span>
### franction_loss
```objectivec
@property (nonatomic, assign) double franction_loss;
```
丢包率。取值范围：`[0, 1.0]`。


<span id="TALWTNRTCVideoStats-jitter"></span>
### jitter
```objectivec
@property (nonatomic, assign) double jitter;
```
jitter 抖动。单位：秒。




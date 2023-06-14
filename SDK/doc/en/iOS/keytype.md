# TALWTNPubAudioSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNPubAudioSource)
```

The type of the audio source to publish.


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNPubAudioSourceInternalRecord | 0 | The data recorded by built-in microphone. Default value. |
| TALWTNPubAudioSourcePushExternalPCM | 1 | PCM data pushed externally. |


# TALWTNPubVideoSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNPubVideoSource)
```

The type of the video source to publish.


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNPubVideoSourceInternalCamera | 0 | The data recorded by built-in camera. Default value. |
| TALWTNPubVideoSourcePushExternalYUV | 1 | YUV data pushed externally. |
| TALWTNPubVideoSourcePushExternalH264 | 2 | H.264 encoded data pushed externally. |


# TALWTNSubAudioSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNSubAudioSource)
```

The audio source type to subscribe.


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNSubAudioSourceInternalPlay | 0 | Internally captured audio data. Default value. |
| TALWTNSubAudioSourceCallbackPCM | 1 | Audio data in PCM format. |


# TALWTNSubVideoSource
```objectivec
typedef NS_ENUM(NSInteger, TALWTNSubVideoSource)
```

The video source type to subscribe.


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNSubVideoSourceInternalRender | 0 | Internally captured video data. Default value. |
| TALWTNSubVideoSourceCallbackYUV | 1 | Video stream in YUV format. |
| TALWTNSubVideoSourceCallbackH264 | 2 | Video stream encoded in H.264 protocal. |


# TALWTNEncodedVideoFrameType
```objectivec
typedef NS_ENUM(NSInteger, TALWTNEncodedVideoFrameType)
```

The encoding type of the encoded video frame


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNCodceH264 | 0 | H.264 |


# TALWTNVideoFrameType
```objectivec
typedef NS_ENUM(NSInteger, TALWTNVideoFrameType)
```

Video frame type


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNYuvI420 | 0 | YUV-I420 |


# TALWTNAudioFrameType
```objectivec
typedef NS_ENUM(NSInteger, TALWTNAudioFrameType)
```

Audio frame type


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNPcm16 | 0 | PCM 16 |


# TALWTNState
```objectivec
typedef NS_ENUM(NSInteger, TALWTNState)
```

state


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNStateStartSuccess | 0 | Success to start publishing/subscribing the stream. |
| TALWTNStateStartFailed | 1 | Failure to start publishing/subscribing the stream. |
| TALWTNStateStopSuccess | 2 | Success to stop publishing/subscribing the stream. |
| TALWTNStateStopFailed | 3 | Failure to stop publishing/subscribing the stream. |


# TALWTNReason
```objectivec
typedef NS_ENUM(NSInteger, TALWTNReason)
```

reason


### Enumerated Value

| Type | Value | Instructions |
| --- | --- | --- |
| TALWTNReasonSuccess | 0 | Success |
| TALWTNReasonParameterError | 1 | Failure. Invalid parameter. |
| TALWTNReasonTokenError | 2 | Failure. Token error, including invalid token, expired token and token authentication failed. |
| TALWTNReasonResourcesNotFound | 3 | Failure. Resources not found. |
| TALWTNReasonServerInternalError | 4 | Failure. Internal server error. Please try again. |
| TALWTNReasonSDKInternalError | 5 | Failure. Internal SDK error. Please try again. |
| TALWTNReasonNetworkError | 6 | Failure. Network error. |
| TALWTNReasonUnknowError | 7 | Failure. Unknown error. Please try again. |
| TALWTNReasonStreamNotExist | 8 | Failure. Stream not exist. |


# TALWTNPubExtraParam
```objectivec
@interface TALWTNPubExtraParam : NSObject
```

publish param


## Member Property

| Type | Name |
| --- | --- |
| **TALWTNPubAudioSource** | [pub_audio_source](#TALWTNPubExtraParam-pub_audio_source) |
| **TALWTNPubVideoSource** | [pub_video_source](#TALWTNPubExtraParam-pub_video_source) |


## Instructions
<span id="TALWTNPubExtraParam-pub_audio_source"></span>
### pub_audio_source
```objectivec
@property (nonatomic, assign) TALWTNPubAudioSource pub_audio_source;
```
Publish audio source


<span id="TALWTNPubExtraParam-pub_video_source"></span>
### pub_video_source
```objectivec
@property (nonatomic, assign) TALWTNPubVideoSource pub_video_source;
```
Publish video source



# TALWTNSubExtraParam
```objectivec
@interface TALWTNSubExtraParam: NSObject
```

Extra param for subscribing


## Member Property

| Type | Name |
| --- | --- |
| **TALWTNSubAudioSource** | [sub_audio_source](#TALWTNSubExtraParam-sub_audio_source) |
| **TALWTNSubVideoSource** | [sub_video_source](#TALWTNSubExtraParam-sub_video_source) |


## Instructions
<span id="TALWTNSubExtraParam-sub_audio_source"></span>
### sub_audio_source
```objectivec
@property (nonatomic, assign) TALWTNSubAudioSource sub_audio_source;
```
Subscribe audio source. See [TALWTNSubAudioSource](#talwtnsubaudiosource).


<span id="TALWTNSubExtraParam-sub_video_source"></span>
### sub_video_source
```objectivec
@property (nonatomic, assign) TALWTNSubVideoSource sub_video_source;
```
Subscribe video source. See [TALWTNSubVideoSource](#talwtnsubvideosource).



# TALWTNEncodedVideoFrame
```objectivec
@interface TALWTNEncodedVideoFrame: NSObject
```

Encoded video frame struct


## Member Property

| Type | Name |
| --- | --- |
| **TALWTNEncodedVideoFrameType** | [codec_type](#TALWTNEncodedVideoFrame-codec_type) |
| **const uint8_t*** | [data](#TALWTNEncodedVideoFrame-data) |
| **int** | [size](#TALWTNEncodedVideoFrame-size) |
| **int** | [width](#TALWTNEncodedVideoFrame-width) |
| **int** | [height](#TALWTNEncodedVideoFrame-height) |
| **unsigned** | [timestamp_ms](#TALWTNEncodedVideoFrame-timestamp_ms) |
| **int** | [rotation](#TALWTNEncodedVideoFrame-rotation) |
| **BOOL** | [is_key_frame](#TALWTNEncodedVideoFrame-is_key_frame) |


## Instructions
<span id="TALWTNEncodedVideoFrame-codec_type"></span>
### codec_type
```objectivec
@property (nonatomic, assign) TALWTNEncodedVideoFrameType codec_type;
```
Frame type. Only H264 - Annex B supported.


<span id="TALWTNEncodedVideoFrame-data"></span>
### data
```objectivec
@property (nonatomic, assign) const uint8_t * data;
```
data buffer


<span id="TALWTNEncodedVideoFrame-size"></span>
### size
```objectivec
@property (nonatomic, assign) int size;
```
data buffer size


<span id="TALWTNEncodedVideoFrame-width"></span>
### width
```objectivec
@property (nonatomic, assign) int width;
```
Width in px


<span id="TALWTNEncodedVideoFrame-height"></span>
### height
```objectivec
@property (nonatomic, assign) int height;
```
Height in px


<span id="TALWTNEncodedVideoFrame-timestamp_ms"></span>
### timestamp_ms
```objectivec
@property (nonatomic, assign) unsigned long timestamp_ms;
```
Timestamp in ms


<span id="TALWTNEncodedVideoFrame-rotation"></span>
### rotation
```objectivec
@property (nonatomic, assign) int rotation;
```
Counterclockwise rotation in degrees. Options are 0, 90, 180, 270。


<span id="TALWTNEncodedVideoFrame-is_key_frame"></span>
### is_key_frame
```objectivec
@property (nonatomic, assign) BOOL is_key_frame;
```
key frame or not. If it is a key frame, it must contain SPS and PPS information.



# TALWTNVideoFrame
```objectivec
@interface TALWTNVideoFrame: NSObject
```

Video frame struct


## Member Property

| Type | Name |
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


## Instructions
<span id="TALWTNVideoFrame-type"></span>
### type
```objectivec
@property (nonatomic, assign) TALWTNVideoFrameType type;
```
Frame type. Only YUV I420 supported.


<span id="TALWTNVideoFrame-y_buffer"></span>
### y_buffer
```objectivec
@property (nonatomic, assign) const uint8_t * y_buffer;
```
Y buffer


<span id="TALWTNVideoFrame-u_buffer"></span>
### u_buffer
```objectivec
@property (nonatomic, assign) const uint8_t * u_buffer;
```
U buffer


<span id="TALWTNVideoFrame-v_buffer"></span>
### v_buffer
```objectivec
@property (nonatomic, assign) const uint8_t * v_buffer;
```
V buffer


<span id="TALWTNVideoFrame-y_stride"></span>
### y_stride
```objectivec
@property (nonatomic, assign) int y_stride;
```
Y stride


<span id="TALWTNVideoFrame-u_stride"></span>
### u_stride
```objectivec
@property (nonatomic, assign) int u_stride;
```
U stride


<span id="TALWTNVideoFrame-v_stride"></span>
### v_stride
```objectivec
@property (nonatomic, assign) int v_stride;
```
V stride


<span id="TALWTNVideoFrame-width"></span>
### width
```objectivec
@property (nonatomic, assign) int width;
```
Width in px


<span id="TALWTNVideoFrame-height"></span>
### height
```objectivec
@property (nonatomic, assign) int height;
```
Height in px


<span id="TALWTNVideoFrame-timestamp_ms"></span>
### timestamp_ms
```objectivec
@property (nonatomic, assign) unsigned long timestamp_ms;
```
Timestamp in ms


<span id="TALWTNVideoFrame-rotation"></span>
### rotation
```objectivec
@property (nonatomic, assign) int rotation;
```
Counterclockwise rotation. The options are 0, 90, 180, and 270.



# TALWTNAudioFrame
```objectivec
@interface TALWTNAudioFrame: NSObject
```

Audio frame


## Member Property

| Type | Name |
| --- | --- |
| **TALWTNAudioFrameType** | [type](#TALWTNAudioFrame-type) |
| **const uint8_t*** | [data](#TALWTNAudioFrame-data) |
| **int** | [sample_length](#TALWTNAudioFrame-sample_length) |
| **unsigned** | [timestamp_ms](#TALWTNAudioFrame-timestamp_ms) |
| **int** | [sample_rate](#TALWTNAudioFrame-sample_rate) |
| **int** | [channels](#TALWTNAudioFrame-channels) |


## Instructions
<span id="TALWTNAudioFrame-type"></span>
### type
```objectivec
@property (nonatomic, assign) TALWTNAudioFrameType type;
```
Frame type. Only PCM16 support.


<span id="TALWTNAudioFrame-data"></span>
### data
```objectivec
@property (nonatomic, assign) const uint8_t * data;
```
data buffer


<span id="TALWTNAudioFrame-sample_length"></span>
### sample_length
```objectivec
@property (nonatomic, assign) int sample_length;
```
data buffer size


<span id="TALWTNAudioFrame-timestamp_ms"></span>
### timestamp_ms
```objectivec
@property (nonatomic, assign) unsigned long timestamp_ms;
```
Timestamp in ms


<span id="TALWTNAudioFrame-sample_rate"></span>
### sample_rate
```objectivec
@property (nonatomic, assign) int sample_rate;
```
SampleRate


<span id="TALWTNAudioFrame-channels"></span>
### channels
```objectivec
@property (nonatomic, assign) int channels;
```
Number of channels



# TALWTNVideoConfig
```objectivec
@interface TALWTNVideoConfig: NSObject
```

Video config


## Member Property

| Type | Name |
| --- | --- |
| **int** | [width](#TALWTNVideoConfig-width) |
| **int** | [height](#TALWTNVideoConfig-height) |
| **int** | [max_fps](#TALWTNVideoConfig-max_fps) |


## Instructions
<span id="TALWTNVideoConfig-width"></span>
### width
```objectivec
@property (nonatomic, assign) int width;
```
Width in px. 640 by default.


<span id="TALWTNVideoConfig-height"></span>
### height
```objectivec
@property (nonatomic, assign) int height;
```
Height in px. 960 by default.


<span id="TALWTNVideoConfig-max_fps"></span>
### max_fps
```objectivec
@property (nonatomic, assign) int max_fps;
```
Maximum fps. 15 by default.



# TALWTNStallInfo
```objectivec
@interface TALWTNStallInfo: NSObject
```

Video stall info


## Member Property

| Type | Name |
| --- | --- |
| **int** | [stall_count_500](#TALWTNStallInfo-stall_count_500) |
| **int** | [stall_duration_500](#TALWTNStallInfo-stall_duration_500) |
| **int** | [stall_count_200](#TALWTNStallInfo-stall_count_200) |
| **int** | [stall_duration_200](#TALWTNStallInfo-stall_duration_200) |
| **int** | [frame_rate](#TALWTNStallInfo-frame_rate) |


## Instructions
<span id="TALWTNStallInfo-stall_count_500"></span>
### stall_count_500
```objectivec
@property (nonatomic, assign) int stall_count_500;
```
Stall count in 500ms


<span id="TALWTNStallInfo-stall_duration_500"></span>
### stall_duration_500
```objectivec
@property (nonatomic, assign) int stall_duration_500;
```
Stall duration in 500ms


<span id="TALWTNStallInfo-stall_count_200"></span>
### stall_count_200
```objectivec
@property (nonatomic, assign) int stall_count_200;
```
Stall count in 200ms


<span id="TALWTNStallInfo-stall_duration_200"></span>
### stall_duration_200
```objectivec
@property (nonatomic, assign) int stall_duration_200;
```
Stall duration in 200ms


<span id="TALWTNStallInfo-frame_rate"></span>
### frame_rate
```objectivec
@property (nonatomic, assign) int frame_rate;
```
Frame rate



# TALWTNRTCAudioStats
```objectivec
@interface TALWTNRTCAudioStats: NSObject
```

Audio stats


## Member Property

| Type | Name |
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


## Instructions
<span id="TALWTNRTCAudioStats-bytes_sent"></span>
### bytes_sent
```objectivec
@property (nonatomic, assign) int64_t bytes_sent;
```
Number of bytes sent.


<span id="TALWTNRTCAudioStats-bytes_received"></span>
### bytes_received
```objectivec
@property (nonatomic, assign) int64_t bytes_received;
```
Number of bytes received.


<span id="TALWTNRTCAudioStats-bytes_sent_per_second"></span>
### bytes_sent_per_second
```objectivec
@property (nonatomic, assign) double bytes_sent_per_second;
```
Number of bytes sent per second.


<span id="TALWTNRTCAudioStats-bytes_received_per_second"></span>
### bytes_received_per_second
```objectivec
@property (nonatomic, assign) double bytes_received_per_second;
```
Number of bytes received per second.


<span id="TALWTNRTCAudioStats-audio_level"></span>
### audio_level
```objectivec
@property (nonatomic, assign) double audio_level;
```
audio level. <br>
The range is `[0, 1.0]`. When the value is `1.0`, the sound pressure level is 0dBov; when the value is `0.5`, the sound pressure level is 6dB SPL.


<span id="TALWTNRTCAudioStats-total_audio_energy"></span>
### total_audio_energy
```objectivec
@property (nonatomic, assign) double total_audio_energy;
```
Total audio energy. Higher the value, bigger the total energy.


<span id="TALWTNRTCAudioStats-codec_id"></span>
### codec_id
```objectivec
@property (nonatomic, strong) NSString* codec_id;
```
codec ID


<span id="TALWTNRTCAudioStats-round_trip_time_measurements"></span>
### round_trip_time_measurements
```objectivec
@property (nonatomic, assign) uint64_t round_trip_time_measurements;
```
The total number of the received RTCP RR packets.


<span id="TALWTNRTCAudioStats-total_round_trip_time"></span>
### total_round_trip_time
```objectivec
@property (nonatomic, assign) double total_round_trip_time;
```
Total rtt time in seconds. You can get the average rtt time by dividing `totalRoundTripTime` by `roundTripTimeMeasurements`.


<span id="TALWTNRTCAudioStats-packets_sent"></span>
### packets_sent
```objectivec
@property (nonatomic, assign) uint32_t packets_sent;
```
packets sent


<span id="TALWTNRTCAudioStats-packets_received"></span>
### packets_received
```objectivec
@property (nonatomic, assign) uint32_t packets_received;
```
packets received


<span id="TALWTNRTCAudioStats-packets_lost"></span>
### packets_lost
```objectivec
@property (nonatomic, assign) uint32_t packets_lost;
```
Packets lost during publishing.


<span id="TALWTNRTCAudioStats-franction_loss"></span>
### franction_loss
```objectivec
@property (nonatomic, assign) double franction_loss;
```
Packet lost rate during publishing. The range is `[0, 1.0]`.


<span id="TALWTNRTCAudioStats-jitter"></span>
### jitter
```objectivec
@property (nonatomic, assign) double jitter;
```
jitter in seconds.



# TALWTNRTCVideoStats
```objectivec
@interface TALWTNRTCVideoStats: NSObject
```

Video stats


## Member Property

| Type | Name |
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


## Instructions
<span id="TALWTNRTCVideoStats-bytes_sent"></span>
### bytes_sent
```objectivec
@property (nonatomic, assign) int64_t bytes_sent;
```
Number of bytes sent, in bytes


<span id="TALWTNRTCVideoStats-bytes_received"></span>
### bytes_received
```objectivec
@property (nonatomic, assign) int64_t bytes_received;
```
Number of bytes received, in bytes


<span id="TALWTNRTCVideoStats-bytes_sent_per_second"></span>
### bytes_sent_per_second
```objectivec
@property (nonatomic, assign) int64_t bytes_sent_per_second;
```
Number of bytes sent per second, in bytes


<span id="TALWTNRTCVideoStats-bytes_received_per_second"></span>
### bytes_received_per_second
```objectivec
@property (nonatomic, assign) int64_t bytes_received_per_second;
```
Number of bytes received per second, in bytes


<span id="TALWTNRTCVideoStats-frame_width"></span>
### frame_width
```objectivec
@property (nonatomic, assign) int64_t frame_width;
```
Video frame width in px.


<span id="TALWTNRTCVideoStats-frame_height"></span>
### frame_height
```objectivec
@property (nonatomic, assign) int64_t frame_height;
```
Video frame height in px.


<span id="TALWTNRTCVideoStats-frames_per_second"></span>
### frames_per_second
```objectivec
@property (nonatomic, assign) double frames_per_second;
```
frames per second


<span id="TALWTNRTCVideoStats-codec_id"></span>
### codec_id
```objectivec
@property (nonatomic, strong) NSString* codec_id;
```
codec ID


<span id="TALWTNRTCVideoStats-round_trip_time_measurements"></span>
### round_trip_time_measurements
```objectivec
@property (nonatomic, assign) uint64_t round_trip_time_measurements;
```
The total number of the received RTCP RR packets.


<span id="TALWTNRTCVideoStats-total_round_trip_time"></span>
### total_round_trip_time
```objectivec
@property (nonatomic, assign) double total_round_trip_time;
```
Total rtt time in seconds. You can get the average rtt time by dividing `totalRoundTripTime` by `roundTripTimeMeasurements`.


<span id="TALWTNRTCVideoStats-packets_sent"></span>
### packets_sent
```objectivec
@property (nonatomic, assign) uint32_t packets_sent;
```
packets sent


<span id="TALWTNRTCVideoStats-packets_received"></span>
### packets_received
```objectivec
@property (nonatomic, assign) uint32_t packets_received;
```
packets received


<span id="TALWTNRTCVideoStats-packets_lost"></span>
### packets_lost
```objectivec
@property (nonatomic, assign) uint32_t packets_lost;
```
Packets lost during publishing.


<span id="TALWTNRTCVideoStats-franction_loss"></span>
### franction_loss
```objectivec
@property (nonatomic, assign) double franction_loss;
```
Packet lost rate during publishing. The range is `[0, 1.0]`.


<span id="TALWTNRTCVideoStats-jitter"></span>
### jitter
```objectivec
@property (nonatomic, assign) double jitter;
```
jitter in seconds.




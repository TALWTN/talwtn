# TALWTNEngine
```objectivec
@interface TALWTNEngine : NSObject
```

TALWTNEngine Class


## 成员函数

| 返回 | 名称 |
| --- | --- |
| **instancetype** | [initWithDelegate:](#TALWTNEngine-initwithdelegate) |
| **TALWTNPublisher*** | [createPublisher:](#TALWTNEngine-createpublisher) |
| **void** | [destroyPublisher:](#TALWTNEngine-destroypublisher) |
| **TALWTNSubscriber*** | [createSubscriber:](#TALWTNEngine-createsubscriber) |
| **void** | [destroySubscriber:](#TALWTNEngine-destroysubscriber) |


## 函数说明
<span id="TALWTNEngine-initwithdelegate"></span>
### initWithDelegate:
```objectivec

- (instancetype)initWithDelegate:(id<TALWTNEngineDelegate>)delegate;
```
创建引擎实例

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| delegate | **id<TALWTNEngineDelegate>** | 参看 [TALWTNEngineDelegate](callback.md#talwtnenginedelegate)。 |

**返回值**
创建成功时。返回一个可用的引擎实例


**注意**
至多只能创建一个引擎。

<span id="TALWTNEngine-createpublisher"></span>
### createPublisher:
```objectivec

- (TALWTNPublisher *)createPublisher:(TALWTNPubExtraParam*)pub_extra_param;
```
创建 Publisher 实例。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| pub_extra_param | **TALWTNPubExtraParam*** | 参看 [TALWTNPubExtraParam](keytype.md#talwtnpubextraparam)。 |

**返回值**

+ Publisher：创建成功。返回一个可用的 [TALWTNPublisher](#talwtnpublisher) 实例  
+ Null：创建失败。可能原因有：已经有一个内部源 Publisher。


**注意**
在发布时，你可以创建任意个外部源，但至多只能创建一个内部源。

<span id="TALWTNEngine-destroypublisher"></span>
### destroyPublisher:
```objectivec

- (void)destroyPublisher:(TALWTNPublisher*)publisher;
```
销毁由 [createPublisher:](#TALWTNEngine-createpublisher) 所创建的 Publisher 实例，并释放所有相关资源


**注意**

+ 请确保和需要销毁的 [TALWTNPublisher](#talwtnpublisher) 实例相关的业务场景全部结束后，才调用此方法  
+ 该方法在调用之后，会销毁所有和此 [TALWTNPublisher](#talwtnpublisher) 实例相关的内存，并且停止与媒体服务器的任何交互  


<span id="TALWTNEngine-createsubscriber"></span>
### createSubscriber:
```objectivec

- (TALWTNSubscriber *)createSubscriber:(TALWTNSubExtraParam*)sub_extra_param;
```
创建 TALWTNSubscriber 实例。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| sub_extra_param | **TALWTNSubExtraParam*** | 参看 [TALWTNSubExtraParam](keytype.md#talwtnsubextraparam)。 |

**返回值**

+ Subscriber: 创建成功。返回一个可用的 [TALWTNSubscriber](#talwtnsubscriber) 实例  
+ Null: 创建失败。可能原因有：已经有一个内部源 Subscriber。


**注意**
在发布时，你可以创建任意个外部源，但至多只能创建一个内部源。

<span id="TALWTNEngine-destroysubscriber"></span>
### destroySubscriber:
```objectivec

- (void)destroySubscriber:(TALWTNSubscriber*)subscriber;
```
销毁由 [createSubscriber:](#TALWTNEngine-createsubscriber) 所创建的 TALWTNSubscriber 实例，并释放所有相关资源。


**注意**

+ 请确保和需要销毁的 [TALWTNSubscriber](#talwtnsubscriber) 实例相关的业务场景全部结束后，才调用此方法  
+ 该方法在调用之后，会销毁所有和此 [TALWTNSubscriber](#talwtnsubscriber) 实例相关的内存，并且停止与媒体服务器的任何交互  


# TALWTNPublisher
```objectivec
@interface TALWTNPublisher : NSObject
```

TALWTNPublisher Class


## 成员函数

| 返回 | 名称 |
| --- | --- |
| **int** | [startPublish:](#TALWTNPublisher-startpublish) |
| **int** | [stopPublish](#TALWTNPublisher-stoppublish) |
| **BOOL** | [isPublishing](#TALWTNPublisher-ispublishing) |
| **void** | [setLocalView:](#TALWTNPublisher-setlocalview) |
| **int** | [setVideoConfig:](#TALWTNPublisher-setvideoconfig) |
| **int** | [startVideoCapture](#TALWTNPublisher-startvideocapture) |
| **int** | [stopVideoCapture](#TALWTNPublisher-stopvideocapture) |
| **int** | [switchCamera](#TALWTNPublisher-switchcamera) |
| **int** | [startAudioCapture](#TALWTNPublisher-startaudiocapture) |
| **int** | [stopAudioCapture](#TALWTNPublisher-stopaudiocapture) |
| **int** | [setLocalAudioMute:](#TALWTNPublisher-setlocalaudiomute) |
| **int** | [setLocalVideoMute:](#TALWTNPublisher-setlocalvideomute) |
| **BOOL** | [pushEncodedVideoFrame:](#TALWTNPublisher-pushencodedvideoframe) |
| **BOOL** | [pushVideoFrame:](#TALWTNPublisher-pushvideoframe) |
| **BOOL** | [pushAudioFrame:](#TALWTNPublisher-pushaudioframe) |


## 函数说明
<span id="TALWTNPublisher-startpublish"></span>
### startPublish:
```objectivec

- (int)startPublish:(NSString*)url;
```
发布音视频流

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| url | **NSString*** | WHIP 请求的 url。<br/>url 由 WTN 固定域名 `https://wtn.volcvideo.com`，PUB 方法，appID，你设定的 streamID, token 和 TokenType 拼接得到。 <br/>形如：`https://wtn.volcvideo.com/pub/<appID>/<streamID>?Token=<token>&TokenType=Bearer` |

**返回值**

+ 0：方法调用成功  
+ < 0：方法调用失败  


**注意**

+ 对于一个 TALWTNPublisher 实例，仅能同时发布一路音视频流。重复调用此接口会失败。
+ 无论是否开启音视频采集，你都可以调用此接口开启发布。
+ 调用此接口后，会收到 [onPublishStateChanged:publishState:reason:](callback.md#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason)。
+ 调用 [stopPublish](#TALWTNPublisher-stoppublish) 取消发布。


<span id="TALWTNPublisher-stoppublish"></span>
### stopPublish
```objectivec

- (int)stopPublish;
```
停止发布音视频流

**返回值**

+ 0：方法调用成功  
+ < 0：方法调用失败


**注意**

+ 调用 [startPublish:](#TALWTNPublisher-startpublish) 发布音视频流。
+ 调用此接口后，会收到 [onPublishStateChanged:publishState:reason:](callback.md#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason)。


<span id="TALWTNPublisher-ispublishing"></span>
### isPublishing
```objectivec

- (BOOL)isPublishing;
```
查询音视频流发布状态

**返回值**

+ true：发布中 
+ false：未发布 


<span id="TALWTNPublisher-setlocalview"></span>
### setLocalView:
```objectivec

- (void)setLocalView:(UIView*)view;
```
设置本地视频渲染时使用的视图。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| view | **UIView*** | 视图对象。必须保证此对象处于有效的生命周期内。 |

**返回值**

+ 0: 成功  
+ -1: 失败。 


**注意**

+ 如果需要解除绑定，你可以调用本方法传入空视图。
+ 必须在调用 [startVideoCapture](#TALWTNPublisher-startvideocapture) 前调用此接口。


<span id="TALWTNPublisher-setvideoconfig"></span>
### setVideoConfig:
```objectivec

- (int)setVideoConfig:(TALWTNVideoConfig*)video_config;
```
设置视频采集参数

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| video_config | **TALWTNVideoConfig*** | 视频采集参数。参看 [TALWTNVideoConfig](keytype.md#talwtnvideoconfig)。 |

**返回值**

+ 0: 成功  
+ < 0: 失败  


**注意**

+ 必须在调用 [startVideoCapture](#TALWTNPublisher-startvideocapture) 前调用此接口。


<span id="TALWTNPublisher-startvideocapture"></span>
### startVideoCapture
```objectivec

- (int)startVideoCapture;
```
开启摄像头采集。默认为关闭状态。  <br>

**返回值**

+ 0: 成功  
+ -1: 失败。 


**注意**

+ 发布前后都可调用。 
+ 调用 [stopVideoCapture](#TALWTNPublisher-stopvideocapture) 可以停止摄像头采集。 
+ 采集使用的摄像头由 [switchCamera](#TALWTNPublisher-switchcamera) 指定。


<span id="TALWTNPublisher-stopvideocapture"></span>
### stopVideoCapture
```objectivec

- (int)stopVideoCapture;
```
关闭摄像头采集。

**返回值**

+ 0: 成功  
+ -1: 失败。 


**注意**

+ 调用 [startVideoCapture](#TALWTNPublisher-startvideocapture) 可以开启摄像头采集。  
+ 如果不调用本方法停止采集，则只有当销毁 Publisher 实例时，摄像头采集才会停止。   


<span id="TALWTNPublisher-switchcamera"></span>
### switchCamera
```objectivec

- (int)switchCamera;
```
切换摄像头采集时使用的前置/后置摄像头。

**返回值**

+ 0：方法调用成功  
+ < 0：方法调用失败  


**注意**

+ 默认使用前置摄像头。
+ 如果你正在使用相机进行视频采集，切换操作当即生效；如果未处于采集状态，后续开启摄像头采集时，会打开设定的摄像头。


<span id="TALWTNPublisher-startaudiocapture"></span>
### startAudioCapture
```objectivec

- (int)startAudioCapture;
```
开启麦克风采集。默认为关闭状态。  <br>

**返回值**

+ 0：方法调用成功  
+ < 0：方法调用失败  


**注意**

+ 调用 [stopAudioCapture](#TALWTNPublisher-stopaudiocapture) 可以关闭音频采集设备。 
+ 无论是否发布音频数据，你都可以调用此方法开启麦克风采集。


<span id="TALWTNPublisher-stopaudiocapture"></span>
### stopAudioCapture
```objectivec

- (int)stopAudioCapture;
```
关闭麦克风采集。

**返回值**

+ 0：方法调用成功  
+ < 0：方法调用失败  


**注意**

+ 调用 [startAudioCapture](#TALWTNPublisher-startaudiocapture) 可以开启麦克风采集。  
+ 如果不调用此方法停止麦克风采集，则只有当销毁 Publisher 实例时，麦克风采集才会停止。


<span id="TALWTNPublisher-setlocalaudiomute"></span>
### setLocalAudioMute:
```objectivec

- (int)setLocalAudioMute:(BOOL)mute;
```
mute 本地音频，不发布。默认值为发布。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| mute | **BOOL** | 是否发布音频数据。 |

**返回值**

+ 0: Success 
+ < 0: Failure 


**注意**
发布前后都可调用，独立于采集。

<span id="TALWTNPublisher-setlocalvideomute"></span>
### setLocalVideoMute:
```objectivec

- (int)setLocalVideoMute:(BOOL)mute;
```
mute 本地视频，不发布。默认值为发布。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| mute | **BOOL** | 是否发布视频数据。 |

**返回值**

+ 0: Success 
+ < 0: Failure 


**注意**
发布前后都可调用，独立于采集。

<span id="TALWTNPublisher-pushencodedvideoframe"></span>
### pushEncodedVideoFrame:
```objectivec

- (BOOL)pushEncodedVideoFrame:(TALWTNEncodedVideoFrame*)encoded_frame;
```
推送外部编码帧。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| encoded_frame | **TALWTNEncodedVideoFrame*** | 外部编码帧。参看 [TALWTNEncodedVideoFrame](keytype.md#talwtnencodedvideoframe)。在推送过程中，帧的分辨率应保持一致。 |

**返回值**

+ 0：调用成功；
+ <0：调用失败


**注意**

+ 不支持编码反馈和请求关键帧反馈。
+ 根据实际帧率，周期推送外部编码帧。


<span id="TALWTNPublisher-pushvideoframe"></span>
### pushVideoFrame:
```objectivec

- (BOOL)pushVideoFrame:(TALWTNVideoFrame*)video_frame;
```
推送外部视频帧。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| video_frame | **TALWTNVideoFrame*** | 视频帧。参看 [TALWTNVideoFrame](keytype.md#talwtnvideoframe)。在推送过程中，帧的分辨率应保持一致，帧的宽高应为 16 的倍数。 |

**返回值**

+ 0：调用成功；
+ <0：调用失败


**注意**
根据实际帧率，周期推送外部编码帧。

<span id="TALWTNPublisher-pushaudioframe"></span>
### pushAudioFrame:
```objectivec

- (BOOL)pushAudioFrame:(TALWTNAudioFrame*)audio_frame;
```
推送外部音频帧

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| audio_frame | **TALWTNAudioFrame*** | 音频帧。参看 [TALWTNAudioFrame](keytype.md#talwtnaudioframe)。在推送过程中，帧的参数应保持一致。 |

**返回值**

+ 0：调用成功；
+ <0：调用失败


**注意**
周期推送外部编码帧。建议周期为 10 ms。

# TALWTNSubscriber
```objectivec
@interface TALWTNSubscriber : NSObject
```

TALWTNSubscriber Class


## 成员函数

| 返回 | 名称 |
| --- | --- |
| **int** | [startSubscribe:](#TALWTNSubscriber-startsubscribe) |
| **int** | [stopSubscribe](#TALWTNSubscriber-stopsubscribe) |
| **BOOL** | [isSubscribed](#TALWTNSubscriber-issubscribed) |
| **int** | [setEnableSpeaker:](#TALWTNSubscriber-setenablespeaker) |
| **int** | [setRemoteView:](#TALWTNSubscriber-setremoteview) |
| **int** | [setRemoteAudioMute:](#TALWTNSubscriber-setremoteaudiomute) |
| **int** | [setRemoteVideoMute:](#TALWTNSubscriber-setremotevideomute) |


## 函数说明
<span id="TALWTNSubscriber-startsubscribe"></span>
### startSubscribe:
```objectivec

- (int)startSubscribe:(NSString*)url;
```
开启订阅音视频流。  <br>
调用该方法后，本地用户会收到 [onSubscribeStateChanged:subscribeState:reason:](callback.md#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason) 的回调。  <br>

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| url | **NSString*** | WHIP 请求的 url。<br/>url 由 WTN 固定域名 `https://wtn.volcvideo.com`，SUB 方法，appID，和你设定的 streamID 拼接得到。 <br/>形如：`https://wtn.volcvideo.com/sub/<appID>/<streamID>` |

**返回值**

+ 0: 成功  
+ -1: 失败。 


**注意**

+ 一个 TALWTNSubscriber 实例仅可以订阅一路音视频流。
+ 订阅音视频流前，请先确保此流已发布。如果未发布，会订阅失败。 
+ 订阅前需要先调用 [setRemoteView:](#TALWTNSubscriber-setremoteview) 设置视图。 
+ 调用 [stopSubscribe](#TALWTNSubscriber-stopsubscribe) 可以停止订阅。 


<span id="TALWTNSubscriber-stopsubscribe"></span>
### stopSubscribe
```objectivec

- (int)stopSubscribe;
```
停止订阅音视频流

**返回值**

+ 0：方法调用成功  
+ < 0：方法调用失败  


**注意**

+ 调用 [startSubscribe:](#TALWTNSubscriber-startsubscribe) 发布音视频流。
+ 调用该方法后，会收到 [onSubscribeStateChanged:subscribeState:reason:](callback.md#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason) 的回调。


<span id="TALWTNSubscriber-issubscribed"></span>
### isSubscribed
```objectivec

- (BOOL)isSubscribed;
```
查询音视频流订阅状态

**返回值**

+ true：正在订阅 
+ false：未订阅 


<span id="TALWTNSubscriber-setenablespeaker"></span>
### setEnableSpeaker:
```objectivec

- (int)setEnableSpeaker:(BOOL)enable;
```
切换播放音频流时使用的听筒/扬声器 <br>

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| enable | **BOOL** | • true：扬声器 <br/>• false：听筒 |

**返回值**

+ 0: 成功  
+ -1: 失败。 


**注意**

+ 默认使用扬声器。 
+ 此设置在播放音频流前后都可以生效。


<span id="TALWTNSubscriber-setremoteview"></span>
### setRemoteView:
```objectivec

- (int)setRemoteView:(UIView*)view;
```
设置渲染远端视频流时使用的视图

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| view | **UIView*** | 视图对象。必须保证此对象处于有效的生命周期内。 |

**返回值**

+ 0: 成功  
+ -1: 失败。 


**注意**

+ 你必须在订阅前，设置渲染视图。 
+ 如果需要解除绑定，你可以调用本方法传入空视图。


<span id="TALWTNSubscriber-setremoteaudiomute"></span>
### setRemoteAudioMute:
```objectivec

- (int)setRemoteAudioMute:(BOOL)mute;
```
mute 远端音频，不订阅。默认值为订阅。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| mute | **BOOL** | 是否订阅音频数据。 |

**返回值**

+ 0: Success 
+ < 0: Failure 


**注意**
发布前后都可调用。

<span id="TALWTNSubscriber-setremotevideomute"></span>
### setRemoteVideoMute:
```objectivec

- (int)setRemoteVideoMute:(BOOL)mute;
```
mute 远端视频，不订阅。默认值为订阅。

**传入参数**

| 参数名 | 类型 | 说明 |
| --- | --- | --- |
| mute | **BOOL** | 是否订阅视频数据。 |

**返回值**

+ 0: Success 
+ < 0: Failure 


**注意**
发布前后都可调用。


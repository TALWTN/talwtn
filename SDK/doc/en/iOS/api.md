# TALWTNEngine
```objectivec
@interface TALWTNEngine : NSObject
```

TALWTNEngine Class


## Member Functions

| Return | Name |
| --- | --- |
| **instancetype** | [initWithDelegate:](#TALWTNEngine-initwithdelegate) |
| **TALWTNPublisher*** | [createPublisher:](#TALWTNEngine-createpublisher) |
| **void** | [destroyPublisher:](#TALWTNEngine-destroypublisher) |
| **TALWTNSubscriber*** | [createSubscriber:](#TALWTNEngine-createsubscriber) |
| **void** | [destroySubscriber:](#TALWTNEngine-destroysubscriber) |


## Instructions
<span id="TALWTNEngine-initwithdelegate"></span>
### initWithDelegate:
```objectivec

- (instancetype)initWithDelegate:(id<TALWTNEngineDelegate>)delegate;
```
Create the engine instance.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| delegate | **id<TALWTNEngineDelegate>** | See [TALWTNEngineDelegate](callback.md#talwtnenginedelegate). |

**Return Value**
A successfully created engine instance.


**Notes**
You can create no more than one engine instance.

<span id="TALWTNEngine-createpublisher"></span>
### createPublisher:
```objectivec

- (TALWTNPublisher *)createPublisher:(TALWTNPubExtraParam*)pub_extra_param;
```
Create the Publisher instance.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| pub_extra_param | **TALWTNPubExtraParam*** | See [TALWTNPubExtraParam](keytype.md#talwtnpubextraparam). |

**Return Value**

+ Publisher: A successfully created [TALWTNPublisher](#talwtnpublisher) instance.  
+ Null: Failed to create. Possible reasons are: Creating an internal source Publisher when an internal one exists.


**Notes**
You may create multiple Publisher with external sources, but no more than one Publisher with internal source.

<span id="TALWTNEngine-destroypublisher"></span>
### destroyPublisher:
```objectivec

- (void)destroyPublisher:(TALWTNPublisher*)publisher;
```
Destroy the Publisher instance created by [createPublisher:](#TALWTNEngine-createpublisher), and release all related resources. <br>


**Notes**

+ Call this API after all business scenarios related to the instance are destroyed.  
+ When the API is called, the SDK destroys all memory associated with the instance and stops any interaction with the media server.  


<span id="TALWTNEngine-createsubscriber"></span>
### createSubscriber:
```objectivec

- (TALWTNSubscriber *)createSubscriber:(TALWTNSubExtraParam*)sub_extra_param;
```
Create the Subscriber instance.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| sub_extra_param | **TALWTNSubExtraParam*** | See [TALWTNSubExtraParam](keytype.md#talwtnsubextraparam). |

**Return Value**

+ Subscriber: A successfully created [TALWTNSubscriber](#talwtnsubscriber) instance.  
+ Null: Failed to create. Possible reasons are: Creating an internal source Subscriber when an internal one exists.


**Notes**
You may create multiple Subscriber with external sources, but no more than one Subscriber with internal source.

<span id="TALWTNEngine-destroysubscriber"></span>
### destroySubscriber:
```objectivec

- (void)destroySubscriber:(TALWTNSubscriber*)subscriber;
```
Destroy the Subscriber instance created by [createSubscriber:](#TALWTNEngine-createsubscriber), and release all related resources. <br>


**Notes**

+ Call this API after all business scenarios related to the [TALWTNSubscriber](#talwtnsubscriber) instance are destroyed.  
+ When the API is called, the SDK destroys all memory associated with the instance and stops any interaction with the media server.  


# TALWTNPublisher
```objectivec
@interface TALWTNPublisher : NSObject
```

TALWTNPublisher Class


## Member Functions

| Return | Name |
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


## Instructions
<span id="TALWTNPublisher-startpublish"></span>
### startPublish:
```objectivec

- (int)startPublish:(NSString*)url;
```
Publish the captured media stream.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| url | **NSString*** | The url for WHIP request. <br/>Concatenate the fixed url `https://wtn.volcvideo.com`, PUB method, appID, your specified streamID, token and TokenType into the value of url. <br/>The url is like `https://wtn.volcvideo.com/pub/<appID>/<streamID>?Token=<token>&TokenType=Bearer`. |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ You can only publish one media stream with one TALWTNPublisher instance. Calling this API during publishing will fail. 
+ You can call this API to start publishing media streams with or without media capture. 
+ After calling this API, you will receive [onPublishStateChanged:publishState:reason:](callback.md#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason). 
+ Call [stopPublish](#TALWTNPublisher-stoppublish) to stop publishing the media stream.


<span id="TALWTNPublisher-stoppublish"></span>
### stopPublish
```objectivec

- (int)stopPublish;
```
Stops publishing the media stream.

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ Call [startPublish:](#TALWTNPublisher-startpublish) to publish the media stream. 
+ After calling this API, you will receive [onPublishStateChanged:publishState:reason:](callback.md#TALWTNEngineDelegate-onpublishstatechanged-publishstate-reason).


<span id="TALWTNPublisher-ispublishing"></span>
### isPublishing
```objectivec

- (BOOL)isPublishing;
```
Inspect the media stream publishing status.

**Return Value**

+ true: Publishing. 
+ false：Not publishing. 


<span id="TALWTNPublisher-setlocalview"></span>
### setLocalView:
```objectivec

- (void)setLocalView:(UIView*)view;
```
Binds the view to be used for local video rendering. <br>

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| view | **UIView*** | View object. The object must be of effective lifecycle. |

**Return Value**

+ 0: Success 
+ -1: Failure. The view is empty. 


**Notes**

+ To unbind the view, call this API with the view set to `null`. 
+ Bind the view before calling [startVideoCapture](#TALWTNPublisher-startvideocapture). 


<span id="TALWTNPublisher-setvideoconfig"></span>
### setVideoConfig:
```objectivec

- (int)setVideoConfig:(TALWTNVideoConfig*)video_config;
```
Set the video capture parameters.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| video_config | **TALWTNVideoConfig*** | See [TALWTNVideoConfig](keytype.md#talwtnvideoconfig). |

**Return Value**

+ 0: Success; 
+ < 0: Failure; 


**Notes**

+ You must call this API before calling [startVideoCapture](#TALWTNPublisher-startvideocapture). 


<span id="TALWTNPublisher-startvideocapture"></span>
### startVideoCapture
```objectivec

- (int)startVideoCapture;
```
Enable video capture. The default setting is off.   <br>

**Return Value**

+ 0: Success 
+ -1: Failure. The view is empty. 


**Notes**

+ You can call this API before or after publishing the stream. 
+ Call [stopVideoCapture](#TALWTNPublisher-stopvideocapture) to stop video capture. 
+ The camera used for video capture is set by [switchCamera](#TALWTNPublisher-switchcamera).


<span id="TALWTNPublisher-stopvideocapture"></span>
### stopVideoCapture
```objectivec

- (int)stopVideoCapture;
```
Stop video capture.

**Return Value**

+ 0: Success 
+ -1: Failure. The view is empty. 


**Notes**

+ Call [startVideoCapture](#TALWTNPublisher-startvideocapture) to enable video capture. 
+ Without calling this API, the video capture sustains until the Publisher instance is destroyed.


<span id="TALWTNPublisher-switchcamera"></span>
### switchCamera
```objectivec

- (int)switchCamera;
```
Switch the camera for video capture between front-facing/back-facing cameras.

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ Front-facing camera is the default camera. 
+ If the video capture is on-going, the switch is effective immediately. If the video capture is off, the set camera is used when video capture starts.


<span id="TALWTNPublisher-startaudiocapture"></span>
### startAudioCapture
```objectivec

- (int)startAudioCapture;
```
Start audio capture. The default is off.

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ Call [stopAudioCapture](#TALWTNPublisher-stopaudiocapture) to stop audio capture. 
+ You can call this API to start video capture whether to publish the audio stream.


<span id="TALWTNPublisher-stopaudiocapture"></span>
### stopAudioCapture
```objectivec

- (int)stopAudioCapture;
```
Stop audio capture.

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ Call [startAudioCapture](#TALWTNPublisher-startaudiocapture) to enable audio capture. 
+ Without calling this API, the audio capture will sustain until the Publisher instance is destroyed.


<span id="TALWTNPublisher-setlocalaudiomute"></span>
### setLocalAudioMute:
```objectivec

- (int)setLocalAudioMute:(BOOL)mute;
```
Mute the local audio. Do not publish the captured audio.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| mute | **BOOL** | Whether to publish the locally captured audio. |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ You can call this API before or after the media stream is published. 
+ You can call this API before or after the media is captured.


<span id="TALWTNPublisher-setlocalvideomute"></span>
### setLocalVideoMute:
```objectivec

- (int)setLocalVideoMute:(BOOL)mute;
```
Mute the local video. Do not publish the captured video.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| mute | **BOOL** | Whether to publish the locally captured video. |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ You can call this API before or after the media stream is published. 
+ You can call this API before or after the media is captured.


<span id="TALWTNPublisher-pushencodedvideoframe"></span>
### pushEncodedVideoFrame:
```objectivec

- (BOOL)pushEncodedVideoFrame:(TALWTNEncodedVideoFrame*)encoded_frame;
```
Push external encoded frame.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| encoded_frame | **TALWTNEncodedVideoFrame*** | Encoded frame. See [TALWTNEncodedVideoFrame](keytype.md#talwtnencodedvideoframe). During the process, the resolution of the frames must remain the same. |

**Return Value**

+ 0: Success 
+ <0: Failure


**Notes**

+ Do not support encoding feedback and request keyframe feedback. 
+ Push externally encoded frames periodically according to the actual frame rate.


<span id="TALWTNPublisher-pushvideoframe"></span>
### pushVideoFrame:
```objectivec

- (BOOL)pushVideoFrame:(TALWTNVideoFrame*)video_frame;
```
Push external video frame.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| video_frame | **TALWTNVideoFrame*** | Encoded frame. See [TALWTNVideoFrame](keytype.md#talwtnvideoframe). During the process, the resolution of the frames must remain the same. The frame width and the frame height must be multiples of 16. |

**Return Value**

+ 0: Success 
+ <0: Failure


**Notes**
Push external frames periodically according to the actual frame rate.

<span id="TALWTNPublisher-pushaudioframe"></span>
### pushAudioFrame:
```objectivec

- (BOOL)pushAudioFrame:(TALWTNAudioFrame*)audio_frame;
```
Push external audio data.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| audio_frame | **TALWTNAudioFrame*** | See [TALWTNAudioFrame](keytype.md#talwtnaudioframe). During the process, the parameters of the frames must remain the same. |

**Return Value**

+ 0: Success 
+ <0: Failure


**Notes**
Push external frames periodically. The period is recommended to be 10 ms.

# TALWTNSubscriber
```objectivec
@interface TALWTNSubscriber : NSObject
```

TALWTNSubscriber Class


## Member Functions

| Return | Name |
| --- | --- |
| **int** | [startSubscribe:](#TALWTNSubscriber-startsubscribe) |
| **int** | [stopSubscribe](#TALWTNSubscriber-stopsubscribe) |
| **BOOL** | [isSubscribed](#TALWTNSubscriber-issubscribed) |
| **int** | [setEnableSpeaker:](#TALWTNSubscriber-setenablespeaker) |
| **int** | [setRemoteView:](#TALWTNSubscriber-setremoteview) |
| **int** | [setRemoteAudioMute:](#TALWTNSubscriber-setremoteaudiomute) |
| **int** | [setRemoteVideoMute:](#TALWTNSubscriber-setremotevideomute) |


## Instructions
<span id="TALWTNSubscriber-startsubscribe"></span>
### startSubscribe:
```objectivec

- (int)startSubscribe:(NSString*)url;
```
Subscribe the remote media streams. <br>
After calling the API, you will receive [onSubscribeStateChanged:subscribeState:reason:](callback.md#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason).

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| url | **NSString*** | The url for WHIP request. <br/>Concatenate the fixed url `https://wtn.volcvideo.com`, SUB method, appID, and your specified streamID into the value of url. <br/>The url is like `https://wtn.volcvideo.com/sub/<appID>/<streamID>`. |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ You can only subscribe to one media stream with one TALWTNSubscriber instance. 
+ Ensure the stream is published before subscribe to the stream. 
+ Call [setRemoteView:](#TALWTNSubscriber-setremoteview) to set the remote view for the media stream before subscribing. 
+ Call [stopSubscribe](#TALWTNSubscriber-stopsubscribe) to stop subscribing.


<span id="TALWTNSubscriber-stopsubscribe"></span>
### stopSubscribe
```objectivec

- (int)stopSubscribe;
```
Stop subscribing to the media stream.

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ Call [startSubscribe:](#TALWTNSubscriber-startsubscribe) to start subscribing. 
+ Receive [onSubscribeStateChanged:subscribeState:reason:](callback.md#TALWTNEngineDelegate-onsubscribestatechanged-subscribestate-reason) after calling this API.


<span id="TALWTNSubscriber-issubscribed"></span>
### isSubscribed
```objectivec

- (BOOL)isSubscribed;
```
Inspect the subscribing state.

**Return Value**

+ true: Subscribing 
+ false: Not subscribing 


<span id="TALWTNSubscriber-setenablespeaker"></span>
### setEnableSpeaker:
```objectivec

- (int)setEnableSpeaker:(BOOL)enable;
```
Switch the rendering device for audio stream: earpiece or speakerphone.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| enable | **BOOL** | • true: earpiece <br/>• false：speakerphone |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**

+ Speakerphone is the default device. 
+ You can switch the audio rendering device before or after the audio rendering.


<span id="TALWTNSubscriber-setremoteview"></span>
### setRemoteView:
```objectivec

- (int)setRemoteView:(UIView*)view;
```
Binds the view to be used for remote video rendering. <br>

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| view | **UIView*** | View object. The object must be of effective lifecycle. |

**Return Value**

+ 0: Success 
+ -1: Failure. 


**Notes**

+ You must bind the view before subscribe to the video stream. 
+ To unbind the view, call this API with the view set to `null`.


<span id="TALWTNSubscriber-setremoteaudiomute"></span>
### setRemoteAudioMute:
```objectivec

- (int)setRemoteAudioMute:(BOOL)mute;
```
Mute the remote audio. Do not subscribe the captured audio.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| mute | **BOOL** | Whether to subscribe the remote audio. |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**
You can call this API before or after the media stream is published.

<span id="TALWTNSubscriber-setremotevideomute"></span>
### setRemoteVideoMute:
```objectivec

- (int)setRemoteVideoMute:(BOOL)mute;
```
Mute the remote video. Do not subscribe the captured video.

**Input Parameters**

| Name | Type | Instructions |
| --- | --- | --- |
| mute | **BOOL** | Whether to subscribe the remote video. |

**Return Value**

+ 0: Success 
+ < 0: Failure 


**Notes**
You can call this API before or after the media stream is published.


/*
 *  Copyright 2022 Beijing Volcanoengine Technology Ltd. All Rights Reserved.
 *
 *  SPDX-license-identifier: BSD-3-Clause
 */
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "TALWTNDefines.h"

NS_ASSUME_NONNULL_BEGIN

/** {zh}
 * @type api
 * @brief TALWTNSubscriber Class
 */
/** {en}
 * @type api
 * @brief TALWTNSubscriber Class
 */
TALWTN_IOS_EXPORT @interface TALWTNSubscriber : NSObject
/** {zh}
 * @type api
 * @brief 开启订阅音视频流。  <br>
 *        调用该方法后，本地用户会收到 onSubscribeStateChanged:subscribeState:reason:{@link #TALWTNEngineDelegate#onSubscribeStateChanged:subscribeState:reason:} 的回调。  <br>
 * @param url WHIP 请求的 url。<br>
 *        url 由 WTN 固定域名 `https://wtn.volcvideo.com`，SUB 方法，appID，和你设定的 streamID 拼接得到。 <br>
 *        形如：`https://wtn.volcvideo.com/sub/<appID>/<streamID>`
 * @return  <br>
 *        + 0: 成功  <br>
 *        + -1: 失败。 <br>
 * @notes  <br>
 *       + 一个 TALWTNSubscriber 实例仅可以订阅一路音视频流。<br>
 *       + 订阅音视频流前，请先确保此流已发布。如果未发布，会订阅失败。 <br>
 *       + 订阅前需要先调用 setRemoteView:{@link #TALWTNSubscriber#setRemoteView:} 设置视图。 <br>
 *       + 调用 stopSubscribe{@link #TALWTNSubscriber#stopSubscribe} 可以停止订阅。 <br>
 */
/** {en}
 * @type api
 * @brief Subscribe the remote media streams. <br>
 *        After calling the API, you will receive onSubscribeStateChanged:subscribeState:reason:{@link #TALWTNEngineDelegate#onSubscribeStateChanged:subscribeState:reason:}.
 * @param url The url for WHIP request. <br>
 *        Concatenate the fixed url `https://wtn.volcvideo.com`, SUB method, appID, and your specified streamID into the value of url. <br>
 *        The url is like `https://wtn.volcvideo.com/sub/<appID>/<streamID>`.
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 * @notes  <br>
 *        + You can only subscribe to one media stream with one TALWTNSubscriber instance. <br>
 *        + Ensure the stream is published before subscribe to the stream. <br>
 *        + Call setRemoteView:{@link #TALWTNSubscriber#setRemoteView:} to set the remote view for the media stream before subscribing. <br>
 *        + Call stopSubscribe{@link #TALWTNSubscriber#stopSubscribe} to stop subscribing.
 */
- (int)startSubscribe:(NSString*)url;
/** {zh}
 * @type api
 * @brief 停止订阅音视频流
 * @return  <br>
 *        + 0：方法调用成功  <br>
 *        + < 0：方法调用失败  <br>
 * @notes <br>
 *        + 调用 startSubscribe:{@link #TALWTNSubscriber#startSubscribe:} 发布音视频流。
 *        + 调用该方法后，会收到 onSubscribeStateChanged:subscribeState:reason:{@link #TALWTNEngineDelegate#onSubscribeStateChanged:subscribeState:reason:} 的回调。
 */
/** {en}
 * @type api
 * @brief Stop subscribing to the media stream.
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 * @notes  <br>
 *         + Call startSubscribe:{@link #TALWTNSubscriber#startSubscribe:} to start subscribing. <br>
 *         + Receive onSubscribeStateChanged:subscribeState:reason:{@link #TALWTNEngineDelegate#onSubscribeStateChanged:subscribeState:reason:} after calling this API.
 */
- (int)stopSubscribe;
/** {zh}
 * @type api
 * @brief 查询音视频流订阅状态
 * @return  <br>
 *        + true：正在订阅 <br>
 *        + false：未订阅 <br>
 */
/** {en}
 * @type api
 * @brief Inspect the subscribing state.
 * @return   <br>
 *         + true: Subscribing <br>
 *         + false: Not subscribing <br>
 */
- (BOOL)isSubscribed;
 /** {zh}
 * @type api
 * @brief 切换播放音频流时使用的听筒/扬声器 <br>
 * @param enable <br>
 *        + true：扬声器 <br>
 *        + false：听筒 <br>
 * @return  <br>
 *        + 0: 成功  <br>
 *        + -1: 失败。 <br>
 * @notes <br>
 *        + 默认使用扬声器。 <br>
 *        + 此设置在播放音频流前后都可以生效。
 */
/** {en}
 * @type api
 * @brief Switch the rendering device for audio stream: earpiece or speakerphone.
 * @param enable <br>
 *        + true: earpiece <br>
 *        + false：speakerphone <br>
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 * @notes  <br>
 *         + Speakerphone is the default device. <br>
 *         + You can switch the audio rendering device before or after the audio rendering.
 */
- (int)setEnableSpeaker:(BOOL)enable;
/** {zh}
 * @type api
 * @brief 设置渲染远端视频流时使用的视图
 * @param view 视图对象。必须保证此对象处于有效的生命周期内。
 * @return  <br>
 *        + 0: 成功  <br>
 *        + -1: 失败。 <br>
 * @notes <br>
 *        + 你必须在订阅前，设置渲染视图。 <br>
 *        + 如果需要解除绑定，你可以调用本方法传入空视图。
 */
/** {en}
 * @type api
 * @brief Binds the view to be used for remote video rendering. <br>
 * @param view View object. The object must be of effective lifecycle.
 * @return   <br>
 *         + 0: Success <br>
 *         + -1: Failure. <br>
 * @notes  <br>
 *       + You must bind the view before subscribe to the video stream. <br>
 *       + To unbind the view, call this API with the view set to `null`.
 */
- (int)setRemoteView:(UIView*)view;
/** {zh}
 * @type api
 * @brief mute 远端音频，不订阅。默认值为订阅。
 * @param mute 是否订阅音频数据。
 * @notes 发布前后都可调用。
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 */
/** {en}
 * @type api
 * @brief Mute the remote audio. Do not subscribe the captured audio.
 * @param mute Whether to subscribe the remote audio.
 * @notes You can call this API before or after the media stream is published.
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 */
- (int)setRemoteAudioMute:(BOOL)mute;
/** {zh}
 * @type api
 * @brief mute 远端视频，不订阅。默认值为订阅。
 * @param mute 是否订阅视频数据。
 * @notes 发布前后都可调用。
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 */
/** {en}
 * @type api
 * @brief Mute the remote video. Do not subscribe the captured video.
 * @param mute Whether to subscribe the remote video.
 * @notes You can call this API before or after the media stream is published.
 * @return   <br>
 *         + 0: Success <br>
 *         + < 0: Failure <br>
 */
- (int)setRemoteVideoMute:(BOOL)mute;
@end

NS_ASSUME_NONNULL_END

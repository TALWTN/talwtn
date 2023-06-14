/*
 *  Copyright 2022 Beijing Volcanoengine Technology Ltd. All Rights Reserved.
 *
 *  SPDX-license-identifier: BSD-3-Clause
 */

#import "TALWTNSubscriber.h"
#import "TALWTNPubSubInternal.h"
#include "wtn_interface.h"

@interface TALWTNSubscriber()
@property (nonatomic, assign) talwtn::ISubscriber * subscriber;
@end

@implementation TALWTNSubscriber

- (instancetype)init {
    if (self = [super init]) {
        _subscriber = nullptr;
    }
    return self;
}

- (int)startSubscribe:(NSString*)url {
    if (_subscriber != nullptr) {
        return _subscriber->StartSubscribe([url UTF8String]);
    }
    return -1;
}

- (int)stopSubscribe {
    if (_subscriber != nullptr) {
        return _subscriber->StopSubscribe();
    }
    return -1;
}

- (BOOL)isSubscribed {
    if (_subscriber != nullptr) {
        return _subscriber->IsSubscribed();
    }
    return NO;
}

- (int)setEnableSpeaker:(BOOL)enable {
    if (_subscriber != nullptr) {
        return _subscriber->SetEnableSpeaker(enable);
    }
    return -1;
}

- (int)setRemoteView:(UIView*)view {
    if (_subscriber != nullptr) {
        _subscriber->SetRemoteView((__bridge void*)view);
    }
}

- (int)setRemoteAudioMute:(BOOL)mute {
    if (_subscriber != nullptr) {
        return _subscriber->SetRemoteAudioMute(mute);
    }
    return -1;
}

- (int)setRemoteVideoMute:(BOOL)mute {
    if (_subscriber != nullptr) {
        return _subscriber->SetRemoteVideoMute(mute);
    }
    return -1;
}

@end


@implementation TALWTNSubscriber(internal)
- (void)setNativeSubscriber:(talwtn::ISubscriber*)subscriber {
    _subscriber = subscriber;
}

- (talwtn::ISubscriber*)getNativeSubscriber {
    return _subscriber;
}
@end


/*
 *  Copyright 2022 Beijing Volcanoengine Technology Ltd. All Rights Reserved.
 *
 *  SPDX-license-identifier: BSD-3-Clause
 */
#import "TALWTNEngine.h"

#import "TALWTNEventHandler.h"
#import "TALWTNPublisher.h"
#import "TALWTNSubscriber.h"
#import "TALWTNPubSubInternal.h"
#include "wtn_interface.h"

@interface TALWTNEngine()
@property (nonatomic, weak) id<TALWTNEngineDelegate> delegate;
@property (nonatomic, assign) TALWTNEventHandler * eventHandler;
@property (nonatomic, assign) talwtn::IRtcEngine * engine;


@property (nonatomic, strong) NSLock * pubSubsLock;
@property (nonatomic, strong) NSMutableArray * pubSubs;
@end

@implementation TALWTNEngine
- (instancetype)init {
    if (self = [super init]) {
        _engine = nullptr;
    }
    return self;
}

- (instancetype)initWithDelegate:(id<TALWTNEngineDelegate>)delegate {
    if (self = [super init]) {
        _eventHandler = new TALWTNEventHandler(delegate);
        _engine = talwtn::CreateRtcEngine(_eventHandler);
        if (_engine == nullptr) {
            delete _eventHandler;
            return nil;
        }
        _pubSubsLock = [[NSLock alloc] init];
        _pubSubs = @[].mutableCopy;
    }
    return self;
}

- (void)dealloc {
    [self _releaseNativeResource];
}

- (void)_releaseNativeResource {
    if (_engine != nullptr) {
        [_pubSubsLock lock];
        for (int i = 0; i < _pubSubs.count; i++) {
            if ([_pubSubs[i] isKindOfClass:[TALWTNPublisher class]]) {
                TALWTNPublisher * per = (TALWTNPublisher*)_pubSubs[i];
                if ([per getNativePublisher] != nullptr) {
                    _engine->DestroyPublisher([per getNativePublisher]);
                    [per setNativePublisher:nullptr];
                }
            } else if ([_pubSubs[i] isKindOfClass:[TALWTNSubscriber class]]) {
                TALWTNSubscriber * ser = (TALWTNSubscriber*)_pubSubs[i];
                if ([ser getNativeSubscriber] != nullptr) {
                    _engine->DestroySubscriber([ser getNativeSubscriber]);
                    [ser setNativeSubscriber:nullptr];
                }
            }
        }
        [_pubSubsLock unlock];
    }
    if (_engine != nullptr) {
        talwtn::DestroyRtcEngine(_engine);
    }
    if (_eventHandler != nullptr) {
        delete _eventHandler;
    }
}

- (TALWTNPublisher *)createPublisher:(TALWTNPubExtraParam*)pub_extra_param {
    if (_engine != nullptr) {
        talwtn::PubExtraParam param;
        param.pub_audio_source = pub_extra_param.pub_audio_source == TALWTNPubAudioSourceInternalRecord ? talwtn::PubAudioSource::InternalRecord : talwtn::PubAudioSource::PushExternalPCM;
        param.pub_video_source = pub_extra_param.pub_video_source == TALWTNPubVideoSourceInternalCamera ? talwtn::PubVideoSource::InternalCamera : pub_extra_param.pub_video_source == TALWTNPubVideoSourcePushExternalYUV ? talwtn::PubVideoSource::PushExternalYUV : talwtn::PubVideoSource::PushExternalH264;
        talwtn::IPublisher * np = _engine->CreatePublisher(param);
        if (np == nullptr) {
            return nil;
        }
        TALWTNPublisher * publisher = [[TALWTNPublisher alloc] init];
        [publisher setNativePublisher:np];
        [_pubSubsLock lock];
        [_pubSubs addObject:publisher];
        [_pubSubsLock unlock];
        return publisher;
    }
    return nil;
}

- (void)destroyPublisher:(TALWTNPublisher*)publisher {
    if (_engine != nullptr) {
        talwtn::IPublisher * np = [publisher getNativePublisher];
        if (np != nullptr) {
            _engine->DestroyPublisher(np);
            [publisher setNativePublisher:nullptr];
        }
        [_pubSubsLock lock];
        [_pubSubs removeObject:publisher];
        [_pubSubsLock unlock];
    }
}

- (TALWTNSubscriber *)createSubscriber:(TALWTNSubExtraParam*)sub_extra_param {
    if (_engine != nullptr) {
        talwtn::SubExtraParam param;
        param.sub_audio_source = sub_extra_param.sub_audio_source == TALWTNSubAudioSourceInternalPlay ? talwtn::SubAudioSource::InternalPlay : talwtn::SubAudioSource::CallbackPCM;
        param.sub_video_source = sub_extra_param.sub_video_source == TALWTNSubVideoSourceInternalRender ? talwtn::SubVideoSource::InternalRender : sub_extra_param.sub_video_source == TALWTNSubVideoSourceCallbackYUV ? talwtn::SubVideoSource::CallbackYUV : talwtn::SubVideoSource::CallbackH264;
        talwtn::ISubscriber * ns = _engine->CreateSubscriber(param);
        if (ns == nullptr) {
            return nil;
        }
        TALWTNSubscriber * subscriber = [[TALWTNSubscriber alloc] init];
        [subscriber setNativeSubscriber:ns];
        [_pubSubsLock lock];
        [_pubSubs addObject:subscriber];
        [_pubSubsLock unlock];
        return subscriber;
    }
}

- (void)destroySubscriber:(TALWTNSubscriber*)subscriber {
    if (_engine != nullptr) {
        talwtn::ISubscriber * ns = [subscriber getNativeSubscriber];
        if (ns != nullptr) {
            _engine->DestroySubscriber(ns);
            [subscriber setNativeSubscriber:nullptr];
        }
        [_pubSubsLock lock];
        [_pubSubs removeObject:subscriber];
        [_pubSubsLock unlock];
    }
}

@end



@implementation TALWTNPubExtraParam
@end

@implementation TALWTNSubExtraParam
@end

@implementation TALWTNEncodedVideoFrame
@end

@implementation TALWTNVideoFrame
@end

@implementation TALWTNAudioFrame
@end


@implementation TALWTNVideoConfig
@end

@implementation TALWTNStallInfo
@end


@implementation TALWTNRTCAudioStats
@end

@implementation TALWTNRTCVideoStats
@end


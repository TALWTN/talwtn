/*
 *  Copyright 2022 Beijing Volcanoengine Technology Ltd. All Rights Reserved.
 *
 *  SPDX-license-identifier: BSD-3-Clause
 */
#import <Foundation/Foundation.h>
#import "TALWTNPublisher.h"
#import "TALWTNSubscriber.h"
#include "wtn_interface.h"

@interface TALWTNPublisher(internal)
- (void)setNativePublisher:(talwtn::IPublisher*)publisher;
- (talwtn::IPublisher*)getNativePublisher;
@end

@interface TALWTNSubscriber(internal)
- (void)setNativeSubscriber:(talwtn::ISubscriber*)subscriber;
- (talwtn::ISubscriber*)getNativeSubscriber;
@end

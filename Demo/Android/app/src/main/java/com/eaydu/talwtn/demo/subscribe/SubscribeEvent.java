/*
 * Copyright 2022 Beijing TAL Technology Ltd. All Rights Reserved.
 * SPDX-license-identifier: BSD-3-Clause
 */
package com.eaydu.talwtn.demo.subscribe;

//import com.talwtn.SubscriberEventHandler;

import com.talwtn.RtcDefines;

public class SubscribeEvent {

    public final RtcDefines.State state;
    public final RtcDefines.Reason reason;

    public SubscribeEvent(RtcDefines.State state, RtcDefines.Reason reason) {
        this.state = state;
        this.reason = reason;
    }
}
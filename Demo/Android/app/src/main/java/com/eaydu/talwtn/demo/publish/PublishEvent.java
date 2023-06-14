/*
 * Copyright 2022 Beijing TAL Technology Ltd. All Rights Reserved.
 * SPDX-license-identifier: BSD-3-Clause
 */
package com.eaydu.talwtn.demo.publish;

//import com.talwtn.PublisherEventHandler;

import com.talwtn.RtcDefines;

public class PublishEvent {
    public final RtcDefines.State state;
    public final RtcDefines.Reason reason;

    public PublishEvent(RtcDefines.State state, RtcDefines.Reason reason) {
        this.state = state;
        this.reason = reason;
    }

    public boolean isStartPublishSuccess() {
        return state == RtcDefines.State.StartSuccess;
    }
}

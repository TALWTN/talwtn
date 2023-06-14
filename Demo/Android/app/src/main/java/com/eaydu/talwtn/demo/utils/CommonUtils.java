package com.eaydu.talwtn.demo.utils;

import java.util.UUID;

public class CommonUtils {

    public static String getPushUrl(String streamID) {
        String sessionId = UUID.randomUUID().toString();
        //streamID = UUID.randomUUID().toString();
        //enablePullAuth=false&
        String token = JwtUtils.encodeJwt("pub", streamID);
        //SessionID=%s&
        String url = String.format("%s/pub/%s/%s?MuteAudio=false&MuteVideo=false&Token=%s&TokenType=Bearer",
                CommonConfig.Host,
                CommonConfig.AppID,
                streamID,
                //sessionId,
                token
                );
        return url;
    }

    public static String getPullUrl(String streamID) {
        String sessionId = UUID.randomUUID().toString();
        String token = JwtUtils.encodeJwt("sub", streamID);
        //MuteAudio=false&MuteVideo=false&PullAuth=false&
        String url = String.format("%s/sub/%s/%s?Token=%s&TokenType=Bearer",
                CommonConfig.Host,
                CommonConfig.AppID,
                streamID,
                token
        );
        return url;
    }
}

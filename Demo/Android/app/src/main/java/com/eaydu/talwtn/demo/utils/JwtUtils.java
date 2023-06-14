package com.eaydu.talwtn.demo.utils;

import android.util.Base64;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {


    public static String encodeJwt(String action, String streamID) {
        Map<String, Object> map = new HashMap<>();
        // map.put("appid", "ae03d1bf-c5ce-44d8-b0bf-2d7ab5404c26"); // 线上
        map.put("appID", CommonConfig.AppID);
        map.put("exp", System.currentTimeMillis() + 3600 * 1000);
        map.put("action", action);
        map.put("version", "1.0");
        map.put("streamID", streamID);
        if("pub".equals(action)) {
            map.put("enableSubAuth", false);
        }
        String key = Base64.encodeToString(CommonConfig.AppKey.getBytes(), 0);
        Date exp = new Date(System.currentTimeMillis() + 3600 * 1000);//过期时间
        String compactJws = Jwts.builder().addClaims(map).setHeaderParam("typ", "JWT")
                .signWith(SignatureAlgorithm.HS256, key).setExpiration(exp).compact();

        return compactJws;
    }
}

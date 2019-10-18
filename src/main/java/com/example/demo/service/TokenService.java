package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/14 8:59
 */

@Service
public class TokenService {

    private static final String SECRET = "YYT-SHARE";   //公用密钥

    private static final Long maxAge = 7L * 24L * 3600L * 1000L;

    public String getToken(User user){

        Map<String,Object> headers = new HashMap<String,Object>();
        headers.put("alg","HS256");
        headers.put("typ","JWT");

        String token="";
        token = JWT.create()
                .withHeader(headers)
                .withExpiresAt(new Date(System.currentTimeMillis() + maxAge))    //过期时间
                .withIssuedAt(new Date())                                        // token签发时间
                .withAudience(user.getId())
                .sign(Algorithm.HMAC256(SECRET+user.getPwd()));

        return token;
    }
}

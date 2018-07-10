package com.seeri.utils;


import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Requests {

    /**
     * 请求体为json的post请求
     * @param url   接口地址
     * @param reqJson   请求json串
     * @return  接口返回的Response
     */
    public static Response post (String url, Object reqJson, Map headers) {
        Response response = given()
                .config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .headers(headers)
                .body(reqJson)
                .when()
                .log()
                .body()
                .post(url.trim());
        return response;
    }

    public static Response postWithCookie (String url, String reqJson, Map cookies) {
        Response response = given()
                .cookies(cookies)
                .config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .headers("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36",
                        "Content-Type", "application/json;charset=UTF-8")
                .body(reqJson)
                .when()
                .log()
                .body()
                .post(url.trim());
        return response;
    }
}

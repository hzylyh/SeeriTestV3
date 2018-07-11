package com.seeri.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeri.utils.HollTest;
import com.seeri.utils.Requests;
import io.restassured.response.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/run")
public class RunController {

    @RequestMapping(method = RequestMethod.POST)
    public String run (@RequestBody JSONObject jsonObject) {
        String url = jsonObject.getString("url");
//        JSONObject reqJson = jsonObject.getJSONObject("reqJson");
        Map headers = (Map) jsonObject.get("headers");
        String json = jsonObject.getString("expJson");
        JSONArray verifyCol = jsonObject.getJSONArray("verifyCol");

        JSONObject first = JSONObject.parseObject("{\"phone\": \"hzy\",\"password\": \"e19d5cd5af0378da05f63f891c7467af\",\"isCover\": true}");
        JSONObject second = JSONObject.parseObject("{\"phone\": \"hzy2\",\"password\": \"e19d5cd5af0378da05f63f891c7467af\",\"isCover\": true}");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(first);
        jsonArray.add(second);
        for (Object test: jsonArray) {
            JSONObject reqJson = (JSONObject) test;
            Response response = Requests.post(url, reqJson, headers);
            String res = HollTest.assertPost(json, response.print(), verifyCol);
            System.out.println(res);
        }


        return "Finish";
    }

}

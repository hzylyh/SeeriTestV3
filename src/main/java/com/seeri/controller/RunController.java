package com.seeri.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeri.utils.Requests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.Assert;

import java.util.Map;

@RestController
@RequestMapping(value = "/run")
public class RunController {

    @RequestMapping(method = RequestMethod.POST)
    public String run (@RequestBody JSONObject jsonObject) {
        String url = jsonObject.getString("url");
        JSONObject reqJson = jsonObject.getJSONObject("reqJson");
        Map headers = (Map) jsonObject.get("headers");
        String json = jsonObject.getString("expJson");
        JSONArray verifyCol = jsonObject.getJSONArray("verifyCol");

        Response response = Requests.post(url, reqJson, headers);

        JsonPath expJson = new JsonPath(json);
        JsonPath actJson = new JsonPath(response.print());

        for ( Object verify : verifyCol) {
            String exp = expJson.getString((String) verify);
            String act = actJson.getString((String) verify);

            if (!StringUtils.isEmpty(exp) && !StringUtils.isEmpty(act)) {
                if (exp.equals(act)) {
                    continue;
                } else {
                    return verify + "字段不等";
                }
            } else {
                return verify + "字段为空";
            }
        }
        return "Success";
    }

}

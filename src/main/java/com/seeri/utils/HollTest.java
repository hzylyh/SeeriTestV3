package com.seeri.utils;

import com.alibaba.fastjson.JSONArray;
import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.StringUtils;

public class HollTest {

    public static String assertPost(String expInput, String actInput, JSONArray verifyCol) {
        JsonPath expJson = new JsonPath(expInput);
        JsonPath actJson = new JsonPath(actInput);

        for (Object verify : verifyCol) {
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

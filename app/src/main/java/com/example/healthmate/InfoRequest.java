package com.example.healthmate;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class InfoRequest extends StringRequest {

    final static private String URL = "http://health1234.dothome.co.kr/Register.php"; // php 파일 연동
    private Map<String, String> map;

    public InfoRequest(String userID, String userPassword, String userName, int userAge, String user_sex, String user_personality1, String user_personality2, String user_personality3, String user_sport1, String user_sport2, String user_sport3, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userAge", userAge + "");
        map.put("user_sex", user_sex);
        map.put("user_personality1", user_personality1);
        map.put("user_personality2", user_personality2);
        map.put("user_personality3", user_personality3);
        map.put("user_sport1", user_sport1);
        map.put("user_sport2", user_sport2);
        map.put("user_sport3", user_sport3);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

package com.example.healthmate;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// user_sex 추가됨. (db 필수값인데 아직 칩으로 가입 구현이 안되었기 때문!)
public class RegisterRequest extends StringRequest {

    final static private String URL = "http://health1234.dothome.co.kr/Register.php"; // php 파일 연동
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName,
                           int userAge, String user_sex, Response .Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userAge", userAge + "");
        map.put("user_sex", user_sex);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}



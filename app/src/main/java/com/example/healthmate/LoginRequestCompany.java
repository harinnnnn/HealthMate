package com.example.healthmate;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequestCompany extends StringRequest {

    final static private String URL = "http://health1234.dothome.co.kr/LoginCompany.php"; // php 파일 연동
    private Map<String, String> map;

    public LoginRequestCompany(String companyID, String companyPassword, Response .Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("companyID", companyID);
        map.put("companyPassword", companyPassword);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}



package com.example.healthmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoActivity extends AppCompatActivity {

    private TextView tv_gender, tv_personality, tv_sports;



    @Override
    protected void onCreate(Bundle savedInstanceState) { // OnCreate는 액티비티 처음 실행될 때 실행되는 애들
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv_gender = findViewById(R.id.tv_gender);
        tv_personality = findViewById(R.id.tv_personality);
        tv_sports = findViewById(R.id.tv_sports);


    }
}
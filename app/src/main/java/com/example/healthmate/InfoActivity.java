package com.example.healthmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoActivity extends AppCompatActivity {


    private Button btn_info;

    String userID, userPass, userName, user_sex, user_personality1, user_personality2, user_personality3, user_sport1, user_sport2, user_sport3;
    int userAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // OnCreate는 액티비티 처음 실행될 때 실행되는 애들
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        userID = getIntent().getStringExtra("userID");
        userPass = getIntent().getStringExtra("userPass");
        userName = getIntent().getStringExtra("userName");
        userAge = getIntent().getIntExtra("userAge", 0);
//        userAge = Integer.parseInt(getIntent().getStringExtra("userAge"));

        btn_info = findViewById(R.id.btn_info);

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 성별 받아오기
                ChipGroup cg_gender = findViewById(R.id.cg_gender);
                Chip chip_gender = (Chip) cg_gender.getChildAt(0);
                user_sex = chip_gender.getText().toString(); // 이거 성별

                // 성격 담아오기
                ChipGroup cg_personality = findViewById(R.id.cg_personality);
                int chipsCount_p = cg_personality.getChildCount(); // 하위속성 몇갠지 체크
                if(chipsCount_p == 0){
                    Toast.makeText(getApplicationContext(), "성격을 1개 이상 골라주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    int i = 0;
                    while(i<chipsCount_p) { // 하위속성 개수만큼 while문 돌기
                        Chip chip = (Chip) cg_personality.getChildAt(i);
                        if(chip.isChecked()) {
                            if(i==0) {
                                user_personality1 = chip.getText().toString();
                            }
                            else if(i==1) {
                                user_personality2 = chip.getText().toString();
                            }
                            else user_personality3 = chip.getText().toString();
                        }
                        i++;
                    }
                }

                // 운동 담아오기
                ChipGroup cg_sports = findViewById(R.id.cg_sports);
                int chipsCount_s = cg_sports.getChildCount();
                if(chipsCount_s == 0){
                    Toast.makeText(getApplicationContext(), "운동을 1개 이상 골라주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    int i = 0;
                    while(i<chipsCount_s) {
                        Chip chip = (Chip) cg_personality.getChildAt(i);
                        if(chip.isChecked()) {
                            if(i==0) {
                                user_sport1 = chip.getText().toString();
                            }
                            else if(i==1) {
                                user_sport2 = chip.getText().toString();
                            }
                            else user_sport3 = chip.getText().toString();
                        }
                        i++;
                    }
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success) {
                                Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(InfoActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                InfoRequest infoRequest = new InfoRequest(userID, userPass, userName, userAge, user_sex, user_personality1, user_personality2, user_personality3, user_sport1, user_sport2, user_sport3, responseListener);
                RequestQueue queue = Volley.newRequestQueue(InfoActivity.this);
                queue.add(infoRequest);

            }
        });


    }
}
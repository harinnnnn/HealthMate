package com.example.healthmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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

    ArrayAdapter<CharSequence> adspin1, adspin2;
    String choice_do="";
    String choice_se="";

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

        final Spinner spin1 = (Spinner)findViewById(R.id.spinner);
        final Spinner spin2 = (Spinner)findViewById(R.id.spinner2);
//        Button btn_refresh = (Button)findViewById(R.id.btn_refresh);

        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin1.getItem(i).equals("서울특별시")) {
                    choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("인천광역시")) {
                    choice_do = "인천광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("광주광역시")) {
                    choice_do = "광주광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_gwangju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("대구광역시")) {
                    choice_do = "대구광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_daegu, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("울산광역시")) {
                    choice_do = "울산광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_ulsan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("대전광역시")) {
                    choice_do = "대전광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_daejeon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("부산광역시")) {
                    choice_do = "부산광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_busan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("대구광역시")) {
                    choice_do = "대구광역시";
                    adspin2 = ArrayAdapter.createFromResource(InfoActivity.this, R.array.spinner_do_daegu, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        btn_refresh.setOnClickListener(new View.OnClickListener() {
//            //버튼 클릭시 이벤트입니다.
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(InfoActivity.this, choice_do + "=" + choice_se, Toast.LENGTH_SHORT).show();
//            }
//        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 성별 받아오기
                ChipGroup cg_gender = findViewById(R.id.cg_gender);
                Chip chip_gender = (Chip) cg_gender.getChildAt(0);
                user_sex = chip_gender.getText().toString(); // 이거 성별

                //지역 받아오기


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
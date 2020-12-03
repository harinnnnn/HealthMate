package com.example.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;

public class Register2 extends AppCompatActivity {

    private static final String TAG = "InfoActivity";
    FirebaseAuth mAuth;

    private TextView tv_gender, tv_personality, tv_sports;
    private ChipGroup cg_gender, cg_personality, cg_sports;
    private Chip c_man, c_women, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12 , s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    private Button btn_result;

    ArrayAdapter<CharSequence> adspin1, adspin2;
    String choice_do="";
    String choice_se="";


    String userID, userPass, userName, user_sex, user_do, user_se, user_personality1, user_personality2, user_sport1, user_sport2;
    int userAge;

    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        database = FirebaseDatabase.getInstance();

        //Initialize firebase Auth
        mAuth = FirebaseAuth.getInstance();

        userID = getIntent().getStringExtra("userID");
        userPass = getIntent().getStringExtra("userPass");
        userName = getIntent().getStringExtra("userName");
        userAge = getIntent().getIntExtra("userAge", 0);

        tv_gender = findViewById(R.id.tv_gender);
        tv_personality = findViewById(R.id.tv_personality);
        tv_sports = findViewById(R.id.tv_sports);
        c_man = findViewById(R.id.c_man);
        c_women = findViewById(R.id.c_women);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        p9 = findViewById(R.id.p9);
        p10 = findViewById(R.id.p10);
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);
        s7 = findViewById(R.id.s7);
        s8 = findViewById(R.id.s8);
        s9 = findViewById(R.id.s9);
        s10 = findViewById(R.id.s10);


        //선호지역
        final Spinner spin1 = (Spinner)findViewById(R.id.spinner3);
        final Spinner spin2 = (Spinner)findViewById(R.id.spinner4);

        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin1.getItem(i).equals("서울특별시")) {
                    choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_gwangju, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_daegu, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_ulsan, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_daejeon, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_busan, android.R.layout.simple_spinner_dropdown_item);
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
                    adspin2 = ArrayAdapter.createFromResource(Register2.this, R.array.spinner_do_daegu, android.R.layout.simple_spinner_dropdown_item);
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


        btn_result = findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_sex = "";
                if(c_man.isChecked()) {
                    user_sex = c_man.getText().toString();
                }
                if(c_women.isChecked()) {
                    user_sex = c_women.getText().toString();
                }
//                else if (str_gender == ""){
//                    Toast.makeText(Register2.this, "성별을 선택해주세요", Toast.LENGTH_SHORT).show();
//                }
//                tv_gender.setText(user_sex);

                //선호지역
                user_do = choice_do;
                user_se = choice_se;

                //성격1
                String user_personality1 = "";
                if (p1.isChecked()) {
                    user_personality1 = p1.getText().toString();
                }
                else if (p2.isChecked()) {
                    user_personality1 = p2.getText().toString();
                }
                else if (p3.isChecked()) {
                    user_personality1 = p3.getText().toString();
                }
                else if (p4.isChecked()) {
                    user_personality1 = p4.getText().toString();
                }
                else if (p5.isChecked()) {
                    user_personality1 = p5.getText().toString();
                }
                else if (p6.isChecked()) {
                    user_personality1 = p6.getText().toString();
                }
                else if (p7.isChecked()) {
                    user_personality1 = p7.getText().toString();
                }
                else if (p8.isChecked()) {
                    user_personality1 = p8.getText().toString();
                }
                else if (p9.isChecked()) {
                    user_personality1 = p9.getText().toString();
                }
                else if (p10.isChecked()) {
                    user_personality1 = p10.getText().toString();
                }
                else if (p11.isChecked()) {
                    user_personality1 = p11.getText().toString();
                }
                else if (p12.isChecked()) {
                    user_personality1 = p12.getText().toString();
                }

                String user_personality2 = "";
                if (p1.isChecked()) {
                    user_personality2 = p1.getText().toString();
                }
                if (p2.isChecked()) {
                    user_personality2 = p2.getText().toString();
                }
                if (p3.isChecked()) {
                    user_personality2 = p3.getText().toString();
                }
                if (p4.isChecked()) {
                    user_personality2 = p4.getText().toString();
                }
                if (p5.isChecked()) {
                    user_personality2 = p5.getText().toString();
                }
                if (p6.isChecked()) {
                    user_personality2 = p6.getText().toString();
                }
                if (p7.isChecked()) {
                    user_personality2 = p7.getText().toString();
                }
                if (p8.isChecked()) {
                    user_personality2 = p8.getText().toString();
                }
                if (p9.isChecked()) {
                    user_personality2 = p9.getText().toString();
                }
                if (p10.isChecked()) {
                    user_personality2 = p10.getText().toString();
                }
                if (p11.isChecked()) {
                    user_personality2 = p11.getText().toString();
                }
                if (p12.isChecked()) {
                    user_personality2 = p12.getText().toString();
                }
//                tv_personality.setText(user_personality1 + user_personality2);



                //운동1
                String user_sport1 = "";
                if (s1.isChecked()) {
                    user_sport1 = s1.getText().toString();
                }
                else if (s2.isChecked()) {
                    user_sport1 = s2.getText().toString();
                }
                else if (s3.isChecked()) {
                    user_sport1 = s3.getText().toString();
                }
                else if (s4.isChecked()) {
                    user_sport1 = s4.getText().toString();
                }
                else if (s5.isChecked()) {
                    user_sport1 = s5.getText().toString();
                }
                else if (s6.isChecked()) {
                    user_sport1 = s6.getText().toString();
                }
                else if (s7.isChecked()) {
                    user_sport1 = s7.getText().toString();
                }
                else if (s8.isChecked()) {
                    user_sport1 = s8.getText().toString();
                }
                else if (s9.isChecked()) {
                    user_sport1 = s9.getText().toString();
                }
                else if (s10.isChecked()) {
                    user_sport1 = s10.getText().toString();
                }


                //운동2
                String user_sport2 = "";
                if (s1.isChecked()) {
                    user_sport2 = s1.getText().toString();
                }
                if (s2.isChecked()) {
                    user_sport2 = s2.getText().toString();
                }
                if (s3.isChecked()) {
                    user_sport2 = s3.getText().toString();
                }
                if (s4.isChecked()) {
                    user_sport2 = s4.getText().toString();
                }
                if (s5.isChecked()) {
                    user_sport2 = s5.getText().toString();
                }
                if (s6.isChecked()) {
                    user_sport2 = s6.getText().toString();
                }
                if (s7.isChecked()) {
                    user_sport2 = s7.getText().toString();
                }
                if (s8.isChecked()) {
                    user_sport2 = s8.getText().toString();
                }
                if (s9.isChecked()) {
                    user_sport2 = s9.getText().toString();
                }
                if (s10.isChecked()) {
                    user_sport2 = s10.getText().toString();
                }

//                tv_sports.setText(user_sport1 + user_sport2);

                if (user_sex == "") {
                    Toast.makeText(Register2.this, "성별을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
                else if (user_do == "") {
                    Toast.makeText(Register2.this, "선호지역을 선택해주세요", Toast.LENGTH_SHORT).show();
                } else if (user_personality1 == "") {
                    Toast.makeText(Register2.this, "성격을 선택해주세요", Toast.LENGTH_SHORT).show();
                } else if (user_sport1 == "") {
                    Toast.makeText(Register2.this, "선호운동을 선택해주세요", Toast.LENGTH_SHORT).show();
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success) {
                                Toast.makeText(getApplicationContext(), "회원가입완료", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register2.this, LoginActivity.class);
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

                InfoRequest infoRequest = new InfoRequest(userID, userPass, userName, userAge, user_sex, user_do, user_se, user_personality1, user_personality2,  user_sport1, user_sport2, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register2.this);
                queue.add(infoRequest);
                mAuth.createUserWithEmailAndPassword(userID, userPass)
                        .addOnCompleteListener(Register2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(Register2.this, LoginActivity.class);
                                    startActivity(intent);
//                                    updateUI(user);

                                    DatabaseReference myRef = database.getReference("message").child(user.getUid());

                                    Hashtable<String, String> numbers
                                            = new Hashtable<String, String>();
                                    numbers.put("email", user.getEmail());
                                    Toast.makeText(Register2.this, "Register Success", Toast.LENGTH_LONG).show();

                                    myRef.setValue(numbers);


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register2.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }

                                // ...
                            }
                        });
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }
}
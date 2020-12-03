package com.example.healthmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginCompany extends AppCompatActivity {

    private static final String TAG = "LoginCompany";
    private EditText et_idc, et_passc;
    private Button btn_person, btn_company, btn_loginc, btn_registerc;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_company);

                database = FirebaseDatabase.getInstance();
                mAuth = FirebaseAuth.getInstance();

                progressBar = findViewById(R.id.progressBar);

                et_idc = findViewById(R.id.et_idc);
                et_passc = findViewById(R.id.et_passc);
                btn_loginc = findViewById(R.id.btn_loginc);
                btn_registerc = findViewById(R.id.btn_infoc);

                btn_registerc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginCompany.this, RegisterCompany.class);
                        startActivity(intent);
                    }
                });

                btn_loginc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String companyID = et_idc.getText().toString();
                        String companyPass = et_passc.getText().toString();

                        progressBar.setVisibility(View.VISIBLE);

                        Log.d(TAG, "로그인 실패1");
                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    boolean success = jsonObject.getBoolean("success");
                                    Log.d(TAG, "로그인 실패2");
                                    if(success) {
                                        String userID = jsonObject.getString("userID");
                                        String userPass = jsonObject.getString("userPassword");
                                        Log.d(TAG, "로그인 실패3");
                                        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginCompany.this, MainActivity.class);
                                        intent.putExtra("userID", userID);
                                        intent.putExtra("userPass", userPass);
                                        startActivity(intent);
                                    }
                                    else {
                                        Log.d(TAG, "로그인 실패");
                                        Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        };

                        LoginRequest loginRequest = new LoginRequest(companyID, companyPass, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(LoginCompany.this);
                        queue.add(loginRequest);


                        mAuth.signInWithEmailAndPassword(companyID, companyPass)
                                .addOnCompleteListener(LoginCompany.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressBar.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d(TAG, "signInWithEmail:success");

                                            Intent intent = new Intent(LoginCompany.this, MainActivity.class);
                                            startActivity(intent);

                                            FirebaseUser user = mAuth.getCurrentUser();
                                            String stUserEmail = user.getEmail();
                                            String stUserName = user.getDisplayName();
                                            Log.d(TAG, "stUserEmail: " + stUserEmail + ", stUserName: " + stUserName);

                                            // 공유 환경설정에 쓰기
                                            SharedPreferences sharedPref = getSharedPreferences("shared", Context.MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPref.edit();
                                            editor.putString("email", stUserEmail);
                                            editor.commit();


//                                    updateUI(user);
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                                            Toast.makeText(LoginCompany.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                        }

                                        // ...
                                    }
                                });


                    }
                });

                btn_person = findViewById(R.id.btn_person);
                btn_person.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginCompany.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
package com.example.healthmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "ChatActivity";
    private RecyclerView recyclerView;
    MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    EditText et_text;
    Button btn_send;
    String stEmail;
    FirebaseDatabase database;
    ArrayList<Chat> chatArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();

        chatArrayList = new ArrayList<>(); // chat(email, text)을 나열하기 위한 배열

        stEmail = getIntent().getStringExtra("email");
        Button btn_finish = findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_send = findViewById(R.id.btn_send);
        et_text = findViewById(R.id.et_text);
        
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // 영어 주석 무슨 말이냐면 리사이클러뷰가 리스트로 나올 때 높이가 가변적이지 않아야 성능이 좋다.
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        // 리사이클러뷰가 하나일때도, 여러개일때도 있는데 하나일때는 linearlayoutmanager 사용한대!
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        // 어댑터 사용.
        String[] myDataset = {"test1", "test2", "test3", "test4"};
        mAdapter = new MyAdapter(chatArrayList, stEmail);
        recyclerView.setAdapter(mAdapter);


        // 날짜의 하위 이벤트인 email, text 를 위한 것들.
        // firebase는 실시간 db이기 때문에 메시지들이 변경될 때마다 메소드가 실시간으로 수행됨 !
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                Chat chat = dataSnapshot.getValue(Chat.class);
                String commentKey = dataSnapshot.getKey();

                String stEmail = chat.getEmail();
                String stText = chat.getText();
                Log.d(TAG, "stEmail: " + stEmail);
                Log.d(TAG, "stText: " + stText);

                chatArrayList.add(chat); // 배열에 chat 추가
                mAdapter.notifyDataSetChanged(); // 배열 바뀐거 알려줌.
                // ...
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.


                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
                Toast.makeText(ChatActivity.this, "Failed to load comments.",
                        Toast.LENGTH_SHORT).show();
            }
        };

        DatabaseReference ref = database.getReference("message");
        ref.addChildEventListener(childEventListener);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stText = et_text.getText().toString(); // stText가 실제 파이어베이스에 올릴 문자열!
                Toast.makeText(ChatActivity.this, "MSG: " + stText, Toast.LENGTH_SHORT).show();

                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String datetime = dateformat.format(c.getTime());
                System.out.println(datetime);

                DatabaseReference myRef = database.getReference("message").child(datetime);

                Hashtable<String, String> numbers
                        = new Hashtable<String, String>();
                numbers.put("email", stEmail); // 에러
                numbers.put("text", stText);

                myRef.setValue(numbers);

                et_text.setText("");
            }
        });
    }
}
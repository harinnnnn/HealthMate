package com.example.healthmate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.healthmate.R;

import java.util.ArrayList;

public class FragmentPage1 extends Fragment {

    ArrayList<Actor> actors;
    ListView customListView;
    private static CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_page_1, container, false);

        //data를 가져와서 어답터와 연결해 준다. 서버에서 가져오는게 대부분 이다.
        actors = new ArrayList<>();
        // 로그인한 사용자의 선호운동이 배드민턴, 축구라고 가정
        actors.add(new Actor("Robert Downey Jr. (서울 강남구)", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg", "선호 운동: 축구, 배드민턴 \n성격: 활발, 유머\n자기소개: I'm Ironman"));
        actors.add(new Actor("Scarlett Johansson (서울 강남구)", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6NsMbJXRlDZuDzatN2akFdGuTvx.jpg", "선호 운동: 배드민턴, 요가 \n성격: 엉뚱, 도도\n자기소개: BTS 사랑해요"));
        actors.add(new Actor("조여정 (서울 강남구)", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5MgWM8pkUiYkj9MEaEpO0Ir1FD9.jpg", "선호 운동: 조깅, 배드민턴\n성격: 친절, 착한\n자기소개: 운동친구 구합니다~"));
        actors.add(new Actor("송강호 (서울 강남구)", "http://image.cine21.com/resize/cine21/still/2019/0527/15_58_58__5ceb8ab23619b[X252,310].jpg", "선호 운동: 골프, 축구 \n성격: 유머, 털털\n자기소개: 즐거운 운동해요 ^^"));
        actors.add(new Actor("홍길동 (서울 성북구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 축구, 배드민턴 \n성격: 다정다감, 친절\n자기소개: "));
        actors.add(new Actor("아무개 (서울 강동구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 축구, 배드민턴 \n성격: 순수, 착한 \n자기소개: 축구할 사람 괌"));
        actors.add(new Actor("홍길동 (서울 종로구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 배드민턴, 축구\n성격: 활발, 엉뚱\n자기소개: "));
        actors.add(new Actor("아무개 (서울 성북구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 배드민턴, 야구 \n성격: 도도, 엉뚱\n자기소개: "));
        actors.add(new Actor("홍길동 (서울 종로구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 테니스, 축구\n성격: 친절, 착한\n자기소개: 테니스 신, 테신입니다"));
        actors.add(new Actor("아무개 (서울 강동구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 배드민턴, 탁구\n성격: 성실, 털털\n자기소개: "));
        actors.add(new Actor("홍길동 (서울 마포구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 축구, 농구\n성격: 4차원, 친절\n자기소개: 운동광입니다"));
        actors.add(new Actor("아무개 (서울 반포구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 조깅, 축구\n성격: 다정다감, 활발\n자기소개: 같이 뛰면서 친해져요~"));
        actors.add(new Actor("홍길동 (서울 성동구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 배드민턴, 골프\n성격: 애교, 친절\n자기소개: "));
        actors.add(new Actor("아무개 (서울 종로구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 탁구, 축구\n성격: 유머, 4차원\n자기소개: "));
        actors.add(new Actor("홍길동 (서울 광진구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 배드민턴, 필라테스\n성격: 도도, 애교\n자기소개: "));
        actors.add(new Actor("아무개 (서울 강동구)", "https://www.seekpng.com/png/full/115-1150053_avatar-png-transparent-png-royalty-free-default-user.png", "선호 운동: 테니스, 축구\n성격: 활발, 성실\n자기소개: "));

        customListView = (ListView) rootView.findViewById(R.id.fragment_page_1);
        customAdapter = new CustomAdapter(getContext(),actors);
        customListView.setAdapter(customAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String) view.findViewById(R.id.textView_name).getTag().toString();
                Toast.makeText(getContext(), "Clicked: " + position +" " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}


//data class
class Actor {
    private String name;
    private String summary;
    private String thumb_url;

    public Actor(String name, String thumb_url, String summary) {
        this.name = name;
        this.summary = summary;
        this.thumb_url = thumb_url;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getThumb_url() {
        return thumb_url;
    }
}
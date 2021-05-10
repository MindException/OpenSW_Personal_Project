package com.cookandroid.opensw_3team_cafereviewproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

//intent를 위해서 추가 import 목록
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.sign_up);
        button.setOnClickListener(new View.OnClickListener(){ //버튼을 눌렀을 경우 발생

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NewUser.class);       //첫 번째 매개변수는 자신, 두 번째는 이동
                startActivity(intent);      //시작

            }
        });


    }

}
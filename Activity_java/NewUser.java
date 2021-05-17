package com.cookandroid.opensw_3team_cafereviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;          //이렇게 import 해줘야 사용이 가능하다.
import com.google.firebase.database.FirebaseDatabase;

public class NewUser extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getInstance().getReference();

        Button cancle_Button = (Button)findViewById(R.id.cancle_button);
        cancle_Button.setOnClickListener(new View.OnClickListener(){ //버튼을 눌렀을 경우 발생

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(NewUser.this, MainActivity.class);       //첫 번째 매개변수는 자신, 두 번째는 이동
                startActivity(intent);      //시작

            }
        });

        Button sign_Button = (Button)findViewById(R.id.Sign_button);
        sign_Button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //회원정보를 저장할 것이다.
                String id_address = "";
                String passwd = "";
                String name = "";
                String nickname = "";
                String phonenum = "";

                EditText idtext = (EditText) findViewById(R.id.EmailAddress);
                id_address = idtext.getText().toString();       //Email 저장
                EditText pwtext= (EditText) findViewById(R.id.password);
                passwd = pwtext.getText().toString();           //비번 저장
                EditText nametext = (EditText)findViewById(R.id.editTextTextPersonName);
                name = nametext.getText().toString();           //이름 저장
                EditText nicknametext = (EditText)findViewById(R.id.editTextTextPersonNickName);
                nickname = nicknametext.getText().toString();   //별명 저장
                EditText phonetext = (EditText)findViewById(R.id.editTextPhone);
                phonenum = phonetext.getText().toString();      //전화번호 저장

                //String 저장까지 성공

                User user = new User(id_address,passwd, name, nickname, phonenum);     //유저 객체를 만든다.

                System.out.println("성공");

                //이제 db에 객체 저장
                myRef.child("USER").setValue(user);

                /*

                파이어베이스에는 키값으로 들어가는 문자열에 .(마침표)와 /(슬래시)가 들어가지 못한다.

                 */



                //Intent intent2 = new Intent(NewUser.this, MainActivity.class);       //첫 번째 매개변수는 자신, 두 번째는 이동
                //startActivity(intent2);      //시작


            }
        });



    }
}
package com.cookandroid.opensw_3team_cafereviewproject;

public class User {             //새로운 사용자들의 계정 정보를 저장하는 클래스이다.

    public String id_address = "";     // 이메일 저장
    public String passwd = "";         // passwd저장
    public String name = "";           // 성함 저장
    public String nickname = "";       //계정 닉네임 저장
    public String phonenum = "";       //핸드폰 번호 저장

    User(String id_address, String passwd, String name, String nickname, String phonenum){     //생성자

        this.id_address = id_address;
        this.passwd = passwd;
        this.name = name;
        this.nickname = nickname;
        this.phonenum = phonenum;

    }

}

package com.Semi_Projrct.Ciyt.controller;

public class MemberForm {

    // createMemberForm에 태그안 name이 여기 변수에 매칭이 됨 김영한 강의
    private String username;
    private String password;
    private String nickname;
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

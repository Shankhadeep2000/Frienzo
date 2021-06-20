package com.sarkar.frienzo.Models;

public class User {
     String uid, name, phoneNumber, profileImage , mail , password;

    public User() {

    }
//    sign up constructor for Email Purpose
    public User( String mail , String password){

        this.mail = mail;
        this.password = password;
    }



//For phone purpose
public User(String uid, String name, String phoneNumber, String profileImage) {
    this.uid = uid;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.profileImage = profileImage;
}




    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

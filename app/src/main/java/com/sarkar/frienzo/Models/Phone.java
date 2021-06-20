package com.sarkar.frienzo.Models;

public class Phone {
    String uid , phoneNumber;
    public Phone(){

    }
    public Phone(String uid , String phoneNumber){
        this.uid = uid;
        this.phoneNumber = phoneNumber;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

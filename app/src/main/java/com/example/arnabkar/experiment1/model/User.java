package com.example.arnabkar.experiment1.model;

import com.squareup.moshi.Json;

public class User {
    public final String name;
    public final String address;
    public final String emailId;
    public final long phoneNo;
    public final boolean isStudent;
    public final @Json(name= "imgUrl") String imageUrl;

    public User(String name,String address,String emailId,long phoneNo,boolean isStudent,String imageUrl) {
        this.name = name;
        this.address = address;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.isStudent = isStudent;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return String.format("User's name is %s with emailId %s having phone number %s",name,emailId,phoneNo);
    }
}

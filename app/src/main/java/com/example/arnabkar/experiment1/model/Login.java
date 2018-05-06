package com.example.arnabkar.experiment1.model;

import com.squareup.moshi.Json;

public class Login {
    public final User user;
    public final @Json(name= "message") String msg;
    public final boolean success;
    public final String authKey;

    public Login(User user,boolean success,String msg,String authKey) {
        this.user = user;
        this.msg = msg;
        this.success = success;
        this.authKey = authKey;
    }

    @Override
    public String toString() {
        if(success){
            return "Login was successful with authKey: "+ authKey;
        }else{
            return "Login failed with message: "+msg;
        }
    }
}

package com.example.arnabkar.experiment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.arnabkar.experiment1.model.Login;
import com.example.arnabkar.experiment1.model.User;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOError;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    void writeJsonToClass (String json) throws IOException{
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Login> jsonAdapter = moshi.adapter(Login.class);

        Login blackjackHand = jsonAdapter.fromJson(json);
        System.out.println(blackjackHand);
    }

    void writeClassToJson(){
        Login blackjackHand = new Login(
                new User("Arnab Kar","2101 Waverley Street, U.S","kararnab@github.com",400123220,true,null),
                true,null,"214sfafsa3423432");

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Login> jsonAdapter = moshi.adapter(Login.class);

        String json = jsonAdapter.toJson(blackjackHand);
        System.out.println(json);
    }
}

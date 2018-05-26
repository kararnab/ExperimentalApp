package com.example.arnabkar.experiment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.arnabkar.experiment1.model.Login;
import com.example.arnabkar.experiment1.model.User;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String jsonToConvert = "{\"user\":{\"name\":\"Arnab\",\"address\":\"22 Rk das road\",\"emailId\":\"kararnab@github.com\",\"phoneNo\":98765443310,\"imgUrl\":null},\"msg\":\"ok\",\"success\":true,\"authKey\":\"awsfde32rwevsd422tgvgsdvsdvgvveasrs34_et34\"}";
                try {
                    Login login = writeJsonToClass(jsonToConvert, Login.class);
                    Log.e("authKey is:",login.authKey);
                }catch (IOException ignored){
                    Log.e("Error",ignored.getMessage());
                }
            }
        });
    }

    <T> T writeJsonToClass(String json,Class<T> className) throws IOException{
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<T> jsonAdapter = moshi.adapter(className);

        return jsonAdapter.fromJson(json);
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

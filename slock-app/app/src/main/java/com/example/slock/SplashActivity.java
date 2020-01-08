package com.example.slock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreference.removeAllAttribute(getApplicationContext());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(SharedPreference.getAttributeBool(getApplicationContext(), "start")){ // 처음으로 앱을 실행한 것이 아니라면 startActivity가 실행되지 않음
            if(SharedPreference.getAttribute(getApplicationContext(), "remember").equals("ok")){
                if(SharedPreference.getAttribute(getApplicationContext(), "job").equals("student")){
                    Intent intent1 = new Intent(getApplicationContext(), MainStudentActivity.class);
                    startActivity(intent1);
                }
                else{
                    Intent intent2 = new Intent(getApplicationContext(), MainTeacherActivity.class);
                    startActivity(intent2);
                }
            }
            else{
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        }
        else{
            Intent intent2 = new Intent(this, StartActivity.class);
            startActivity(intent2);

            SharedPreference.setAttribute(getApplicationContext(), "start", true);
        }

        finish();
    }
}
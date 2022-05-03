package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyStatement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_statement);
        //設定跳轉按鈕_同意按鈕
        Button accept = (Button) findViewById(R.id.accept);
        Intent intent;
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PrivacyStatement.this,LoginScene.class);
                startActivity(intent1);
            }
        });
        Button unaccept = (Button) findViewById(R.id.unaccept);
        unaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PrivacyStatement.this,MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}
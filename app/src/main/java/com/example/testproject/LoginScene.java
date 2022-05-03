package com.example.testproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_scene);
        Button loginsent =(Button) findViewById(R.id.loginsent);
        Intent intent;
        //輸入後跳轉至應用主頁面
        loginsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginScene.this,MainScene_AfterLogin.class);
                startActivity(intent1);
            }
        });
        //清除輸入數值
        Button loginclear = (Button) findViewById(R.id.loginclear);
        loginclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText clearphoneormail = findViewById(R.id.phoneoremail);
                clearphoneormail.setText("");
                EditText clearpassword = findViewById(R.id.password);
                clearpassword.setText("");
            }
        });

    }
}
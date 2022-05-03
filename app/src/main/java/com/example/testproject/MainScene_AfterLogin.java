package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainScene_AfterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scene_after_login);

        //紅利點數查詢跳轉按鈕
        Button rewardsearch = (Button) findViewById(R.id.rewardsearch);
        Intent intent;
        rewardsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainScene_AfterLogin.this,RewardScene.class);
                startActivity(intent1);
            }
        });

    }
}
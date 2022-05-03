package com.example.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class MainActivity<adapter> extends AppCompatActivity
{
    private Spinner spinner;
    private ArrayAdapter<String>adapter;
    private List<String>list;
    Spinner country;    //全域變數country為Spinner屬性。
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        //Spinner下拉式選單
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Spinner spinner = (Spinner)findViewById(R.id.spinner2);
//        final String[] CountryName = {"請選擇國籍","Taiwan", "America", "Korean", "Japan", "China"};
//
//        //ArrayAdapter函數參考資料:
//        //Android Studio 官網:https://developer.android.com/reference/android/widget/ArrayAdapter
//        ArrayAdapter<String> CountryList = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_spinner_dropdown_item, CountryName);
//        spinner.setAdapter(CountryList);

//會無法執行 參考網站:(程式碼已修正)
// https://stackoverflow.com/questions/13240682/android-populate-a-spinner-from-strings-xml
        super.onCreate(savedInstanceState);
        //先抓到activity_main的畫面才能抓到以下的ID
        setContentView(R.layout.activity_main);
        country = (Spinner)findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this,
                R.array.CountryName,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter);

        //跳轉畫面
        Button sent = (Button) findViewById(R.id.sent);
        Intent intent;
        sent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //新增Intent變數並設定目前的Activity和目標Activity
                //跳轉至隱私權聲明頁面
                Intent intent = new Intent(MainActivity.this, PrivacyStatement.class);
                startActivity(intent);  //開始執行跳轉頁面
            }
        });

            //清除TextView的輸入資料
        Button Cleandata = (Button) findViewById(R.id.clear);
        Cleandata.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    EditText clearphonenum = findViewById(R.id.phonenumber);
                    clearphonenum.setText("");
                    EditText clearpasswd = findViewById(R.id.passwordnumber);
                    clearpasswd.setText("");
                    EditText clearemailadd = findViewById(R.id.emailaddress);
                    clearemailadd.setText("");
                    EditText clearbirthday = findViewById(R.id.birthday);
                    clearbirthday.setText("");
                }

            });


    }
}
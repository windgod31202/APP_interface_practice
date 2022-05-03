package com.example.testproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class RewardScene extends AppCompatActivity {
RecyclerView mRecyclerView;
MyListAdapter myListAdapter;
ArrayList<HashMap<String ,String>> arrayList = new ArrayList<>();

Spinner date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_scene);


        //產生資料的函數
        makedata();


        /*設定返回鍵按鈕*/
        Button backtomainscene = (Button) findViewById(R.id.back);
        Intent intent;
        backtomainscene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RewardScene.this,MainScene_AfterLogin.class);
                startActivity(intent1);
            }
        });

        /**在Strings.xml中新增的字串陣列後在這取出，然後放在Spinner中**/
        date = (Spinner)findViewById(R.id.date_selecter);

        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this,
                R.array.date,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        date.setAdapter(adapter);

        //設置RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        myListAdapter = new MyListAdapter();
        mRecyclerView.setAdapter(myListAdapter);

    }//onCreate

    //...製造數字假資料...//
    private void makedata(){
        for (int i = 0;i<100;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("name_infomation","商店代號："+String.format("%02d",i+1));
            hashMap.put("date_infomation",String.valueOf(new Random().nextInt(80) + 20));
            hashMap.put("time_infomation",String.valueOf(new Random().nextInt(80) + 20));
            hashMap.put("rewardpoint_infomation",String.valueOf(
                    (Integer.parseInt(hashMap.get("date_infomation"))
                    +(Integer.parseInt(hashMap.get("time_infomation"))))^2+48/99*2
            ));

            arrayList.add(hashMap);
        }
    }

//    public interface OnItemClickListener{
//        void onItemClick(View view,int position);
//    }
//    public void setOnItemClickListener(OnItemClickListener itemClickListener){
//        this.mItemClickListener = itemClickListener;
//    }

    /*** Adapter ***/
    private class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{



        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView tvname,tvdate,tvtime,tvrewardpoint;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                tvname = itemView.findViewById(R.id.name_infomation);
                tvdate = itemView.findViewById(R.id.date_infomation);
                tvtime = itemView.findViewById(R.id.time_infomation);
                tvrewardpoint = itemView.findViewById(R.id.rewardpoint_infomation);
            }

            public void itemView(HashMap<String, String> stringStringHashMap) {
            }
        }

//簡單介紹一下三個方法(複寫OverWrite)
//
//1.onCreateViewHolder:連接剛才寫的layout檔案，return一個View
//
//2.onBindViewHolder:在這裡取得元件的控制(每個item內的控制)
//
//3.getItemCount:取得顯示數量，return一個int，通常都會return陣列長度(arrayList.size)

        @NonNull
        @Override
        public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item,parent,false);
            return new ViewHolder(view);
        }


        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {


            /***隔行換顏色***/
            for (int i=1;i<31;i++){
                if (position%2==0){
                    holder.tvname.setBackgroundColor(getColor(R.color.red));
                    holder.tvdate.setBackgroundColor(getColor(R.color.red));
                    holder.tvtime.setBackgroundColor(getColor(R.color.red));
                    holder.tvrewardpoint.setBackgroundColor(getColor(R.color.red));
                }
                else {
                    holder.tvname.setBackgroundColor(getColor(R.color.white));
                    holder.tvdate.setBackgroundColor(getColor(R.color.white));
                    holder.tvtime.setBackgroundColor(getColor(R.color.white));
                    holder.tvrewardpoint.setBackgroundColor(getColor(R.color.white));
                }
            }

            holder.tvname.setText(arrayList.get(position).get("name_infomation"));
            holder.tvdate.setText("YYYY/MM/DD");
            holder.tvtime.setText("hh/mm");
            holder.tvrewardpoint.setText(arrayList.get(position).get("rewardpoint_infomation"));


            /**點擊事件後整行換色**/
            holder.itemView(arrayList.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( holder != null) {
                        Log.e("click", String.valueOf(position));
//                        holder.onItemClick(position);
                        holder.tvname.setBackgroundColor(getColor(R.color.blue));
                        holder.tvdate.setBackgroundColor(getColor(R.color.blue));
                        holder.tvtime.setBackgroundColor(getColor(R.color.blue));
                        holder.tvrewardpoint.setBackgroundColor(getColor(R.color.blue));

                    }

//                    Log.e("error", String.valueOf(position));
                }
            });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }


}
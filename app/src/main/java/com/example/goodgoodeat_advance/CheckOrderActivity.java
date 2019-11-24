package com.example.goodgoodeat_advance;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckOrderActivity extends AppCompatActivity {

    TextView txt_msg;
    Intent intent;
    Bundle get_bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);

        Button btn_previous = findViewById(R.id.backButton);
        Button btn_next = findViewById(R.id.submitButton2);
        txt_msg = findViewById(R.id.order);
        intent = new Intent();

        //使用bundle接收資料
        get_bag = getIntent().getExtras(); //這行要打對
        String Time = get_bag.getString("Time");
        String Meal = get_bag.getString("Meal");
        String Add = get_bag.getString("Add");
        txt_msg.setText(Time +"\n"+Meal+"\n"+Add);

        //跳回MainActivity
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(CheckOrderActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //訂購完成，跳到下一頁
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CheckOrderActivity.this,FinishActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
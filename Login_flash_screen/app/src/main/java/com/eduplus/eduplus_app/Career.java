package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;

public class Career extends AppCompatActivity implements View.OnClickListener  {

    CheckBox check1, check2, check3;
    CardView ep_s1, ep_s2, ep_s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);
       // getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        ep_s1 = (CardView)findViewById(R.id.ep_s1);
        ep_s2 = (CardView)findViewById(R.id.ep_s2);
        ep_s3 = (CardView)findViewById(R.id.ep_s3);

        ep_s1.setOnClickListener(this);
        ep_s2.setOnClickListener(this);
        ep_s3.setOnClickListener(this);


        check1  = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);


        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    check1.setTextColor(getResources().getColor(R.color.colorcheck));
                }
                else{
                    check1.setTextColor(getResources().getColor(R.color.colorAccent));
                }

            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check2.isChecked()){
                    check2.setTextColor(getResources().getColor(R.color.colorcheck));
                }
                else{
                    check2.setTextColor(getResources().getColor(R.color.colorAccent));
                }

            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check3.isChecked()){
                    check3.setTextColor(getResources().getColor(R.color.colorcheck));
                }
                else{
                    check3.setTextColor(getResources().getColor(R.color.colorAccent));
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){
            case R.id.ep_s1:
                i = new Intent(Career.this, EP_S1_Module.class);
                startActivity(i);
                break;

            case R.id.ep_s2:
                i = new Intent(Career.this, EP_S2_Module.class);
                startActivity(i);
                break;

            case R.id.ep_s3:
                i = new Intent(Career.this, EP_S3_Module.class);
                startActivity(i);
                break;
        }
    }
}
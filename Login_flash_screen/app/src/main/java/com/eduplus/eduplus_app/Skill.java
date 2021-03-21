package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Switch;

public class Skill extends AppCompatActivity implements View.OnClickListener {

    CheckBox check, check1, check2, check3;
    CardView fp_w1, fp_w2, fp_w3, fp_w4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        fp_w1 = (CardView)findViewById(R.id.fp_w1);
        fp_w2 = (CardView)findViewById(R.id.fp_w2);
        fp_w3 = (CardView)findViewById(R.id.fp_w3);
        fp_w4 = (CardView)findViewById(R.id.fp_w4);

        fp_w1.setOnClickListener(this);
        fp_w2.setOnClickListener(this);
        fp_w3.setOnClickListener(this);
        fp_w4.setOnClickListener(this);


        check  = findViewById(R.id.check);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked()){
                    check.setTextColor(getResources().getColor(R.color.colorcheck));
                }
                else{
                    check.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }
        });

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
            case R.id.fp_w1:
                i = new Intent(Skill.this, FP_W1_Module.class);
                startActivity(i);
                break;

           case R.id.fp_w2:
               i = new Intent(Skill.this, FP_W2_Module.class);
               startActivity(i);
               break;

           case R.id.fp_w3:
               i = new Intent(Skill.this, FP_W3_Module.class);
               startActivity(i);
               break;

           case R.id.fp_w4:
               i = new Intent(Skill.this, FP_W4_Module.class);
               startActivity(i);
               break;
        }
    }
}
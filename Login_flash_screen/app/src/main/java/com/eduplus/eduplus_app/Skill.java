package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Skill extends AppCompatActivity {

    CheckBox check, check1, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        check = findViewById(R.id.check);
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
}
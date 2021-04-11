package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class ProgrammingContent extends AppCompatActivity implements View.OnClickListener {

    ImageView np1, np2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_content);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        np1 = (ImageView) findViewById(R.id.clickView1);
        np2 = (ImageView) findViewById(R.id.clickView2);

        np1.setOnClickListener(this);
        np2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){
            case R.id.clickView1:
                i = new Intent(ProgrammingContent.this, ProgrammingMonth1Activity.class);
                startActivity(i);
                break;

            case R.id.clickView2:
                i = new Intent(ProgrammingContent.this, SkillAI.class);
                startActivity(i);
                break;


        }
    }
}
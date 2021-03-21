package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

public class FP_W1_Module extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w1__module);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
}
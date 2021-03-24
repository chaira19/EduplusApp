package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class FP_W1_Module extends AppCompatActivity {


   // PDFView m1pdf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p__w1__module);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

      //  m1pdf = (PDFView) findViewById(R.id.pdf1);
      //  m1pdf.fromAsset("Week1Module.pdf").load();

    }
}

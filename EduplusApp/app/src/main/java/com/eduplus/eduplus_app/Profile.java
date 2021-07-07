package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btn = findViewById(R.id.update_button);
        btn.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(Profile.this, Home.class));

    }
}
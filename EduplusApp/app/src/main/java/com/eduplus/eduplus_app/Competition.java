package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Competition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CardView intraCard = findViewById(R.id.intra);
        CardView interCard = findViewById(R.id.inter);

        TextView interView = findViewById(R.id.textViewInterSchool);
        RelativeLayout intraLayout = findViewById(R.id.intraSchoolLayout);

        TableRow trIntra = findViewById(R.id.intra1b);
        TableRow trInter = findViewById(R.id.inter1b);

        intraCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                interView.setVisibility(View.GONE);
                intraLayout.setVisibility(View.VISIBLE);
                trIntra.setBackgroundColor(Color.parseColor("#fe616a"));
                trInter.setBackgroundColor(Color.parseColor("#d3d3d3"));

            }
        });

        interCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                interView.setVisibility(View.VISIBLE);
                intraLayout.setVisibility(View.GONE);
                trIntra.setBackgroundColor(Color.parseColor("#d3d3d3"));
                trInter.setBackgroundColor(Color.parseColor("#fe616a"));

            }
        });


    }
}
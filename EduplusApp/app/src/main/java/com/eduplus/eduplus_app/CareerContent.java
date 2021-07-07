package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class CareerContent extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_content);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        */
        CardView cardView = (CardView) findViewById(R.id.c_ep);

        cardView.setOnClickListener(this);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Users").document(user.getPhoneNumber())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot doc = task.getResult();

                        Map<String, Object> careerProg = (Map<String, Object>) doc.get("Career");

                        if(careerProg != null)
                        {
                            Map<String, Object> finPlanProg = (Map<String, Object>) (careerProg.get("Entrepreneurship"));

                            if (finPlanProg != null) {
                                ProgressBar bar1 = (ProgressBar) findViewById(R.id.bar1);;
                                bar1.setMax(3);
                                bar1.setProgress(getMonthProgress((Map<String, Boolean>) finPlanProg.get("Month1")));
                            }
                        }
                    }
                });
    }

    private int getMonthProgress(Map<String, Boolean> monthMap) {
        if(monthMap == null)
        {
            return 0;
        }
        int progress = 0;
        for (Map.Entry<String, Boolean> week : monthMap.entrySet()) {
            if (week.getValue() == true) {
                progress++;
            }
        }
        return progress;
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){
            case R.id.c_ep:
                i = new Intent(CareerContent.this, CareerEP.class);
                startActivity(i);
                break;

        }
    }
}
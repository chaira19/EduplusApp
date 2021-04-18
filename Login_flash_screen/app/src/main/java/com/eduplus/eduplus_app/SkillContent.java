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
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class SkillContent extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_content);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CardView cardView = (CardView) findViewById(R.id.s_fp);

        cardView.setOnClickListener(this);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Users").document("+919410571687");
        db.collection("Users").document("+919410571687")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot doc = task.getResult();

                        Map<String, Object> finPlanProg = (Map<String, Object>) ((Map<String, Object>) doc.get("Skills")).get("FinancialPlanning");


                        if (finPlanProg != null) {
                            ProgressBar bar1 = (ProgressBar) findViewById(R.id.bar1);;
                            bar1.setMax(4);
                            bar1.setProgress(getMonthProgress((Map<String, Boolean>) finPlanProg.get("Month1")));
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
            case R.id.s_fp:
                i = new Intent(SkillContent.this, SkillFP.class);
                startActivity(i);
                break;

        }
    }
}
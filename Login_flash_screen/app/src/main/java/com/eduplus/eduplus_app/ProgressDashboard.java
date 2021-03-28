package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class ProgressDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dashboard);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Users").document(user.getPhoneNumber())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot doc = task.getResult();
                        Map<String, Object> finPlanProg = (Map<String, Object>)((Map<String, Object>)doc.get("Skills")).get("FinancialPlanning");

                        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
                        simpleProgressBar.setProgress(getMonthProgress((Map<String, Boolean>)finPlanProg.get("Month1")));
                    }
                });
    }

    private int getMonthProgress(Map<String, Boolean> monthMap)
    {
        int progress = 0;
        for(Map.Entry<String,Boolean> week :  monthMap.entrySet())
        {
            if(week.getValue() == true)
            {
                progress++;
            }
        }
        return progress;
    }
}
package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class CareerEP extends AppCompatActivity implements View.OnClickListener  {

    CheckBox check1, check2, check3;
    CardView ep_s1, ep_s2, ep_s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_ep);
       // getWindow().setStatusBarColor(Color.TRANSPARENT);
       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ep_s1 = (CardView)findViewById(R.id.ep_s1);
        ep_s2 = (CardView)findViewById(R.id.ep_s2);
        ep_s3 = (CardView)findViewById(R.id.ep_s3);


        ep_s1.setOnClickListener(this);
        ep_s2.setOnClickListener(this);
        ep_s3.setOnClickListener(this);

        check1  = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //String userId = user.getPhoneNumber();
        String userId = "+918006491339";

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    Map<String, Object> careerProgress = (Map<String, Object>)document.get("Career");
                    if(careerProgress != null)
                    {
                        Map<String, Object> entProg = (Map<String, Object>)careerProgress.get("Entrepreneurship");
                        if(entProg != null)
                        {
                            Map<String, Object> month1 = (Map<String, Object>)entProg.get("Month1");
                            if(month1 != null)
                            {
//                                if(month1.containsKey("Week1"))
//                                {
//                                    check.setChecked((Boolean)month1.get("Week1"));
//                                }
                                if(month1.containsKey("Week2"))
                                {
                                    check1.setChecked((Boolean)month1.get("Week2"));
                                }
                                if(month1.containsKey("Week3"))
                                {
                                    check2.setChecked((Boolean)month1.get("Week3"));
                                }
                                if(month1.containsKey("Week4"))
                                {
                                    check3.setChecked((Boolean)month1.get("Week4"));
                                }
                            }
                        }
                    }
                }
                else {
                    Log.e("Error", "Task is not successful");
                }

            }
        });

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked()){
                    check1.setTextColor(getResources().getColor(R.color.colorcheck));
                    setMarkAsCompleted("Month1", "Week2", true);
                }
                else{
                    check1.setTextColor(getResources().getColor(R.color.black));
                    setMarkAsCompleted("Month1", "Week2", false);
                }

            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check2.isChecked()){
                    check2.setTextColor(getResources().getColor(R.color.colorcheck));
                    setMarkAsCompleted("Month1", "Week3", true);
                }
                else{
                    check2.setTextColor(getResources().getColor(R.color.black));
                    setMarkAsCompleted("Month1", "Week3", false);
                }

            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check3.isChecked()){
                    check3.setTextColor(getResources().getColor(R.color.colorcheck));
                    setMarkAsCompleted("Month1", "Week4", true);
                }
                else{
                    check3.setTextColor(getResources().getColor(R.color.black));
                    setMarkAsCompleted("Month1", "Week4", false);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        Intent i;
        SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);

        switch (v.getId()){
            case R.id.ep_s1:
                sharedPreferences.edit().putString("CareerPage", "EP_S1_Module").apply();
                sharedPreferences.edit().commit();
                i = new Intent(CareerEP.this, EP_S1_Module.class);
                startActivity(i);
                break;

            case R.id.ep_s2:
                sharedPreferences.edit().putString("CareerPage", "EP_S2_Module").apply();
                sharedPreferences.edit().commit();
                i = new Intent(CareerEP.this, EP_S2_Module.class);
                startActivity(i);
                break;

            case R.id.ep_s3:
                sharedPreferences.edit().putString("CareerPage", "EP_S3_Module").apply();
                sharedPreferences.edit().commit();
                i = new Intent(CareerEP.this, EP_S3_Module.class);
                startActivity(i);
                break;

        }
    }

    private void setMarkAsCompleted(String month, String week, Boolean completed)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //db.collection("Users").document(user.getPhoneNumber())
        db.collection("Users").document("+918006491339")
                .update("Career.Entrepreneurship." + month + "." + week, completed)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
}
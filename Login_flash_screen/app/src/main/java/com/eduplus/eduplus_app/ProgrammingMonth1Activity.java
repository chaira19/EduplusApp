package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class ProgrammingMonth1Activity extends AppCompatActivity implements View.OnClickListener {

    CheckBox check, check1, check2, check3;
    CardView fp_w1, fp_w2, fp_w3, fp_w4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_month1);
        //getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        fp_w1 = (CardView)findViewById(R.id.fp_w1);
        fp_w2 = (CardView)findViewById(R.id.fp_w2);
        fp_w3 = (CardView)findViewById(R.id.fp_w3);
        fp_w4 = (CardView)findViewById(R.id.fp_w4);

        fp_w1.setOnClickListener(this);
        fp_w2.setOnClickListener(this);
        fp_w3.setOnClickListener(this);
        fp_w4.setOnClickListener(this);


        check  = findViewById(R.id.check);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //String userId = user.getPhoneNumber();

        String userId = "+919410571687";

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    Map<String, Object> skillProgress = (Map<String, Object>)document.get("Programming");
                    if(skillProgress != null)
                    {
                            Map<String, Object> month1 = (Map<String, Object>)skillProgress.get("Month1");
                            if(month1 != null)
                            {
                                if(month1.containsKey("Week1"))
                                {
                                    check.setChecked((Boolean)month1.get("Week1"));
                                }
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
                else {
                    Log.e("Error", "Task is not successful");
                }

            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked()){
                    check.setTextColor(getResources().getColor(R.color.colorcheck));
                    setMarkAsCompleted("Month1", "Week1", true);
                }
                else{
                    check.setTextColor(getResources().getColor(R.color.colorAccent));
                    setMarkAsCompleted("Month1", "Week1", false);
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
                    check1.setTextColor(getResources().getColor(R.color.colorAccent));
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
                    check2.setTextColor(getResources().getColor(R.color.colorAccent));
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
                    check3.setTextColor(getResources().getColor(R.color.colorAccent));
                    setMarkAsCompleted("Month1", "Week4", false);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent();
        SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        String pdfLink = "";

        switch (v.getId()){
            case R.id.fp_w1:
                pdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week1.pdf?alt=media&token=4d76e201-384f-4106-bc46-87c97201e786";
                i = new Intent(ProgrammingMonth1Activity.this, Prog_M1W1_Activity.class);
                break;

            case R.id.fp_w2:
                i = new Intent(ProgrammingMonth1Activity.this, FP_W2_Module.class);
                startActivity(i);
                break;

            case R.id.fp_w3:
                pdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week3.pdf?alt=media&token=3f27cb1c-88dd-40a3-b32e-e6e1fbd34ecf";
                i = new Intent(ProgrammingMonth1Activity.this, Prog_M1W1_Activity.class);
                break;

            case R.id.fp_w4:
                pdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1W4.pdf?alt=media&token=3537ca47-b08e-431a-872f-5adf9e650255";
                i = new Intent(ProgrammingMonth1Activity.this, Prog_M1W1_Activity.class);
                break;
        }

        sharedPreferences.edit().putString("pdfLink", pdfLink).apply();
        sharedPreferences.edit().commit();
        i.putExtra("pdfLink", pdfLink);
        startActivity(i);
    }

    public void setMarkAsCompleted(String month, String week, Boolean completed)
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Users").document(user.getPhoneNumber())
                .update("Programming." + month + "." + week, completed)
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
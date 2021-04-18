package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Map;

public class ProgressDashboard extends AppCompatActivity implements View.OnClickListener {

    private int selectedCard = 0;

    private TextView heading;
    private TextView subHeading1;
    private TextView subHeading2;
    private TextView subHeading3;
    private TextView progTV1;
    private TextView progTV2;
    private TextView progTV3;
    private TextView progTV4;
    private TextView modCom;
    private TextView modTot;

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;

    private ProgressBar pB1;
    private ProgressBar pB2;
    private ProgressBar pB3;
    private ProgressBar pB4;

    private int progProgramming = 0;
    private int progSkills = 0;
    private int progCareer = 0;

    private int progProgrammingM1 = 0;
    private int progSkillsM1 = 0;
    private int progCareerM1 = 0;

    private int progProgrammingM2 = 0;
    private int progSkillsM2 = 0;
    private int progCareerM2 = 0;

    private int progProgrammingM3 = 0;
    private int progSkillsM3 = 0;
    private int progCareerM3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        heading = (TextView) findViewById(R.id.textViewHeading);
        subHeading1 = (TextView) findViewById(R.id.textViewSubHeading1);
        subHeading2 = (TextView) findViewById(R.id.textViewSubHeading2);
        subHeading3 = (TextView) findViewById(R.id.textViewSubHeading3);
        modCom = (TextView) findViewById(R.id.mod_total2);
        modTot = (TextView) findViewById(R.id.mod_total);

        pB1 = (ProgressBar) findViewById(R.id.pB1);
        pB2 = (ProgressBar) findViewById(R.id.pB2);
        pB3 = (ProgressBar) findViewById(R.id.pB3);
        pB4 = (ProgressBar) findViewById(R.id.pB4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setUserData();
        setProgressDashboard();

        Button continueLearning = (Button) findViewById(R.id.buttonContinueLearning);
        continueLearning.setOnClickListener((View.OnClickListener) this);

        CardView c1 = (CardView) findViewById(R.id.c1);
        CardView c2 = (CardView) findViewById(R.id.c2);
        CardView c3 = (CardView) findViewById(R.id.c3);
        CardView c4 = (CardView) findViewById(R.id.c4);

        c1.setOnClickListener((View.OnClickListener) this);
        c2.setOnClickListener((View.OnClickListener) this);
        c3.setOnClickListener((View.OnClickListener) this);
        c4.setOnClickListener((View.OnClickListener) this);

    }

    private void setProgressDashboard()
    {
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
                        Map<String, Object> entshipProg = (Map<String, Object>) ((Map<String, Object>) doc.get("Career")).get("Entrepreneurship");
                        Map<String, Object> progProg = (Map<String, Object>) ((Map<String, Object>) doc.get("Programming"));


                        if (progProg != null) {
                            progProgrammingM1 = getMonthProgress((Map<String, Boolean>) progProg.get("Month1"));
                            progProgrammingM2 = getMonthProgress((Map<String, Boolean>) progProg.get("Month2"));
                            progProgrammingM3 = getMonthProgress((Map<String, Boolean>) progProg.get("Month3"));
                            progProgramming = progProgrammingM1 + progProgrammingM2 + progProgrammingM3;
                        }
                        if (finPlanProg != null) {
                            progSkillsM1 = getMonthProgress((Map<String, Boolean>) finPlanProg.get("Month1"));
                            progSkillsM2 = getMonthProgress((Map<String, Boolean>) finPlanProg.get("Month2"));
                            progSkillsM3 = getMonthProgress((Map<String, Boolean>) finPlanProg.get("Month3"));
                            progSkills = progSkillsM1 + progSkillsM2 + progSkillsM3;
                        }
                        if (entshipProg != null) {
                            progCareerM1 = getMonthProgress((Map<String, Boolean>) entshipProg.get("Month1"));
                            progCareerM2 = getMonthProgress((Map<String, Boolean>) entshipProg.get("Month2"));
                            progCareerM3 = getMonthProgress((Map<String, Boolean>) entshipProg.get("Month3"));
                            progCareer = progCareerM1 + progCareerM2 + progCareerM3;
                        }

                        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
                        progressBar1.setMax(12);
                        progressBar1.setProgress(progProgramming);
                        //pB4.setProgress(progProgramming);

                        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
                        progressBar2.setMax(12);
                        progressBar2.setProgress(progSkills);
                        //pB2.setProgress(progSkills);

                        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
                        progressBar3.setMax(12);
                        progressBar3.setProgress(progCareer);
                        //pB3.setProgress(progCareer);

                        final ProgressBar overallProgress = (ProgressBar) findViewById(R.id.circular_progress);
                        overallProgress.setProgress(progProgramming + progSkills + progCareer);

                        progTV1  = (TextView) findViewById(R.id.textViewRightSubHeading1);
                        progTV2 = (TextView) findViewById(R.id.textViewRightSubHeading2);
                        progTV3 = (TextView) findViewById(R.id.textViewRightSubHeading3);
                        progTV4 = (TextView) findViewById(R.id.textViewOverall);

                        progTV1.setText(((progProgramming * 100) / 12) + "%");
                        progTV2.setText(((progSkills * 100) / 12) + "%");
                        progTV3.setText(((progCareer * 100) / 12) + "%");
                        progTV4.setText(((progProgramming + progSkills + progCareer) * 100) / 36 + "%\n Overall Progress");
                        //pB1.setProgress(progProgramming + progSkills + progCareer);

                        modCom.setText((progProgramming + progSkills + progCareer) + "");
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

    private void setUserData() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //We are creating phone numbers as userIds
        String userId = "+919410571687";

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    String name = (String) document.get("Name");
                    String schoolName = (String) document.get("SchoolName");
                    String photoId = (String) document.get("PhotoId");

//                    TextView nameTextView = findViewById(R.id.tv1);
//                    nameTextView.setText(name.toUpperCase());

//                    TextView schoolNameText = findViewById(R.id.tv2);
//                    schoolNameText.setText(schoolName.toUpperCase());
//
//                    TextView classTextView = findViewById(R.id.tv3);
//                    classTextView.setText("CLASS X");
//
//                    setImageInImageView(findViewById(R.id.studentImage), photoId, "userImages/");
                } else {
                    Log.e("Error", "Task is not successful");
                }

            }
        });
    }

    // set image from storage
    private void setImageInImageView(final ImageView imageView, String imageId, String imageFolder) {
        if (imageId == null || imageId.isEmpty()) {
//            imageView.setImageResource(R.drawable.app_logo);
            return;
        } else {
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            StorageReference imageRef = storageRef.child(imageFolder + imageId);

            imageRef.getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {

                    if (imageView != null) {
                        imageView.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
                        //Glide.with(imageView).load(bytes).into(imageView);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Log.e("Error", "Image Task is not successful");
                }
            });
        }
    }

    @Override
    public void onClick(View v) {

        SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);

        switch (v.getId()){
            case R.id.buttonContinueLearning:
                Intent i;
                switch (selectedCard) {
                    case 0:
                        i = new Intent(ProgressDashboard.this, Home.class);
                        startActivity(i);
                        break;
                    case 1:
                        String skillPage = sharedPreferences.getString("SkillPage",null);

                        if(skillPage == null)
                        {
                            Log.e("Error", "is this fucking null");
                            i = new Intent(ProgressDashboard.this, SkillFP.class);
                        }
                        else
                        {
                            try {
                                i = new Intent(ProgressDashboard.this, Class.forName("com.eduplus.eduplus_app." + skillPage));
                            } catch (ClassNotFoundException e) {
                                Log.e("Error", "attempt failed");
                                i = new Intent(ProgressDashboard.this, SkillFP.class);
                            }
                        }
                        startActivity(i);
                        break;
                    case 2:
                        String careerPage = sharedPreferences.getString("CareerPage",null);

                        if(careerPage == null)
                        {
                            i = new Intent(ProgressDashboard.this, CareerEP.class);
                        }
                        else
                        {
                            try {
                                i = new Intent(ProgressDashboard.this, Class.forName("com.eduplus.eduplus_app." + careerPage));
                            } catch (ClassNotFoundException e) {
                                i = new Intent(ProgressDashboard.this, CareerEP.class);
                            }
                        }
                        startActivity(i);
                        break;
                    case 3:
                        String progPdf = sharedPreferences.getString("pdfLink",null);
                        i = new Intent(ProgressDashboard.this, Prog_M1W1_Activity.class);
                        i.putExtra("pdfLink", progPdf);
                        startActivity(i);
                        break;

                }

                break;

            case R.id.c1:
                selectedCard = 0;
                heading.setText("Overall Progress");
                progTV1.setText(((progProgramming * 100) / 12) + "%");
                progTV2.setText(((progSkills * 100) / 12) + "%");
                progTV3.setText(((progCareer * 100) / 12) + "%");
                progTV4.setText(((progProgramming + progSkills + progCareer) * 100) / 36 + "%\n Overall Progress");
                progressBar1.setMax(32);
                progressBar2.setMax(32);
                progressBar3.setMax(32);
                progressBar1.setProgress(progProgramming);
                progressBar2.setProgress(progSkills);
                progressBar3.setProgress(progCareer);
                pB1.setMax(1);
                pB1.setProgress(1);
                pB2.setMax(1);
                pB2.setProgress(0);
                pB3.setMax(1);
                pB3.setProgress(0);
                pB4.setMax(1);
                pB4.setProgress(0);
                subHeading1.setText("Programming");
                subHeading2.setText("Skills");
                subHeading3.setText("Career");
                modCom.setText((progProgramming + progSkills + progCareer) + "");
                modTot.setText("96");
                break;

            case R.id.c2:
                selectedCard = 1;
                heading.setText("Progress in Skills");
                progTV1.setText(((progSkillsM1 * 100) / 4) + "%");
                progTV2.setText(((progSkillsM2 * 100) / 4) + "%");
                progTV3.setText(((progSkillsM3 * 100) / 4) + "%");
                progTV4.setText(((progSkills) * 100) / 12 + "%\n Prog in Skills");
                progressBar1.setMax(4);
                progressBar2.setMax(4);
                progressBar3.setMax(4);
                progressBar1.setProgress(progSkillsM1);
                progressBar2.setProgress(progSkillsM2);
                progressBar3.setProgress(progSkillsM3);
                pB1.setMax(1);
                pB1.setProgress(0);
                pB2.setMax(1);
                pB2.setProgress(1);
                pB3.setMax(1);
                pB3.setProgress(0);
                pB4.setMax(1);
                pB4.setProgress(0);
                subHeading1.setText("Financial Planning");
                subHeading2.setText("Artificial Intelligence");
                subHeading3.setText("Photography");
                modCom.setText((progSkills) + "");
                modTot.setText("32");
                break;

            case R.id.c3:
                selectedCard = 2;
                heading.setText("Progress in Career");
                progTV1.setText(((progCareerM1 * 100) / 4) + "%");
                progTV2.setText(((progCareerM2 * 100) / 4) + "%");
                progTV3.setText(((progCareerM3 * 100) / 4) + "%");
                progTV4.setText(((progCareer) * 100) / 12 + "%\n Prog in Career");
                progressBar1.setMax(4);
                progressBar2.setMax(4);
                progressBar3.setMax(4);
                progressBar1.setProgress(progCareerM1);
                progressBar2.setProgress(progCareerM2);
                progressBar3.setProgress(progCareerM3);
                pB1.setMax(1);
                pB1.setProgress(0);
                pB2.setMax(1);
                pB2.setProgress(0);
                pB3.setMax(1);
                pB3.setProgress(1);
                pB4.setMax(1);
                pB4.setProgress(0);
                subHeading1.setText("Entrepreneurship");
                subHeading2.setText("Financial Broker");
                subHeading3.setText("Wildlife Photographer");
                modCom.setText((progCareer) + "");
                modTot.setText("32");
                break;

            case R.id.c4:
                selectedCard = 3;
                heading.setText("Progress in Programming");
                progTV1.setText(((progProgrammingM1 * 100) / 4) + "%");
                progTV2.setText(((progProgrammingM2 * 100) / 4) + "%");
                progTV3.setText(((progProgrammingM3 * 100) / 4) + "%");
                progTV4.setText(((progProgramming) * 100) / 12 + "%\n Prog in Programming");
                progressBar1.setMax(4);
                progressBar2.setMax(4);
                progressBar3.setMax(4);
                progressBar1.setProgress(progProgrammingM1);
                progressBar2.setProgress(progProgrammingM2);
                progressBar3.setProgress(progProgrammingM3);
                pB1.setMax(1);
                pB1.setProgress(0);
                pB2.setMax(1);
                pB2.setProgress(0);
                pB3.setMax(1);
                pB3.setProgress(0);
                pB4.setMax(1);
                pB4.setProgress(1);
                subHeading1.setText("Introduction");
                subHeading2.setText("Basics");
                subHeading3.setText("Practice Problems");
                modCom.setText((progProgramming) + "");
                modTot.setText("32");
                break;}
    }
}
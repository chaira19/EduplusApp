package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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

public class ProgressDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dashboard);

        setUserData();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        db.collection("Users").document(user.getPhoneNumber());
        db.collection("Users").document("+919410571687")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot doc = task.getResult();

                        Map<String, Object> finPlanProg = (Map<String, Object>)((Map<String, Object>)doc.get("Skills")).get("FinancialPlanning");
                        Map<String, Object> entshipProg = (Map<String, Object>)((Map<String, Object>)doc.get("Career")).get("Entrepreneurship");
                        Map<String, Object> progProg = (Map<String, Object>)((Map<String, Object>)doc.get("Programming"));

                        int progProgramming = 0;
                        if(progProg != null)
                        {
                            progProgramming = getMonthProgress((Map<String, Boolean>)progProg.get("Month1"));
                        }
                        int progSkills = 0;
                        if(finPlanProg != null)
                        {
                            progSkills = getMonthProgress((Map<String, Boolean>)finPlanProg.get("Month1"));
                        }
                        int progCareer = 0;
                        if(entshipProg != null)
                        {
                            progCareer = getMonthProgress((Map<String, Boolean>)entshipProg.get("Month1"));
                        }

                        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
                        progressBar1.setProgress(progProgramming);

                        final ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
                        progressBar2.setProgress(progSkills);

                        final ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
                        progressBar3.setProgress(progCareer);

                        final ProgressBar overallProgress = (ProgressBar) findViewById(R.id.circular_progress);
                        overallProgress.setProgress(progProgramming + progSkills + progCareer);

                        final TextView progTV1 = (TextView) findViewById(R.id.textViewRightSubHeading1);
                        final TextView progTV2 = (TextView) findViewById(R.id.textViewRightSubHeading2);
                        final TextView progTV3 = (TextView) findViewById(R.id.textViewRightSubHeading3);
                        final TextView progTV4 = (TextView) findViewById(R.id.textViewOverall);

                        progTV1.setText(((progProgramming*100)/4) + "%");
                        progTV2.setText(((progSkills*100)/4) + "%");
                        progTV3.setText(((progCareer*100)/4) + "%");
                        progTV4.setText(((progProgramming + progSkills + progCareer)*100)/12 + "%\n Overall Progress");
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

    private void setUserData() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //We are creating phone numbers as userIds
         String userId = user.getPhoneNumber();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    String name = (String) document.get("Name");
                    String schoolName = (String) document.get("SchoolName");
                    String photoId = (String) document.get("PhotoId");

                    TextView nameTextView = findViewById(R.id.tv1);
                    nameTextView.setText(name.toUpperCase());

                    TextView schoolNameText = findViewById(R.id.tv2);
                    schoolNameText.setText(schoolName.toUpperCase());

                    TextView classTextView = findViewById(R.id.tv3);
                    classTextView.setText("CLASS X");

                    setImageInImageView(findViewById(R.id.studentImage), photoId, "userImages/");
                }
                else {
                    Log.e("Error", "Task is not successful");
                }

            }
        });
    }

    // set image from storage
    private void setImageInImageView(final ImageView imageView, String imageId, String imageFolder)
    {
        if(imageId == null || imageId.isEmpty())
        {
//            imageView.setImageResource(R.drawable.app_logo);
            return;
        }
        else
        {
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            StorageReference imageRef = storageRef.child(imageFolder + imageId);

            imageRef.getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {

                    if(imageView != null)
                    {
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
}
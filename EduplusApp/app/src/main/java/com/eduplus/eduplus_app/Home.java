package com.eduplus.eduplus_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import org.w3c.dom.Text;

import java.util.Map;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView np, ns, nc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.TYPE_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
       setContentView(R.layout.activity_home);

        np = findViewById(R.id.card1);
        ns = findViewById(R.id.card2);
        nc = findViewById(R.id.card3);

        np.setOnClickListener((View.OnClickListener) this);
        ns.setOnClickListener((View.OnClickListener) this);
        nc.setOnClickListener((View.OnClickListener) this);

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Nav drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        setUserData();

        ImageView progIcon = findViewById(R.id.progressIcon);
        progIcon.setOnClickListener((View.OnClickListener) this);

        setProgressDashboard();

    }

    private void setProgressDashboard()
    {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

       db.collection("Users").document(user.getPhoneNumber())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot doc = task.getResult();

                        int progSkills = 0;
                        int progProgramming = 0;
                        int progCareer = 0;

                        Map<String, Object> skillsProg = (Map<String, Object>) doc.get("Skills");
                        if(skillsProg != null)
                        {
                            Map<String, Object> finPlanProg = (Map<String, Object>) skillsProg.get("FinancialPlanning");
                            if (finPlanProg != null) {
                                progSkills = getMonthProgress((Map<String, Boolean>) finPlanProg.get("Month1"));
                            }
                        }

                        Map<String, Object> careerProg = (Map<String, Object>) doc.get("Career");
                        if(careerProg != null)
                        {
                            Map<String, Object> entshipProg = (Map<String, Object>) careerProg.get("Entrepreneurship");
                            if (entshipProg != null) {
                                progCareer = getMonthProgress((Map<String, Boolean>) entshipProg.get("Month1"));
                            }
                        }

                        Map<String, Object> progProg = (Map<String, Object>) ((Map<String, Object>) doc.get("Programming"));
                        if (progProg != null) {
                            progProgramming = getMonthProgress((Map<String, Boolean>) progProg.get("Month1"));
                        }

                        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
                        progressBar1.setMax(32);
                        progressBar1.setProgress(progProgramming);

                        final ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
                        progressBar2.setMax(32);
                        progressBar2.setProgress(progSkills);

                        final ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
                        progressBar3.setMax(24);
                        progressBar3.setProgress(progCareer);

                        final ProgressBar overallProgress = (ProgressBar) findViewById(R.id.circular_progress);
                        overallProgress.setMax(88);
                        overallProgress.setProgress(progProgramming + progSkills + progCareer);

                        final TextView progTV1 = (TextView) findViewById(R.id.textViewRightSubHeading1);
                        final TextView progTV2 = (TextView) findViewById(R.id.textViewRightSubHeading2);
                        final TextView progTV3 = (TextView) findViewById(R.id.textViewRightSubHeading3);
                        final TextView progTV4 = (TextView) findViewById(R.id.textViewOverall);

                        progTV1.setText(((progProgramming * 100) / 32) + "%");
                        progTV2.setText(((progSkills * 100) / 32) + "%");
                        progTV3.setText(((progCareer * 100) / 24) + "%");
                        progTV4.setText(((progProgramming + progSkills + progCareer) * 100) / 88 + "%\n Overall Progress");
                    }
                });
    }

    private int getMonthProgress(Map<String, Boolean> monthMap) {
        int progress = 0;
        if(monthMap == null)
        {
            return progress;
        }
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
        SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);

        switch (v.getId()){
            case R.id.progressIcon:
                startActivity(new Intent(Home.this, ProgressDashboard.class));
                break;
            case R.id.card1:
                String progPdf = sharedPreferences.getString("pdfLink",null);
                i = new Intent(Home.this, Prog_M1W1_Activity.class);
                i.putExtra("pdfLink", progPdf);
                startActivity(i);
                break;

            case R.id.card2:
                String skillPage = sharedPreferences.getString("SkillPage",null);

                if(skillPage == null)
                {
                    Log.e("Error", "is this fucking null");
                    i = new Intent(Home.this, SkillFP.class);
                }
                else
                {
                    try {
                        i = new Intent(Home.this, Class.forName("com.eduplus.eduplus_app." + skillPage));
                    } catch (ClassNotFoundException e) {
                        Log.e("Error", "attempt failed");
                        i = new Intent(Home.this, SkillFP.class);
                    }
                }
                startActivity(i);
                break;

            case R.id.card3:
                String careerPage = sharedPreferences.getString("CareerPage",null);

                if(careerPage == null)
                {
                    i = new Intent(Home.this, CareerEP.class);
                }
                else
                {
                    try {
                        i = new Intent(Home.this, Class.forName("com.eduplus.eduplus_app." + careerPage));
                    } catch (ClassNotFoundException e) {
                        i = new Intent(Home.this, CareerEP.class);
                    }
                }
                startActivity(i);
                break;


        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finishAffinity();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.dashboard:
                Intent intent = new Intent(Home.this, ProgressDashboard.class);
                startActivity(intent);
                break;
            case R.id.programming:
                Intent intent1 = new Intent(Home.this, ProgrammingContent.class);
                startActivity(intent1);
                break;
            case R.id.skill:
                Intent intent2 = new Intent(Home.this, SkillContent.class);
                startActivity(intent2);
                break;
            case R.id.career:
                Intent intent3 = new Intent(Home.this, CareerContent.class);
                startActivity(intent3);
                break;
            case R.id.Competitions:
                Intent intent4 = new Intent(Home.this, Competition.class);
                startActivity(intent4);
                break;
//            case R.id.feedback:
//                Intent intent5 = new Intent(Home.this, Feedback.class);
//                startActivity(intent5);
//                break;
            case R.id.contact:
                Intent intent6 = new Intent(Home.this, Contact.class);
                startActivity(intent6);
                break;
            case R.id.Logout:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                startActivity(new Intent(Home.this, MainActivity.class));
                            }
                        });

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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

                    String firstName = (String) document.get("FirstName");
                    String name = (String) document.get("Name");
                    String schoolName = (String) document.get("SchoolName");
                    String schoolLogoId = (String) document.get("SchoolLogoId");
                    String photoId = (String) document.get("PhotoId");
                    String studentClass = (String) document.get("Class");

                    toolbar = (Toolbar) findViewById(R.id.toolbar);
                    TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
                    mTitle.setText((String)document.get("ToolbarString"));

                    TextView nametxt = findViewById(R.id.headerName);
                    nametxt.setText(name);

                    TextView nameTextView = findViewById(R.id.textView);
                    nameTextView.setText("Hi " + firstName + "!");

                    TextView schoolNameText = findViewById(R.id.textView2);
                    schoolNameText.setText(schoolName);

                    TextView classText = findViewById(R.id.textViewClass);
                    classText.setText("Class " + studentClass);

                    setImageInImageView(findViewById(R.id.headerImage), photoId, "userImages/");
                    setImageInImageView(findViewById(R.id.imageView), schoolLogoId, "schoolLogos/");
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
////            Glide.with(this)
////                    .load(imageRef)
////                    .into(imageView);
//        }
    }
}
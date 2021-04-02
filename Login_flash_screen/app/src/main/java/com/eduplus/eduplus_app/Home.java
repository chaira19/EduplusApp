package com.eduplus.eduplus_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView np, ns, nc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Window g = getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.TYPE_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
       setContentView(R.layout.activity_home);

        np = (ImageView) findViewById(R.id.np);
        ns = (ImageView) findViewById(R.id.ns);
        nc = (ImageView) findViewById(R.id.nc);

        np.setOnClickListener((View.OnClickListener) this);
        ns.setOnClickListener((View.OnClickListener) this);
        nc.setOnClickListener((View.OnClickListener) this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

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

    }


    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){
            case R.id.np:
                i = new Intent(Home.this, Programming.class);
                startActivity(i);
                break;

            case R.id.ns:
                i = new Intent(Home.this, SkillFP.class);
                startActivity(i);
                break;

            case R.id.nc:
                i = new Intent(Home.this, CareerEP.class);
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
            case R.id.feedback:
                Intent intent5 = new Intent(Home.this, Feedback.class);
                startActivity(intent5);
                break;
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
       // String userId = user.getPhoneNumber();
        String userId = "+919410571687";

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    String name = (String) document.get("Name");
                    String schoolName = (String) document.get("SchoolName");
                    String schoolLogoId = (String) document.get("SchoolLogoId");
                    String photoId = (String) document.get("PhotoId");

                    TextView nametxt = findViewById(R.id.headerName);
                    nametxt.setText(name);

                    TextView nameTextView = findViewById(R.id.textView);
                    nameTextView.setText("Hi " + name + "!");

                    TextView schoolNameText = findViewById(R.id.textView2);
                    schoolNameText.setText("Welcome to " + schoolName + "'s learning App");

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
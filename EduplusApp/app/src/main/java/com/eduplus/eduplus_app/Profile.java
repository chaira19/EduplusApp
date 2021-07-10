package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btn = findViewById(R.id.update_button);
        btn.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {

        EditText input1 = findViewById(R.id.name_feedback);
        EditText input2 = findViewById(R.id.number_feedback);
        EditText input3 = findViewById(R.id.feedback_txt);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Map<String, String> userData = new HashMap<>();
        userData.put("Username", String.valueOf(input1.getText()));
        userData.put("Standard", String.valueOf(input2.getText()));
        userData.put("School", String.valueOf(input3.getText()));

        db.collection("Users").document(user.getPhoneNumber())
                .set(userData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "DocumentSnapshot successfully written!");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error writing document", e);
                        }
                    });

        startActivity(new Intent(Profile.this, Home.class));

    }
}
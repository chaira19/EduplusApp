package com.eduplus.eduplus_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        final EditText feedbackText = (EditText) findViewById(R.id.feedback_txt);
        final EditText nameText = (EditText) findViewById(R.id.name_feedback);
        final EditText numberText = (EditText) findViewById(R.id.number_feedback);

        Button button=findViewById(R.id.send_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strValue1 = feedbackText.getText().toString();
                String strValue2 = nameText.getText().toString();
                String strValue3 = numberText.getText().toString();

                if (TextUtils.isEmpty(feedbackText.getText())) {
                    feedbackText.setError("Feedback is required!");
                    Toast.makeText(Contact.this, "Feedback is required", Toast.LENGTH_LONG).show();
                }
                final Map<String, Object> feedback = new HashMap<>();
                feedback.put("Feedback",strValue1);
                feedback.put("Name", strValue2);
                feedback.put("Number", strValue3);

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                db.collection("Feedbacks").add(feedback);
                Toast.makeText(Contact.this, "Thanks for your feedback :)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
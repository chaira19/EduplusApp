package com.eduplus.eduplus_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        createSignInIntent();

    }

    private void createSignInIntent() {

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.LoginTheme)
                        .setLogo(R.drawable.eduplus)
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK) {

//            FirebaseFirestore db = FirebaseFirestore.getInstance();
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//            Map<String, String> userData = new HashMap<>();
//            userData.put("Username", user.getDisplayName());
//            userData.put("ContactNumber", user.getPhoneNumber());
//
//            db.collection("Users").document(user.getUid())
//                    .set(userData)
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Log.d(TAG, "DocumentSnapshot successfully written!");
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.w(TAG, "Error writing document", e);
//                        }
//                    });

            startActivity(new Intent(com.eduplus.eduplus_app.SignInActivity.this, HomeActivity.class));
        }
    }
}
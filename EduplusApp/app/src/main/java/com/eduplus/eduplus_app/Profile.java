package com.eduplus.eduplus_app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ProfileActivity";
    private static final int CROP_PIC_REQUEST_CODE = 0;
    private String imageId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button btn = findViewById(R.id.update_button);
        btn.setOnClickListener((View.OnClickListener) this);

        FloatingActionButton imageButton = findViewById(R.id.floatbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
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
        userData.put("ImageId", imageId);

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

    private void doCrop(Uri picUri) {
        try {

            Intent cropIntent = new Intent("com.android.camera.action.CROP");

            cropIntent.setDataAndType(picUri, "image/*");
            cropIntent.putExtra("crop", "true");
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            cropIntent.putExtra("outputX", 128);
            cropIntent.putExtra("outputY", 128);
            cropIntent.putExtra("return-data", true);
            startActivityForResult(cropIntent, CROP_PIC_REQUEST_CODE);
        }
        // respond to users whose devices do not support the crop action
        catch (ActivityNotFoundException anfe) {

            uploadImage(picUri);
            // display an error message
            String errorMessage = "Whoops - your device doesn't support the crop action!";
            Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        ImageView imageView = findViewById(R.id.imageupload);

        if(requestCode == CROP_PIC_REQUEST_CODE)
        {
            if(resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Bundle extras = data.getExtras();
                    Bitmap bitmap= extras.getParcelable("data");

                    imageView.setImageBitmap(bitmap);
                    uploadImage(data.getData());
                }
            }
        }
        else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                imageView.setImageURI(resultUri);
                uploadImage(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
        else
        {
            if(resultCode == Activity.RESULT_OK) {
                if(data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();
                    for(int i = 0; i < count; i++)
                    {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        CropImage.activity(imageUri)
                                .start(this);
                        //doCrop(imageUri);
                    }
                }
                else if(data.getData() != null) {

                    String imagePath = data.getData().getPath();
                    Uri file = data.getData();

//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.setDataAndType(file, "image/*");
//                    startActivity(intent);
                    CropImage.activity(file)
                            .start(this);
                    //doCrop(file);
                }
            }
        }

    }
    // UploadImage method
    private void uploadImage(Uri imagePath)
    {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        StorageReference imagesRef = storageRef.child("userImages");

        if (imagePath != null) {

            // Code for showing progressDialog while uploading
            final ProgressDialog progressDialog = new ProgressDialog(Profile.this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            final String randomString = UUID.randomUUID().toString();

            // Defining the child of storageReference
            StorageReference ref
                    = storageRef
                    .child(
                            "userImages/"
                                    + randomString);

            // adding listeners on upload
            // or failure of image
            ref.putFile(imagePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    imageId = randomString;

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast.makeText(Profile.this,
                                            "Image Uploaded!!",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(Profile.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_LONG)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }
}
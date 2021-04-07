package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Prog_M1W3_Activity extends AppCompatActivity {

//    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog__m1_w3_);

//        File file = new File(getCacheDir(), "M1Week1.pdf");
//        if (!file.exists()) {
//
//            try {
//                InputStream asset = getAssets().open("M1Week1.pdf");
//                FileOutputStream output = null;
//                output = new FileOutputStream(file);
//                final byte[] buffer = new byte[1024];
//                int size;
//                while ((size = asset.read(buffer)) != -1) {
//                    output.write(buffer, 0, size);
//                }
//                asset.close();
//                output.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }

//        PDFView m1pdf = (PDFView) findViewById(R.id.pdfView1);
        //m1pdf.fromAsset("M1Week3.pdf").load();
        //Uri uri =  Uri.parse( "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week1.pdf?alt=media&token=4d76e201-384f-4106-bc46-87c97201e786" );
//        m1pdf.fromAsset("M1Week3.pdf").load();

//        pdfView=findViewById(R.id.pdfView1);
//        new RetrievePDFStream().execute("");
    }

//    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {
//
//        ProgressDialog progressDialog;
//        protected void onPreExecute()
//        {
//            progressDialog = new ProgressDialog(Prog_M1W3_Activity.this);
//            progressDialog.setTitle("getting the book content...");
//            progressDialog.setMessage("Please wait...");
//            progressDialog.setCanceledOnTouchOutside(false);
//            progressDialog.show();
//
//        }
//        @Override
//        protected InputStream doInBackground(String... strings) {
//            InputStream inputStream = null;
//
//            try {
//
//                URL urlx = new URL(strings[0]);
//                HttpURLConnection urlConnection = (HttpURLConnection) urlx.openConnection();
//                if (urlConnection.getResponseCode() == 200) {
//                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
//
//                }
//            } catch (IOException e) {
//                return null;
//            }
//            return inputStream;
//
//        }
//
//        @Override
//        protected void onPostExecute(InputStream inputStream) {
//            pdfView.fromStream(inputStream).load();
//            progressDialog.dismiss();
//        }
//    }
}
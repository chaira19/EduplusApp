package com.eduplus.eduplus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Prog_M1W1_Activity extends AppCompatActivity {

    PDFView pdfView;
    String pdfLink;
    String newPdfLink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog__m1_w1_);

        ImageView toolbarLeft = (ImageView) findViewById(R.id.leftNavigate);
        toolbarLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                if(pdfLink.contains("Week3"))
                {
                    newPdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week1.pdf?alt=media&token=4d76e201-384f-4106-bc46-87c97201e786";
                    pdfLink = newPdfLink;
                    loadPdf(newPdfLink);
                    sharedPreferences.edit().putString("pdfLink", pdfLink).apply();
                    sharedPreferences.edit().commit();
                }
                else if(pdfLink.contains("W4"))
                {
                    newPdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week3.pdf?alt=media&token=3f27cb1c-88dd-40a3-b32e-e6e1fbd34ecf";
                    pdfLink = newPdfLink;
                    loadPdf(newPdfLink);
                    sharedPreferences.edit().putString("pdfLink", pdfLink).apply();
                    sharedPreferences.edit().commit();
                }
                else
                {
                    finish();
                }
            }
        });

        ImageView imageView = findViewById(R.id.rightNavigate);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                if(pdfLink.contains("Week1"))
                {
                    newPdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week3.pdf?alt=media&token=3f27cb1c-88dd-40a3-b32e-e6e1fbd34ecf";
                    pdfLink = newPdfLink;
                    loadPdf(newPdfLink);
                    sharedPreferences.edit().putString("pdfLink", pdfLink).apply();
                    sharedPreferences.edit().commit();
                }
                else if(pdfLink.contains("Week3"))
                {
                    newPdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1W4.pdf?alt=media&token=3537ca47-b08e-431a-872f-5adf9e650255";
                    pdfLink = newPdfLink;
                    loadPdf(newPdfLink);
                    sharedPreferences.edit().putString("pdfLink", pdfLink).apply();
                    sharedPreferences.edit().commit();
                }
                else if(pdfLink.contains("W4"))
                {
                    finish();
                    startActivity(new Intent(Prog_M1W1_Activity.this, ProgrammingContent.class));
                }

            }
        });

        pdfLink = (String)getIntent().getSerializableExtra("pdfLink");
        loadPdf(pdfLink);
    }

    public void loadPdf(String pdfLink)
    {

//        WebView webView = (WebView) findViewById(R.id.webviewM1W1);
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
////        webView.getSettings().setUseWideViewPort(true);
////        webView.getSettings().setLoadWithOverviewMode(true);
////        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
//
////        webView.getSettings().setSupportZoom(true);
////        webView.getSettings().setBuiltInZoomControls(true);
////        webView.getSettings().setDisplayZoomControls(false);
//
//        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week1.pdf?alt=media&token=4d76e201-384f-4106-bc46-87c97201e786");

//        String mUrl = "https://ide.geeksforgeeks.org/";
//        try {
//            Document document = Jsoup.connect(mUrl).get();
//            document.getElementsByClass("col-sm-3 col-xs-12").remove();
//            //webView.loadData(document.toString(),"text/html","utf-8");
//            webView.loadDataWithBaseURL(mUrl,document.toString(),"text/html","utf-8","");
//        } catch (IOException e) {
//            webView.loadUrl("https://ide.geeksforgeeks.org/");
//            e.printStackTrace();
//        }


//        webView.setWebViewClient(new WebViewClient() {
//            @Nullable
//            @Override
//            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
//                if(url.contains("google")||url.contains("facebook")){
//                    InputStream textStream = new ByteArrayInputStream("".getBytes());
//                    return getTextWebResource(textStream);
//                }
//                return super.shouldInterceptRequest(view, url);
//            }
//
//            //webview used to display a URL in the application
//
////            @Override
////            public void onPageFinished(WebView view, String url) {
////
////                //webview load url and remove header from website
////
////                webView.loadUrl("javascript:(function() { " +
////                        "document.getElementsByClass('col-sm-3 col-xs-12')[0].style.display='none'; " +
////                        "})()");
////
////            }
//        });

        //String html = "<p><iframe src=\"https://docs.google.com/document/d/e/2PACX-1vQkrH3bxEByVKsuxBeHavsiS9msKGvtthyldDQNaGQHgsPZAn38n1udV3MLCDmPAO4VyA2Jrlx1Read/pub?embedded=false\" width=\"100%\"></iframe></p>";
        //webView.loadUrl("https://docs.google.com/document/d/e/2PACX-1vQkrH3bxEByVKsuxBeHavsiS9msKGvtthyldDQNaGQHgsPZAn38n1udV3MLCDmPAO4VyA2Jrlx1Read/pub?embedded=false");
//        Log.e("Error", "It's coming here fuck");

        if(pdfLink == null || pdfLink.isEmpty())
        {
            pdfLink = "https://firebasestorage.googleapis.com/v0/b/eduplus-8497a.appspot.com/o/pdfs%2FM1Week1.pdf?alt=media&token=4d76e201-384f-4106-bc46-87c97201e786";
        }

        TextView textView = (TextView) findViewById(R.id.heading);
        if(pdfLink.contains("Week1"))
        {
            textView.setText("Introduction to Computer Science");
        }
        if(pdfLink.contains("Week3"))
        {
            textView.setText("Programming Languages");
        }
        if(pdfLink.contains("W4"))
        {
            textView.setText("Setting up for C++");
        }
//
//        Log.e("Error", "The value of pdfName string is " + pdfName);
//
//        PDFView m1pdf = (PDFView) findViewById(R.id.pdfView);
//        m1pdf.fromAsset("M1Week3.pdf")
//                .enableAnnotationRendering(true)
//                .scrollHandle(new DefaultScrollHandle(this))
//                .load();

//        if(pdfName.equalsIgnoreCase("M1W1"))
//        {
//            Log.e("Error", "pdf name is " + pdfName);
//            m1pdf.fromAsset("M1W1").load();
//        }

//        if(pdfName.equalsIgnoreCase("M1W3"))
//        {
//            m1pdf.fromAsset("M1W3").load();
//        }
//
//        if(pdfName.equalsIgnoreCase("M1W4"))
//        {
//            m1pdf.fromAsset("M1W4").load();
//        }

//        File file = new File(getCacheDir(), "M1Week3.pdf");
//        if (!file.exists()) {
//
//            try {
//                InputStream asset = getAssets().open("M1Week3.pdf");
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
//        m1pdf.fromFile(file).load();

        pdfView=findViewById(R.id.pdfView);
        new Prog_M1W1_Activity.RetrievePDFStream().execute(pdfLink);

    }

    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {

        ProgressDialog progressDialog;
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(Prog_M1W1_Activity.this);
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

        }
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try {

                URL urlx = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) urlx.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            progressDialog.dismiss();
        }
    }
}
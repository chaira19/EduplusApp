package com.eduplus.eduplus_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Prog_M1W1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog__m1_w1_);

        WebView webView = (WebView) findViewById(R.id.webviewM1W1);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        //webView.loadUrl("https://ide.geeksforgeeks.org/");

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

         PDFView m1pdf = (PDFView) findViewById(R.id.pdfView);
          m1pdf.fromAsset("M1W1.pdf").load();
    }
}
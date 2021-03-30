package com.eduplus.eduplus_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CodeEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_editor);

        WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

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


        webView.setWebViewClient(new WebViewClient() {
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if(url.contains("google")||url.contains("facebook")){
                    InputStream textStream = new ByteArrayInputStream("".getBytes());
                    return getTextWebResource(textStream);
                }
                return super.shouldInterceptRequest(view, url);
            }

            //webview used to display a URL in the application

//            @Override
//            public void onPageFinished(WebView view, String url) {
//
//                //webview load url and remove header from website
//
//                webView.loadUrl("javascript:(function() { " +
//                        "document.getElementsByClass('col-sm-3 col-xs-12')[0].style.display='none'; " +
//                        "})()");
//
//            }
        });

        webView.loadUrl("https://ide.geeksforgeeks.org/");
    }

    private WebResourceResponse getTextWebResource(InputStream data) {
        return new WebResourceResponse("text/plain", "UTF-8", data);
    }
}
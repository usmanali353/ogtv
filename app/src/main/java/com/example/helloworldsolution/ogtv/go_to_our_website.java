package com.example.helloworldsolution.ogtv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class go_to_our_website extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_our_website);
        browser=(WebView)findViewById(R.id.webview);
               String url="http://creativeexperts.com.pk/oslotv/";
                browser.getSettings().setBuiltInZoomControls(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                browser.setWebViewClient(new MyWebViewClient());
                browser.loadUrl(url);
    }
    class MyWebViewClient extends WebViewClient {
       @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
           view.loadUrl(url);
                       return true;
       }
   }

}

package com.example.alvin.feedthebaby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by alvin on 8/12/17.
 */

public class WebViewexperiment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView simpleWebView=(WebView) findViewById(R.id.simplewebview);
// specify the url of the web page in loadUrl function
        simpleWebView.loadUrl("file:///android_asset/babyurl.html");
    }
}

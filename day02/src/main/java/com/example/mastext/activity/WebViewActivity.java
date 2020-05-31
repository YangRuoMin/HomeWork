package com.example.mastext.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastext.R;

public class WebViewActivity extends AppCompatActivity {


    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {

        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("https://www.baidu.com");
    }
}

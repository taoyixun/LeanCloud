package com.taoyixun.leancloud;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.http.util.EncodingUtils;

public class AdobeIdActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adobe_id);
        mWebView = findViewById(R.id.webView);

        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.getSettings().setSavePassword(false);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        // 设置可以支持缩放
        mWebView.getSettings().setSupportZoom(true);
        // 扩大比例的缩放
        mWebView.getSettings().setUseWideViewPort(true);
        // 自适应屏幕
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.getSettings().setLoadWithOverviewMode(true);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        mWebView.loadUrl("https://account.adobe.com/");
        // https://api.account.adobe.com/ims/resend/v1/email_verification?client_id=SunbreakWebUI1&locale=zh-Hans
        // https://api.account.adobe.com/ims/update_profile/v1?client_id=SunbreakWebUI1&locale=zh-Hans
        // {"email":"1714091258@qq.com"}
    }

    public void go(View view) {
        StringBuilder builder1 = new StringBuilder();
        builder1.append("email=").append("3092805940@qq.com");
        String postData = builder1.toString();
        mWebView.postUrl("https://api.account.adobe.com/ims/update_profile/v1?client_id=SunbreakWebUI1&locale=zh-Hans", EncodingUtils.getBytes(postData, "BASE64"));
    }
}

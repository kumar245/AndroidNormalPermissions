package com.kumar.user.androidnormalpermissions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView) findViewById(R.id.wV);
        webView.setWebViewClient(new myWebView());
        editText= (EditText) findViewById(R.id.editText);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    }
    String url;
    void LoadUrl(String url){
        this.url=url;
        webView.loadUrl(url);
    }

    public void buGO(View view) {
        LoadUrl(editText.getText().toString());
    }

    public void buBack(View view) {
        webView.goBack();
    }

    public void buForward(View view) {
        webView.goForward();
    }
    public class myWebView extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(url);
            return true;
        }
    }
}

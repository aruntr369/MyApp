package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewEx extends AppCompatActivity {
    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_ex);

        webView=(WebView) findViewById(R.id.webView);
        editText=(EditText) findViewById(R.id.textSite);
        Button button=(Button) findViewById(R.id.submitBtn);


        webView.setWebViewClient(new WebViewClient());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url =editText.getText().toString();

                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl("https://www."+url+".com");
            }
        });
    }
}
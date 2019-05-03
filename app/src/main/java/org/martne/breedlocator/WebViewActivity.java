package org.martne.breedlocator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class WebViewActivity extends Activity implements AdvancedWebView.Listener {

    AdvancedWebView web;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        web = (AdvancedWebView) findViewById(R.id.webView);
        web.setListener(this, this);
        web.loadUrl("http://breedlocator.martne.org/");
        progressBar = (ProgressBar) findViewById(R.id.spin_kit);

    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        web.onResume();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        web.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        web.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        web.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public void onBackPressed() {
        if (!web.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        progressBar.setVisibility(View.VISIBLE);
        web.setVisibility(View.GONE);
    }

    @Override
    public void onPageFinished(String url) {
        progressBar.setVisibility(View.GONE);
        web.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        Intent i = new Intent(WebViewActivity.this, Error.class);
        startActivity(i);
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) { }

    @Override
    public void onExternalPageRequest(String url) { }

}

package preslm.simplewebviewapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class activity_webViewPage extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_webview);
        Activity activity = this;
        progressDialog = ProgressDialog.show(activity, "Loading", "Please wait...", true);
        progressDialog.setCancelable(false);

        WebView webView = (WebView) findViewById(R.id.webViewWindow);
        assert webView != null; //suppress warnings
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(
            new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    progressDialog.show();
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, final String url) {
                    progressDialog.dismiss();
                }
            }
        );
        webView.loadUrl(helper_General.returnURL());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //ToDo: Implement onResume
    }

    @Override
    public void onBackPressed() { // back out, leave the site.
        Intent intent = new Intent(activity_webViewPage.this, activity_MainMenu.class);
        startActivity(intent);
        finish();
    }
}
package benicio.solucoes.castanhalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import benicio.solucoes.castanhalnews.databinding.ActivityMainBinding;
import benicio.solucoes.castanhalnews.databinding.ActivitySiteBinding;

public class ActivitySite extends AppCompatActivity {
    private ActivitySiteBinding vb;
    private WebView wb;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vb = ActivitySiteBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(vb.getRoot());
        wb  = vb.wb;

        Toast.makeText(getApplicationContext(), "Espere carregar...", Toast.LENGTH_SHORT).show();
        WebSettings webSett = wb.getSettings();
        webSett.setJavaScriptEnabled(true);
        wb.setWebViewClient( new WebViewClientImpl(this) );
        wb.loadUrl("http://castanhalnews.com.br/");


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && wb.canGoBack()) {
            wb.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public class WebViewClientImpl extends WebViewClient {

        private Activity activity = null;

        public WebViewClientImpl(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if(url.contains("castanhalnews.com.br")) return false;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }


    }
}

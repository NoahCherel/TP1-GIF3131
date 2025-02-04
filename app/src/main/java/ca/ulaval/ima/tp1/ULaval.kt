package ca.ulaval.ima.tp1

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.ComponentActivity


class ULaval : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulaval)

        val url: String? = intent.getStringExtra("url")
        val webView = findViewById<WebView>(R.id.webView)
        val button = findViewById<Button>(R.id.closeButton)
        button.setOnClickListener {
            finish()
        }

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        if (url != null) {
            webView.loadUrl(url)
        }
        webView.webViewClient = WebViewClient()
    }
}
package ca.ulaval.ima.tp1
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity


class Genie_info : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genie_info)
        val url: String? = intent.getStringExtra("url")

        val webView = findViewById<WebView>(R.id.webView)
        if (url != null) {
            webView.loadUrl(url)
        }
        webView.webViewClient = WebViewClient()
    }
}
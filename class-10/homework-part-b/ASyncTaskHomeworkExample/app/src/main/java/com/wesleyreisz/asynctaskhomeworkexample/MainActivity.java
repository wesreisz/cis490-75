package com.wesleyreisz.asynctaskhomeworkexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnGo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText urlToGet = (EditText)findViewById(R.id.urlToFetch);
                String url = urlToGet.getText().toString();

                if(url!=null && url.length()>0){
                    WebView webView = (WebView) findViewById(R.id.webView);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.loadUrl(url);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Please enter a url", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });
    }
}

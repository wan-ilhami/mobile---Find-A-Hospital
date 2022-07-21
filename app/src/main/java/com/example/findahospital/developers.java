package com.example.findahospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class developers extends AppCompatActivity {
    Button button;
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        WebView webViewer=  findViewById(R.id.web);
        webViewer.loadUrl("file:///android_asset/www/index.html" );



        button = (Button) findViewById(R.id.btnhome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdashboard();
            }
        });
    }
    public void userdashboard(){
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);
    }

}
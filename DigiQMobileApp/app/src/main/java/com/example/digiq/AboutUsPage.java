package com.example.digiq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUsPage extends AppCompatActivity {
    TextView tvAbout ,tvinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_page);

        tvAbout=findViewById(R.id.tvAbout);
        tvinfo=findViewById(R.id.tvinfo);
    }
}
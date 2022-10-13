package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity2 extends AppCompatActivity {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        message=intent.getStringExtra("messag_e");
        getSupportActionBar().setTitle(message);
        TextView tex=(TextView)findViewById(R.id.price_text_view);
        tex.setText(message);



    }
}
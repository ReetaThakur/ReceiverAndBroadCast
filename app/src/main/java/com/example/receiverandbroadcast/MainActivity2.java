package com.example.receiverandbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtReceive=findViewById(R.id.txtreceive);
        Intent intent=getIntent();
        String data=intent.getStringExtra("Message");
        txtReceive.setText(data);
    }
}
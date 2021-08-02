package com.example.receiverandbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button click;
    private final int REQUEST_CODE=1;
    private AirplaneModeReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click=findViewById(R.id.btnclick);
        receiver=new AirplaneModeReceiver();
        IntentFilter intentFilter=new IntentFilter("com.receiverbroadcast");
        registerReceiver(receiver,intentFilter);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("Message","I am Sending BroadCast");
               startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String []permission={Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(MainActivity.this,permission,1);
    }
}
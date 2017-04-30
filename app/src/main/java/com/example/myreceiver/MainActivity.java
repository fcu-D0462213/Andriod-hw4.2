package com.example.myreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView toSayHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        toSayHello=(TextView)findViewById(R.id.output);
        String hello="Hello";
        if(intent!=null)
        {
            String name=intent.getStringExtra("OName");
            if(name!=null)
            {
                hello=hello+name;
            }
        }
        toSayHello.setText(hello);
    }
}

package com.example.techland.crashrecoverysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CustomErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_error);

        Button restartButton = findViewById(R.id.restart_button);
        restartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    overridePendingTransition(0,0);
                /*Intent intent = new Intent();
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent);
                finishAffinity();*/
                    //onBackPressed();
                    finish();
                    System.exit(2);
                }
            });
    }
    }


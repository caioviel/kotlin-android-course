package com.example.eat_and_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(v -> onStartButton());
    }

    private void onStartButton() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }
}
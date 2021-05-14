package com.example.ceaser_cypher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void Encrypt(View view) {
        Intent intent = new Intent(MainActivity.this, EncryptionActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }

    public void Decrypt(View view) {
        Intent intent = new Intent(MainActivity.this, DecryptionActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}
package com.example.ceaser_cypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.encryption)
    Button encryptionButton;
    @BindView(R.id.decryption)
    Button decryptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        encryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent encryptionintent = new Intent(MainActivity.this, EncryptionActivity.class);
                startActivity(encryptionintent);
            }
        });

        decryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent decryptionintent = new Intent(MainActivity.this, DecryptionActivity.class);
                startActivity(decryptionintent);
            }
        });
    }

    public void Encrypt(View view) {
        Intent intent = new Intent(MainActivity.this, EncryptionActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void Decrypt(View view) {
        Intent intent = new Intent(MainActivity.this, DecryptionActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
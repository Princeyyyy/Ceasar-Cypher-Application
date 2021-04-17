package com.example.ceaser_cypher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DecryptionActivity extends AppCompatActivity {


    @BindView(R.id.decryptiontext)
    EditText decryptionText;
    @BindView(R.id.decryptionbutton)
    Button decryptionbutton;
    @BindView(R.id.encrypted)
    TextView encrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
        ButterKnife.bind(this);
    }
}
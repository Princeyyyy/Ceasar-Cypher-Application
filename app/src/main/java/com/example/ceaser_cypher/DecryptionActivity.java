package com.example.ceaser_cypher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
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
    @BindView(R.id.decrypted)
    TextView decrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
        ButterKnife.bind(this);

        decryptionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable y = decryptionText.getText();
                decrypted.setText(DecrytionCc(y));
            }
        });
    }

    int key = 5;

    String DecrytionCc(Editable cipher) {
        String temp = "";
        for (int i = 0; i < cipher.length(); i++) {

            if (cipher.charAt(i) == ' ') {
                temp += ' ';
            } else if (cipher.charAt(i) - key < 'a') {
                temp += ((char) (cipher.charAt(i) - (key - 26)));
            } else
                temp += ((char) (cipher.charAt(i) - key));
        }
        return temp;

    }
}
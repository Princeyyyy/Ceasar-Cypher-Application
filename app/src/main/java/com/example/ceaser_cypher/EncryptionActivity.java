package com.example.ceaser_cypher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EncryptionActivity extends AppCompatActivity {

    @BindView(R.id.encryptiontext)
    EditText encryptionText;
    @BindView(R.id.encryptionbutton)
    Button encryptionButton;
    @BindView(R.id.encrypted)
    TextView encrypted;
//    @BindView(R.id.shiftkey)
//    EditText shiftKey;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        ButterKnife.bind(this);

        encryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText shiftKey = findViewById(R.id.shiftkey);
                Editable x = encryptionText.getText();
                String w = x.toString();
                Editable a = shiftKey.getText();
                String b = a.toString();
                if (TextUtils.isEmpty(w)) {
                    encryptionText.setError("Text Required");
                    return;
                }
                if (TextUtils.isEmpty(b)) {
                    shiftKey.setError("Shift Key Required");
                } else {
                    encrypted.setText(EncrytionCc(x));
                }
            }
        });
    }

    String EncrytionCc(Editable plain) {
        EditText shiftKey = findViewById(R.id.shiftkey);
        String value = shiftKey.getText().toString();
        int finalValue = Integer.parseInt(value);
        String temp = "";
        for (int i = 0; i < plain.length(); i++) {

            if (plain.charAt(i) == ' ') {
                temp += ' ';
            } else if (plain.charAt(i) + finalValue > 'z') {
                temp += ((char) (plain.charAt(i) - (26 - finalValue)));
            } else
                temp += ((char) (plain.charAt(i) + finalValue));
        }
        return temp;
    }

}

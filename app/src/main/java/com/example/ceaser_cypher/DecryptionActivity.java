package com.example.ceaser_cypher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    @BindView(R.id.image2)
    ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);
        ButterKnife.bind(this);

        decryptionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText shiftKey2 = findViewById(R.id.shiftkey2);
                Editable y = decryptionText.getText();
                String z = y.toString();
                Editable d = shiftKey2.getText();
                String e = d.toString();
                if (TextUtils.isEmpty(z)) {
                    decryptionText.setError("Text Required");
                    return;
                }
                if (TextUtils.isEmpty(e)) {
                    shiftKey2.setError("Shift Key Required");
                } else {
                    decrypted.setText(DecryptionCc(y));
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu2(v);
            }
        });
    }


    String DecryptionCc(Editable cipher) {
        EditText shiftKey2 = findViewById(R.id.shiftkey2);
        String value2 = shiftKey2.getText().toString();
        int finalValue2 = Integer.parseInt(value2);
        String temp = "";
        for (int i = 0; i < cipher.length(); i++) {

            if (cipher.charAt(i) == ' ') {
                temp += ' ';
            } else if (cipher.charAt(i) - finalValue2 < 'a') {
                temp += ((char) (cipher.charAt(i) - (finalValue2 - 26)));
            } else
                temp += ((char) (cipher.charAt(i) - finalValue2));
        }
        return temp;

    }

    public void Menu2(View view) {
        Intent intent = new Intent(DecryptionActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.stay);
    }
}
package com.develop.dubhad.securerandomnumber;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.SecureRandom;

public class RandomNumberActivity extends Activity {

    private Button generateButton = null;
    private EditText startValueEdit = null;
    private EditText endValueEdit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);
    }

    public void generateRandomNumber(View button) {
        startValueEdit = findViewById(R.id.startValueEdit);
        endValueEdit = findViewById(R.id.endValueEdit);

        if (TextUtils.isEmpty(startValueEdit.getText()) || TextUtils.isEmpty(endValueEdit.getText())) {
            Toast.makeText(this, "Enter the bounds", Toast.LENGTH_SHORT).show();
            return;
        }

        int startValue;
        int endValue;
        try {
            startValue = Integer.parseInt(startValueEdit.getText().toString());
            endValue = Integer.parseInt(endValueEdit.getText().toString());
        }
        catch (NumberFormatException nfe) {
            Toast.makeText(this,"Number is too big", Toast.LENGTH_SHORT).show();
            return;
        }

        SecureRandom rand = new SecureRandom();
        int number;
        if (startValue > endValue) {
            number = rand.nextInt(startValue - endValue) + endValue;
        }
        else {
            number = rand.nextInt(endValue - startValue) + startValue;
        }

        generateButton = (Button)button;
        generateButton.setText(String.valueOf(number));
    }
}

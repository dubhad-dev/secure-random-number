package com.develop.dubhad.securerandomnumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.SecureRandom;

public class RandomNumberActivity extends Activity {

    private Button generateButton = null;
    private EditText minValueEdit = null;
    private EditText maxValueEdit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);
    }

    public void generateRandomNumber(View button) {
        SecureRandom rand = new SecureRandom();

        minValueEdit = findViewById(R.id.minValueEdit);
        maxValueEdit = findViewById(R.id.maxValueEdit);
        int minValue = Integer.parseInt(minValueEdit.getText().toString());
        int maxValue = Integer.parseInt(maxValueEdit.getText().toString());
        int number = rand.nextInt(maxValue - minValue) + minValue;

        generateButton = (Button)button;
        generateButton.setText(String.valueOf(number));
    }
}

package com.develop.dubhad.securerandomnumber;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

        startValueEdit = findViewById(R.id.startValueEdit);
        endValueEdit = findViewById(R.id.endValueEdit);
    }

    public void generateRandomNumber(View button) {
        generateButton = (Button)button;

        if (TextUtils.isEmpty(startValueEdit.getText()) || TextUtils.isEmpty(endValueEdit.getText())) {
            signalError(getString(R.string.bounds_error), "Empty bounds");
            return;
        }

        int startValue;
        int endValue;
        try {
            startValue = Integer.parseInt(startValueEdit.getText().toString());
            endValue = Integer.parseInt(endValueEdit.getText().toString());
        }
        catch (NumberFormatException nfe) {
            signalError(getString(R.string.overflow_error), "Wrong integer\n" + nfe);
            return;
        }

        int number = generateRandomInt(startValue, endValue);
        Log.i(getClass().getSimpleName(), "Generated number = " + number);

        generateButton.setText(String.valueOf(number));
    }

    private int generateRandomInt(int startValue, int endValue) {
        SecureRandom rand = new SecureRandom();
        int number;
        if (startValue > endValue)
            number = rand.nextInt(startValue - endValue) + endValue;
        else
            number = rand.nextInt(endValue - startValue) + startValue;
        return number;
    }

    private void signalError(String message, String info) {
        Log.e(getClass().getSimpleName(), info);
        generateButton.setText(R.string.error_title);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

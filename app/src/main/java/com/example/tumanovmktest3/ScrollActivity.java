package com.example.tumanovmktest3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ScrollActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "scroll_prefs";
    private static final String KEY_USER_INPUT = "user_input";

    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        userInput = findViewById(R.id.userInput);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String saved = prefs.getString(KEY_USER_INPUT, "");
        userInput.setText(saved);
        userInput.setSelection(saved.length());
    }

    @Override
    protected void onPause() {
        super.onPause();
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                .edit()
                .putString(KEY_USER_INPUT, userInput.getText().toString())
                .apply();
    }
}

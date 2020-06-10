package com.ensias.chatbot;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView greeting;
    public static EditText username;
    private EditText userage;
    private Button begin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greeting = findViewById(R.id.greeting_text);
        username = findViewById(R.id.activitymain_inputname);
        userage = findViewById(R.id.activitymain_inputage);
        begin = findViewById(R.id.activitymain_button);
        begin.setEnabled(false);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username.getText().length() != 0 && userage.getText().length() != 0)
                    begin.setEnabled(true);
                else
                    begin.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        userage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if(username.getText().length() != 0 && userage.getText().length() != 0)
                   begin.setEnabled(true);
               else
                   begin.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ChatbotIntent = new Intent(MainActivity.this, botChat.class);
                startActivity(ChatbotIntent);
            }
        });
    }
}
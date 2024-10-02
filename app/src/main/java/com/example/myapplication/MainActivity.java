package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Initializing EditText, button and textView components
    EditText nameText;
    Button buttonSayHello;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameText.addTextChangedListener(new TextWatcher() { //Add text changed listener to nameText passing in textWatcher
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { //Before nameText change

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) { //On nameText change
                buttonSayHello.setEnabled(nameText.getText() != null && !nameText.getText().toString().isEmpty()); // set button to enabled true when nameText not null or empty
            }

            @Override
            public void afterTextChanged(Editable s) { //After nameText change

            }
        });
    }

    public void sayHello(View view) {
        if (nameText.getText() != null && !nameText.getText().toString().isEmpty()) { //if nameText is not empty and not null hello, name!
            String Greeting = "Hello, " + nameText.getText() + "!"; //Sets greeting with name
            textView.setText(Greeting); //Sets textview text to the greeting
        } else { //Else if nameText is empty or null, hello!
            String Greeting = "Hello!";
            textView.setText(Greeting);

        }
    }
}
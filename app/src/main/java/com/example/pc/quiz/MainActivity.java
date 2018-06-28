package com.example.pc.quiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private  EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }


    public void validate(String userName, String Password) {
        if ((userName.equals("Admin")) && (Password.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        } else {
            counter--;
            Info.setText("No of attempts remaining: " + String.valueOf(counter));

        }

        if (counter == 0) {
            Login.setEnabled(false);
        }
    }
}
package com.example.pc.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    int score = 0;
    String ans1 = "",
            ans2 = "",
            ans5 = "";
    EditText name, ans5text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    void check() {
        //first ans
        RadioGroup first = (RadioGroup) findViewById(R.id.first);
        int selected1 = first.getCheckedRadioButtonId();
        RadioButton b = (RadioButton) findViewById(selected1);
        ans1 = b.getText() + "";
        if (ans1.equals("B.    Google")) {
            score++;
        }

        //second ans

        name = (EditText) findViewById(R.id.etName);
        ans2 = name.getText().toString();
        if (ans2.equals("google")) {
            score++;
        }

        //third ans


        //four ans

        //five ans

        ans5text = (EditText) findViewById(R.id.etName);
        ans5 = ans5text.getText().toString();
        if (ans5.equals("yes")) {
            score++;
        }

    }

    public void checkboxclick(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            score++;
        }
    }


    @SuppressLint("SetTextI18n")
    void submit(View view) {
        check();
        TextView scoremsg = (TextView) findViewById(R.id.score);
        scoremsg.setEnabled(true);
        if(score==5){
            scoremsg.setText("GENIUS You scored " + score + " mark in Android Quiz");
        }
        else {
            scoremsg.setText("Congratulations! You scored " + score + " mark");
        }
        Button submit= (Button) findViewById(R.id.submit);
        submit.setEnabled(false);

    }

    void share(View view) {
        //share code
        String message = "I scored " + score + " mark in Android Quiz";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(share, "Congratulations!"));

        //share code closed
    }
}

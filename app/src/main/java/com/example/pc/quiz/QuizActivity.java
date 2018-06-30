package com.example.pc.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    int score = 0;
    String ans1 = "",
            ans2 = "",
            ans3 = "",
            ans4 = "",
            ans5 = "",
            ans6 = "",
            ans7 = "",
            ans8 = "",
            ans9 = "",
            ans10 = "";

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

        RadioGroup second = (RadioGroup) findViewById(R.id.second);
        int selected2 = second.getCheckedRadioButtonId();
        RadioButton c = (RadioButton) findViewById(selected2);
        ans2 = c.getText() + "";
        if (ans2.equals("D.    Google")) {
            score++;
        }

        //third ans

        RadioGroup third = (RadioGroup) findViewById(R.id.third);
        int selected3 = third.getCheckedRadioButtonId();
        RadioButton d = (RadioButton) findViewById(selected3);
        ans3 = d.getText() + "";
        if (ans3.equals("C.   Open-source Webkit")) {
            score++;
        }
        //four ans

        RadioGroup four = (RadioGroup) findViewById(R.id.four);
        int selected4 = four.getCheckedRadioButtonId();
        RadioButton e = (RadioButton) findViewById(selected4);
        ans4 = e.getText() + "";
        if (ans4.equals("A.    Linux kernel")) {
            score++;
        }
        //five ans

        RadioGroup five = (RadioGroup) findViewById(R.id.five);
        int selected5 = five.getCheckedRadioButtonId();
        RadioButton f = (RadioButton) findViewById(selected5);
        ans5 = f.getText() + "";
        if (ans5.equals("B.    No")) {
            score++;
        }

        //six ans

        RadioGroup six= (RadioGroup) findViewById(R.id.six);
        int selected6 = six.getCheckedRadioButtonId();
        RadioButton g = (RadioButton) findViewById(selected6);
        ans6 = g.getText() + "";
        if (ans6.equals("D.    Java")) {
            score++;
        }

        //seven ans

        RadioGroup seven= (RadioGroup) findViewById(R.id.seven);
        int selected7 = seven.getCheckedRadioButtonId();
        RadioButton h = (RadioButton) findViewById(selected7);
        ans7 = h.getText() + "";
        if (ans7.equals("B.    No")) {
            score++;
        }

        //eight ans

        RadioGroup eight= (RadioGroup) findViewById(R.id.eight);
        int selected8 = eight.getCheckedRadioButtonId();
        RadioButton i = (RadioButton) findViewById(selected8);
        ans8 = i.getText() + "";
        if (ans8.equals("B.    2.3 (Gingerbread)" )) {
            score++;
        }

        //nine ans

        RadioGroup nine= (RadioGroup) findViewById(R.id.nine);
        int selected9 = nine.getCheckedRadioButtonId();
        RadioButton j = (RadioButton) findViewById(selected9);
        ans9 = j.getText() + "";
        if (ans9.equals("C.    Mobile Operating System")) {
            score++;
        }

        //ten ans

        RadioGroup ten= (RadioGroup) findViewById(R.id.ten);
        int selected10 = ten.getCheckedRadioButtonId();
        RadioButton k = (RadioButton) findViewById(selected10);
        ans10 = k.getText() + "";
        if (ans10.equals("B.    MPEG" )) {
            score++;
        }
    }

    @SuppressLint("SetTextI18n")
    void submit(View view) {
        check();
        TextView scoremsg = (TextView) findViewById(R.id.score);
        scoremsg.setEnabled(true);
        if(score==10){
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

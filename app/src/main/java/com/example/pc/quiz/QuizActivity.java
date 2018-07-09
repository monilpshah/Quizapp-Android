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

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    int score = 0;
    String ans2 = "",
            ans5 = "";
    EditText name, ans5text;
    private RadioButton b;
    RadioGroup first;
    int selected1;
    TextView scoremsg;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initView();
    }

    private void initView() {
        first = (RadioGroup) findViewById(R.id.first);
        selected1 = first.getCheckedRadioButtonId();
        b = (RadioButton) findViewById(selected1);

        scoremsg = (TextView) findViewById(R.id.score);
//        submit = (Button) findViewById(R.id.submit);
//        submit.setOnClickListener(this);
    }

    void check(View view) {
        //first ans
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.A:
                if (checked)
                    break;
            case R.id.B:
                if (checked) {
                    score++;
                    break;
                }
            case R.id.C:
                if (checked)
                    break;
            case R.id.D:
                if (checked)
                    break;

        }

    }

    void Edittext2() {
        //second ans

        name = (EditText) findViewById(R.id.secondedittext);
        ans2 = name.getText().toString();

        if (ans2.equals("google")) {
            score++;
        }
    }

    void Edittext3() {
        ans5text = (EditText) findViewById(R.id.yesno);
        ans5 = ans5text.getText().toString();
        if (ans5.equals("yes")) {
            score++;
        }
    }


    //
    public void checkboxclick(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            score++;
        }
    }

    @Override
    public void onClick(View view) {
        Edittext2();
        Edittext3();
        if (score ==5) {
            scoremsg.setText("GENIUS You scored " + score + " mark in Android Quiz");
        }
        else if(score==0){
            scoremsg.setText("OOPS! You scored " + score + " mark \n \n \n Better Luck Next time");
        }
        else {
            scoremsg.setText("Congratulations! You scored " + score + " mark");
        }

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
package com.example.android.projectquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app is a financial aid quiz.
 */
public class MainActivity extends AppCompatActivity {

    //Correct number of quiz answers
    int correct = 0;

    //Total number of quiz questions
    static int total = 4;

    //Q2 button result
    String Q2_answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit answers button is clicked.
     */
    public void submitAnswers(View view) {
        //get the answer to text entry question 1 --FREE
        EditText tQuestion1 = (EditText) findViewById(R.id.Question_1_Answer_Text);
        String q1a = tQuestion1.getText().toString();

        //set the question 2 radio button answer --NO
        String q2a = Q2_answer;

        //get the answer to text entry question 3 --Rocky Raider or Rocky the Raider (depending on the source)
        EditText tQuestion3 = (EditText) findViewById(R.id.Question_3_Answer_Text);
        String q3a = tQuestion3.getText().toString();

        //get all the checked box states for question 4
        //phone --correct answer
        CheckBox q4a1 = (CheckBox) findViewById(R.id.Question_4_Answer_1);
        boolean getQ4A1 = q4a1.isChecked();

        //twitter --wrong answer
        CheckBox q4a2 = (CheckBox) findViewById(R.id.Question_4_Answer_2);
        boolean getQ4A2 = q4a2.isChecked();

        //facebook --correct answer
        CheckBox q4a3 = (CheckBox) findViewById(R.id.Question_4_Answer_3);
        boolean getQ4A3 = q4a3.isChecked();

        //in person --correct answer
        CheckBox q4a4 = (CheckBox) findViewById(R.id.Question_4_Answer_4);
        boolean getQ4A4 = q4a4.isChecked();

        //email --correct answer
        CheckBox q4a5 = (CheckBox) findViewById(R.id.Question_4_Answer_5);
        boolean getQ4A5 = q4a5.isChecked();

        //mobile app --wrong answer
        CheckBox q4a6 = (CheckBox) findViewById(R.id.Question_4_Answer_6);
        boolean getQ4A6 = q4a6.isChecked();

        //check the answers and increment the correct variable for correct answers
        checkQ1(q1a);
        checkQ2(q2a);
        checkQ3(q3a);
        checkQ4(getQ4A1, getQ4A2, getQ4A3, getQ4A4, getQ4A5, getQ4A6);

        //give the user a toast with the number of correct answers
        displayScore();
    }

    //check the answer to question 1 and increment correct if correct
    private void checkQ1(String answer) {
        if (answer.toUpperCase().equals("FREE")) {
            correct += 1;
            return;
        }
    }

    //check the answer to question 2 and increment correct if correct
    private void checkQ2(String answer) {
        if (answer == "NO" && answer != null) {
            correct += 1;
            return;
        }
    }

    //check the answer to question 3 and increment correct if correct
    private void checkQ3(String answer) {
        if (answer.toUpperCase().equals("ROCKY THE RAIDER")) {
            correct += 1;
            return;
        }

        if (answer.toUpperCase().equals("ROCKY RAIDER")) {
            correct += 1;
            return;
        }
    }

    //check the answers to question 4 and increment correct if correct
    private void checkQ4(boolean a1, boolean a2, boolean a3, boolean a4, boolean a5, boolean a6) {
        if (a1 == true && a2 == false && a3 == true && a4 == true && a5 == true && a6 == false) {
            correct += 1;
            return;
        }
    }

    //toast the user with a range of scores, from 0 to 4.
    public void displayScore() {
        Context context = getApplicationContext();
        String grade = Integer.toString(correct);
        CharSequence text = grade + " out of " + total;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        correct = 0;
        return;
    }

    //check the radio answer for question 2
    public void onRadioButtonClicked(View view) {
        // Question 2 - Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q2_yes_radio:
                if (checked)
                    // Yes
                    Q2_answer = "YES";
                break;
            case R.id.q2_no_radio:
                if (checked)
                    Q2_answer = "NO";
                // No
                break;
        }
    }
}
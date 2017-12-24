package com.example.vlada.europeancapitalsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class EasyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
    }

    //This method is called when the submit button is clicked
    public void submitAnswers (View view){

        int finalScore = calculatePoints();

        //displays this toast if the user acumulated 3 points
        if (finalScore == 3){
            Toast.makeText(this, getString(R.string.won),
                    Toast.LENGTH_LONG).show();

        }
        //displays this toast if the user's score is bellow 3 points
        else {
            Toast.makeText(this, getString(R.string.loose_easy),
                    Toast.LENGTH_LONG).show();
        }
    }


    /*@param checkedReykjavik is wether the user checked the corect answer
     *@param checkedTirana is wether the user checked the corect answer
     *@param checkedBratislava is wether the user checked the corect answer
    */

    public int calculatePoints () {

        //initial value of the points
        int score = 0;

        //checks if the user answered correct the first question
        if (((RadioButton)findViewById(R.id.france_paris)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the second question
        if (((RadioButton)findViewById(R.id.germany_berlin)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the third question
        if (((RadioButton)findViewById(R.id.england_london)).isChecked()){
            score += 1;
        }

        return score;
    }
}



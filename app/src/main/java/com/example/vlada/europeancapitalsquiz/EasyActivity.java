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

        //Checks which radio button is checked in question 1.
        RadioButton paris = (RadioButton)findViewById(R.id.france_paris);
        boolean selectParis = paris.isChecked();
        RadioButton bucharest = (RadioButton)findViewById(R.id.france_bucharest);
        boolean selectBucharest = bucharest.isChecked();
        RadioButton prague = (RadioButton)findViewById(R.id.france_prague);
        boolean selectPrague = prague.isChecked();

        //Checks which radio button is checked in question 2.
        RadioButton dublin = (RadioButton)findViewById(R.id.germany_dublin);
        boolean selectDublin = dublin.isChecked();
        RadioButton berlin = (RadioButton)findViewById(R.id.germany_berlin);
        boolean selectBerlin = berlin.isChecked();
        RadioButton rome = (RadioButton)findViewById(R.id.germany_rome);
        boolean selectRome = rome.isChecked();

        //Checks which radio button is checked in question 3.
        RadioButton athens = (RadioButton)findViewById(R.id.england_athens);
        boolean selectAthens = athens.isChecked();
        RadioButton madrid = (RadioButton)findViewById(R.id.england_madrid);
        boolean selectMadrid = madrid.isChecked();
        RadioButton london = (RadioButton)findViewById(R.id.england_london);
        boolean selectLondon = london.isChecked();
        int finalScore = calculatePoints(selectParis, selectBerlin, selectLondon);

        //displays this toast if the user acumulated 3 points
        if (finalScore == 3){
            Toast.makeText(this, getString(R.string.won),
                    Toast.LENGTH_LONG).show();

        }
        //displays this toast if the user's score is bellow 3 points
        else {
            Toast.makeText(this, getString(R.string.loose),
                    Toast.LENGTH_LONG).show();
        }
    }


    /*@param checkedReykjavik is wether the user checked the corect answer
     *@param checkedTirana is wether the user checked the corect answer
     *@param checkedBratislava is wether the user checked the corect answer
    */

    public int calculatePoints (boolean checkedParis, boolean checkedBerlin, boolean checkedLondon) {

        //initial value of the points
        int score = 0;

        //checks if the user answered correct the first question
        if (checkedParis) {
            score += 1;
        }

        //checks if the user answered correct the second question
        if (checkedBerlin) {
            score += 1;
        }

        //checks if the user answered correct the third question
        if (checkedLondon){
            score += 1;
        }

        return score;
    }
}



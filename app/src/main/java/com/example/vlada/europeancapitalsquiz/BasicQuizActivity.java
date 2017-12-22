package com.example.vlada.europeancapitalsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class BasicQuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_quiz);
    }

    //This method is called when the submit button is clicked
    public void submitAnswers (View view){

        //Checks which radio button is checked in question 1.
        RadioButton zagreb = (RadioButton)findViewById(R.id.albania_zagreb);
        boolean selectZagreb = zagreb.isChecked();
        RadioButton tirana = (RadioButton)findViewById(R.id.albania_tirana);
        boolean selectTirana = tirana.isChecked();
        RadioButton tibilisi = (RadioButton)findViewById(R.id.albania_tibilisi);
        boolean selectTibilisi = tibilisi.isChecked();

        //Checks which radio button is checked in question 2.
        RadioButton stockholm = (RadioButton)findViewById(R.id.iceland_stockholm);
        boolean selectStockholm = stockholm.isChecked();
        RadioButton helsinki = (RadioButton)findViewById(R.id.iceland_helsinki);
        boolean selectHelsinki = helsinki.isChecked();
        RadioButton reykjavik = (RadioButton)findViewById(R.id.iceland_reykjavik);
        boolean selectReykjavik = reykjavik.isChecked();

        //Checks which radio button is checked in question 3.
        RadioButton bratislava = (RadioButton)findViewById(R.id.slovakia_bratislava);
        boolean selectBratislava = bratislava.isChecked();
        RadioButton ljublijana = (RadioButton)findViewById(R.id.slovakia_ljublijana);
        boolean selectljublijana = ljublijana.isChecked();
        RadioButton belgrade = (RadioButton)findViewById(R.id.slovakia_belgrade);
        boolean selectBelgrade = belgrade.isChecked();
        int finalScore = calculatePoints(selectTirana, selectReykjavik, selectBratislava);

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

    public int calculatePoints (boolean checkedReykjavik, boolean checkedTirana, boolean checkedBratislava) {

        //initial value of the points
        int score = 0;

        //checks if the user answered correct the first question
        if (checkedTirana) {
            score += 1;
        }

        //checks if the user answered correct the second question
        if (checkedReykjavik) {
            score += 1;
        }

        //checks if the user answered correct the third question
        if (checkedBratislava){
            score += 1;
        }

        return score;
    }
}

package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class QuizActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // sets layout according to what the user selected on the MainActivity
        final Bundle parameters = getIntent().getExtras();
        if (parameters != null && parameters.containsKey("layout")){
            setContentView(parameters.getInt("layout"));}
        else{
            setContentView(R.layout.activity_easy);}
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        final int layoutId = parameters.getInt("layout");

        // starts Ending activity
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layoutId == R.layout.activity_basic_quiz) {
                    int finalScore = calculatePoints();

                    if (parameters != null) {
                        String data = parameters.getString("name");
                        Intent intent = new Intent(QuizActivity.this, EndingActivity.class);
                        intent.putExtra("name", data);
                        intent.putExtra("finalScore", finalScore);

                        //defines what will be displayed in the EndingActivity
                        if (finalScore > 2) {
                            intent.putExtra("finalTxt", getText(R.string.win).toString());
                        }
                        //defines what will be displayed in the EndingActivity
                        else {
                            intent.putExtra("finalTxt", getText(R.string.loser).toString());
                            intent.putExtra("image", R.drawable.looser);
                        }
                        startActivity(intent);
                    }
                }else {
                    int finalScore = calculatePointsEasy();

                    if (parameters != null) {
                        String data = parameters.getString("name");
                        Intent intent = new Intent(QuizActivity.this, EndingActivity.class);
                        intent.putExtra("name", data);
                        intent.putExtra("finalScore", finalScore);

                        //defines what will be displayed in the EndingActivity
                        if (finalScore > 2) {
                            intent.putExtra("finalTxt", getText(R.string.win).toString());
                        }
                        //defines what will be displayed in the EndingActivity
                        else {
                            intent.putExtra("finalTxt", getText(R.string.loser).toString());
                            intent.putExtra("image", R.drawable.looser);
                        }
                        startActivity(intent);
                    }
                }




            }
        });

    }

    /*@param checkedReykjavik is wether the user checked the corect answer
     *@param checkedTirana is wether the user checked the corect answer
     *@param checkedBratislava is wether the user checked the corect answer
    */

    public int calculatePoints() {

        //initial value of the points
        int score = 0;
        EditText answer = (EditText) findViewById(R.id.answer);

        if (answer.getText().toString().contentEquals(getString(R.string.basic_answer))) {
            score += 1;
        }

        // Check which checkbox was clicked
        if ((((CheckBox) findViewById(R.id.wine)).isChecked()) &&
                        (((CheckBox) findViewById(R.id.empires)).isChecked()) &&
                        (((CheckBox) findViewById(R.id.civilisation)).isChecked())) {
                score += 1;
            }

        //checks if the user answered correct the first question
        if (((RadioButton) findViewById(R.id.albania_tirana)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the second question
        if (((RadioButton) findViewById(R.id.iceland_reykjavik)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the third question
        if (((RadioButton) findViewById(R.id.slovakia_bratislava)).isChecked()) {
            score += 1;
        }

        return score;
    }

    public int calculatePointsEasy() {

        //initial value of the points
        int score = 0;
        EditText answer = (EditText) findViewById(R.id.answer);

        if (answer.getText().toString().contentEquals(getString(R.string.easy_answer))) {
            score += 1;
        }

        // Check which checkbox was clicked

        if ((((CheckBox) findViewById(R.id.countries)).isChecked()) &&
                (((CheckBox) findViewById(R.id.smallest)).isChecked()) &&
                (((CheckBox) findViewById(R.id.economy)).isChecked())) {
            score += 1;
        }

        //checks if the user answered correct the first question

        if (((RadioButton) findViewById(R.id.france_paris)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the second question

        if (((RadioButton) findViewById(R.id.germany_berlin)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the third question

        if (((RadioButton) findViewById(R.id.england_london)).isChecked()) {
            score += 1;
        }

        return score;
    }
}

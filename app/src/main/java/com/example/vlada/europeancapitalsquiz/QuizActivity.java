package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // sets layout according to what the user selected on the MainActivity
        final Bundle parameters = getIntent().getExtras();
        if (parameters != null && parameters.containsKey("layout")) {
            setContentView(parameters.getInt("layout"));
        } else {
            this.finish();
        }
        Button btnSubmit = findViewById(R.id.btnSubmit);
        final int layoutId = parameters.getInt("layout");

        // starts Ending activity
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checks if the user answered all the questions
                boolean questionsAnswered = (layoutId == R.layout.activity_basic_quiz) ?
                        checkAllQuestionsBasicAnswered() : checkAllQuestionsEasyAnswered();

                if (questionsAnswered) {
                    //defines the score according to the layout and gets specific method for the layout
                    int finalScore = (layoutId == R.layout.activity_basic_quiz) ? getPoints() : getPointsEasy();
                    Intent intent = new Intent(QuizActivity.this, EndingActivity.class);
                    intent.putExtra("name", parameters.getString("name"));
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
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.all_questions), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //gets points according to the answers for activity_basic_quiz layout
    public int getPoints() {

        //initial value of the points
        int score = 0;
        EditText answer = findViewById(R.id.answer);

        //adds point if user inputs the correct answer
        if (answer.getText().toString().contentEquals(getString(R.string.basic_answer))) {
            score += 1;
        }

        //adds point if user selected correct answers
        if ((((CheckBox) findViewById(R.id.wine)).isChecked()) &&
                (((CheckBox) findViewById(R.id.empires)).isChecked()) &&
                (((CheckBox) findViewById(R.id.civilisation)).isChecked()) &&
                (!((CheckBox) findViewById(R.id.name)).isChecked())) {
            score += 1;
        }

        //adds point if user selected correct answer
        if (((RadioButton) findViewById(R.id.albania_tirana)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct answer
        if (((RadioButton) findViewById(R.id.iceland_reykjavik)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct answer
        if (((RadioButton) findViewById(R.id.slovakia_bratislava)).isChecked()) {
            score += 1;
        }

        return score;
    }

    //gets points according to the answers for activity_easy layout
    public int getPointsEasy() {

        //initial value of the points
        int score = 0;
        EditText answer = findViewById(R.id.answer);

        //adds point if user inputs the correct answer
        if (answer.getText().toString().contentEquals(getString(R.string.easy_answer))) {
            score += 1;
        }

        //adds point if user selected correct answers
        if ((((CheckBox) findViewById(R.id.countries)).isChecked()) &&
                (((CheckBox) findViewById(R.id.smallest)).isChecked()) &&
                (((CheckBox) findViewById(R.id.economy)).isChecked()) &&
                (!((CheckBox) findViewById(R.id.christian)).isChecked())) {
            score += 1;
        }

        //adds point if user selected correct answer
        if (((RadioButton) findViewById(R.id.france_paris)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct answer
        if (((RadioButton) findViewById(R.id.germany_berlin)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct answer
        if (((RadioButton) findViewById(R.id.england_london)).isChecked()) {
            score += 1;
        }

        return score;
    }

    //checks if all the questions ware answered from activity_basic_quiz layout
    public boolean checkAllQuestionsBasicAnswered() {

        return ((((CheckBox) findViewById(R.id.wine)).isChecked()) ||
                (((CheckBox) findViewById(R.id.empires)).isChecked()) ||
                (((CheckBox) findViewById(R.id.civilisation)).isChecked()) ||
                (((CheckBox) findViewById(R.id.name)).isChecked())) &&
                (((((RadioButton) findViewById(R.id.albania_tibilisi)).isChecked()) ||
                (((RadioButton) findViewById(R.id.albania_tirana)).isChecked()) ||
                (((RadioButton) findViewById(R.id.albania_zagreb)).isChecked())) &&
                ((((RadioButton) findViewById(R.id.iceland_reykjavik)).isChecked()) ||
                (((RadioButton) findViewById(R.id.iceland_helsinki)).isChecked()) ||
                (((RadioButton) findViewById(R.id.iceland_stockholm)).isChecked())) &&
                ((((RadioButton) findViewById(R.id.slovakia_belgrade)).isChecked()) ||
                (((RadioButton) findViewById(R.id.slovakia_bratislava)).isChecked()) ||
                (((RadioButton) findViewById(R.id.slovakia_ljublijana)).isChecked())));

    }

    //checks if all the questions ware answered from activity_easy layout
    public boolean checkAllQuestionsEasyAnswered() {

        return ((((CheckBox) findViewById(R.id.countries)).isChecked()) ||
                (((CheckBox) findViewById(R.id.smallest)).isChecked()) ||
                (((CheckBox) findViewById(R.id.economy)).isChecked()) ||
                (((CheckBox) findViewById(R.id.christian)).isChecked())) &&
                (((((RadioButton) findViewById(R.id.france_paris)).isChecked()) ||
                (((RadioButton) findViewById(R.id.france_bucharest)).isChecked()) ||
                (((RadioButton) findViewById(R.id.france_prague)).isChecked())) &&
                ((((RadioButton) findViewById(R.id.germany_berlin)).isChecked()) ||
                (((RadioButton) findViewById(R.id.germany_dublin)).isChecked()) ||
                (((RadioButton) findViewById(R.id.germany_rome)).isChecked())) &&
                ((((RadioButton) findViewById(R.id.england_london)).isChecked()) ||
                (((RadioButton) findViewById(R.id.england_athens)).isChecked()) ||
                (((RadioButton) findViewById(R.id.england_madrid)).isChecked())));

    }
}

package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
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

                //defines the score according to the layout and gets specific method for the layout
                if (questionsAnswered) {
                    int finalScore = (layoutId == R.layout.activity_basic_quiz) ? getPoints() : getPointsEasy();
                    Intent intent = new Intent(QuizActivity.this, EndingActivity.class);
                    intent.putExtra("userNameInput", parameters.getString("userNameInput"));
                    intent.putExtra("finalScore", finalScore);

                    //defines what will be displayed in the EndingActivity
                    if (finalScore > 2) {
                        intent.putExtra("finalTxt", getText(R.string.win).toString());
                    } else {
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
    private int getPoints() {

        //initial value of the points
        int score = 0;
        EditText answer = findViewById(R.id.userAnswerInput);

        //adds point if user inputs the correct userAnswerInput
        if (answer.getText().toString().contentEquals(getString(R.string.basic_answer))) {
            score += 1;
        }

        //adds point if user selected correct answers
        if ((((CheckBox) findViewById(R.id.europeWineProduction)).isChecked()) &&
                (((CheckBox) findViewById(R.id.wwiEuropeanEmpires)).isChecked()) &&
                (((CheckBox) findViewById(R.id.westernCivilisationBirth)).isChecked()) &&
                (!((CheckBox) findViewById(R.id.europeNameFrom)).isChecked())) {
            score += 1;
        }

        //adds point if user selected correct userAnswerInput
        if (((RadioButton) findViewById(R.id.albania_tirana)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct userAnswerInput
        if (((RadioButton) findViewById(R.id.iceland_reykjavik)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct userAnswerInput
        if (((RadioButton) findViewById(R.id.slovakia_bratislava)).isChecked()) {
            score += 1;
        }

        return score;
    }

    //gets points according to the answers for activity_easy layout
    private int getPointsEasy() {

        //initial value of the points
        int score = 0;
        EditText answer = findViewById(R.id.userAnswerInput);

        //adds point if user inputs the correct userAnswerInput
        if (answer.getText().toString().contentEquals(getString(R.string.easy_answer))) {
            score += 1;
        }

        //adds point if user selected correct answers
        if ((((CheckBox) findViewById(R.id.numberOfEuropeanCountries)).isChecked()) &&
                (((CheckBox) findViewById(R.id.europeSmallestCountry)).isChecked()) &&
                (((CheckBox) findViewById(R.id.worldsRichestEconomy)).isChecked()) &&
                (!((CheckBox) findViewById(R.id.europeReligion)).isChecked())) {
            score += 1;
        }

        //adds point if user selected correct userAnswerInput
        if (((RadioButton) findViewById(R.id.france_paris)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct userAnswerInput
        if (((RadioButton) findViewById(R.id.germany_berlin)).isChecked()) {
            score += 1;
        }

        //adds point if user selected correct userAnswerInput
        if (((RadioButton) findViewById(R.id.england_london)).isChecked()) {
            score += 1;
        }

        return score;
    }

    //checks if all the questions ware answered from activity_basic_quiz layout
    public boolean checkAllQuestionsBasicAnswered() {

        return ((((CheckBox) findViewById(R.id.europeWineProduction)).isChecked()) ||
                (((CheckBox) findViewById(R.id.wwiEuropeanEmpires)).isChecked()) ||
                (((CheckBox) findViewById(R.id.westernCivilisationBirth)).isChecked()) ||
                (((CheckBox) findViewById(R.id.europeNameFrom)).isChecked())) &&
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

        return ((((CheckBox) findViewById(R.id.numberOfEuropeanCountries)).isChecked()) ||
                (((CheckBox) findViewById(R.id.europeSmallestCountry)).isChecked()) ||
                (((CheckBox) findViewById(R.id.worldsRichestEconomy)).isChecked()) ||
                (((CheckBox) findViewById(R.id.europeReligion)).isChecked())) &&
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

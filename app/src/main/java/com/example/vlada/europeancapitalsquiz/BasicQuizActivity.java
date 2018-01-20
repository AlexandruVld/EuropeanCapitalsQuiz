package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class BasicQuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_quiz);
        final EditText name = (EditText) findViewById(R.id.name_input);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int finalScore = calculatePoints();

                //starts WinActivity if the user scores 4 points
                if (finalScore == 4) {
                Intent intent = new Intent(BasicQuizActivity.this, WinActivity.class);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);


            }
            //starts LooseActivity if the user scored below 4 points
            else {
                Intent intent = new Intent(BasicQuizActivity.this, LooseActivity.class);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);

            }

            }
        });

    }

    /*@param checkedReykjavik is wether the user checked the corect answer
     *@param checkedTirana is wether the user checked the corect answer
     *@param checkedBratislava is wether the user checked the corect answer
    */

    public int calculatePoints () {

        //initial value of the points
        int score = 0;

        if ((((CheckBox)findViewById(R.id.wine)).isChecked()) &&
        (((CheckBox)findViewById(R.id.empires)).isChecked()) &&
                (((CheckBox)findViewById(R.id.civilisation)).isChecked())) {
            score += 1;
        }
        //checks if the user answered correct the first question
        if (((RadioButton)findViewById(R.id.albania_tirana)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the second question
        if (((RadioButton)findViewById(R.id.iceland_reykjavik)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the third question
        if (((RadioButton)findViewById(R.id.slovakia_bratislava)).isChecked()){
            score += 1;
        }

        return score;
    }
}

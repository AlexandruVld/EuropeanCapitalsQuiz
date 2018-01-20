package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class EasyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        final EditText name = (EditText) findViewById(R.id.name_input);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int finalScore = calculatePoints();

                //starts WinActivity if the user scored 4 points and sends the user name
                if (finalScore == 4) {
                    Intent intent = new Intent(EasyActivity.this, WinActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    startActivity(intent);


                }
                //starts LooseActivity if the user scored bellow 4 points and sends the user name
                else {
                    Intent intent = new Intent(EasyActivity.this, LooseActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    startActivity(intent);

                }

            }
        });

    }


    /*@param checkedParis is wether the user checked the corect answer
     *@param checkedBerlin is wether the user checked the corect answer
     *@param checkedLondon is wether the user checked the corect answer
    */

    //calculate the points that user scored
    public int calculatePoints () {

        //initial value of the points
        int score = 0;

        //checks if the user selected the corect statements from the first question set
        if ((((CheckBox)findViewById(R.id.countries)).isChecked()) &&
                (((CheckBox)findViewById(R.id.economy)).isChecked()) &&
                (((CheckBox)findViewById(R.id.smallest)).isChecked())) {
            score += 1;
        }

        //checks if the user answered correct the second question
        if (((RadioButton)findViewById(R.id.france_paris)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the third question
        if (((RadioButton)findViewById(R.id.germany_berlin)).isChecked()) {
            score += 1;
        }

        //checks if the user answered correct the forth question
        if (((RadioButton)findViewById(R.id.england_london)).isChecked()){
            score += 1;
        }

        return score;
    }
}



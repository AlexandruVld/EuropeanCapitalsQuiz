package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = findViewById(R.id.continents_spinner);
        spin.setOnItemSelectedListener(this);
        String[] continents = getResources().getStringArray(R.array.continents_array);
        ArrayAdapter<String> continentChooser = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, continents);
        continentChooser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(continentChooser);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> spinner, View item, int position, long row_id) {
        //Defines which activity starts according to what the user is selecting
        EditText name = findViewById(R.id.name_input);

        Intent intent;
        switch (position) {
            case 1:
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(this, R.string.name_input, Toast.LENGTH_LONG).show();
                    spinner.setSelection(0);
                    break;
                }
                Toast.makeText(this, getString(R.string.heavy_stuff), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("layout", R.layout.activity_basic_quiz);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
                break;

            case 2:
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(this, R.string.name_input, Toast.LENGTH_LONG).show();
                    spinner.setSelection(0);
                    break;
                }
                Toast.makeText(this, getString(R.string.easy), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("layout", R.layout.activity_easy);
                intent.putExtra("name", name.getText().toString());
                startActivity(intent);
                break;

            default:
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}

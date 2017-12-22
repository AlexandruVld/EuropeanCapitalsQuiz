package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.continents_spinner);
        spin.setOnItemSelectedListener(this);
        String[] continents = getResources().getStringArray(R.array.continents_array);
        ArrayAdapter<String> continentChooser = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, continents);
        continentChooser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(continentChooser);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long row_id) {
    //Defines which activity starts acording to what the user is selecting
        final Intent intent;
        switch(position) {
            case 1:
                Toast.makeText(this, getString(R.string.heavy_stuff),Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, BasicQuizActivity.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this, getString(R.string.easy), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
                break;
            case 3:
                Toast.makeText(this, getString(R.string.easy), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this, getString(R.string.easy), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
                break;
            case 5:
                Toast.makeText(this, getString(R.string.easy), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
                break;
            case 6:
                Toast.makeText(this, getString(R.string.easy), Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}

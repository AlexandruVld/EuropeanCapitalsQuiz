package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EndingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        TextView name = (TextView) findViewById(R.id.receiveName);
        TextView textScore = (TextView) findViewById(R.id.ending);
        TextView percent = (TextView) findViewById(R.id.percent);
        ImageView image = (ImageView) findViewById(R.id.win);

        Bundle bundle = getIntent().getExtras();

        //gets the user name from the quiz activities
        //gets the picture to be displayed on the screen
        //gets the score and percentage
        if (bundle != null) {
            String data = bundle.getString("name");
            int finalScore = bundle.getInt("finalScore");
            String finalTxt = bundle.getString("finalTxt");
            int imgEnding = getIntent().getIntExtra("image", R.drawable.winner);
            name.setText(data);
            textScore.setText(finalTxt);
            percent.setText("Final score: " + finalScore + "/5 ( " + ((finalScore * 100) / 5) + "% )");
            image.setImageResource(imgEnding);
        }

    }

    //when restart button is clicked the app returns to the MainActivity
    public void reset(View view) {
        final Intent intent;
        intent = new Intent(EndingActivity.this, MainActivity.class);
        startActivity(intent);

    }
}

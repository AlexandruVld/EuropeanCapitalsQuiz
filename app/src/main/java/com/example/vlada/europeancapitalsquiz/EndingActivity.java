package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EndingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        TextView name = findViewById(R.id.receiveName);
        TextView textScore = findViewById(R.id.ending);
        ImageView image = findViewById(R.id.win);
        Bundle bundle = getIntent().getExtras();

        //gets the user name from the quiz activities
        //gets the picture to be displayed on the screen
        //gets the score and percentage
        if (bundle != null) {
            String data = bundle.getString("userNameInput");
            int finalScore = bundle.getInt("finalScore");
            int percentage = (finalScore * 100) / 5;
            String finalTxt = bundle.getString("finalTxt");
            int imgEnding = getIntent().getIntExtra("image", R.drawable.winner);
            name.setText(data);
            textScore.setText(finalTxt);
            image.setImageResource(imgEnding);
            String score = String.valueOf(getString(R.string.score) + finalScore + getString(R.string.from) +
                    percentage + getString(R.string.end_line));
            Toast.makeText(this, score, Toast.LENGTH_LONG).show();
        }

    }

    //when restart button is clicked the app returns to the MainActivity
    public void reset(View view) {
        final Intent intent;
        intent = new Intent(EndingActivity.this, MainActivity.class);
        startActivity(intent);

    }
}

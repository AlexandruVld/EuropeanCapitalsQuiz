package com.example.vlada.europeancapitalsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loose);
        TextView ending = (TextView)findViewById(R.id.receiveName);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            String data = bundle.getString("name");
            ending.setText(data);
        }

    }

    public void reset (View view){
        final Intent intent;
        intent = new Intent(LooseActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
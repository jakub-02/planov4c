package com.example.planov4c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button den, tyzden, mesiac, ciel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        den = findViewById(R.id.den);
        tyzden = findViewById(R.id.tyzden);
        mesiac = findViewById(R.id.mesiac);
        ciel = findViewById(R.id.ciel);

        den.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialyPlan();
            }
        });
    }

    private void dialyPlan() {
        Intent intent = new Intent(MainActivity.this, DailyPlanActivity.class);
        startActivity(intent);
    }

}
package com.example.planov4c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DailyPlanActivity extends AppCompatActivity {

    TextView datum, tyzden;
    Button pon, uto, str, stv, pia, sob, ned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_plan);

        datum = findViewById(R.id.datum);
        tyzden = findViewById(R.id.tyzden);

        pon = findViewById(R.id.pon);
        uto = findViewById(R.id.uto);
        str = findViewById(R.id.str);
        stv = findViewById(R.id.stv);
        pia = findViewById(R.id.pia);
        sob = findViewById(R.id.sob);
        ned = findViewById(R.id.ned);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.WEEK_OF_YEAR);

        datum.setText(formattedDate);
        tyzden.setText(week + ". týždeň");

        pon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Pondelok");
            }
        });

        uto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Utorok");
            }
        });

        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Streda");
            }
        });

        stv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Štvrtok");
            }
        });

        pia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Piatok");
            }
        });

        sob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Sobota");
            }
        });

        ned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDay("Nedeľa");
            }
        });
    }

    private void selectedDay(String vybratyDen) {
        Intent intent = new Intent(DailyPlanActivity.this, SelectedDayActitvity.class);
        intent.putExtra("vybratyDen", vybratyDen);
        startActivity(intent);

    }
}
package com.example.planov4c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SelectedDayActitvity extends AppCompatActivity {

    TextView datum, den;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_day_actitvity);

        datum = findViewById(R.id.datum);
        den = findViewById(R.id.den);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        datum.setText(formattedDate);
        den.setText(getIntent().getExtras().get("vybratyDen").toString());
    }
}
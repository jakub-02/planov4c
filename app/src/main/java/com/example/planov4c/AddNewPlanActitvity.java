package com.example.planov4c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddNewPlanActitvity extends AppCompatActivity {

    ImageButton close;
    TextView add;
    TextView nazov;
    RadioGroup radioGroupPriorita;
    RadioGroup radioGroupOznamenie;
    RadioGroup radioGroupKategorie;
    RadioButton radioButtonPriorita;
    RadioButton radioButtonOznamenie;
    RadioButton radioButtonKategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_plan);

        close = findViewById(R.id.closeButton);
        add = findViewById(R.id.addButton);
        nazov = findViewById(R.id.nazovPlanu);
        radioGroupPriorita = findViewById(R.id.radioGroupPriorita);
        radioGroupOznamenie = findViewById(R.id.radioGroupOznamenie);
        radioGroupKategorie = findViewById(R.id.radioGroupKategorie);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewPlanActitvity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkButtons(v);

                MyDatabaseHelper myDH = new MyDatabaseHelper(AddNewPlanActitvity.this);
                myDH.addPlan(
                        nazov.getText().toString().trim(),
                        radioButtonPriorita.getText().toString().trim(),
                        radioButtonOznamenie.getText().toString().trim(),
                        radioButtonKategorie.getText().toString().trim()
                );

                Intent intent = new Intent(AddNewPlanActitvity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkButtons(View v){
        int radioIdPriorita = radioGroupPriorita.getCheckedRadioButtonId();
        radioButtonPriorita = findViewById(radioIdPriorita);
        int radioIdOznamenie = radioGroupOznamenie.getCheckedRadioButtonId();
        radioButtonOznamenie = findViewById(radioIdOznamenie);
        int radioIdKategorie = radioGroupKategorie.getCheckedRadioButtonId();
        radioButtonKategorie = findViewById(radioIdKategorie);
    }
}
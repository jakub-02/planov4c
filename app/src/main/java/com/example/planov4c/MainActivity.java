package com.example.planov4c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CardView praca, rodina, skola, zabava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.myToolbar);

        praca = findViewById(R.id.praca);
        rodina = findViewById(R.id.rodina);
        skola = findViewById(R.id.skola);
        zabava = findViewById(R.id.zabava);

        setSupportActionBar(toolbar);

        praca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PracaActivity.class);
                startActivity(intent);
            }
        });

        rodina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RodinaActivity.class);
                startActivity(intent);
            }
        });

        skola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SkolaActivity.class);
                startActivity(intent);
            }
        });

        zabava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SkolaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.pridaj:
                openDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog(){
        DialogFragment dialog = Dialog.newInstance();
        ((Dialog) dialog).setCallback(new Dialog.Callback() {
            @Override
            public void onActionClick(String name) {
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show(getSupportFragmentManager(), "tag");
    }


}
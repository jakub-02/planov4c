package com.example.planov4c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CardView praca, rodina, skola, zabava;

    MyDatabaseHelper myDH;
    ArrayList<String> plan_id, plan_title, plan_priority, plan_time, plan_category;

    RecyclerView recyclerPlany;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPlany = findViewById(R.id.recyclerPlany);
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

        myDH = new MyDatabaseHelper(MainActivity.this);

        plan_id = new ArrayList<>();
        plan_title = new ArrayList<>();
        plan_priority = new ArrayList<>();
        plan_time = new ArrayList<>();
        plan_category = new ArrayList<>();

        storeData();

        customAdapter = new CustomAdapter(MainActivity.this, this, plan_id, plan_title, plan_priority,
                plan_time, plan_category);
        recyclerPlany.setAdapter(customAdapter);
        recyclerPlany.setLayoutManager(new LinearLayoutManager(MainActivity.this));

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
                openAddNewPlan();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openAddNewPlan(){
        Intent intent = new Intent(MainActivity.this, AddNewPlanActitvity.class);
        startActivity(intent);
    }

    public void storeData(){
        Cursor cursor = myDH.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Ziadne data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                plan_id.add(cursor.getString(0));
                plan_title.add(cursor.getString(1));
                plan_priority.add(cursor.getString(2));
                plan_time.add(cursor.getString(3));
                plan_category.add(cursor.getString(4));
            }
        }
    }

}
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
    CardView health, work, family, goal;
    CardView dailyPlan, weeklyPlan, monthlyPlan;

    /*
    MyDatabaseHelper myDH;
    ArrayList<String> plan_id, plan_title, plan_priority, plan_time, plan_category;

    RecyclerView recyclerPlany;
    CustomAdapter customAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*recyclerPlany = findViewById(R.id.recyclerPlany);*/
        toolbar = findViewById(R.id.myToolbar);

        health = findViewById(R.id.health);
        work = findViewById(R.id.work);
        family = findViewById(R.id.family);
        goal = findViewById(R.id.goal);
        dailyPlan = findViewById(R.id.dailyPlan);
        weeklyPlan = findViewById(R.id.weeklyPlan);
        monthlyPlan = findViewById(R.id.monthlyPlan);

        setSupportActionBar(toolbar);

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkActivity.class);
                startActivity(intent);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }
        });

        goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GoalActivity.class);
                startActivity(intent);
            }
        });

        dailyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DailyActivity.class);
                startActivity(intent);
            }
        });

        weeklyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeeklyActivity.class);
                startActivity(intent);
            }
        });

        monthlyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MonthlyActivity.class);
                startActivity(intent);
            }
        });

        /*
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
        recyclerPlany.setLayoutManager(new LinearLayoutManager(MainActivity.this));*/

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

    /*
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
    }*/

}
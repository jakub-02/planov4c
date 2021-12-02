package com.example.planov4c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MonthlyActivity extends AppCompatActivity {

    Toolbar toolbar;

    MyDatabaseHelper myDH;
    ArrayList<String> plan_id, plan_title, plan_priority, plan_time, plan_category;

    RecyclerView recycler;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        recycler = findViewById(R.id.recycler);
        toolbar = findViewById(R.id.myToolbar);

        setSupportActionBar(toolbar);

        myDH = new MyDatabaseHelper(MonthlyActivity.this);

        plan_id = new ArrayList<>();
        plan_title = new ArrayList<>();
        plan_priority = new ArrayList<>();
        plan_time = new ArrayList<>();
        plan_category = new ArrayList<>();

        storeData();

        customAdapter = new CustomAdapter(MonthlyActivity.this, this, plan_id, plan_title, plan_priority,
                plan_time, plan_category);
        recycler.setAdapter(customAdapter);
        recycler.setLayoutManager(new LinearLayoutManager(MonthlyActivity.this));
    }

    public void storeData(){
        Cursor cursor = myDH.selectMonthly();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
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
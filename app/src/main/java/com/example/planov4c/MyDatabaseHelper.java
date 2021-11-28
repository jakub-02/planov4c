package com.example.planov4c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Planner.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_planner";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "plan_title";
    private static final String COLUMN_PRIORITY = "plan_priority";
    private static final String COLUMN_TIME = "plan_time";
    private static final String COLUMN_CATEGORY = "plan_category";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_PRIORITY + " TEXT, " +
                        COLUMN_TIME + " TEXT, " +
                        COLUMN_CATEGORY + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addPlan(String title, String priority, String time, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_PRIORITY, priority);
        cv.put(COLUMN_TIME, time);
        cv.put(COLUMN_CATEGORY, category);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Plan creation failed.", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Plan was created!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}

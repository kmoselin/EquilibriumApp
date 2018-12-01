package com.example.trina.equilibriumapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper{

    Context ctx;
    SQLiteDatabase db;
    private static String DB_NAME = "Events";
    private static String TABLE_EVENT = "event_table";
    private static String TABLE_GOAL = "goal_table";
    private  static int VERSION = 1;

    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, VERSION);
        ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_EVENT + "(id integer primary key, " +
                "event_date String, start_time String, end_time String, event String, priority String);");

        db.execSQL("create table " + TABLE_GOAL + "(id integer primary key, " +
                "goal String, priority String, type String, completion String);");
        Toast.makeText(ctx, "DB is created", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_EVENT);
        db.execSQL("drop table if exists " + TABLE_GOAL);
        VERSION++;
        onCreate(db);
    }

    public long insertEvent(String s1, String s2, String s3, String s4, String s5){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("event_date", s1);
        cv.put("start_time", s2);
        cv.put("end_time", s3);
        cv.put("event", s4);
        cv.put("priority", s5);
        return db.insert(TABLE_EVENT, null, cv);
    }

    public long insertGoal(String s1, String s2, String s3, String s4){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("goal", s1);
        cv.put("priority", s2);
        cv.put("type", s3);
        cv.put("completion", s4);
        return db.insert(TABLE_GOAL, null, cv);
    }

    public Cursor getIncompleteCount(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select completion from " + TABLE_GOAL + " where " + " completion " + " like '%Not complete%' " + ";", null);
        return cr;
    }

    public Cursor getCompleteCount(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select completion from " + TABLE_GOAL + " where " + " completion " + " like '%finished%' " + ";", null);
        return cr;
    }

    public void getAll(){
        db = getReadableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_EVENT + ";", null );
        StringBuilder sr = new StringBuilder();
        while(cr.moveToNext()){
            sr.append(cr.getString(1) + "    " + cr.getString(2) + "\n ");
        }
        Toast.makeText(ctx, sr.toString(), Toast.LENGTH_LONG).show();
    }


    public Cursor getAllEvents(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_EVENT + ";", null );
        return cr;
    }

    public Cursor getAllGoals(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select * from " + TABLE_GOAL + ";", null );
        return cr;
    }

    public void delete(String s){
        db = getWritableDatabase();
        db.delete(TABLE_EVENT, "first_name = ?", new String[]{s});
    }

    public void update(String s1, String s2){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("first_name", s1);
        cv.put("last_name", s2);
        db.update(TABLE_EVENT, cv,  "first_name = ?", new String[]{s1});
    }

    public Cursor getGoal(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select goal from " + TABLE_GOAL + ";", null );
        return cr;

    }
    public Cursor getGoalData(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select priority, type, completion from " + TABLE_GOAL + ";", null);
        return cr;
    }

    public Cursor getDate(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select event_date from " + TABLE_EVENT + ";", null);
        return cr;
    }
    public Cursor getEventData(){
        db = getWritableDatabase();
        Cursor cr = db.rawQuery("select start_time, end_time, event, priority from " + TABLE_EVENT + ";", null);
        return cr;
    }
}


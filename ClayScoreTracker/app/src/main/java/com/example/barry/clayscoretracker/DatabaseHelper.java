/**
 * Created by Barry on 26/11/2015.
 */
package com.example.barry.clayscoretracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ScoreTrackerDB.db";
    public static final String TABLE_NAME = "UserScore";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "STAND1";
    public static final String COL_3 = "STAND2";
    public static final String COL_4 = "STAND3";
    public static final String COL_5 = "STAND4";
    public static final String COL_6 = "STAND5";
    public static final String COL_7 = "DATE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,STAND1 INTEGER,STAND2 INTEGER,STAND3 INTEGER,STAND4 INTEGER,STAND5 INTEGER,SHOOTINGDATE datetime current_DATE)");
        //this creates tabel with a auto increment id , and also ,when the insert is done, it auto puts in time.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long insertData(int stand1var, int stand2var, int stand3var, int stand4var, int stand5var) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,stand1var);
        contentValues.put(COL_3,stand2var);
        contentValues.put(COL_4, stand3var);
        contentValues.put(COL_5,stand4var);
        contentValues.put(COL_6,stand5var);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return -1;
        else
            return result;
    }
    public long  newCourseDBInstert(){
        //this is simpleused to create a new course.

        long id =insertData(0, 0, 0, 0, 0);
        SQLiteDatabase db = this.getWritableDatabase();
        Log.i("dbmanager", id+ "");
        return id;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id});
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,int  stand1var, String COL){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL,stand1var);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;

    }

}

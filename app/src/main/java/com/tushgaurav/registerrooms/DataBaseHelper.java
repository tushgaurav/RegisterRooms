package com.tushgaurav.registerrooms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "STUDENTS_REGISTERED";

    public DataBaseHelper(@Nullable Context context) {
            super(context, "students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PHONE TEXT)";
        
        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    
    public boolean addStudent(Student student) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("NAME", student.getName());
        cv.put("EMAIL", student.getEmail());
        cv.put("PHONE", student.getPhone());

        long insert = db.insert(TABLE_NAME, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}

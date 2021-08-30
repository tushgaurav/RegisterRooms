package com.tushgaurav.registerrooms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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


    public List<Student> getRegisteredStudents() {
        List<Student> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String phone = cursor.getString(3);

                Student newStudent = new Student(name, email, phone, 1, 'A');
                returnList.add(newStudent);

            } while (cursor.moveToNext());
        } else {

        }
        cursor.close();
        db.close();
        return returnList;
    }

}

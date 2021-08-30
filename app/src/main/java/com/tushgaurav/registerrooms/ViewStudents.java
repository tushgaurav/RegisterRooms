package com.tushgaurav.registerrooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewStudents extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        recyclerView = findViewById(R.id.recyclerStudents);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, dataBaseHelper);

   }
}
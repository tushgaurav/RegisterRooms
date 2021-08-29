package com.tushgaurav.registerrooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText editName, editPhone, editEmail;
    private TextView txtWarnName, txtWarnEmail, txtWarnMobile, txtWarnAgreement, txtAgreement, txtRoomsLeft;
    private Button btnSubmit, btnRegisteredStudents;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();



        // click listeners
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               initRegister();
            }
        });

        btnRegisteredStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityViewAll();
            }
        });
    }

    private void initViews() {
        parent = findViewById(R.id.parent);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnMobile = findViewById(R.id.txtWarnMobile);
        txtWarnAgreement = findViewById(R.id.txtWarnAgreement);

        txtRoomsLeft = findViewById(R.id.txtRoomLeft);

        txtAgreement = findViewById(R.id.txtAgreement);
        agreementCheck = findViewById(R.id.chAccept);

//        btnReset = null;
        btnSubmit = findViewById(R.id.btnSubmit);
        btnRegisteredStudents = findViewById(R.id.btnViewRegisteredStudents);



    }

    private void initRegister() {
        if (validateData()) {
            if (agreementCheck.isChecked()) {
                boolean final_result = submitData();
                if (final_result) {
                    showSnackBar("Student Registered", "View");
                }
                else {
                    Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "You need to agree to the conditions", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar(String message, String actionName) {
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnMobile.setVisibility(View.GONE);
        txtWarnAgreement.setVisibility(View.GONE);

        Snackbar.make(parent, message, Snackbar.LENGTH_INDEFINITE)
                .setAction(actionName, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, student.toString() + " has been registered", Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    private void changeActivityViewAll() {
        Intent intent = new Intent(MainActivity.this, ViewStudents.class);
        startActivity(intent);
    }

    private boolean validateData() {


        if (editName.getText().toString().equals("")) {
            txtWarnName.setVisibility(View.VISIBLE);
            return false;
        } else {
            txtWarnName.setVisibility(View.INVISIBLE);
        }

        if (editEmail.getText().toString().equals("")) {
            txtWarnEmail.setVisibility(View.VISIBLE);
            return false;
        } else {
            txtWarnEmail.setVisibility(View.INVISIBLE);
        }

        if (editPhone.getText().toString().equals("")) {
            txtWarnMobile.setVisibility(View.VISIBLE);
            return false;
        } else {
            txtWarnMobile.setVisibility(View.INVISIBLE);
        }
        
        student = new Student(editName.getText().toString(),
                    editEmail.getText().toString(),
                    editPhone.getText().toString(),
                    1,
                    'A');

        return true;
    }

    private void roomsLeftUpdater() {
        txtRoomsLeft.setText(student.roomsLeft());
    }

    private boolean submitData() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
        boolean success = dataBaseHelper.addStudent(student);
        roomsLeftUpdater();
        
        return success;
    }
}
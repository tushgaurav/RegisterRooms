package com.tushgaurav.registerrooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText editName, editPhone, editEmail;
    private TextView txtWarnName, txtWarnEmail, txtWarnMobile, txtWarnAgreement, txtAgreement;
    private Button btnSubmit, btnReset;
    private ConstraintLayout parent;

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

        txtAgreement = findViewById(R.id.txtAgreement);

        btnReset = null;
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void initRegister() {
        Student student = null;

        if (editName.getText().toString() == "") {
            txtWarnName.setVisibility(View.VISIBLE);
        }
        if (editEmail.getText().toString() == "") {
            txtWarnEmail.setVisibility(View.VISIBLE);
        }
        if (editPhone.getText().toString() == "") {
            txtWarnMobile.setVisibility(View.VISIBLE);
        }


        try {
            student = new Student(editName.getText().toString(),
                    editEmail.getText().toString(),
                    editPhone.getText().toString(),
                    1,
                    'A');

            txtWarnName.setVisibility(View.INVISIBLE);
            txtWarnEmail.setVisibility(View.INVISIBLE);
            txtWarnMobile.setVisibility(View.INVISIBLE);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please check your input", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(MainActivity.this, "Data Not Submitted" + student.toString(), Toast.LENGTH_SHORT).show();

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

                    }
                }).show();
    }

    private boolean validateData() {
        //TODO implement a data checking algo
        return true;
    }

    private boolean submitData() {
        //TODO implement a data submission algo
        return true;
    }
}
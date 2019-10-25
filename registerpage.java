package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class registerpage extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    RadioButton rb1,rb2;
    Button b1;
    Spinner spinner;
    String [] BloodType_array={"BloodType","A+","A-","B+","B-","AB+","AB-","O+","O-"};
    String name,address,contactnumber,username,password;
    DBHelper dbh = new DBHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        e4 = (EditText)findViewById(R.id.e4);
        e5 = (EditText)findViewById(R.id.e5);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        spinner =(Spinner)findViewById(R.id.spinner);
        b1 = (Button)findViewById(R.id.b1);

        ArrayAdapter adapter= new ArrayAdapter(registerpage.this,android.R.layout.simple_spinner_item,BloodType_array);
        spinner.setAdapter(adapter);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinner.getClass().toString().trim().isEmpty()||rb1.getText().toString().trim().isEmpty()||rb2.getText().toString().trim().isEmpty() ||e1.getText().toString().trim().isEmpty() ||e2.getText().toString().trim().isEmpty() || e3.getText().toString().trim().isEmpty()||e4.getText().toString().trim().isEmpty()||e5.getText().toString().trim().isEmpty()){
                    Toast.makeText(registerpage.this,"Please enter the fields",Toast.LENGTH_SHORT).show();
                }

                else  {
                    boolean res = dbh.RegisterData(e1.getText().toString().trim(),rb1.getResources().toString(),rb2.getResources().toString(),e2.getText().toString().trim(),e3.getText().toString(),spinner.getClass().toString(),e4.getText().toString(),e5.getText().toString());
                    if (res == true)
                    {
                        Toast.makeText(registerpage.this, "Registered Succesfully", Toast.LENGTH_LONG).show();
                        Intent in = new Intent(registerpage.this,loginpage.class);
                        startActivity(in);
                    }
                }


            }
        });
    }
}


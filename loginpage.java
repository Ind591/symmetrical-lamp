package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    DBHelper dbh = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().trim().isEmpty() ||e2.getText().toString().isEmpty()){
                    Toast.makeText(loginpage.this,"Please enter the fields",Toast.LENGTH_SHORT).show();
                }
                else{

                    SQLiteDatabase db = dbh.getReadableDatabase();
                    Cursor cursor = db.rawQuery("SELECT ID FROM Register WHERE USERNAME=? AND PASSWORD=?", new String[]{e1.getText().toString(), e1.getText().toString()});
                    if(cursor.getCount() > 0) {
                        //cursor.moveToFirst();
                        //id = cursor.getInt(0);
                        cursor.close();

                        // in.putExtra("name", u);
                        Toast.makeText(loginpage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(loginpage.this,Myprofile.class);
                        startActivity(in);

                    }else{
                        Toast.makeText(loginpage.this, "No user exist", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(loginpage.this,registerpage.class);
                startActivity(next);
            }
        });



    }
}

package com.example.bloodbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Myprofile extends AppCompatActivity {
    Button b1;
    DBHelper dbh = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = dbh.getAllData();
                if(res.getCount() == 0)
                {
                    //show message
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("NAME:" + res.getString(0) + "\n");
                    buffer.append("MALE:" + res.getString(1) + "\n");
                    buffer.append("FEMALE:" + res.getString(2) + "\n");
                    buffer.append("ADDRESS:" + res.getString(3) + "\n");
                    buffer.append("CONTACT NUMBER:" + res.getString(4) + "\n");
                    buffer.append("BLOODTYPE:" + res.getString(5) + "\n");




                }
                showMessage("Data",buffer.toString());
            }

        });
    }
    public void showMessage(String title,String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}

package com.example.admin.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;


public class TakeAttendance extends AppCompatActivity {

    Button next;
    EditText scode,pwd;


    DatabaseHelper db = new DatabaseHelper(this);

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        next = (Button) findViewById(R.id.button6);
        scode = (EditText) findViewById(R.id.editText3);
        pwd = (EditText)findViewById(R.id.editText4);




            next.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pass=pwd.getText().toString();
                    String sub_code=scode.getText().toString();

                    if (scode.equals("") || pwd.equals("")) {
                        if (scode.equals("")) {
                            Toast.makeText(getApplicationContext(), "Pls Fill in the Username!", Toast.LENGTH_LONG).show();
                        } else if (pwd.equals("")) {
                            Toast.makeText(getApplicationContext(), "Pls Fill in the Password!", Toast.LENGTH_LONG).show();
                        }
                    }
                    final String password=db.searchpass(sub_code);

                    if(pass.equals(password)) {
                        Toast.makeText(getApplication() , "Sign In Successful" ,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TakeAttendance.this, FacultyOptions.class);
                        startActivity(intent);
                    }
                    else {
                    Toast.makeText(getApplicationContext() ,"Incorrect subject code or password",Toast.LENGTH_SHORT).show();
                    }
                }

            });

        }


}

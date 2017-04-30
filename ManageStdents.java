package com.example.admin.myapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ManageStdents extends ListActivity {
    public EditText sname;
    public EditText susn;
    public EditText sphone;
    public EditText scode;
    public String ssusn;
    public String ssphone;
    public String sscode;
    public String ssname;
    DatabaseHelper db;
    Cursor c;
    Button add,back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_stdents);
        sname = (EditText) findViewById(R.id.Sname1);
        susn = (EditText) findViewById(R.id.USN1);
        sphone = (EditText) findViewById(R.id.Phone1);
        scode = (EditText) findViewById(R.id.Code1);
        Button add=(Button)findViewById(R.id.bu1);
        Button back=(Button)findViewById(R.id.home);
        sscode = scode.getText().toString();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Isinserted=db.addstudents(ssname,ssusn,ssphone,sscode);
                if(Isinserted)
                    Toast.makeText(ManageStdents.this,"VALUES INSERTED",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ManageStdents.this,"VALUES NOT INSERTED",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyOptions extends AppCompatActivity {

    Button managestd,markatt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_options);

        managestd=(Button)findViewById(R.id.button7);
        markatt=(Button)findViewById(R.id.button8);

        managestd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FacultyOptions.this,ManageStdents.class);
                startActivity(intent);
            }
        });

    }
}

package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button student,teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacher=(Button) findViewById(R.id.button1);
        student=(Button) findViewById(R.id.button2);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TeacherLogin.class);
                startActivity(intent);
            }
        });
        student.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,ManageStdents.class);
                startActivity(intent);
            }
        });


    }
}

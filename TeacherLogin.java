package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherLogin extends AppCompatActivity {

    Button signin,takeatt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        signin=(Button)findViewById(R.id.button3);
        takeatt=(Button)findViewById(R.id.button4);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherLogin.this,SignIn.class);
                startActivity(intent);
            }
        });
        takeatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherLogin.this,TakeAttendance.class);
                startActivity(intent);
            }
        });



    }
}

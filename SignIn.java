package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    Button sin;
    EditText subcode,pass,cpass;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sin= (Button)findViewById(R.id.button6);
        subcode=(EditText)findViewById(R.id.editText1);
        pass=(EditText)findViewById(R.id.editText2);
        cpass=(EditText)findViewById(R.id.editText);
        db=new DatabaseHelper(this);
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String pwd=pass.getText().toString().trim();
                String cpwd=cpass.getText().toString().trim();

                if(pwd.equals(cpwd))
                {
                    boolean isInserted = db.addregister(subcode.getText().toString(),
                            pass.getText().toString());
                    if(isInserted) {
                        Toast.makeText(SignIn.this, "Sign in Successful, You can take attendance for your class", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        Toast.makeText(SignIn.this, "Sign in unSuccessful", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(SignIn.this, TeacherLogin.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(SignIn.this, "Passwords didn,t match", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

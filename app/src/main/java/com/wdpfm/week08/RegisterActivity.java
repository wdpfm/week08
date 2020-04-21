package com.wdpfm.week08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("注册");
        final EditText myEmail=(EditText)findViewById(R.id.email);
        final EditText myUsername=(EditText)findViewById(R.id.username);
        final EditText myPassword=(EditText)findViewById(R.id.password);
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("email",myEmail.getText().toString());
                intent.putExtra("username",myUsername.getText().toString());
                intent.putExtra("password",myPassword.getText().toString());
                setResult(1,intent);
                finish();
            }
        });
    }
}

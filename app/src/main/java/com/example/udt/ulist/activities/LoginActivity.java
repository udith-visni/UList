package com.example.udt.ulist.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.udt.ulist.R;

public class LoginActivity extends AppCompatActivity {

    Button btnTry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnTry=(Button)findViewById(R.id.btn_try);

        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
    }


}

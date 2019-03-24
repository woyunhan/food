package com.example.administrator.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GetMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_message);
    }
    public void M2 (View view){
        Intent i = new Intent(GetMessage.this , Female.class);
        startActivity(i);
    }
    public void M1(View view){
        Intent i = new Intent(GetMessage.this , Male.class);
        startActivity(i);
    }
}

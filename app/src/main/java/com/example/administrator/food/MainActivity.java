package com.example.administrator.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void M2 (View view){
        Intent i = new Intent(MainActivity.this , FoodBank.class);
        startActivity(i);
    }
    public void M1(View view){
        Intent i = new Intent(MainActivity.this , GetMessage.class);
        startActivity(i);
    }
}

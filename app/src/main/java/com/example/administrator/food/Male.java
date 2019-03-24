package com.example.administrator.food;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/***
 * 男性静息代谢获取
 */

public class Male extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4;
    Button btn;
    double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        btn = (Button)findViewById(R.id.btn);


    }
    public void B(View view){
        a=Integer.parseInt(editText1.getText().toString());
        b=Integer.parseInt(editText2.getText().toString());
        c=Integer.parseInt(editText3.getText().toString());
        double f;
        f=9.9*c+6.25*b-4.92*a+5;
        editText4.setText(String.valueOf(f));

    }
}

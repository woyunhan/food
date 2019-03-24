package com.example.administrator.food;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liguowang on 2018/6/2.
 */

public class FoodInfo extends ListActivity {
    Button image=null;
    Button back=null;
    TextView foodinfo=null;
   /* String[] efood={"116.0Kcal/100g","106.0Kcal/100g","46.0Kcal/100g",};
    String[] efoodinfo={
            "热量(大卡)116.00碳水化合物(克)25.60" +"\n"+ "脂肪(克)0.30蛋白质(克)2.60"+"\n" + "纤维素(克)0.30维生素A(微克)一",
            "热量（千卡）118.00\n" + "碳水化合物（克）22.80\n" + "脂肪（克）1.20\n" + "蛋白质（克）4.00\n" + "膳食纤维（克）2.90",
            "热量（千卡）45.50\n" + "碳水化合物（克）8.40\n" + "脂肪（克）0.70\n" + "蛋白质（克）1.40\n" + "膳食纤维（克）0.00",};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodinfo);

        Bundle bundle=getIntent().getExtras();
        int drawable=bundle.getInt("drawable");
        String foodname=bundle.getString("foodname");
        String efoodname=bundle.getString("efoodnema");
        String foodinfos=bundle.getString("foodinfo");
        String efoodinfo=bundle.getString("efoodinfo");

        image=(Button)findViewById(R.id.Button);
        image.setBackgroundResource(drawable);
        image.setText(foodname);
        foodinfo=(TextView)findViewById(R.id.TextView03);
        foodinfo.setText(foodinfos);
        back=(Button)findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Button b=(Button)v;
                b.setBackgroundResource(R.drawable.btn_back_active);
                Intent intent=new Intent(FoodInfo.this, OneFragment.class);
                startActivity(intent);
            }
        });
        List<Map<String, String>> data=new ArrayList<Map<String,String>>();
        Map<String, String> map=new HashMap<String,String>();
        map.put("TextView04", efoodname);
        map.put("TextView05", efoodinfo);
        data.add(map);
        SimpleAdapter adapter=new SimpleAdapter(this, data, R.layout.ex_foodinfo,new String[]{"TextView04","TextView05"} , new int[]{R.id.TextView04,R.id.TextView05});
        setListAdapter(adapter);
    }
}

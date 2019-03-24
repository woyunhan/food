package com.example.administrator.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OneFragment extends Fragment  implements AdapterView.OnItemClickListener {

    ListView list;
    private String[] mName = { "米饭", "玉米", "小米粥", "全麦面包","大麦","低筋面粉","燕麦","黑米粥","粉皮",
    "煮面条","年糕","花卷","馒头","卷饼","糯米","汤包","豆沙包",
    "蛋糕","油条","饼干","方便面","山药"};
    private String[] mNum = { "116.0Kcal/100g","106.0Kcal/100g","46.0Kcal/100g","235.0Kcal/100g","320.0Kcal/100g","367.0Kcal/100g","46.0Kcal/100g","64.0Kcal/100g",
    "109.0Kcal/100g","154.0Kcal/100g","217.0Kcal/100g","233.0Kcal/100g","275.0Kcal/100g","343.0Kcal/100g","238.0Kcal/100g","240.0Kcal/100g",
    "347.0Kcal/100g","386.0Kcal/100g","433.0Kcal/100g","472.0Kcal/100g","57.0Kcal/100g","76.0Kcal/100g"};
    private static final int[] resId = {R.drawable.rice,R.drawable.corn,R.drawable.millet_congee,R.drawable.graham_bread,R.drawable.damai,R.drawable.dijingmianfen,R.drawable.yanmai,R.drawable.heimizhou,
    R.drawable.fenpi,R.drawable.zhumiantiao,R.drawable.niangao,R.drawable.huajuan,R.drawable.mantou,R.drawable.juanbing,R.drawable.nuomi,R.drawable.tangbao,
    R.drawable.doushabao,R.drawable.dangao,R.drawable.youtiao,R.drawable.binggan,R.drawable.fangbianmian,R.drawable.shanyao};
    private static final String [] foodjianjie={
            "米是五谷之首，米饭更是人们日常饮食中的主角之一；一味米饭，与五味调配，几乎可以供给全身所需营养。",
            "一种热量较低纤维含量较高的粗粮，适量进食可缓解便秘，营养学会建议每天最好吃50g以上粗粮，减肥期间推荐食用。",
            "小米粥含水量极高，热量极低，但不含膳食纤维，推荐减肥期间作为粗粮搭配主食食用。",
            "仅去掉麸皮，保留小麦大部分营养的面包，属于热量较低的面包，减肥期间可适量食用。",
            "大麦中膳食纤维含量较为丰富，营养含量与其他谷物类似，推荐减肥期间食用。",
            "一种高碳水化合物的食品，减肥时不宜多食",
            "高纤维、高蛋白、高碳水化合物，虽然热量也较高，但只需少量干燕麦片即可冲泡一大份燕麦粥，减肥期间推荐食用。",
            "此类菜肴通常较为清淡热量较低，减肥期间只需除去明显的脂肪、油脂即可食用。",
            "碳水化合物含量较高的一种小吃，水分率极高，其它营养较低，热量约是米饭的一半，减肥时可偶尔食用。",
            "生面条煮熟后，水分含量增多，单位热量会低50%－66%，较易消化及吸收，适宜减肥期间食用。",
            "原料是糯米的一种谷物食品，碳水化合物含量超过米饭，GI值超过80，减肥期间不宜大量食用。",
            "热量及营养均与馒头类似，水分含量较高，较易消化及吸收，适宜减肥期间食用。",
            "碳水化合物及水分含量较高的北方最常见的一种主食，可占全天热量的55%左右，适宜减肥期间食用。",
            "食材煎后会吸收部分油脂导致热量提升，同时也易产生致癌物质，不利于健康，减肥期间应尽量少食煎制菜肴。",
            "碳水化合物含量较高的一种谷物，高热量，高GI，煮熟后粘性较强，适宜减肥期间食用。",
            "清蒸类菜肴往往清淡少油，食材营养流失也较少，是非常适宜减肥期间食用的菜肴类别。",
            "清蒸类菜肴往往清淡少油，食材营养流失也较少，是非常适宜减肥期间食用的菜肴类别。",
            "蛋糕脂肪含量高，能量大，减肥期间尽量少吃。",
            "油条热量和脂肪含量极高，且油炸食品含大量致癌物质，减肥期间千万别碰，平时也少吃为宜。",
            "脂肪和碳水化合物含量很高，热量很高，减肥期间不适宜多食用。",
            "油炸类方便面脂肪含量普遍在20%以上，导致热量极高，而且在加工过程中营养流失严重，减肥期间不宜食用。",
            "山药热量较低，减肥期间推荐作为粗粮代替主食食用。"};
    private static final String [] efoodinfo={
          "碳水化合物（克）25.90\n" + "脂肪（克）0.30\n" + "蛋白质（克）2.60\n" + "膳食纤维（克）0.30",
            "碳水化合物（克）22.80\n" + "脂肪（克）1.20\n" + "蛋白质（克）4.00\n" + "膳食纤维（克）2.90",
            "碳水化合物（克）8.40\n" + "脂肪（克）0.70\n" + "蛋白质（克）1.40\n" + "膳食纤维（克）0.00",
           "碳水化合物（克）46.60\n" + "脂肪（克）1.65\n" + "蛋白质（克）9.07\n" + "膳食纤维（克）8.00",
            "碳水化合物（克）73.30\n" + "脂肪（克）1.40\n" + "蛋白质（克）10.20\n" + "膳食纤维（克）9.9",
           "碳水化合物（克）71.70\n" + "脂肪（克）1.20\n" + "蛋白质（克）10.20\n" + "膳食纤维（克）3.90",
             "碳水化合物（克）66.90\n" + "脂肪（克）6.70\n" + "蛋白质（克）15.00\n" + "膳食纤维（克）5.30",
            "碳水化合物（克）14.73\n" + "脂肪（克）0.44\n" + "蛋白质（克）1.73\n" + "膳食纤维（克）0.72",
            "碳水化合物（克）15.00\n" + "脂肪（克）0.30\n" + "蛋白质（克）0.20\n" + "膳食纤维（克）0.60",
            "碳水化合物（克）24.30\n" + "脂肪（克）0.20\n" + "蛋白质（克）2.70\n" + "膳食纤维（克）0.10",
            "碳水化合物（克）34.70\n" + "脂肪（克）0.60\n" + "蛋白质（克）3.30\n" + "膳食纤维（克）0.80",
             "碳水化合物（克）45.60\n" + "脂肪（克）1.00\n" + "蛋白质（克）6.40\n" + "膳食纤维（克）1.50",
            "碳水化合物（克）47.00\n" + "脂肪（克）1.10\n" + "蛋白质（克）7.00\n" + "膳食纤维（克）1.30",
            "碳水化合物（克）25.60\n" + "脂肪（克）3.88\n" + "蛋白质（克）5.24\n" + "膳食纤维（克）1.42",
            "碳水化合物（克）78.30\n" + "脂肪（克）1.00\n" + "蛋白质（克）7.30\n" + "膳食纤维（克）0.80",
             "碳水化合物（克）28.93\n" + "脂肪（克）14.55\n" + "蛋白质（克）8.52\n" + "膳食纤维（克）0.81",
             "碳水化合物（克）48.48\n" + "脂肪（克）0.84\n" + "蛋白质（克）5.91\n" + "膳食纤维（克）0.71",
           "碳水化合物（克）67.10\n" + "脂肪（克）5.10\n" + "蛋白质（克）8.60\n" + "膳食纤维（克）0.40",
            "碳水化合物（克）51.00\n" + "脂肪（克）17.60\n" + "蛋白质（克）6.90\n" + "膳食纤维（克）0.90",
            "碳水化合物（克）71.70\n" + "脂肪（克）12.70\n" + "蛋白质（克）9.00\n" + "膳食纤维（克）1.10",
             "碳水化合物（克）61.60\n" + "脂肪（克）21.10\n" + "蛋白质（克）9.50\n" + "膳食纤维（克）0.70",
            "碳水化合物（克）12.40\n" + "脂肪（克）0.20\n" + "蛋白质（克）1.90\n" + "膳食纤维（克）0.80"};
    private static final String []efood={"116.0Kcal/100g","106.0Kcal/100g","46.0Kcal/100g","235.0Kcal/100g","320.0Kcal/100g","367.0Kcal/100g","46.0Kcal/100g","64.0Kcal/100g",
            "109.0Kcal/100g","154.0Kcal/100g","217.0Kcal/100g","233.0Kcal/100g","275.0Kcal/100g","343.0Kcal/100g","238.0Kcal/100g","240.0Kcal/100g",
            "347.0Kcal/100g","386.0Kcal/100g","433.0Kcal/100g","472.0Kcal/100g","57.0Kcal/100g","76.0Kcal/100g"};
    private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    public OneFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_oneth, null);
            list = (ListView)view.findViewById(R.id.lv);

            for(int i = 0; i < mNum.length; i ++){
                Map<String,Object> item = new HashMap<String,Object>();
                item.put("name", mName[i]);
                item.put("num", mNum[i]);
                mData.add(item);
            }
            SimpleAdapter adapter = new SimpleAdapter(getActivity(),mData,android.R.layout.simple_expandable_list_item_2, new String[]{"name","num"},new int[]{android.R.id.text1,android.R.id.text2});
            list.setAdapter(adapter);
            list.setOnItemClickListener(this);
            return view;
        }
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        List<Map<String, Object>> data=new ArrayList<Map<String,Object>>();
        for(int j=0;j<efood.length;j++){
            Map<String, Object> map=new HashMap<String, Object>();
            map.put(efood[j], efoodinfo[j]);
            data.add(map);
        }

        Intent intent=new Intent();
        intent.setClass(getContext(), FoodInfo.class);
        intent.putExtra("drawable", resId[position]);
        intent.putExtra("foodname",mName[position]);
        intent.putExtra("efoodnema", mNum[position]);
        intent.putExtra("foodinfo", foodjianjie[position]);
        intent.putExtra("efoodinfo", efoodinfo[position]);
        //intent.putExtra("data", data);
//		intent.putCharSequenceArrayListExtra(name, value)("efood", data);

        startActivity(intent);
    }
    }

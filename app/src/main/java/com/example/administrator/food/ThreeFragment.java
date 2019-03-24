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

public class ThreeFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView list;
    private String[] mName ={"栗子","瓜子","干莲子","松子仁","腰果","花生仁","白果","杏仁","核桃","糖水莲子","橄榄油"};
    private String[] mNum ={"170.0Kcal/100g","185.0Kcal/100g","344.0Kcal/100g","698.0Kcal/100g","594.0Kcal/100g","563.0Kcal/100g","355.0Kcal/100g","570.0Kcal/100g","627.0Kcal/100g"
            ,"201.0Kcal/100g","899.0Kcal/100g"};
    private static final int[] resId = {R.drawable.lizi,R.drawable.guazi,R.drawable.lianzi,R.drawable.songzireng,R.drawable.yaoguo,R.drawable.huashenren,R.drawable.baiguo,R.drawable.xingren,
            R.drawable.hetao,R.drawable.tangshuilianzi,R.drawable.ganlanyou};
    private static final String [] foodjianjie = {
            "能量较高，碳水化合物含量极丰富，还含有丰富的不饱和脂肪酸、多种维生素和矿物质，减肥期间可少量食用。",
            "葵花子仁脂肪含量高达53%，虽有营养，减肥时可少量食用。",
            "蛋白质、碳水化合物和钾含量较高，热量很高，通常会加水食用，加水后水分率升高，热量下降，减肥时可适量食用。",
            "富含不饱和脂肪酸，如亚油酸、亚麻油酸等，还含大量矿物质如钙、铁、磷，能量较高，但热量较高，减肥期间不宜过多食用。",
            "富含脂肪、蛋白质、碳水化合物，还含有锰、铬、镁、硒等微量元素，但能量很高，减肥期间尽量少食用。",
            "高蛋白、高纤维、高碳水化合物、高不饱和脂肪酸、高热量、高饱腹感，减肥时可少量食用。",
            "白果含有多种药用成分，但同时淀粉含量较高，且可能具有一定毒性，减肥期间不宜多吃。",
            "蛋白质、不饱和脂肪酸以及各种矿物质含量丰富，但热量很高，减肥时可少量食用。",
            "高纤维、高脂肪、高热量，另外碳水化合物和蛋白质含量也较高，减肥时可少量食用。",
            "蛋白质、碳水化合物和钾含量较高，制作成罐头后，糖分上升，热量上升，不推荐减肥时期食用。",
            "烹调菜肴常用的油脂，脂肪含量达到99.9%，其中80%以上为不饱和脂肪酸，属于比较健康的油脂，但热量较高，减肥期间要适量。"};
    private static final String [] efoodinfo= {
            "碳水化合物（克）46.00\n" + "脂肪（克）1.50\n" + "蛋白质（克）4.80\n" + "膳食纤维（克）1.20",
            "碳水化合物（克）35.00\n" + "脂肪（克）7.00\n" + "蛋白质（克）7.50\n" + "膳食纤维（克）6.00",
            "碳水化合物（克）67.20\n" + "脂肪（克）2.00\n" + "蛋白质（克）17.20\n" + "膳食纤维（克）3.00",
            "碳水化合物（克）12.20\n" + "脂肪（克）70.60\n" + "蛋白质（克）13.40\n" + "膳食纤维（克）10.00",
            "碳水化合物（克）41.60\n" + "脂肪（克）36.70\n" + "蛋白质（克）17.30\n" + "膳食纤维（克）3.60",
            "碳水化合物（克）21.70\n" + "脂肪（克）44.30\n" + "蛋白质（克）24.80\n" + "膳食纤维（克）5.50",
            "碳水化合物（克）23.90\n" + "脂肪（克）45.40\n" + "蛋白质（克）22.50\n" + "膳食纤维（克）8.00",
            "碳水化合物（克）21.70\n" + "脂肪（克）6.70\n" + "蛋白质（克）12.00\n" + "膳食纤维（克）5.40",
            "碳水化合物（克）46.90\n" + "脂肪（克）0.50\n" + "蛋白质（克）2.80\n" + "膳食纤维（克）0.70",
            "碳水化合物（克）0.00\n" + "脂肪（克）99.90\n" + "蛋白质（克）0.00\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）47.00\n" + "脂肪（克）1.10\n" + "蛋白质（克）7.00\n" + "膳食纤维（克）1.30",};
    private static final String []efood={"170.0Kcal/100g",
            "185.0Kcal/100g","344.0Kcal/100g","698.0Kcal/100g","514.0Kcal/100g","563.0Kcal/100g","566.0Kcal/100g","570.0Kcal/100g","627.0Kcal/100g"
            ,"201.0Kcal/100g","899.0Kcal/100g"};
    public ThreeFragment() {
        // Required empty public constructor
    }


    private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, null);
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

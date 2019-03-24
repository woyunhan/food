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

public class FourthFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView list;


    String[] mName ={"冬瓜","生菜","黄瓜","娃娃菜","海带","青菜","西红柿","香菇","平菇","白萝卜","黑木耳","芦笋","茄子","丝瓜","南瓜","卷心菜"
            ,"莴笋","菠菜","杏鲍菇","金针菇","西兰花","胡萝卜"};
    String[] mNum ={"11.0Kcal/100g","13.0Kcal/100g","15.0Kcal/100g","15.0Kcal/100g","17.0Kcal/100g","17.0Kcal/100g","19.0Kcal/100g","19.0Kcal/100g","19.0Kcal/100g","20.0Kcal/100g","21.0Kcal/100g"
            ,"21.0Kcal/100g","21.0Kcal/100g","21.0Kcal/100g","22.0Kcal/100g","22.0Kcal/100g","22.0Kcal/100g",
            "23.0Kcal/100g","23.0Kcal/100g","26.0Kcal/100g","33.0Kcal/100g","43.0Kcal/100g"};
    private static final int[] resId = {R.drawable.donggua,R.drawable.shengcai,R.drawable.huanggua,R.drawable.wawacai,R.drawable.haidai,R.drawable.qingcai,R.drawable.xihongshi,R.drawable.xianggu,
            R.drawable.pinggu,R.drawable.bailuobo,R.drawable.muer,R.drawable.lusun,R.drawable.qiezhi,R.drawable.shigua,R.drawable.nangua,R.drawable.juanxincai,R.drawable.wosun,R.drawable.bocai,
            R.drawable.xingbaogu,R.drawable.jinzengu,R.drawable.xilanhua,R.drawable.huluobo
          };
    private static final String [] foodjianjie={
            "冬瓜微量营养素含量一般，但热量很低，且可消水肿，推荐在减肥期间食用。",
            "蔬菜类食材采取凉拌的烹调方式营养损失最小，是减肥期间推荐的烹调方式。",
            "一种热量低、含水量极高的蔬菜，由于其便携性，也常被当作水果食用，推荐在减肥期间食用。",
            "热量极低，水分率很高的一种蔬菜，含有较多纤维，适量食用有利于缓解便秘，推荐减肥期间食用。",
            "海带除了众所周知的补碘功效外，在植物性食物中钙含量十分突出，而且热量较低，推荐减肥期间食用。",
            "含水量很高、热量很低的一种蔬菜，含有一定的纤维和植物钙，推荐在减肥期间食用。",
            "一种热量低、含水量极高的蔬菜，由于其便携性，也常被当作水果食用，推荐在减肥期间食用。",
            "香菇氨基酸和纤维素含量丰富，新鲜香菇还含有一定量的维生素，单位热量也比较低，推荐减肥期间食用。",
            "钾和纤维含量较高的一种菌菇，对于缓解水肿和便秘有帮助，且水分率高、热量低，推荐减肥期间食用。",
            "白萝卜可促进肠道蠕动，预防便秘，同时热量非常低，且饱腹感较强，推荐在减肥期间食用。",
            "干木耳碳水化合物含量极高，热量在菌藻类中属于高的，水发后热量降低，其纤维和钾含量也极高，推荐减肥期间食用。",
            "芦笋的膳食纤维含量较为丰富，有助于缓解便秘，降低血脂及胆固醇，推荐在减肥期间食用。",
            "茄子是为数不多的紫色蔬菜之一，在它的紫皮中含有丰富的维生素E和维生素P，热量低且营养丰富，推荐在减肥期间食用。",
            "水分含量很高的常见蔬菜，含一定量的钾，热量较低，推荐在减肥期间食用。",
            "南瓜热量低，碳水化合物含量较低，我们感觉它甜，并非因为其糖分高，而是因为其果糖成分比蔗糖要甜，推荐在减肥期间食用。",
            "水分含量很高的蔬菜，热量很低，维生素含量与橙子相当，推荐在减肥期间食用。",
            "钾含量和水分含量比较高的一种蔬菜，其他营养方面无突出特点，推荐在减肥期间食用。",
            "虽然铁含量没有传闻中那么高，但也属于营养丰富的深色蔬菜，热量也较低，推荐减肥期间食用。",
            "杏鲍菇营养丰富，质地脆嫩，口感绝佳，风味独特，故有\"草原上的美味牛肝菌\"之美称，推荐在减肥期间食用。",
            "富含磷和钾，热量低，推荐减肥期间食用。",
            "西兰花中维生素A及胡萝卜素含量极为丰富，且热量较低，推荐在减肥期间食用。",
            "水分和纤维含量较高的蔬菜，由于携带方便，有时也被用来代替水果食用，推荐减肥期间食用。",
            };
    private static final String [] efoodinfo={
           "碳水化合物（克）2.60\n" + "脂肪（克）0.20\n" + "蛋白质（克）0.40\n" + "膳食纤维（克）0.70",
            "碳水化合物（克）4.31\n" + "脂肪（克）3.98\n" + "蛋白质（克）2.46\n" + "膳食纤维（克）0.80",
            "碳水化合物（克）2.90\n" + "脂肪（克）0.20\n" + "蛋白质（克）0.80\n" + "膳食纤维（克）0.50",
           "碳水化合物（克）2.40\n" + "脂肪（克）0.00\n" + "蛋白质（克）1.90\n" + "膳食纤维（克）2.30",
            "碳水化合物（克）2.10\n" + "脂肪（克）0.10\n" + "蛋白质（克）1.20\n" + "膳食纤维（克）0.50",
            "碳水化合物（克）2.70\n" + "脂肪（克）0.30\n" + "蛋白质（克）1.50\n" + "膳食纤维（克）1.10",
           "碳水化合物（克）4.00\n" + "脂肪（克）0.20\n" + "蛋白质（克）0.90\n" + "膳食纤维（克）0.50",
           "碳水化合物（克）5.20\n" + "脂肪（克）0.30\n" + "蛋白质（克）2.20\n" + "膳食纤维（克）3.30",
            "碳水化合物（克）4.60\n" + "脂肪（克）0.30\n" + "蛋白质（克）1.90\n" + "膳食纤维（克）2.30",
            "碳水化合物（克）5.00\n" + "脂肪（克）0.10\n" + "蛋白质（克）0.90\n" + "膳食纤维（克）1.00",
           "碳水化合物（克）65.60\n" + "脂肪（克）1.50\n" + "蛋白质（克）12.10\n" + "膳食纤维（克）29.90",
           "碳水化合物（克）4.90\n" + "脂肪（克）0.10\n" + "蛋白质（克）1.40\n" + "膳食纤维（克）1.90",
            "碳水化合物（克）4.90\n" + "脂肪（克）0.20\n" + "蛋白质（克）1.10\n" + "膳食纤维（克）1.30",
            "碳水化合物（克）4.20\n" + "脂肪（克）0.20\n" + "蛋白质（克）1.00\n" + "膳食纤维（克）0.60",
            "碳水化合物（克）5.30\n" + "脂肪（克）0.10\n" + "蛋白质（克）0.70\n" + "膳食纤维（克）0.80",
            "碳水化合物（克）4.60\n" + "脂肪（克）0.20\n" + "蛋白质（克）1.50\n" + "膳食纤维（克）1.00",
          "碳水化合物（克）2.80\n" + "脂肪（克）0.10\n" + "蛋白质（克）1.00\n" + "膳食纤维（克）0.60",
            "碳水化合物（克）4.50\n" + "脂肪（克）0.30\n" + "蛋白质（克）2.60\n" + "膳食纤维（克）1.70",
            "碳水化合物（克）51.00\n" + "脂肪（克）17.60\n" + "蛋白质（克）6.90\n" + "膳食纤维（克）0.90",
            "碳水化合物（克）71.70\n" + "脂肪（克）12.70\n" + "蛋白质（克）9.00\n" + "膳食纤维（克）1.10",
            "碳水化合物（克）61.60\n" + "脂肪（克）21.10\n" + "蛋白质（克）9.50\n" + "膳食纤维（克）0.70",
            "碳水化合物（克）12.40\n" + "脂肪（克）0.20\n" + "蛋白质（克）1.90\n" + "膳食纤维（克）0.80"};
    private static final String []efood={"11.0Kcal/100g","13.0Kcal/100g","15.0Kcal/100g","15.0Kcal/100g","17.0Kcal/100g","17.0Kcal/100g","19.0Kcal/100g","19.0Kcal/100g","19.0Kcal/100g","20.0Kcal/100g","21.0Kcal/100g"
            ,"21.0Kcal/100g","21.0Kcal/100g","21.0Kcal/100g","22.0Kcal/100g","22.0Kcal/100g","22.0Kcal/100g",
            "23.0Kcal/100g","23.0Kcal/100g","26.0Kcal/100g","33.0Kcal/100g","43.0Kcal/100g"};
    public FourthFragment() {
        // Required empty public constructor
    }
    private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, null);
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

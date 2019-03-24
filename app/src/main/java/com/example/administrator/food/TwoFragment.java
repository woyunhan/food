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

public class TwoFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView list;
    private String[] mName ={"瘦猪肉","鸡胸肉","去皮鸡腿","瘦牛肉","羊肉","鸡蛋","牛奶"
            ,"酸奶","豆浆","豆腐","豆腐干","黄豆","豆腐脑","扇贝","虾仁","鱿鱼"
            ,"海虾","鲈鱼","草鱼","三文鱼","油浸金枪鱼"};
    private String[] mNum ={"155.0Kcal/100g","101.0Kcal/100g","99.0Kcal/100g","106.0Kcal/100g","118.0Kcal/100g","156.0Kcal/100g","60.0Kcal/100g"
            ,"67.0Kcal/100g","33.0Kcal/100g","98.0Kcal/100g","166.0Kcal/100g","359.0Kcal/100g","30.0Kcal/100g","60.0Kcal/100g","68.0Kcal/100g","79.0Kcal/100g"
            ,"100.0Kcal/100g","100.0Kcal/100g","112.0Kcal/100g","139.0Kcal/100g","184.0Kcal/100g"};
    private static final int[] resId = {R.drawable.shouzhurou,R.drawable.jixiongrou, R.drawable.jitui,R.drawable.shouniurou,R.drawable.yangrou,R.drawable.jidan,
            R.drawable.niunai,R.drawable.shuannai,R.drawable.doujiang,R.drawable.doufu,R.drawable.doufugang,R.drawable.huangdou,R.drawable.doufunao,R.drawable.shanbei,
            R.drawable.xiaren,R.drawable.youyu,R.drawable.haixia,R.drawable.luyu,R.drawable.caoyu,R.drawable.sanwenyu,R.drawable.youjinjinqiangyu};
    private static final String [] foodjianjie={
            "蛋白质最多、血红素铁最丰富的肉类之一，脂肪较少，热量在肉类中属于低的，与大多数鱼类相当,减肥期间可适量食用。",
            "鸡胸脯肉是鸡身上热量比较低的部位，是减肥期间蛋白质最佳来源之一，非常适宜作为减肥期间的肉类食物来源适量食用。",
            "鸡的脂肪多囤积在皮下，鸡腿带皮，所以脂肪含量不低，减肥期间建议去皮后食用。",
            "蛋白质最多、脂肪最少、血红素铁最丰富的肉类之一，热量在肉类中属于低的，与大多数鱼类相当，减肥期间可适量食用。" ,
            "羊肉与猪肉、牛肉同属常见红肉类，富含铁、铜等多种矿物质，比起牛肉脂肪含量略高，减肥期间适宜选择纯瘦肉适量食用。",
            "鸡蛋热量及营养与生鸡蛋基本相同，但熟鸡蛋中的营养物质被人体吸收利用效率更高。",
            "蛋白质和钙含量较丰富的一种饮品，减肥时可选择低脂或脱脂牛奶，每天的建议量为250g。",
            "蛋白质和钙含量较丰富的奶制品，且不含乳糖，适合中国人体质饮用，减肥期间可适量饮用。",
            "含水量90%以上的饮品，热量很低，蛋白质约为牛奶的1/2，钙约为牛奶的1/10，不可替代牛奶，推荐减肥期间作为蛋白质的来源食用。",
            "蛋白质含量较高，豆腐中大豆异黄酮对于女性调理内分泌也有帮助，推荐减肥期间作为蛋白质的来源食用。",
            "蛋白质含量高，而又不像肉类一样含较多脂肪，减肥期间作为蛋白质的来源可适量食用。",
            "一种富含优质蛋白和纤维的食品，其脂肪也较高，热量较高，不过其中80%以上为不饱和脂肪酸，推荐减肥期间作为蛋白质的来源食用。",
            "豆腐脑的含水量较高，蛋白质和热量在豆制品中属于极低的，如加入辣油等调料，热量将有较大升高，推荐减肥期间作为蛋白质的来源食用。",
            "干贝又叫瑶柱，蛋白质含量非常高，减肥期间不宜过多食用。",
            "蛋白质含量较高，热量很低的肉类，几乎不含脂肪，但是钠含量比较高，减肥期间不宜大量食用以免水肿。",
            "鱿鱼蛋白质含量较高，但钠含量也较高，综合来说不宜食用过多。",
            "海虾几乎不含脂肪，是非常优质的蛋白质来源，且富含多种矿物质，非常适宜作为减肥期间的肉类食物。",
            "鲈鱼脂肪含量较低，富含优质蛋白及钙质等矿物质，营养丰富，适宜减肥期间食用。",
            "和其他鱼类一样，是非常优质的蛋白质来源，适宜作为减肥期间的肉类食物。",
            "含有较多蛋白质和部分脂肪，但热量在肉类中依然属于较低的，其钾含量较高，减肥时可适量食用。",
            "比起新鲜的金枪鱼，盐分及油脂含量增加，减肥期间要适量食用。"};
    private static final String [] efoodinfo={
            "碳水化合物（克）1.50\n" + "脂肪（克）6.20\n" + "蛋白质（克）20.30\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）0.00\n" + "脂肪（克）2.40\n" + "蛋白质（克）29.00\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）0.00\n" + "脂肪（克）13.00\n" + "蛋白质（克）16.00\n" + "膳食纤维（克）0.00\n",
            "碳水化合物（克）3.20\n" + "脂肪（克）11.90\n" + "蛋白质（克）31.40\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）2.40\n" + "脂肪（克）4.00\n" + "蛋白质（克）18.00\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）2.80\n" + "脂肪（克）8.80\n" + "蛋白质（克）13.30\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）3.40\n" + "脂肪（克）3.20\n" + "蛋白质（克）3.00\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）9.30\n" + "脂肪（克）2.70\n" + "蛋白质（克）2.50\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）1.10\n" + "脂肪（克）0.70\n" + "蛋白质（克）1.80\n" + "膳食纤维（克）1.10",
            "碳水化合物（克）4.20\n" + "脂肪（克）3.70\n" + "蛋白质（克）8.10\n" + "膳食纤维（克）0.40",
            "碳水化合物（克）11.50\n" + "脂肪（克）3.60\n" + "蛋白质（克）16.20\n" + "膳食纤维（克）0.80",
            "碳水化合物（克）34.20\n" + "脂肪（克）16.00\n" + "蛋白质（克）35.00\n" + "膳食纤维（克）15.50",
            "碳水化合物（克）0.00\n" + "脂肪（克）0.80\n" + "蛋白质（克）1.90\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）2.60\n" + "脂肪（克）0.60\n" + "蛋白质（克）11.10\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）18.71\n" + "脂肪（克）12.67\n" + "蛋白质（克）3.31\n" + "膳食纤维（克）1.30",
            "碳水化合物（克）6.47\n" + "脂肪（克）1.18\n" + "蛋白质（克）10.76\n" + "膳食纤维（克）3.59",
            "碳水化合物（克）1.50\n" + "脂肪（克）0.60\n" + "蛋白质（克）16.80\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）0.00\n" + "脂肪（克）3.40\n" + "蛋白质（克）18.60\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）0.00\n" + "脂肪（克）5.20\n" + "蛋白质（克）16.60\n" + "膳食纤维（克）0.00",
            "碳水化合物（克）2.70\n" + "脂肪（克）5.18\n" + "蛋白质（克）0.66\n" + "膳食纤维（克）0.35",
            "碳水化合物（克）0.00\n" + "脂肪（克）9.00\n" + "蛋白质（克）27.10\n" + "膳食纤维（克）0.00"};
    private static final String []efood={"155.0Kcal/100g","101.0Kcal/100g","99.0Kcal/100g","106.0Kcal/100g","118.0Kcal/100g","156.0Kcal/100g","60.0Kcal/100g"
            ,"67.0Kcal/100g","33.0Kcal/100g","98.0Kcal/100g","166.0Kcal/100g","359.0Kcal/100g","30.0Kcal/100g","60.0Kcal/100g","68.0Kcal/100g","79.0Kcal/100g"
            ,"100.0Kcal/100g","100.0Kcal/100g","112.0Kcal/100g","139.0Kcal/100g","184.0Kcal/100g"};
    public TwoFragment() {
        // Required empty public constructor
    }
    private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, null);
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

package com.example.administrator.listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv_1;
    //simpleAdapter需要的数据
    //对应item中的城市名tv_cityName
    private String[] simpleadapter_citynames =
            {"北京","上海","广州","深圳","成都"};
    //对应item中的城市口号tv_cityInfo
    private String[] simpleadapter_cityinfos =
            {"北京欢迎您！","上海欢迎您！","广州欢迎您！","深圳欢迎您！","成都欢迎您！"};
    //对应item中的城市图片iv_city
    private int[] simpleadapter_cityimages =
            {R.drawable.img01,R.drawable.img08,R.drawable.img07,
                    R.drawable.img04,R.drawable.img05};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_1 = (ListView) findViewById(R.id.lv_1);
        //获取SimpleAdapter
        SimpleAdapter simpleAdapter = getSimpleAdapter();

        List<ItemBean> datas = new ArrayList<>();
        for (int i=0;i<50;i++){
            ItemBean itemBean = new ItemBean
                    (simpleadapter_citynames[i%2],
                            simpleadapter_cityinfos[i%2],
                            simpleadapter_cityimages[i%2]);
            datas.add(itemBean);

        }
        MyAdapter myAdapter = new MyAdapter(this,datas);

        //通过布局文件设置ListView表头
        View head_view = LayoutInflater.from(this).inflate(R.layout.header_divider,null);
        lv_1.addHeaderView(head_view);
        //设置ListView表尾
        TextView footer_tv = new TextView(this);
        footer_tv.setText("列表结束");
        footer_tv.setGravity(Gravity.CENTER);
        lv_1.addFooterView(footer_tv);

        lv_1.setAdapter(myAdapter);
    }

    //得到SimpleAdapter
    private SimpleAdapter getSimpleAdapter(){
        List<Map<String,Object>> datas = new ArrayList<>();
        for (int i=0;i<simpleadapter_citynames.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("cityname",simpleadapter_citynames[i]);
            map.put("cityinfo",simpleadapter_cityinfos[i]);
            map.put("cityimage",simpleadapter_cityimages[i]);
            datas.add(map);
        }
        String[] from = {"cityinfo","cityname","cityimage"};
        int[] to = {R.id.tv_cityInfo,R.id.tv_cityName,R.id.iv_city};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,datas,R.layout.base_item,from,to);
        return simpleAdapter;
    }
}

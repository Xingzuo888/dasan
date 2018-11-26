package com.example.administrator.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2018/10/15.
 */

public class MyAdapter extends BaseAdapter {
    private Context myContext;
    private List<ItemBean> datas;
    public MyAdapter(Context context,List<ItemBean> datas){
        this.myContext = context;
        this.datas = datas;
    }
    //数据集的数据个数
    @Override
    public int getCount() {
        return datas.size();
    }
    //获取数据集中与索引对应的数据项
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }
    //获取指定行对应的ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;
        MyHolderView myHolderView = null;
        if (convertView == null){
            myHolderView = new MyHolderView();
            view = LayoutInflater.from(myContext).inflate(R.layout.base_item,null);
            myHolderView.tv_cityname = (TextView) view.findViewById(R.id.tv_cityName);
            myHolderView.tv_cityinfo = (TextView) view.findViewById(R.id.tv_cityInfo);
            myHolderView.iv_city = (ImageView) view.findViewById(R.id.iv_city);
            myHolderView.cb = (CheckBox) view.findViewById(R.id.cb);
            myHolderView.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Toast.makeText(myContext,datas.get(position).cityname,Toast.LENGTH_SHORT).show();
                }
            });
            view.setTag(myHolderView);
        }else{
            view = convertView;
            myHolderView = (MyHolderView) view.getTag();
        }
        ItemBean itemBean = datas.get(position);
        myHolderView.iv_city.setImageResource(itemBean.cityimage);
        myHolderView.tv_cityname.setText(itemBean.cityname);
        myHolderView.tv_cityinfo.setText(itemBean.cityinfo);
        return view;

    }

    class MyHolderView{
        public TextView tv_cityname;
        public TextView tv_cityinfo;
        public ImageView iv_city;
        public CheckBox cb;
    }
}

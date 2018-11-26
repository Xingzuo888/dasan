package com.example.administrator.listviewadapter;

/**
 * Created by Administrator on 2018/10/15.
 */

public class ItemBean {
    public String cityname;
    public String cityinfo;
    public int cityimage;

    public ItemBean(String name,String info , int image){
        this.cityimage = image;
        this.cityinfo = info;
        this.cityname = name;
    }

}

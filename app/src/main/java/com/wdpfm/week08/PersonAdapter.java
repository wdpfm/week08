package com.wdpfm.week08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private List<Actor> pdata = new ArrayList<Actor>();
    //上下文
    private Context context;

    public PersonAdapter(List<Actor> pdata, Context context) {
        this.pdata = pdata;
        this.context = context;
    }
    @Override
    public int getCount() {
        return pdata.size();//列表数据个数
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return position;//返回数据项在列表中的索引
    }
    //绑定数据至ListView
    //定义ViewHolder静态类
    static class ViewHolder{
        //定义对应的列表项
        public ImageView myimg;
        public TextView myname;
        public TextView myinfo;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //定义ViewHolder对象
        ViewHolder holder;
        //判断convertView是否为空，convertView对应的列表项
        if (convertView==null){
            //新建
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
            holder.myimg = (ImageView) convertView.findViewById(R.id.itemImageView);
            holder.myname = (TextView) convertView.findViewById(R.id.itemTextView);
            holder.myinfo = (TextView) convertView.findViewById(R.id.itemTextView2);
            convertView.setTag(holder);
        }else{
            //复用列表项
            holder = (ViewHolder) convertView.getTag();

        }
        //设置列表项数据
        holder.myimg.setImageResource(pdata.get(position).getImg());
        holder.myname.setText(pdata.get(position).getName());
        holder.myinfo.setText(pdata.get(position).getInfo());
        return convertView;
    }
}

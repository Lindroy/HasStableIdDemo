package com.lindroid.hasstableiddemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author Lin
 * @date 2018/4/19
 * @function
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<String> datas;

    protected MyAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public boolean hasStableIds() {
        return super.hasStableIds();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("Tag","数据"+position+"调用getView方法");
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context,android.R.layout.simple_list_item_1,null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(android.R.id.text1);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(datas.get(position));
        return convertView;
    }

    class ViewHolder{
        TextView textView;
    }
}

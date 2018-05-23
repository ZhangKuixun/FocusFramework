package com.zkx.focus.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zkx.focus.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangkuixun on 2017/7/26.
 */

public class ListviewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private List<Integer> mArrayList = new ArrayList();

    public ListviewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        for (int i = 0; i < 10; i++) {
            mArrayList.add(i);
        }
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter_listview_item, null);
            holder.text = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        Log.e("akui", "isSelected=" + holder.text.isSelected() + "  isFocused=" + holder.text.isFocused() + "  isPressed=" + holder.text.isPressed());
        holder.text.setText("item " + mArrayList.get(position));
        return convertView;
    }

    class ViewHolder {
        public TextView text;
    }
}

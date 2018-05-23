package com.zkx.focus.myapplication.adapter;

import android.content.Context;

import com.zkx.focus.library.adapter.CommonRecyclerViewAdapter;
import com.zkx.focus.library.adapter.CommonViewHolder;
import com.zkx.focus.myapplication.R;

/**
 * Created by zhangkuixun on 2017/8/1.
 */

public class RecyclerViewAdapter extends CommonRecyclerViewAdapter<String> {
    public RecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.adapter_recyclerview_item;
    }

    @Override
    public void onBindItemHolder(CommonViewHolder holder, String item, int position) {
        holder.setText(R.id.textView, item);
    }
}

package com.zkx.focus.library.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owen on 15/7/28.
 */
public abstract class CommonRecyclerViewAdapter<T> extends RecyclerView.Adapter<CommonRecyclerViewHolder> {
    protected Context mContext;
    private List<T> mDatas = new ArrayList<T>();

    public Context getContext() {
        return mContext;
    }

    public CommonRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public CommonRecyclerViewAdapter(Context context, List<T> datas) {
        this(context);
    }

    public void clearDatas() {
        this.mDatas.clear();
    }

    public void setDatas(List<T> datas) {
        this.mDatas = datas;
    }

    public void appendDatas(List<T> datas) {
        if (null == datas)
            return;
        int size = mDatas.size();
        this.mDatas.addAll(datas);
        notifyItemRangeInserted(size, datas.size());
    }

    public void removeItem(int postion) {
        if (null != mDatas && postion < mDatas.size()) {
            mDatas.remove(postion);
            notifyItemRemoved(postion);
        }
    }

    public void movedItem(int form, int to) {
        if (null != mDatas && !mDatas.isEmpty()) {
            if (form < 0 || form >= getItemCount() || to < 0 || to >= getItemCount()) {
                return;
            }
            T item = mDatas.get(form);
            mDatas.remove(form);
            mDatas.add(to - 1, item);
            notifyItemMoved(form, to);
        }
    }

    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return CommonRecyclerViewHolder.get(this.mContext, viewGroup, getItemLayoutId(viewType));
    }

    @Override
    public void onBindViewHolder(final CommonRecyclerViewHolder holder, int position) {
        onBindItemHolder(holder.getHolder(), getItem(position), position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return null != this.mDatas ? this.mDatas.size() : 0;
    }

    @Nullable
    private T getItem(int position) {
        return (null != mDatas && position < mDatas.size()) ? mDatas.get(position) : null;
    }

    public abstract int getItemLayoutId(int viewType);

    public abstract void onBindItemHolder(final CommonViewHolder holder, T item, int position);
}

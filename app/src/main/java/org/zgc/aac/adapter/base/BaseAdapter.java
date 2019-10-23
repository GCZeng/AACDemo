package org.zgc.aac.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author: ZGC
 * Time: 2019/10/21 9:56
 * Description:
 */
public abstract class BaseAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected Context mContext;
    protected List<T> mList;

    public BaseAdapter(Context context) {
        this.mContext = context;
    }

    public BaseAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void addData(List<T> list) {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        B bing = DataBindingUtil.inflate(LayoutInflater.from(mContext), getLayoutResId(viewType), parent, false);
        return new RecyclerHolder(bing.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B binding = DataBindingUtil.getBinding(holder.itemView);
        final T t = mList.get(position);
        onBindItem(binding, t, position);
    }

    protected abstract @LayoutRes
    int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, T t, int position);

    static class RecyclerHolder extends RecyclerView.ViewHolder {

        public RecyclerHolder(View itemView) {
            super(itemView);
        }
    }
}

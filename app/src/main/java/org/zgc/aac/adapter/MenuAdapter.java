package org.zgc.aac.adapter;


import android.content.Context;
import android.view.View;

import org.zgc.aac.R;
import org.zgc.aac.adapter.base.BaseAdapter;
import org.zgc.aac.bean.entity.Menu;
import org.zgc.aac.databinding.RvMenuListItemBinding;
import org.zgc.aac.util.LogUtil;

import java.util.List;


/**
 * Author:Nick
 * Time2018/7/2 11:36
 * Description
 */
public class MenuAdapter extends BaseAdapter<Menu, RvMenuListItemBinding> {

    public MenuAdapter(Context context, List<Menu> list) {
        super(context, list);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.rv_menu_list_item;
    }

    @Override
    protected void onBindItem(RvMenuListItemBinding binding, Menu menu, int position) {
        LogUtil.d(menu.getName());
        binding.setEntity(menu);
        binding.executePendingBindings();

        binding.getRoot().setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(this, binding.getRoot(), position);
            }
        });
    }

    private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        public void onItemClick(BaseAdapter adapter, View view, int position);
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;

    }
}

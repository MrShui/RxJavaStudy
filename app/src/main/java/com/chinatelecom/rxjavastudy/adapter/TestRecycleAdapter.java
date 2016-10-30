package com.chinatelecom.rxjavastudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chinatelecom.rxjavastudy.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/30.
 */

public class TestRecycleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TestRecycleAdapter(List<String> data) {
        super(R.layout.item_test, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.text_view, s);
    }
}

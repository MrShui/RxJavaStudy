package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.adapter.TestRecycleAdapter;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/30.
 */

public class RoundTableFragment extends BaseFragment {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    List<String> mData = new ArrayList<>();

    {
        mData.add("小明");
        mData.add("小王");
        mData.add("小水");
        mData.add("小黃");
        mData.add("小美");
        mData.add("小明");
        mData.add("小王");
        mData.add("小水");
        mData.add("小黃");
        mData.add("小美");
        mData.add("小明");
        mData.add("小王");
        mData.add("小水");
        mData.add("小黃");
        mData.add("小美");
    }

    public static RoundTableFragment newInstance() {
        return new RoundTableFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("TAG", "RoundTableFragment() onCreateView()");
        View inflate = inflater.inflate(R.layout.fragment_round_table, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    private void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(_mActivity));
        TestRecycleAdapter adapter = new TestRecycleAdapter(mData);
        View headerView = LayoutInflater.from(_mActivity).inflate(R.layout.header_image, null, false);
        adapter.addHeaderView(headerView);
        recycleView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                String item = (String) baseQuickAdapter.getItem(i);
                ((BaseFragment) getParentFragment()).start(DetailFragment.newInstance(item));
            }
        });
        recycleView.setAdapter(adapter);
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
        initView();
    }
}

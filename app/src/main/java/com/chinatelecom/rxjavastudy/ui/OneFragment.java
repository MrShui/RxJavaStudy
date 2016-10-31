package com.chinatelecom.rxjavastudy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinatelecom.rxjavastudy.R;
import com.chinatelecom.rxjavastudy.RxTag;
import com.chinatelecom.rxjavastudy.ui.base.BaseFragment;
import com.hwangjr.rxbus.RxBus;

/**
 * Created by Shui on 16/10/30.
 */

public class OneFragment extends BaseFragment {
    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        return inflate;
    }

    @Override
    protected void initLazy(@Nullable Bundle savedInstanceState) {
        Log.i("TAG", "OneFragment");
//        ReqProfessorInteraction reqProfessorInteraction = new ReqProfessorInteraction();
//        reqProfessorInteraction.setId("11");
//        ApiHelper.getApi().professorInteraction(reqProfessorInteraction)
//                .compose(RxSchedulersHelper.<ResultModel<List<ResProfessorInteraction>>>io_main())
//                .compose(RxResultHelper.<List<ResProfessorInteraction>>handleResult())
////                .compose(this.<List<ResProfessorInteraction>>bindToLifecycle())
//                .subscribe(new Action1<List<ResProfessorInteraction>>() {
//                    @Override
//                    public void call(List<ResProfessorInteraction> resProfessorInteractions) {
//
//                    }
//                });
    }

    @Override
    public boolean onBackPressedSupport() {
        _mActivity.finish();
        return true;
    }
}

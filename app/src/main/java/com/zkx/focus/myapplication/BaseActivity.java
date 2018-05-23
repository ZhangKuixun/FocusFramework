package com.zkx.focus.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zkx.focus.library.focusMap.FocusView;
import com.zkx.focus.library.utils.LayoutUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ZhangKuixun on 2017/7/10.
 */

public class BaseActivity extends AppCompatActivity  {

    private List<FocusView> mFocusViewList = new ArrayList<>();
    public View mChildAt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //获取所有控件
        mChildAt = findViewById(android.R.id.content);
        List<View> allChildViews = LayoutUtils.getAllChildViews(mChildAt);
        for (View view : allChildViews) {
            FocusView focusView = new FocusView();
            focusView.mView = view;
            mFocusViewList.add(focusView);
        }
    }
}

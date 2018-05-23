package com.zkx.focus.myapplication;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.zkx.focus.library.widget.controlLibrary.TVButton;
import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.params.TextParams;

import java.util.List;

public class MainActivity4 extends BaseActivity {
    private int screenWidth;
    private int screenHeight;
    private FrameLayout frame;
    private MainActivity4 context;
    private int mLikeId;
    private List<Composition> mLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("MainActivity3");
        context = this;
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        mLikeId = getIntent().getIntExtra("likeId", 0);
        mLike = MainActivity.getCompositionPage().getCompositions().get(mLikeId).getLike();

        frame = (FrameLayout) findViewById(R.id.frame);


        initView();
    }

    private void initView() {
        TextParams params = new TextParams();
        params.setBackgroundColor(R.drawable.focus_transparent);
        params.setGravity(Gravity.CENTER);

        for (int i = 0; i < mLike.size(); i++) {
            params.setText("button" + i);
            TVButton button = new TVButton(context, i);
            button.setParams(params);
            button.composition(screenWidth, screenHeight, mLike.get(i));
            frame.addView(button);
        }
    }
}
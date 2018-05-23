package com.zkx.focus.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.data.CompositionPage;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 服务器整体页面配置数据
     */
    private static CompositionPage mCompositionPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainActivity");
        initData();
        initView();
    }

    /**
     * @return 服务器整体页面配置数据
     */
    public synchronized static CompositionPage getCompositionPage() {
        return mCompositionPage;
    }

    public void initData() {
        mCompositionPage = new CompositionPage();
        ArrayList<Composition> mCompositions = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                Composition composition = new Composition(10, 10, j * 11, i * 11);
                if (i == 0)
                    composition.setLike(initButtonData());
                mCompositions.add(composition);
                mCompositionPage.setCompositions(mCompositions);
            }
        }
    }

    public ArrayList<Composition> initButtonData() {
        ArrayList<Composition> compositions = new ArrayList<>();
        Composition composition1 = new Composition(80, 40, 0, 0);
        Composition composition2 = new Composition(20, 20, 81, 0);
        Composition composition3 = new Composition(20, 20, 81, 21);
        compositions.add(composition1);
        compositions.add(composition2);
        compositions.add(composition3);
        return compositions;
    }

    private void initView() {
        findViewById(R.id.btn1_MainActivity).setOnClickListener(this);
        findViewById(R.id.btn2_MainActivity).setOnClickListener(this);
        findViewById(R.id.btn3_MainActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn1_MainActivity)
            startActivity(new Intent(this, MainActivity2.class));
        else if (v.getId() == R.id.btn2_MainActivity)
            startActivity(new Intent(this, MainActivity1.class));
        else if (v.getId() == R.id.btn3_MainActivity)
            startActivity(new Intent(this, MainActivity3.class));

        finish();
    }
}

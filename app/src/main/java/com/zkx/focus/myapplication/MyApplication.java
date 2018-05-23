package com.zkx.focus.myapplication;

import android.app.Application;

import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.data.CompositionPage;

import java.util.ArrayList;

/**
 * Created by zhangkuixun on 2017/8/24.
 */

public class MyApplication extends Application {

    /**
     * 服务器整体页面配置数据
     */
    private static CompositionPage mCompositionPage;

    @Override
    public void onCreate() {
        super.onCreate();

        initData();
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
}

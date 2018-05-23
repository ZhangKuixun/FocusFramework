package com.zkx.focus.library.utils;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.FOCUS_DOWN;
import static android.view.View.FOCUS_LEFT;
import static android.view.View.FOCUS_RIGHT;
import static android.view.View.FOCUS_UP;

/**
 * Created by zhangkuixun on 2017/7/7.
 */
public class LayoutUtils {
    /**
     * 获取所有控件
     *
     * @param view 获取所有控件：this.getWindow().getDecorView();
     *             获取当前布局下所有的控件：findViewById(android.R.id.content);
     * @return view列表
     */
    public static List<View> getAllChildViews(View view) {
        List<View> allChildren = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewChild = vp.getChildAt(i);
                allChildren.add(viewChild);
                allChildren.addAll(getAllChildViews(viewChild));
            }
        }
        return allChildren;
    }

    /**
     * keycode值转成Direction值
     *
     * @param keyCode
     * @return
     */
    public static int keyCode2Direction(int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                return FOCUS_DOWN;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                return FOCUS_RIGHT;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                return FOCUS_LEFT;

            case KeyEvent.KEYCODE_DPAD_UP:
                return FOCUS_UP;

            default:
                return -1;
        }
    }

    /**
     * 清除焦点的权限
     */
    public static void clearFocusable(View... views) {
        for (View view : views) {
            view.setFocusable(false);
        }
    }

    /**
     * 添加焦点的权限
     */
    public static void requestFocusable(View... views) {
        for (View view : views) {
            view.setFocusable(true);
        }
    }

    /**
     * 清除焦点
     */
    public static void clearFocus(View... views) {
        for (View view : views) {
            view.clearFocus();
        }
    }

    /**
     * 添加焦点
     */
    public static void requestFocus(View... views) {
        for (View view : views) {
            view.requestFocus();
        }
    }

    /**
     * 设置页面选中焦点
     */
    public static void setPageFocus(final View view) {
        try {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.requestFocus();
                }
            }, 300);
        } catch (Exception e) {
            Loger.e("....设置页面选中焦点,控件未加载出来....");
        }
    }

}

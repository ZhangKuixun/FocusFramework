package com.zkx.focus.myapplication.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owen on 2017/7/6.
 */

public class ItemDatas {
    public static List<String> getDatas(int count) {
        List<String> mItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String itemBean = "数据" + i;
            mItems.add(itemBean);
        }
        return mItems;
    }

}

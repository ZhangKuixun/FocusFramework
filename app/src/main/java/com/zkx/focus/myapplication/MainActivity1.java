package com.zkx.focus.myapplication;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.zkx.focus.library.widget.viewGroup.TVLinearLayout;
import com.zkx.focus.library.widget.viewGroup.TVRecyclerView;
import com.zkx.focus.myapplication.adapter.RecyclerViewAdapter;
import com.zkx.focus.myapplication.data.ItemDatas;

import static android.view.View.FOCUS_UP;

public class MainActivity1 extends BaseActivity implements TVRecyclerView.OnInBorderKeyEventListener {
    private TVRecyclerView recyclerView;
    private TVLinearLayout tvLinerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("MainActivity1");

        init();
    }

    private void init() {
        tvLinerLayout = (TVLinearLayout) findViewById(R.id.tvLinerLayout);
        recyclerView = (TVRecyclerView) findViewById(R.id.listView1);
        recyclerView.setOnInBorderKeyEventListener(this);

        recyclerView.setSpacingWithMargins(10, 10);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setDatas(ItemDatas.getDatas(50));
    }

    @Override
    public boolean onInBorderKeyEvent(int direction, int keyCode, KeyEvent event, View focusView) {
        if (direction == FOCUS_UP) {
            focusView.setNextFocusLeftId(tvLinerLayout.getDownView().getId());
        }
        return false;
    }
}

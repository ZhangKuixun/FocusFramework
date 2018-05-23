package com.zkx.focus.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity2 extends BaseActivity {

    private TextView mTvSelect_mainActivity;
    private TextView mTvFocus_mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("MainActivity");
        View activity_main = findViewById(R.id.activity_main2);
        mTvSelect_mainActivity = findViewById(R.id.tvSelect_mainActivity2);
        mTvFocus_mainActivity = findViewById(R.id.tvFocus_mainActivity2);
        activity_main.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(final View oldFocus, final View newFocus) {
                mTvSelect_mainActivity.setText(oldFocus != null ? "oldFocus:" + oldFocus.toString() : "oldFocus:");
                mTvFocus_mainActivity.setText(newFocus != null ? "newFocus:" + newFocus.toString() : "newFocus:");
            }
        });
    }
}

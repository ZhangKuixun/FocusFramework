package com.zkx.focus.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

import com.zkx.focus.library.widget.controlLibrary.TVButton;
import com.zkx.focus.library.widget.controlLibrary.TVImageView;
import com.zkx.focus.library.widget.controlLibrary.TVTextView;
import com.zkx.focus.library.widget.controlLibrary.data.Composition;
import com.zkx.focus.library.widget.controlLibrary.params.ImageParams;
import com.zkx.focus.library.widget.controlLibrary.params.TextParams;
import com.zkx.focus.library.widget.interfaces.BaseView;

import java.util.List;

public class MainActivity3 extends Activity implements BaseView, View.OnClickListener {
    /**
     * 屏幕宽高
     */
    private int screenWidth, screenHeight;
    private FrameLayout frame;
    private MainActivity3 context;
    /**
     * 页面内所有的控件
     */
    private List<Composition> mCompositions;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("MainActivity3");
        context = this;
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        mCompositions = MainActivity.getCompositionPage().getCompositions();

        frame = (FrameLayout) findViewById(R.id.frame);

        initView();
    }

    private void initView() {
        addView();
    }

    public void addView() {
        for (Composition data : mCompositions) {
            View child = ContentType(type.TextView, data);
            if (child != null)
                frame.addView(child);
        }
    }

    @Override
    public View ContentType(type type, Composition data) {
        if (type == BaseView.type.Button) {
            TextParams params = new TextParams();
            params.setText("button" + i++);
            params.setBackgroundColor(R.drawable.focus_transparent);

            TVButton button = new TVButton(context, i);
            button.setParams(params);
            button.composition(screenWidth, screenHeight, data);
            return button;
        }
        if (type == BaseView.type.TextView) {
            TextParams params = new TextParams();
            params.setText("text" + i);
            params.setBackgroundColor(R.drawable.focus_transparent);

            TVTextView textView = new TVTextView(context, i);
            textView.setParams(params);
            textView.composition(screenWidth, screenHeight, data);
            if (mCompositions.get(i).getLike() != null)
                textView.setOnClickListener(this);
            i++;
            return textView;
        }
        if (type == BaseView.type.ImageView) {
            ImageParams params = new ImageParams();
            params.setBitmapResource(R.mipmap.ic_launcher);
            params.setBackGroundResource(R.drawable.focus_transparent);

            TVImageView imageView = new TVImageView(context, i);
            imageView.setParams(params);
            imageView.composition(screenWidth, screenHeight, data);
            return imageView;
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, MainActivity4.class);
//        intent.putExtra("like", (Serializable) mCompositions.get(v.getId()).getLike());
        intent.putExtra("likeId", v.getId());
        startActivity(intent);
    }
}
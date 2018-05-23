//package com.zkx.focus.library.widget.viewGroup;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.view.View;
//import android.widget.FrameLayout;
//
//import com.zkx.focus.library.R;
//import com.zkx.focus.library.widget.interfaces.BaseView;
//import com.zkx.focus.library.widget.controlLibrary.TVButton;
//import com.zkx.focus.library.widget.controlLibrary.TVImageView;
//import com.zkx.focus.library.widget.controlLibrary.data.Composition;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Created by zhangkuixun on 2017/8/11.
// */
//
//public class TVFrameLayout extends FrameLayout implements BaseView {
//
//    private int screenWidth;
//    private int screenHeight;
//    private int paddingTV;
//    private int paddingLeftTV;
//    private int paddingRightTV;
//    private int paddingTopTV;
//    private int paddingBottomTV;
//    private List<Composition> mIntegers;
//
//    public TVFrameLayout(Context context) {
//        super(context, null);
//    }
//
//    public TVFrameLayout(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TVFrameLayout);
//        paddingTV = a.getDimensionPixelOffset(R.styleable.TVFrameLayout_tv_padding, -1);
//        paddingLeftTV = a.getDimensionPixelOffset(R.styleable.TVFrameLayout_tv_paddingLeft, 0);
//        paddingRightTV = a.getDimensionPixelOffset(R.styleable.TVFrameLayout_tv_paddingRight, 0);
//        paddingTopTV = a.getDimensionPixelOffset(R.styleable.TVFrameLayout_tv_paddingTop, 0);
//        paddingBottomTV = a.getDimensionPixelOffset(R.styleable.TVFrameLayout_tv_paddingBottom, 0);
//        a.recycle();
//        DisplayMetrics dm = getResources().getDisplayMetrics();
//        screenWidth = dm.widthPixels;
//        screenHeight = dm.heightPixels;
//
//        if (paddingTV >= 0) {
//            setPadding(paddingTV, paddingTV, paddingTV, paddingTV);
//        } else {
//            if (paddingLeftTV > 0) {
//                setPadding(paddingLeftTV, 0, 0, 0);
//            }
//            if (paddingRightTV > 0) {
//                setPadding(0, 0, paddingRightTV, 0);
//            }
//            if (paddingTopTV > 0) {
//                setPadding(0, paddingTopTV, 0, 0);
//            }
//            if (paddingBottomTV > 0) {
//                setPadding(0, 0, 0, paddingBottomTV);
//            }
//        }
//    }
//
//    public void initData() {
//        mIntegers = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 10; j++) {
//                Composition composition = new Composition();
//                composition.setToALL(12.8, 7.2, 1, 1, j, i);
//                mIntegers.add(composition);
//            }
//        }
//    }
//
//    private void initView() {
//        initData();
//        addView();
//    }
//
//    public void addView() {
//        for (Composition data : mIntegers) {
//            View child = ContentType(type.Button, data);
//            if (child != null)
//                addView(child);
//        }
////        TVButton button = new TVButton(getContext());
////        button.composition(12, 6, 80, 40, 0, 0);
////        addView(button);
////
////        TVButton button1 = new TVButton(getContext());
////        button1.composition(12, 6, 20, 20, 4, 0);
////        addView(button1);
////
////        TVButton button2 = new TVButton(getContext());
////        button2.composition(12, 6, 20, 20, 4, 1);
////        addView(button2);
//
////        TVImageView imageView = new TVImageView(getContext());
////        imageView.composition(12, 6, 80, 40, 0, 0);
////        imageView.setImageResource(R.mipmap.ic_launcher);
////        addView(imageView);
////
////        TVImageView button1 = new TVImageView(getContext());
////        button1.composition(12, 6, 20, 20, 4, 0);
////        button1.setImageResource(R.mipmap.ic_launcher);
////        addView(button1);
////
////        TVImageView button2 = new TVImageView(getContext());
////        button2.composition(12, 6, 20, 20, 4, 1);
////        button2.setImageResource(R.mipmap.ic_launcher);
////        addView(button2);
//    }
//
//    @Override
//    public View ContentType(type type, Composition data) {
//        if (type == BaseView.type.Button) {
//            TVButton button = new TVButton(getContext());
////            button.composition(screenWidth, screenHeight, data);
//            return button;
//        }
//        if (type == BaseView.type.TextView) {
//
//        }
//        if (type == BaseView.type.ImageView) {
//            TVImageView imageView = new TVImageView(getContext());
////            imageView.composition(screenWidth, screenHeight, data);
//            return imageView;
//        }
//
//        return null;
//    }
//}

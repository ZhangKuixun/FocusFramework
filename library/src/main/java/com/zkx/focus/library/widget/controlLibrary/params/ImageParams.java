package com.zkx.focus.library.widget.controlLibrary.params;

import android.graphics.Bitmap;

/**
 * Created by zhangkuixun on 2017/8/16.
 * 图片控件属性参数
 */
public class ImageParams {
    /**
     * 图片
     */
    private Bitmap bitmap;
    /**
     * 本地图片资源
     */
    private int bitmapResource;
    /**
     * 本地背景资源
     */
    private int backGroundResource;

    /**
     * 图片
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * 图片
     */
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    /**
     * 本地图片资源
     */
    public int getBitmapResource() {
        return bitmapResource;
    }

    /**
     * 本地图片资源
     */
    public void setBitmapResource(int bitmapResource) {
        this.bitmapResource = bitmapResource;
    }

    /**
     * 本地背景资源
     */
    public int getBackGroundResource() {
        return backGroundResource;
    }

    /**
     * 本地背景资源
     */
    public void setBackGroundResource(int backGroundResource) {
        this.backGroundResource = backGroundResource;
    }
}
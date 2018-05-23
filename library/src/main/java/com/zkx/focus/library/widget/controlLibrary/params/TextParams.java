package com.zkx.focus.library.widget.controlLibrary.params;

import android.text.TextUtils;
import android.view.Gravity;

/**
 * Created by zhangkuixun on 2017/8/16.
 * 文本控件属性参数
 */
public class TextParams {
    /**
     * 文本内容
     */
    private String text;
    /**
     * 文本大小
     */
    private int textSize = 16;
    /**
     * 文本颜色
     */
    private int textColor;
    /**
     * 文本位置
     */
    private int gravity = Gravity.CENTER;
    /**
     * 背景色
     */
    private int backgroundColor;

    /**
     * 省略号
     */
    private TextUtils.TruncateAt ellipsize;
    /**
     * 文本行数
     */
    private int lines;
    /**
     * 文本长度
     */
    private int length;
    /**
     * 内边距
     */
    private int padding;
    /**
     * 左内边距
     */
    private int paddingLeft;
    /**
     * 右内边距
     */
    private int paddingRight;
    /**
     * 上内边距
     */
    private int paddingTop;
    /**
     * 下内边距
     */
    private int paddingBottom;

    /**
     * 文本内容
     */
    public String getText() {
        return text;
    }

    /**
     * 文本内容
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 文本大小
     */
    public int getTextSize() {
        return textSize;
    }

    /**
     * 文本大小
     */
    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    /**
     * 文本位置
     */
    public int getGravity() {
        return gravity;
    }

    /**
     * 文本位置
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    /**
     * 文本颜色
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * 文本颜色
     */
    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * 背景色
     */
    public int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 背景色
     */
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * 省略号
     */
    public TextUtils.TruncateAt getEllipsize() {
        return ellipsize;
    }

    /**
     * 省略号
     */
    public void setEllipsize(TextUtils.TruncateAt ellipsize) {
        this.ellipsize = ellipsize;
    }

    /**
     * 文本行数
     */
    public int getLines() {
        return lines;
    }

    /**
     * 文本行数
     */
    public void setLines(int lines) {
        this.lines = lines;
    }

    /**
     * 文本长度
     */
    public int getLength() {
        return length;
    }

    /**
     * 文本长度
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 内边距
     */
    public int getPadding() {
        return padding;
    }

    /**
     * 内边距
     */
    public void setPadding(int padding) {
        this.padding = padding;
    }

    /**
     * 左内边距
     */
    public int getPaddingLeft() {
        return paddingLeft;
    }

    /**
     * 左内边距
     */
    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    /**
     * 右内边距
     */
    public int getPaddingRight() {
        return paddingRight;
    }

    /**
     * 右内边距
     */
    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    /**
     * 上内边距
     */
    public int getPaddingTop() {
        return paddingTop;
    }

    /**
     * 上内边距
     */
    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    /**
     * 下内边距
     */
    public int getPaddingBottom() {
        return paddingBottom;
    }

    /**
     * 下内边距
     */
    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }
}
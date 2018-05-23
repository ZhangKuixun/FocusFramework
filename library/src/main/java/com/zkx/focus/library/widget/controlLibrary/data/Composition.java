package com.zkx.focus.library.widget.controlLibrary.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangkuixun on 2017/8/16.
 * 控件排版参数
 */
public class Composition implements Serializable {
    /**
     * 横向占用单元格数量
     */
    private int wCellNumber;
    /**
     * 纵向占用单元格数量
     */
    private int hCellNumber;
    /**
     * x轴起始单元格
     */
    private int xStart;
    /**
     * y轴起始单元格
     */
    private int yStart;

    /**
     * 连接到某页面
     */
    public List<Composition> like;

    public Composition() {

    }

    /**
     * @param wCellNumber 横向占用单元格数量
     * @param hCellNumber 纵向占用单元格数量
     * @param xStart      x轴起始单元格
     * @param yStart      y轴起始单元格
     */
    public Composition(int wCellNumber, int hCellNumber, int xStart, int yStart) {
        this.wCellNumber = wCellNumber;
        this.hCellNumber = hCellNumber;
        this.xStart = xStart;
        this.yStart = yStart;
    }

    /**
     * 横向占用单元格数量
     */
    public int getWCellNumber() {
        return wCellNumber;
    }

    /**
     * 横向占用单元格数量
     */
    public void setWCellNumber(int wCellNumber) {
        this.wCellNumber = wCellNumber;
    }

    /**
     * 纵向占用单元格数量
     */
    public int getHCellNumber() {
        return hCellNumber;
    }

    /**
     * 纵向占用单元格数量
     */
    public void setHCellNumber(int hCellNumber) {
        this.hCellNumber = hCellNumber;
    }

    /**
     * x轴起始单元格
     */
    public int getXStart() {
        return xStart;
    }

    /**
     * x轴起始单元格
     */
    public void setXStart(int Start) {
        this.xStart = Start;
    }

    /**
     * y轴起始单元格
     */
    public int getYStart() {
        return yStart;
    }

    /**
     * y轴起始单元格
     */
    public void setYStart(int yStart) {
        this.yStart = yStart;
    }

    /**
     * 连接到某页面
     */
    public List<Composition> getLike() {
        return like;
    }

    /**
     * 连接到某页面
     */
    public void setLike(List<Composition> like) {
        this.like = like;
    }
}

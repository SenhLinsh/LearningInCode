package com.linsh.code.view.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/25
 *    desc   : RecyclerView 条目 "装饰" 的绘制
 *             1. 应用: 绘制分割线 & 头部尾部 & 角标 & 装饰 等
 *             2. RecyclerView 可以添加多个或多次 ItemDecoration, 效果可以叠加
 *             3. 具体使用方法和细节可以参考 {@link android.support.v7.widget.DividerItemDecoration}(分割线)
 * </pre>
 */
public class LicItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 在给定 Item 的上下左右插入偏移, 以腾出空间绘制 "装饰"
     * 偏移可能类似 padding 或 margin
     * 当该方向的宽度是 match_parent 时, 偏移一般将会是 padding 方式
     * 当该方向的宽度是 warp_content 或确定的数值, 偏移一般将会是 margin 方式
     *
     * @param outRect 用于接收偏移量的 Rect
     * @param view    需要进行 "装饰" 的 Item
     * @param parent  RecyclerView
     * @param state   当前 RecyclerView 状态
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // 分别对 top & bottom & left & right 插入偏移量
        outRect.top = 1; // 顶部插入 1 px 的偏移
        outRect.bottom = view.getHeight(); // 底部插入和 Item 条目高度一致的偏移
        outRect.left = 0; // 不进行偏移

        int position = parent.getChildAdapterPosition(view);
        int itemCount = parent.getAdapter().getItemCount();
        if (position == 0) {
            // 对第一个条目进行偏移
        }
        if (position == itemCount - 1) {
            // 对最后一个条目进行偏移
        }
        int layoutPosition = parent.getChildLayoutPosition(view);
        int childCount = parent.getChildCount();
        if (layoutPosition == 0) {
            // 对最顶端的条目进行偏移
        }
        if (layoutPosition == childCount - 1) {
            // 对最底端的条目进行偏移
        }

        /*
        * 建议:
        * 1. 根据具体情况, 对不同方向进行偏移, 对不同的条目进行偏移
        * 2. 注意 RecyclerView 有横纵方向之分, 可能需要根据情况进行划分并做不同的处理
        */
    }

    /**
     * 在 Canvas 中绘制适当的 "装饰" 并应用到 RecyclerView.
     * 所有内容的绘制都会先于 Item View 绘制, 即会被 Item 的绘制内容覆盖, 可作为背景
     *
     * @param c      进行绘制的 Canvas
     * @param parent RecyclerView
     * @param state  RecyclerView 状态
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        /*
        * 一般步骤:
        * 1. 为 Canvas 指定绘制范围
        * 2. 绘制 Drawable 或形状
        */
    }

    /**
     * 在 Canvas 中绘制适当的 "装饰" 并应用到 RecyclerView.
     * 所有内容的绘制都会后于 Item View 绘制, 即会对 Item 的绘制内容进行覆盖, 可作为前景
     *
     * @param c      进行绘制的 Canvas
     * @param parent RecyclerView
     * @param state  RecyclerView 状态
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        // 同 onDraw()
    }
}

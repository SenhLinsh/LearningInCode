package com.linsh.code.view.viewpger;

import android.support.v4.view.ViewPager;

public class LicOnPageChangeListener implements ViewPager.OnPageChangeListener {

    /**
     * 当前选择的 Page 滑动时的回调, 有多个 Page 但只记录当前选择的 Page
     * 处于正中时偏移为 0, 向左滑动, 数值变大, 直到 Page 滑出页面, 偏移为 1, 继续则 position 加 1, 偏移重置为 0
     *
     * @param position             当前 Page 位置
     * @param positionOffset       当前 Page 的偏移, 数值为 0 - 1
     * @param positionOffsetPixels 当前 Page 的偏移的像素值
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 当某个 Page 被选择中的时候
     *
     * @param position 当前选中 Page 的位置
     */
    // Page 被选择时
    @Override
    public void onPageSelected(int position) {

    }

    /**
     * Page 滑动状态改变
     *
     * @param state 当前滑动状态
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
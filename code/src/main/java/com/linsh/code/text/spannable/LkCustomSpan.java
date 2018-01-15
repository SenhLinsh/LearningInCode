package com.linsh.code.text.spannable;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import android.view.View;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/15
 *    desc   :
 * </pre>
 */
public class LkCustomSpan extends MetricAffectingSpan implements UpdateLayout, UpdateAppearance {

    /**
     * 点击事件, 需要配合 textView.setMovementMethod(LinkMovementMethod.getInstance())
     */
    public void onClick(View widget) {

    }

    /**
     * 更新绘制状态
     * 在这里可以对笔刷进行设置
     * 需要设置的参数不影响 TextView 大小时, 只需继承 CharacterStyle 即可
     * 如果影响 TextView 大小, 则需继承 MetricAffectingSpan, 并实现 updateMeasureState() 方法, 在该方法中实现与 updateDrawState() 一致的操作
     */
    @Override
    public void updateDrawState(TextPaint ds) {
        /////// 不影响 TextView 大小绘制 //////
        // 文字颜色
        ds.setColor(Color.BLUE);
        // 背景色
        ds.bgColor = Color.RED;
        // 下划线
        ds.setUnderlineText(true);
        // 删除线
        ds.setStrikeThruText(true);

        /////// 影响 TextView 大小绘制 //////
        // 文字大小
        setTextSize(ds);
        // 上下标
        superscriptSpan(ds);
    }

    @Override
    public void updateMeasureState(TextPaint ds) {
        setTextSize(ds);
        superscriptSpan(ds);
    }

    private void setTextSize(TextPaint ds) {
        // px
        ds.setTextSize(40);
        // dp
        ds.setTextSize(20 * ds.density);
        // 相对大小
        ds.setTextSize(ds.getTextSize() * 2);
    }

    private void superscriptSpan(TextPaint ds) {
        // 上标
        ds.baselineShift += (int) (ds.ascent() / 2);
        // 下标
        ds.baselineShift -= (int) (ds.ascent() / 2);
    }
}

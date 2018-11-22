package com.linsh.code.text.spannable;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/15
 *    desc   :
 * </pre>
 */
public class LearnExtendingClickableSpan extends ClickableSpan {

    /**
     * 点击事件
     */
    @Override
    public void onClick(View widget) {
    }

    /**
     * 更新绘制状态
     * ClickableSpan 默认绘制了 linkColor 和下划线, 如果不需要, 可以在这里重写并取消父类的实现
     */
    @Override
    public void updateDrawState(TextPaint ds) {
//        super.updateDrawState(ds);
//        ds.setColor(ds.linkColor);
//        ds.setUnderlineText(true);
    }
}

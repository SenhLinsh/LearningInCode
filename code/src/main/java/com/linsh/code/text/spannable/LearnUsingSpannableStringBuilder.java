package com.linsh.code.text.spannable;

import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/15
 *    desc   :
 * </pre>
 */
public class LearnUsingSpannableStringBuilder {

    public void demo(SpannableStringBuilder builder) {
        // 追加文本
        builder.append("我是");
        // 追加文本, 并为所追加的文本设置 Span
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.append("Linsh", new ForegroundColorSpan(Color.RED), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        // 替换文本 (保留原来的样式)
        builder.replace(0, 3, "Linsh");
        // 插入文本
        builder.insert(0, "Linsh");

        // 设置 Span
        // 参数1: Span 类型
        // 参数2 & 3: 需要设置样式的文字的开始位置和结束位置
        // 参数4: 是否包含两侧, 如果包含, 将同步新插入文字的样式, INCLUSIVE 为包含, EXCLUSIVE 为不包含, 前为头, 后为尾
        builder.setSpan(new ForegroundColorSpan(Color.RED), 0, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }

    public void setSpannable(TextView textView, SpannableStringBuilder builder) {
        // 在单击链接时凡是有要执行的动作，都必须设置MovementMethod对象
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        // 设置点击后的颜色，这里涉及到ClickableSpan的点击背景
        textView.setLinkTextColor(Color.BLUE);

        // 为 TextView 设置 SpannableString
        textView.setText(builder);
        // 注意:
        // 以上只是对指定的字体设置了样式, 不会产生可执行动作
        // 如果需要对 Span 字体执行动作时(如点击), 需要设置 MovementMethod 对象
        // 如果需要产生点击事件(如 URLSpan & ClickableSpan), 可传入: LinkMovementMethod.getInstance()
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        // 如果设置了 URLSpan, TextView 会自动设置 Link 的颜色以及下划线
        // 如果需要更改颜色, 可对 TextView 进行设置
        textView.setLinkTextColor(Color.BLUE);
    }
}

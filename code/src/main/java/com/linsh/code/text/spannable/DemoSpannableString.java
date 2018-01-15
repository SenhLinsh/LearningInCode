package com.linsh.code.text.spannable;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/15
 *    desc   :
 * </pre>
 */
public class DemoSpannableString {

    public void demo(SpannableString string) {
        // 设置 Span
        // 参数1: Span 类型
        // 参数2 & 3: 需要设置样式的文字的开始位置和结束位置
        // 参数4: 是否包含两侧, 如果包含, 将同步新插入文字的样式, INCLUSIVE 为包含, EXCLUSIVE 为不包含, 前为头, 后为尾
        string.setSpan(new ForegroundColorSpan(Color.RED), 0, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }
}

package com.linsh.code.text.spannable;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.DrawableMarginSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.IconMarginSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TabStopSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.linsh.code._.Getter;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/15
 *    desc   : 讲解
 * </pre>
 */
public class LearnUsingSpans {

    public static void demo() {
        // 字体大小
        AbsoluteSizeSpan absoluteSizeSpan = absoluteSizeSpan();
        // 相对文字大小
        RelativeSizeSpan relativeSizeSpan = relativeSizeSpan();
        // 前景色(即文字颜色)
        ForegroundColorSpan foregroundColorSpan = foregroundColorSpan();
        // 背景色
        BackgroundColorSpan backgroundColorSpan = backgroundColorSpan();
        // 字体
        TypefaceSpan typefaceSpan = typefaceSpan();
        // 字体样式
        StyleSpan styleSpan = styleSpan();
        // 文字外观
        TextAppearanceSpan textAppearanceSpan = textAppearanceSpan();
        // 点击事件
        ClickableSpan clickableSpan = clickableSpan();
        // 超链接
        URLSpan urlSpan = urlSpan();
        // 下划线
        UnderlineSpan underlineSpan = underlineSpan();
        // 删除线
        StrikethroughSpan strikethroughSpan = strikethroughSpan();
        // 上标
        SuperscriptSpan superscriptSpan = superscriptSpan();
        // 下标
        SubscriptSpan subscriptSpan = subscriptSpan();
        // tab 偏移量
        TabStopSpan.Standard tabStopSpan = tabStopSpan();
        // 横向缩放
        ScaleXSpan scaleXSpan = scaleXSpan();
        // 文字对齐方式
        AlignmentSpan.Standard alignmentSpan = alignmentSpan();
        // 文本缩进
        LeadingMarginSpan.Standard leadingMarginSpan = leadingMarginSpan();
        // 插入图片
        ImageSpan imageSpan = imageSpan();
        // 插入图片
        IconMarginSpan iconMarginSpan = iconMarginSpan();
        // 插入图片
        DrawableMarginSpan drawableMarginSpan = drawableMarginSpan();
        // 蒙层效果
        MaskFilterSpan maskFilterSpan = maskFilterSpan();
    }

    /**
     * 字体大小
     */
    public static AbsoluteSizeSpan absoluteSizeSpan() {
        // 参数: 字体大小(px)
        AbsoluteSizeSpan absoluteSizeSpan1 = new AbsoluteSizeSpan(30);
        // 参数1: 字体大小
        // 参数2: 是否是 dip 单位, [true:dp, false: px]
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(30, true);
        return null;
    }

    /**
     * 相对文字大小
     */
    public static RelativeSizeSpan relativeSizeSpan() {
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(2); // 参数: 缩放比例
        return null;
    }

    /**
     * 前景色(即文字颜色)
     */
    public static ForegroundColorSpan foregroundColorSpan() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.BLUE);
        return null;
    }

    /**
     * 背景色
     */
    public static BackgroundColorSpan backgroundColorSpan() {
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.RED);
        return null;
    }

    /**
     * 字体
     */
    public static TypefaceSpan typefaceSpan() {
        // 参数: 字体; 如: monospace, serif, sans-serif 等
        TypefaceSpan typefaceSpan = new TypefaceSpan("monospace");
        return null;
    }

    /**
     * 字体样式
     */
    public static StyleSpan styleSpan() {
        // 参数: 字体样式; [NORMAL:正常, BOLD:粗体, ITALIC:斜体, BOLD_ITALIC:粗体+斜体]
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        return null;
    }

    /**
     * 文字外观
     */
    public static TextAppearanceSpan textAppearanceSpan() {
        // 参数2: 文字外观
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(Getter.context, android.R.style.TextAppearance);
        // 参数1: 字体, monospace, serif, sans-serif
        // 参数2: 字体样式（粗体、斜体、等等）; [NORMAL:正常, BOLD:粗体, ITALIC:斜体, BOLD_ITALIC:粗体+斜体]
        // 参数3: 字体颜色状态列表
        // 参数4: 字体链接颜色状态列表
        TextAppearanceSpan textAppearanceSpan3 = new TextAppearanceSpan(null, Typeface.NORMAL, 30, null, null);
        return null;
    }

    /**
     * 点击事件
     */
    public static ClickableSpan clickableSpan() {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // 点击事件
            }
        };
        // 注意:
        // 1. 设置后, 文字颜色会被改变为 TextView 的 LinkColor, 如果不希望字体颜色被改变, 需要自行设置 LinkColor
        // 2. 设置后, 文字会自动添加下划线, 如果需要去掉 下划线, 需要自行重写 updateDrawState() 方法
        //      updateDrawState() 自动对字体设置了 LinkColor 和 下划线, 可根据需要自行设置
        // 3. 但是需要配合 textView.setMovementMethod(LinkMovementMethod.getInstance()) 才能实现点击链接跳转浏览器的效果
        return null;
    }

    /**
     * 超链接
     */
    public static URLSpan urlSpan() {
        URLSpan urlSpan = new URLSpan("https://github.com/SenhLinsh");
        // 注意:
        // 1. 设置后, 文字颜色会被改变为 TextView 的 LinkColor, 如果不希望字体颜色被改变, 需要自行设置 LinkColor
        // 2. 设置后, 文字会自动添加下划线, 如果需要去掉 下划线, 需要自行继承 URLSpan 并重写 updateDrawState() 方法
        //      updateDrawState() 自动对字体设置了 LinkColor 和 下划线, 可根据需要自行设置
        // 3. 但是需要配合 textView.setMovementMethod(LinkMovementMethod.getInstance()) 才能实现点击链接跳转浏览器的效果
        // 注: URLSpan 继承自 ClickableSpan
        return null;
    }

    /**
     * 下划线
     */
    public static UnderlineSpan underlineSpan() {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        return null;
    }

    /**
     * 删除线
     */
    public static StrikethroughSpan strikethroughSpan() {
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        return null;
    }

    /**
     * 上标, 一般在数学公式中会用到
     */
    public static SuperscriptSpan superscriptSpan() {
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        return null;
    }

    /**
     * 下标, 一般在数学公式中会用到
     */
    public static SubscriptSpan subscriptSpan() {
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        return null;
    }

    /**
     * 将字符串中的 "\t" 替换成相应的空行
     */
    public static TabStopSpan.Standard tabStopSpan() {
        TabStopSpan.Standard tabStopSpan = new TabStopSpan.Standard(100); // 参数: "\t"(tab) 的偏移量
        return null;
    }

    /**
     * 横向缩放
     */
    public static ScaleXSpan scaleXSpan() {
        // 参数: 缩放比例
        ScaleXSpan scaleXSpan = new ScaleXSpan(10);
        return null;
    }

    /**
     * 文字对齐方式
     */
    public static AlignmentSpan.Standard alignmentSpan() {
        // 参数: 对齐方式
        // [ALIGN_NORMAL:正常; ALIGN_OPPOSITE:反向对齐; ALIGN_CENTER:居中对齐]
        AlignmentSpan.Standard alignmentSpan = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
        return null;
    }

    /**
     * 文本缩进
     */
    public static LeadingMarginSpan.Standard leadingMarginSpan() {
        // 参数1: 所有行缩进量
        LeadingMarginSpan.Standard leadingMarginSpan1 = new LeadingMarginSpan.Standard(4);
        // 参数1: 首行缩进量
        // 参数2: 其余行缩进量
        LeadingMarginSpan.Standard leadingMarginSpan2 = new LeadingMarginSpan.Standard(8, 4);
        return null;
    }

    /**
     * 插入图片
     */
    public static ImageSpan imageSpan() {
        ImageSpan imageSpan1 = new ImageSpan(Getter.context, Getter.bitmap);
        // 参数3: 图片在竖直方向的对齐方式; [ALIGN_BOTTOM:底部对齐; ALIGN_BASELINE:基线对齐]
        ImageSpan imageSpan2 = new ImageSpan(Getter.context, Getter.bitmap, ImageSpan.ALIGN_BASELINE);
        ImageSpan imageSpan3 = new ImageSpan(Getter.drawable);
        ImageSpan imageSpan4 = new ImageSpan(Getter.context, Getter._int);
        return null;
    }

    /**
     * 插入图片 + Margin
     * 默认该行文本顶部对齐, 并会将行高撑开
     */
    public static IconMarginSpan iconMarginSpan() {
        IconMarginSpan iconMarginSpan = new IconMarginSpan(Getter.bitmap);
        // 图片和文本之间的间距
        IconMarginSpan iconMarginSpan2 = new IconMarginSpan(Getter.bitmap, 60);
        return null;
    }

    /**
     * 插入图片 + Margin
     * 默认该行文本顶部对齐, 并会将行高撑开
     * 与 IconMarginSpan 很相似
     * 测试发现的不同为: IconMarginSpan 的相隔两行之间的图片更紧凑些, 贴在一起
     */
    public static DrawableMarginSpan drawableMarginSpan() {
        DrawableMarginSpan drawableMarginSpan1 = new DrawableMarginSpan(Getter.drawable);
        // 图片和文本之间的间距
        DrawableMarginSpan drawableMarginSpan2 = new DrawableMarginSpan(Getter.drawable, 60);
        return null;
    }

    /**
     * 蒙层效果
     */
    public static MaskFilterSpan maskFilterSpan() {
        // BlurMaskFilter->模糊效果; EmbossMaskFilter->浮雕效果
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(3, BlurMaskFilter.Blur.OUTER));
        return null;
    }
}

package com.linsh.code.view.textview;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/12
 *    desc   :
 * </pre>
 */
public class LearnLayingOutTextView {
}
/*

<TextView
    android:autoLink="web|email|phone"  // 是否识别为可点击的链接 (默认可点击, 可配合 linksClickable 使用)
    android:drawableLeft="..."          // 左侧图片
    android:drawablePadding="5dp"       // 图片和文字的距离
    android:drawableStart="..."         // 开始处图片 (适配从右到左的阅读习惯语言)
    android:ellipsize="end"             // 省略部分显示方式 [start:开始 end:结尾 middle:中间 marquee:跑马灯 none:不显示]
    android:ems="10"                    // 宽度设置为 N 个字符的宽度 (测试约为汉字字符的宽度) (指定宽度后该项会失效)
    android:includeFontPadding="false"  // 是否包含顶部和底部额外空白 (默认为 true)
    android:lineSpacingExtra="4dp"      // 行间距
    android:lineSpacingMultiplier="1.1" // 行间距倍数(下一行顶部到上一行顶部的距离占单行高度的倍数)
                                        // 默认为1, 为 0 时上下行重合 (大于 1 增加行间距, 小于 1 减小行间距)
                                        // lineSpacingExtra 和 lineSpacingMultiplier 可以同事使用, 两者互不影响
    android:lines="2"                   // 文本行数 (设置两行就显示两行，即使第二行没有数据)
    android:linksClickable="true"       // 链接是否可点击 (配合 autoLink 属性使用)
    android:marqueeRepeatLimit="3"      // 在 ellipsize 为 marquee 模式下, 重复滚动的次数 [marquee_forever: 无限重复]
    android:maxLength="30"              // 最大文本长度，超出部分不显示也不计算
    android:maxLines="3"                // 最大显示行数 (存在 lines 时这个属性失效)
    android:minLines="1"                // 最小显示行数
    android:scrollHorizontally="true"   // marquee 模式下, 是否出现横拉条 (测试时并没有出现...)
    android:shadowColor="#00F"          // 文字阴影颜色 (需要配合 shadowRadius 使用)
    android:shadowDx="-4"               // 文字阴影横向坐标偏移
    android:shadowDy="4"                // 文字阴影纵向坐标偏移
    android:shadowRadius="10"           // 文字阴影半径
    android:textAlignment="center"      // 文字对齐 (默认 center 居中对齐)
    android:textAllCaps="false"         // 是否全部大写 (true 时小写英文字母自动变大写)
    android:textAppearance="..."        // 字体外观
    android:textColor="#F00"            // 字体颜色
    android:textColorLink="#0F0"        // 文字链接的颜色
    android:textSize="20sp"             // 字体大小
    android:textStyle="normal"          // 字体样式 [normal:正常, bold:粗体, italic:斜体]
    />

*/
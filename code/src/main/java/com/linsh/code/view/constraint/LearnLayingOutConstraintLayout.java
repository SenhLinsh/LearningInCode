package com.linsh.code.view.constraint;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/16
 *    desc   :
 * </pre>
 */
public class LearnLayingOutConstraintLayout {
}

// ####### ConstraintLayout XML 属性详解 ########
/*

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <View
        android:layout_width="0dp"
        android:layout_height="40dp"

        // 控制上下左右边的约束
        app:layout_constraintLeft_toLeftOf="parent"             // 产生约束: 左边和指定控件的左边
        app:layout_constraintLeft_toRightOf="@id/guideline1"    // 产生约束: 左边和指定控件的右边
        app:layout_constraintRight_toLeftOf="@id/guideline1"    // 产生约束: 右边和指定控件的左边
        app:layout_constraintRight_toRightOf="parent"           // 产生约束: 右边和指定控件的右边
        app:layout_constraintStart_toEndOf="@id/guideline1"     // 产生约束: 开始边和指定控件的结束边
        app:layout_constraintStart_toStartOf="parent"           // 产生约束: 开始边和指定控件的开始边
        app:layout_constraintEnd_toEndOf="parent"               // 产生约束: 结束边和指定控件的结束边
        app:layout_constraintEnd_toStartOf="@id/guideline1"     // 产生约束: 结束边和指定控件的开始边
        app:layout_constraintTop_toBottomOf="@id/guideline2"    // 产生约束: 顶边和指定控件的底边
        app:layout_constraintTop_toTopOf="parent"               // 产生约束: 顶边和指定控件的顶边
        app:layout_constraintBottom_toBottomOf="parent"         // 产生约束: 底边和指定控件的底边
        app:layout_constraintBottom_toTopOf="@+id/guideline2"   // 产生约束: 底边和指定控件的顶边

        // 控制基线的约束
        app:layout_constraintBaseline_toBaselineOf="parent"     // 产生约束: 基线和指定控件的基线

        // 控制宽高比
        app:layout_constraintDimensionRatio="2:1"               // 宽:高 = 2:1 (要求宽高值有一项为0)
        // 辅助控制高度
        app:layout_constraintHeight_default="spread"            // 默认高度 [spread:相当于match_parent, wrap:相当于wrap_content]
        app:layout_constraintHeight_max="50dp"                  // 最大高度
        app:layout_constraintHeight_min="30dp"                  // 最小高度
        // 辅助控制宽度
        app:layout_constraintWidth_default="spread"             // 默认宽度
        app:layout_constraintWidth_max="50dp"                   // 最大宽度
        app:layout_constraintWidth_min="30dp"                   // 最小宽度
        // 控制水平约束
        app:layout_constraintHorizontal_bias="0.5"              // 水平约束的偏移 (0为左侧, 0.5居中, 1为右侧)
        app:layout_constraintHorizontal_chainStyle="spread"     // 群组关联样式 [spread:展开,存在多余空间则平分(默认); spread_inside:展开,存在多余空间,两端不占空间,其余平分; packed:包裹,群组两侧产生约束使它们聚集在一起]
        app:layout_constraintHorizontal_weight="1"              // 群组关联样式为 spread 或 spread_inside 时, 各 View 平分剩余空间的权重
        // 控制垂直约束
        app:layout_constraintVertical_bias="0.5"                // 同理于控制水平约束
        app:layout_constraintVertical_chainStyle="spread"       // 同理于控制水平约束
        app:layout_constraintVertical_weight="1"/>              // 同理于控制水平约束

        // 群组: View 之间互相约束, 会产生相互影响, 组成一个"群组".
        // 群组中的第一个 View 被称之为 Chain head, 由它控制着整个群组的属性
        // 包括 chainStyle & bias & weight

    <android.support.constraint.Guideline
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"                      // 控制参考线的方向
        app:layout_constraintGuide_begin="60dp"             // 参考线距离开始位置的绝对位置
        app:layout_constraintGuide_end="60dp"               // 参考线距离结束位置的绝对位置
        app:layout_constraintGuide_percent="0.66"/>         // 参考线相对位置

</android.support.constraint.ConstraintLayout>

 */


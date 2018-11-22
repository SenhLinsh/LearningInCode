package com.linsh.code.service.accessibility;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

import com.linsh.code._.Getter;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/02/02
 *    desc   : 当用户界面发生某些明显的事件时，AccessibilityEvent代表的无障碍事件会被系统发送，每一种事件类型是由该类暴露出的属性子集表示其特征的。
 *             在此类中为每一种事件类型定义了相应的常量。详细的事件类型请参照 AccessibilityEvent 文档 Zh : http://www.siaa.org.cn/home/content/sharedetail/aid/1142。
 *
 *             注释参考: https://www.jianshu.com/p/ef01ce654302
 * </pre>
 */
public class LearnUsingAccessibilityEvent {

    public static void constant() {
        int i = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void demo(AccessibilityEvent event) {
        // 将AccessibilityRecord(AccessibilityRecord使用pdf文档 Zh)追加到事件记录的结尾。
        event.appendRecord(Getter.accessibilityEvent);
        // 获取给定索引下的记录。
        event.getRecord(Getter._int);
        // 获取被包含在事件中的记录数。
        event.getRecordCount();
        // 描述被包含在 Parcelable 实例的编组表示中的特殊对象种类。
        // 例如，如果对象在 writeToParcel(Parcel, int)的输出里包括一个文件描述符，该方法的返回值必须包括 CONTENTS_FILE_DESCRIPTOR 位。
        event.describeContents();
        // 获取事件类型。
        event.getEventType();
        // 设置事件类型。
        event.setEventType(Getter._int);
        // 返回一个事件类型的字符串表示。例如，TYPE_VIEW_CLICKED 的字符串表示为“TYPE_VIEW_CLICKED”。
        event.eventTypeToString(Getter._int);
        // 获取触发该事件的执行操作。
        event.getAction();
        // 获取由 TYPE_WINDOW_CONTENT_CHANGED 事件标识的改变类型的位掩码。一个单一事件可能代表多种变化类型。
        event.getContentChangeTypes();
        // 获取该事件的发送时间。
        event.getEventTime();
        // 设置事件被发送的时间。
        event.setEventTime(Getter._int);
        // 获取遍历的移动粒度。
        event.getMovementGranularity();
        // 设置遍历的移动粒度。
        event.setMovementGranularity(Getter._int);
        // 获取源的包名。
        event.getPackageName();
        // 设置源的包名。
        event.setPackageName(Getter.text);
        // 从 Parcel 创建一个新实例。
        event.initFromParcel(Getter.parcel);
        // 如果可获得，返回一个缓存实例或创建一个新实例。返回实例从给定事件初始化。
        event.obtain(Getter.accessibilityEvent);
        // 如果可获得，返回一个缓存实例或实例化一个新的。
        event.obtain();
        // 如果可获得，返回一个缓存实例或实例化一个新的并设置它的类型属性。
        event.obtain(Getter._int);
        // 回收一个实例重复使用。
        event.recycle();
        // 设置触发此事件的执行操作。
        event.setAction(Getter._int);
        // 设置由一个 TYPE_WINDOW_CONTENT_CHANGED 事件标识的节点树改变的位掩码。
        event.setContentChangeTypes(Getter._int);
        // 返回对象的字符串表示。一般情况下，toString 方法返回一个“文本表示”该对象的字符串。结果应该是一个简洁但容易阅读的信息表示。建议所有子类重写该方法。
        event.toString();
        // 整组该对象到一个 Parcel。
        event.writeToParcel(Getter.parcel, Getter._int);
    }
}

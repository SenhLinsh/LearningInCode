package com.linsh.code.service.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;

import com.linsh.code.R;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/02/02
 *    desc   : AccessibilityService 配置信息
 *
 *             注释参考自: https://www.jianshu.com/p/ef01ce654302
 * </pre>
 */
public class DemoAccessibilityServiceInfo {

    public static void demo(AccessibilityServiceInfo info) {
        // 设置 AccessibilityService 相关信息的配置, 可以在 xml 中配置或者 AccessibilityService 的 onServiceConnected() 中配置
        // 但部分 xml 中可以配置的属性在 AccessibilityService 的 onServiceConnected() 中无法配置, 所以建议使用 xml 进行配置, 在代码中进行动态修改
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED | AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.notificationTimeout = 100;
        info.packageNames = new String[]{"com.linshode"};

        // 相关属性和方法的解释和说明在 xml 配置文件中, 详见以下 ↓↓↓↓↓
        int xml = R.xml.accessibility_service_config;
    }
}

package com.linsh.code.service.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.linsh.code.R;

import java.util.List;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/02/02
 *    desc   : 辅助功能 / 无障碍服务
 *
 *             注释参考自: https://www.jianshu.com/p/ef01ce654302
 * </pre>
 */
public class LearnExtendingAccessibilityService extends AccessibilityService {

    @Override
    public void onCreate() {
        super.onCreate();
        //////////////////// AccessibilityService 的相关方法和解释, 详见 LearnUsingAccessibilityService ////////////////////////
        LearnUsingAccessibilityService.demo(this);
    }

    /**
     * 该方法在初始化辅助功能服务时调用，可以在这时做相应的初始化工作。
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        // 可以在这里获取配置文件的相关配置(AccessibilityServiceInfo), 或者直接在这里初始化它
        AccessibilityServiceInfo info = getServiceInfo();
        if (info == null) info = new AccessibilityServiceInfo();
        // ... set something
        setServiceInfo(info);
        ////////////////// AccessibilityServiceInfo 属性的设置详见 LearnUsingAccessibilityServiceInfo //////////////////////
        LearnUsingAccessibilityServiceInfo.demo(info);
    }

    /**
     * 在获取到指定的监听事件时，通过回调这个方法来进行对应的操作
     *
     * @param event AccessibilityEvent
     */
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //////////////////////// AccessibilityEvent 的相关使用方法, 详见 LearnUsingAccessibilityEvent ///////////////////////
        LearnUsingAccessibilityEvent.demo(event);

        //================================================ 使用示范 ================================================//
        // 获取事件类型
        int eventType = event.getEventType();
        // 判断事件类型, 作相应处理
        switch (eventType) {
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                // 通知栏状态变化, 如收到推送或消息通知
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                // 窗口状态发生变化
                break;
            default:
                // 其他还有好多类型, 需要自己一一实现, 相关类型说明, 请见 xml 配置文件中 accessibilityEventTypes 的内容说明
                int xml = R.xml.accessibility_service_config; // ←←←← 点击这里查看
                break;
        }
        // 将事件类型转为字符串方式
        String typeToString = AccessibilityEvent.eventTypeToString(eventType);
        // 获取包名 (判断当前界面的应用)
        CharSequence packageName = event.getPackageName();
        // 获取类名 (判断当前界面或内容)
        CharSequence className = event.getClassName();
        // 判断或打印事件的相关信息: 类型, 包名, 类名
        Log.i("LearnExtendingAccessibilityService", "onAccessibilityEvent: ");

        // 通过以上的判断, 就可以有选择地获取想要的节点信息 (需要过滤指定类型/指定应用/指定界面)
        if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED // 窗口发生变化, 如跳转到该界面
                && packageName.equals("com.linsh.code") // 是 LearningInCode 应用的界面
                && className.equals("com.linsh.code.MainActivity") // 是 MainActivity
                ) {
            // 获取 AccessibilityNodeInfo
            AccessibilityNodeInfo info;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2)
                info = event.getSource();
            else
                info = event.getSource();

            // 查找指定的节点
            List<AccessibilityNodeInfo> infos = info.findAccessibilityNodeInfosByText("Text"); // 根据 text 查找
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                infos = info.findAccessibilityNodeInfosByViewId("com.linsh.code:id/tv_code"); // 根据 id 查找
            }
            // 遍历子节点, 查找
            for (int i = 0; i < info.getChildCount(); i++) {
                AccessibilityNodeInfo child = info.getChild(i);
                if (child.getText().toString().equals("Text")) {
                    // do something
                    // 遍历所有节点需要用到递归, 这里就不演示了
                }
            }
            // 查到子节点后, 可以对节点进行操作
            info = infos.get(0);
            if (info.isClickable()) {
                info.performAction(AccessibilityNodeInfo.ACTION_CLICK); // 点击事件
            }
            info.getBoundsInScreen(new Rect()); // 获取节点在屏幕中的位置

            ///////////////// AccessibilityNodeInfo 相关方法和说明, 详见 LearnUsingAccessibilityNodeInfo //////////////////////
            LearnUsingAccessibilityNodeInfo.demo(info);
        }
    }

    /**
     * 系统想要中断辅助功能时会调用该方法
     */
    @Override
    public void onInterrupt() {

    }
}

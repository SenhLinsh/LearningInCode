package com.linsh.code.service.accessibility;

import android.accessibilityservice.AccessibilityButtonController;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.FingerprintGestureController;
import android.annotation.TargetApi;
import android.os.Build;

import com.linsh.code.nothing.Getter;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/02/02
 *    desc   :
 *
 *             注释参考: https://www.jianshu.com/p/ef01ce654302
 * </pre>
 */
public class DemoAccessibilityService {

    public static void constant() {
        int global;
        global = AccessibilityService.GLOBAL_ACTION_BACK; // 相当于点击物理按键返回
        global = AccessibilityService.GLOBAL_ACTION_HOME; // 相当于点击物理按键Home键
        global = AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS; // 相当于下滑打开通知
        global = AccessibilityService.GLOBAL_ACTION_RECENTS; // 相当于点击物理按键最近任务键
        global = AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS; // 打开快速设置
        global = AccessibilityService.GLOBAL_ACTION_POWER_DIALOG; // 打开长按电源键的弹框
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void demo(AccessibilityService service) {
        //================================================ API 20 ================================================//
        // 获取窗体中的节点信息
        service.getRootInActiveWindow();
        // 获取本服务的配置信息
        service.getServiceInfo();
        // 辅助功能事件(s)回调方法
        service.onAccessibilityEvent(Getter.accessibilityEvent);
        // service的bind接口
        service.onBind(Getter.intent);
        // 辅助功能中断的回调
        service.onInterrupt();
        // 全局的点击方法
        service.performGlobalAction(Getter._int);
        // 设置该辅助功能服务的描述，修改辅助功能的配置。可通过搭配使用getServiceInfo()动态修改我们辅助功能的配置
        service.setServiceInfo(null);

        //================================================ API 21新增： ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 返回窗口最上层的一个用户可交互的窗口信息节点 List<AccessibilityWindowInfo>
            service.getWindows();
        }

        //================================================ API 24新增： ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // 关闭自己service的方法，在设置界面可以看到辅助功能状态被关闭
            service.disableSelf();
            // 返回软键盘控制器，可用于查询和修改软键盘显示模式。
            service.getSoftKeyboardController();
            // 找到具有指定焦点类型的视图。搜索在所有窗口中执行。
            // 注意：为了访问Windows，您的服务必须通过在其元数据中设置AccessibilityService_canRetrieveWindowContent属性来声明检索窗口内容的功能。
            // 有关详细信息，请参阅SERVICE_META_DATA。
            // 此外，服务必须选择通过设置FLAG_RETRIEVE_INTERACTIVE_WINDOWS标志来检索交互式窗口。否则，搜索将仅在活动窗口中执行。
            service.findFocus(Getter._int);
            // 返回放大控制器，可用于查询和修改显示放大的状态。
            // 注意：为了控制放大倍数，您的服务必须通过在其元数据中设置AccessibilityService_canControlMagnification属性来声明该功能
            service.getMagnificationController();
            // 将手势发送到触摸屏。
            // 目前正在进行的任何手势（无论是从用户，本服务还是其他服务）将被取消。 手势将被调度，就像在用户直接在屏幕上执行的一样，因此事件可能会受到诸如放大和触摸探索之类的功能的影响。
            service.dispatchGesture(Getter.gestureDescription, Getter.gestureResultCallback, Getter.handler);
        }

        //================================================  ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 返回系统导航区域中可访问性按钮的控制器。
            // 当设置FLAG_REQUEST_ACCESSIBILITY_BUTTON时，此实例可用于查询辅助功能按钮的状态并注册监听器以进行交互和辅助功能按钮的状态更改。
            AccessibilityButtonController controller = service.getAccessibilityButtonController();
            // 获取控制器的指纹手势。
            // 此功能需要 AccessibilityServiceInfo＃CAPABILITY_CAN_CAPTURE_FINGERPRINT_GESTURES。
            // 注意：在调用此方法之前，必须先启动该服务
            FingerprintGestureController controller1 = service.getFingerprintGestureController();
        }
    }

}

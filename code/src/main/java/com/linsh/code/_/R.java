package com.linsh.code._;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/11/22
 *    desc   :
 * </pre>
 */
public class R {

    public static class xml {

        public static class accessibility_service_config {

            /*
                <!--这里是 AccessibilityService 的相关配置-->
                <!--以下配置在 AccessibilityService 中表现为 AccessibilityServiceInfo 的相关属性-->
                <!--可以在 AccessibilityService 的 onServiceConnected() 方法中获取这些配置, 或重新设置相关配置-->
                <!--注释参考自: https://www.jianshu.com/p/ef01ce654302-->

                <accessibility-service
                    android:accessibilityEventTypes=""                  // 此服务希望接收的事件类型 (具体选项见下方解释)
                    android:accessibilityFeedbackType=""                // 此服务提供的反馈类型 (具体选项见下方解释)
                    android:accessibilityFlags=""                       // 辅助功能附加的标志 (具体选项见下方解释)
                    android:canRequestEnhancedWebAccessibility="true"   // 辅助功能服务是否能够请求WEB辅助增强的属性。例如: 安装脚本以使应用程序内容更易于访问
                    android:canRequestFilterKeyEvents="true"            // 辅助功能服务是否能够请求过滤KeyEvent的属性，是否可以请求KeyEvent事件流。搭配 flagRequestFilterKeyEvents 使用
                    android:canRequestTouchExplorationMode="true"       // 用于能够让辅助功能服务通过手势来请求触摸浏览模式，其被触摸的项将被朗读出来，搭配 flagRequestTouchExplorationMode 使用
                    android:canRetrieveWindowContent="true"             // 辅助功能服务是否能够取回活动窗口内容的属性。 与 accessibilityFlags 的 flagRetrieveInteractiveWindows 搭配使用，无法在运行时更改此设置。
                    android:description=""                              // 辅助功能服务目的或行为的简短描述。
                    android:notificationTimeout="100"                   // 同一类型的两个辅助功能事件发送到服务的最短间隔（毫秒，两个辅助功能事件之间的最小周期）(通过间隔来过滤频繁的事件, 以防操作过于频繁)
                    android:packageNames=""                             // 从此服务能接收到事件的软件包名称 (不适合所有软件包)（多个软件包用逗号分隔）
                    android:settingsActivity=""                         // 允许用户修改辅助功能的activity组件名称
                    android:summary=""/>                                // 同 description

                <!--//////////////////////////////////////////////  选项解释  /////////////////////////////////////////////////////-->
                accessibilityEventTypes :

                constant                                      描述
                typeAllMask                                   所有类型的事件
                typeAnnouncement                              一个应用产生一个通知事件
                typeAssistReadingContext                      辅助用户读取当前屏幕事件
                typeContextClicked                            view中上下文点击事件
                typeGestureDetectionEnd                       监测到的手势事件完成
                typeGestureDetectionStart                     开始手势监测事件
                typeNotificationStateChanged                  收到notification弹出消息事件
                typeTouchExplorationGestureEnd                触摸浏览事件完成
                typeTouchExplorationGestureStart              触摸浏览事件开始
                typeTouchInteractionEnd                       用户触屏事件结束
                typeTouchInteractionStart                     触摸屏幕事件开始
                typeViewAccessibilityFocusCleared             无障碍焦点事件清除
                typeViewAccessibilityFocused                  获得无障碍的焦点事件
                typeViewClicked                               点击事件
                typeViewFocused                               view获取到焦点事件
                typeViewHoverEnter                            一个view的悬停事件
                typeViewHoverExit                             一个view的悬停事件结束，悬停离开该view
                typeViewLongClicked                           view的长按事件
                typeViewScrolled                              view的滚动事件，adapterview、scrollview
                typeViewSelected                              view选中，一般是具有选中属性的view，例如adapter
                typeViewTextChanged                           edittext中文字发生改变的事件
                typeViewTextSelectionChanged                  edittext文字选中发生改变事件
                typeViewTextTraversedAtMovementGranularity    UIanimator中在一个视图文本中进行遍历会产生这个事件，多个粒度遍历文本。一般用于语音阅读context
                typeWindowContentChanged                      窗口的内容发生变化，或者更具体的子树根布局变化事件
                typeWindowStateChanged                        新的弹出层导致的窗口变化（dialog、menu、popupwindow）
                typeWindowsChanged                            屏幕上的窗口变化事件，需要API 21+

                ## accessibilityFeedbackType :

                feedbackAllMask     取消所有的可用反馈方式
                feedbackAudible     可听见的（非语音反馈）
                feedbackGeneric     通用反馈
                feedbackHaptic      触觉反馈（震动）
                feedbackSpoken      语音反馈
                feedbackVisual      视觉反馈

                ## accessibilityFlags :

                flagDefault                               默认的配置
                flagEnableAccessibilityVolume             这个标志要求系统内所有的音频通道，使用由STREAM_ACCESSIBILTY音量控制USAGE_ASSISTANCE_ACCESSIBILITY
                flagIncludeNotImportantViews              表示可获取到一些被表示为辅助功能无权获取到的view
                flagReportViewIds                         使用该flag表示可获取到view的ID
                flagRequestAccessibilityButton            如果辅助功能可用，提供一个辅助功能按钮在系统的导航栏 API 26+
                flagRequestEnhancedWebAccessibility       此类扩展的目的是为WebView中呈现的内容提供更好的辅助功能支持。这种扩展的一个例子是从一个安全的来源注入JavaScript。如果至少有一个具有此标志的辅助功能服务, 则系统将使能增强的web辅助功能。因此, 清除此标志并不保证该设备不会使能增强的web辅助功能, 因为可能有另一个使能的服务在使用它。
                flagRequestFilterKeyEvents                能够监听到系统的物理按键
                flagRequestFingerprintGestures            监听系统的指纹手势 API 26+
                flagRequestTouchExplorationMode           系统进入触控探索模式。出现一个鼠标在用户的界面
                flagRetrieveInteractiveWindows            该标志知识的辅助服务要访问所有交互式窗口内容的系统，这个标志没有被设置时，服务不会收到TYPE_WINDOWS_CHANGE事件。
            */

        }

    }
}

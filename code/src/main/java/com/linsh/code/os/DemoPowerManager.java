package com.linsh.code.os;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.RequiresPermission;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/04/03
 *    desc   : 参考博客:
 *              https://blog.csdn.net/sunjing_/article/details/51880023
 *              https://www.aliyun.com/jiaocheng/13968.html?spm=5176.100033.1.24.BbCRhY
 * </pre>
 */
public class DemoPowerManager {

    @RequiresPermission(Manifest.permission.WAKE_LOCK)
    public static void demo(Context context) {
        // 获取 PowerManager
        PowerManager powerManager = (PowerManager) context.getSystemService(Service.POWER_SERVICE);
        /*
        * 创建 WakeLock 锁
        *
        * 参数1: WakeLock 锁类型
        *               锁类型                     cpu     screen      Keyboard    电源键影响       应用情景
        *    PARTIAL_WAKE_LOCK                   On       Off          Off         不受     听音乐，后台下载等
        *    FULL_WAKE_LOCK  (过时)               On      Bright        On           受      来电话，闹钟触发等
        *    SCREEN_DIM_WAKE_LOCK (过时)          On       Dim          Off          受     即将进入灭屏休眠状态时
        *    SCREEN_BRIGHT_WAKE_LOCK (过时)       On      Bright        Off          受       看电子书，看视频
        *    PROXIMITY_SCREEN_OFF_WAKE_LOCK      Off   Bright/Off      Off          受     打电话靠近或远离手机时 (需要设备支持距离传感器，不能和 ACQUIRE_CAUSES_WAKEUP 一起用)
        *    ACQUIRE_CAUSES_WAKEUP               正常情况下，获取wakelock是不会唤醒设备的，加上该标志之后，acquire wakelock也会唤醒设备，该标志常用于闹钟触发，蓝牙链接提醒等场景。(不能和PARTIAL_WAKE_LOCK 一起用)
        *    ON_AFTER_RELEASE                    和用户体验有关，当wakelock释放后如果没有该标志，屏幕会立即黑屏，如果有该标志，屏幕会亮一小会然后在黑屏。(不能和PARTIAL_WAKE_LOCK 一起用)
        *
        *   锁类型中有三个是已过时的方法, 也就是一般情况下不建议使用, 因为 Google 为我们提供了其他的方案, 也就是使用 WindowManager.LayoutParams 的一个参数 FLAG_KEEP_SCREEN_ON 来替换上述三种类型的锁
        *   它更方便我们隐式对屏幕的亮度状态做正确的管理, 同事也不需要申请 WAKE_LOCK 权限
        *   使用方法为: activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        *
        * 参数2: 标志 (目前所知的作用为崩溃时日志中识别在哪里创建的锁)
        */
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "Tag");
        wakeLock(wakeLock);
        // 判断当前屏幕是否亮着,只要不是锁屏状态,都算亮着。而同时在 API 20 中被废弃, 推荐使用 isInteractive()
        boolean screenOn = powerManager.isScreenOn();
        // 判断当前屏幕是否亮着,在 API 20 中被添加
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            boolean interactive = powerManager.isInteractive();
        }
        // 因为有一些 Level 需要权限才能获取, 所以这个方法用于检查当前是否有 level 权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            powerManager.isWakeLockLevelSupported(PowerManager.PARTIAL_WAKE_LOCK);
        }
        // 重启设备, 需要 Manifest.permission.REBOOT 权限, 这是一个系统权限。
        powerManager.reboot("something is going wrong with your system");
        // 判断当前设备是否处于省电模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            powerManager.isPowerSaveMode();
        }
        // 判断当前设备是否处于空闲状态。在空闲状态下,我们可以做一些后台操作。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            powerManager.isDeviceIdleMode();
        }
    }

    public static void wakeLock(PowerManager.WakeLock wakeLock) {
        /*
        * 设置计数锁和非计数锁
        * 计数锁是应用调用一次acquire申请必定会对应一个release来释放；
        * 非计数锁应用调用多次acquire，调用一次release就可释放前面acquire的锁。在申请wakelock时默认申请的是计数锁。
        */
        wakeLock.setReferenceCounted(false);
        // 判断一个wakelock锁是否acquire申请了，但是没有release释放；
        boolean held = wakeLock.isHeld();
        // 申请锁
        wakeLock.acquire(); // 申请 wakelock永久锁（默认），需要手动release
        wakeLock.acquire(1000); // 申请wakelock超时锁，timeout为设置的超时时间，超时自动release掉该wakelock。
        // 释放锁
        wakeLock.release();
    }


}

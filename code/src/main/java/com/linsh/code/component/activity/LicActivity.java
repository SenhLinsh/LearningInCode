package com.linsh.code.component.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/04/04
 *    desc   :
 * </pre>
 */
public class LicActivity extends Activity {

    /**
     * 启动 Activity 时的回调, 用于处理大部分的初始化, 如调用 {@link #setContentView(int)} 来填充 UI 布局, 使用
     * {@link #findViewById} 来查找控件
     *
     * @param savedInstanceState 如果该 Activity 被系统关闭, 且在 {@link #onSaveInstanceState} 中保存了相关数据, 在系统重新初始化就会包含这些数据
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 同 {@link #onCreate(android.os.Bundle)}, 但只有在属性 {@link android.R.attr#persistableMode} 为 <code>persistAcrossReboots</code> 时才会被调用
     * (在 Manifest 中注册 Activity 时加上 <code>android:persistableMode="persistAcrossReboots"</code> )
     *
     * @param savedInstanceState 如果该 Activity 被系统关闭, 且在 {@link #onSaveInstanceState} 中保存了相关数据, 在系统重新初始化就会包含这些数据
     * @param persistentState    如果该 Activity 被系统关闭或关机, 且在 {@link #onSaveInstanceState(Bundle, PersistableBundle)} 中保存了相关数据, 在系统重新初始化就会包含这些数据
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * 在 {@link #onStop} 之后调用, 如果当前 Activity 被用户重现展示的话(用户导航回来). 接下来会调用 {@link #onStart} 以及 {@link #onResume}.
     * <p>
     * <p>对于使用原始 {@link android.database.Cursor} 对象而不是通过 {@link #managedQuery(android.net.Uri, String[], String, String[], String)} 创建的
     * Activity, 这里通常用于 cursor 的重新查询 (因为已经在 {@link #onStop} 被停用)
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * 在 {@link #onCreate} 或 {@link #onRestart} (如果 Activity 被停止(stopped), 且当前重新展现出来) 之后调用. 随后会调用 {@link #onResume}.
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 在 {@link #onRestoreInstanceState}, {@link #onRestart}, 或 {@link #onPause} 之后被调用, 示意 Activity 可以和用户进行交互.
     * 这里非常适合用于开启动画, 打开设备(如相机) 等等
     * <p>
     * <P>注意 onResume 不是 Activity 对用户可见的最好指标, 此时可能会有譬如锁屏的系统窗口在前面,
     * 使用 {@link #onWindowFocusChanged} 来确认Activity 对用户可见(例如恢复游戏)</P>
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 生命周期的一部分, 示意 Activity 正在进入后台, 但还没有被杀死. 对应的方法是 {@link #onResume}
     * <p>
     * <P>当 Activity B 出现在 Activity A 前面时, A 会调用这个回调. 且在 A 调用 onPause 之后才会被创建, 所以尽量不要使用过多冗余的代码 </P>
     * <p>
     * <P>这个回调大部分情况下可以用来 Activity 编辑的任何持久状态, 也可以用来停止动画和其他明显消耗 CPU 的事情等, 以保证尽可能快地切换到下一个 Activity,
     * 或者关闭独家的资源访问, 如相机</P>
     * <p>
     * <P>在一些系统需要更多内存的情况下, 可能会杀死 paused 状态下的进程. 正因如此, 你应该确保当前状态在该方法结束之前被及时的保存.
     * 一般  {@link #onSaveInstanceState} 就是用于保存 Activity 中的每个实例状态, 并且这个方法用于保存全局的持久性数据(包括内容提供者, 文件等)</P>
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 当 Activity 不再对用户可见时显示.
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 在 Activity 销毁之前执行所有最终的清理. 这个回调的发生可能是是 Activity 调用了 {@link #finish}, 也可能是系统暂时销毁了 Activity 的实例
     * 以节省空间. 你可以使用 {@link #isFinishing} 来区分这两种情况
     * <p>
     * <P>注意: 不要指望这个方法是用于保存数据的地方! 例如, 如果使用内容提供者修改数据, 这些修改应该在 {@link #onPause} 或者 {@link #onSaveInstanceState} 被提交, 而不应该在这里.
     * 这个方法一般用于执行释放资源(如和 Activity 绑定的线程). 系统有可能会在没有调用该方法(或其他的任何方法) 的情况下简单明了地杀死该 Activity 所在的进程, 所以不应该被用来做一些意图
     * 在进程结束后保留的操作</P>
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 该方法在 {@link #onStart} 之后调用, 当 Activity 正在通过之前保存 {@link #onSaveInstanceState} 的数据初始化. 大部分情况将简单地通过 {@link #onCreate}
     * 来实现恢复状态, 但有时可以方便地在这里处理所有初始化完毕之后的事情.
     * <p>
     * <p>该方法在 {@link #onStart} 和 {@link #onPostCreate} 之间调用.
     *
     * @param savedInstanceState 最近的通过 {@link #onSaveInstanceState} 提交的数据
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * 同 {@link #onRestoreInstanceState(Bundle)}, 不过是被 {@link android.R.attr#persistableMode} 设置为 <code>persistAcrossReboots</code>
     * 的 Activity 调用.
     *
     * @param savedInstanceState 最近的通过 {@link #onSaveInstanceState} 提交的数据
     * @param persistentState    最近的通过 {@link #onSaveInstanceState} 提交的数据
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    /**
     * 用于在 Activity 被杀死之前回收每个实例的状态, 以便这些这些状态可以在 {@link #onCreate} 或者 {@link #onRestoreInstanceState} 中恢复.
     * <p>
     * <p>该方法在 Activity 可能被杀死之前调用, 以便在之后某些时候回来之后可以恢复它的状态. 例如, 如果 Activity B 启动在 Activity A 之上, 在
     * 某些时候, Activity A 会被杀死以回收资源, Activity A 会有一次通过该方法保存用户界面状态的机会, 所以当用户回到 Activity A 时可以通过
     * {@link #onCreate} 或 {@link #onRestoreInstanceState} 恢复这些状态.
     * <p>
     * <p>不要将该方法和 Activity 生命周期回调搞混.
     * <p>
     * <p>默认的实现通过调用 {@link android.view.View#onSaveInstanceState()} 照顾了每个 UI 实例的大部分状态, 并且保存了当前焦点 View 的 id.
     * 如果重写方法去保存没有被捕获的额外信息, 建议调用默认的实现, 否则自己要做好保存每个 View 的所有状态的准备.
     * <p>
     * <p>如果被调用, 该方法会在 {@link #onStop} 之前, 不担保是否会在  {@link #onPause} 之前或者之后调用.
     *
     * @param outState 放置保存状态的 Bundle
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * 同 {@link #onSaveInstanceState(Bundle)}, 不过是被 {@link android.R.attr#persistableMode} 设置为 <code>persistAcrossReboots</code>
     * 的 Activity 调用.
     * <p>
     * <P>传入的 {@link android.os.PersistableBundle} 会被保存并且会在下一次设备重启之后 Activity 重新创建时在
     * {@link #onCreate(Bundle, PersistableBundle)} 中首次出现</P>
     *
     * @param outState           放置保存状态的 Bundle
     * @param outPersistentState 放置设备重启后仍需保存的状态的 PersistableBundle
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    /**
     * 当 activity 启动完成时调用这个方法(在 {@link #onStart} 和 {@link #onRestoreInstanceState} 被调用之后).
     * 系统会在里边做一些最终的初始化, APP 一般不用重写这个方法.
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    /**
     * 通过 {@link #onPostCreate(Bundle)}, 需要 Activity 设置 {@link android.R.attr#persistableMode} 为
     * <code>persistAcrossReboots</code>
     */
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    /**
     * 在 Activity resume 完成之后调用 (在  {@link #onResume} 之后). APP 一般不用重写该方法.
     */
    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    /**
     * 当按键, 触屏, 轨迹球事件分发给 Activity 时调用. 如果你想知道当你的 Activity 正在运行时用户和这个设备交互了, 可以重写这个方法.
     * 该回调和 {@link #onUserLeaveHint} 的用意是帮助 Activity 智能化管理状态栏通知. 特别是帮助 Activity 确定取消通知的适当时间.
     * <p>
     * <P>所有你 Activity {@link #onUserLeaveHint} 回调的调用都会伴随着 {@link #onUserInteraction}. 这确保了你的 Activity 会被
     * 相应的用户活动告知. 例如拉下通知窗格并在那里触摸条目</P>
     * <p>
     * <P>注意该方法会被一个触摸事件的按下操作时调用, 但可能不会在接下来的移动和抬起操作时调用.</P>
     */
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
    }

    /**
     * 作为生命周期回调的一部分, 当在用户选择的结果使 Activity 即将进入后台时, 会调用该方法. 例如, 当用户按下 Home 键,
     * {@link #onUserLeaveHint} 将会被调用, 但当来电时来电界面自动弹出在前台, Activity 被中断时不会调用 {@link #onUserLeaveHint}.
     * 在被调用的情况下, 该方法会在 {@link #onPause} 的前面.
     * <p>
     * <P>该回调和 {@link #onUserInteraction} 的用意是帮助 Activity 智能化管理状态栏通知. 特别是帮助 Activity 确定取消通知的适当时间.
     * <p>
     * <P>注意, 启动一个新的 Activity (包括Dialog或者透明风格的Activity), 前一个 Activity 会回调该方法. 但是如果前一个 Activity 在
     * startActivity() 之前先调用了 finish() 方法, onUserLeaveHint() 是不会调用的 (当然, 如果是之后调用的 finish() 方法, 还是会收到
     * 该回调的)
     */
    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    /**
     * 当设备的配置信息改变时, 如果你的 Activity 这个运行, 会通过系统调用该方法. 注意只有当你在 Manifest 的
     * {@link android.R.attr#configChanges} 属性中设置了想要处理的配置, 该方法才会被调用. 如果任何该属性没有选择的配置发生改变, Activity
     * 将不会进行回调, 而是停止并以新的配置重新启动
     * <p>
     * <p>在该方法被调用时, 你的资源对象会被更新以返回匹配新配置的资源值
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 当 Activity 关联的主窗口附加到 window manager 时调用.
     * 查看 {@link android.view.View#onAttachedToWindow()} 获取更多的信息.
     */
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /**
     * 当 Activity 关联的主窗口脱离 window manager 时调用.
     * 查看 {@link android.view.View#onDetachedFromWindow()} 获取更多的信息.
     */
    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /**
     * 当当前 Activity 的窗口获取或失去焦点时调用. 这里是 Activity 是否对用户可见的最好的指标.
     * <p>
     * <p>注意它提供了独立管理于生命周期的全局焦点状态信息. 因此, 当焦点改变时, 通常会和生命周期改变有所联系(stopped 状态的 Activity
     * 通常不会获取窗口焦点), 你不应该依靠在这个回调和其他生命周期回调(如 {@link #onResume}) 之间的任何特殊的指令.
     * <p>
     * <p>然而作为基本原则, resumed 的 activity 将会拥有焦点, 除非弹出了其他的 Dialog 或 Popup 拿走的输入焦点, 这种情况下 Activity
     * 自身不会拥有焦点, 因为其他窗口已经拥有了. 同样, 系统可能会弹出系统级别的窗口(例如状态栏 通知面板或系统警告) 在没有暂停(pausing)
     * 前台 Activity 的时候暂时抢走了窗口输入焦点.
     *
     * @param hasFocus Activity 的窗口是否拥有焦点
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    /**
     * 用于处理触屏事件. 你可以重写该方法, 在所有的触摸事件被分发到窗口时去拦截它们. 需要正常处理触摸事件时, 请务必调用该父类方法.
     *
     * @param ev 屏幕触摸事件
     * @return 如果事件被消费了, 返回 true
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 用于处理按键事件. 使用方法类似 {@link #dispatchTouchEvent}
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    /**
     * 用于处理滚轮事件. 使用方法类似 {@link #dispatchTouchEvent}
     */
    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        return super.dispatchGenericMotionEvent(ev);
    }

    /**
     * 用于处理快捷键事件. 使用方法类似 {@link #dispatchTouchEvent}
     */
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    /**
     * 用于处理轨迹球事件. 使用方法类似 {@link #dispatchTouchEvent}
     */
    @Override
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        return super.dispatchTrackballEvent(ev);
    }

    /**
     * 用于处理辅助功能事件. 使用方法类似 {@link #dispatchTouchEvent}
     */
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    /**
     * 该方法会被设置了 launchMode 为 "singleTop" 或者在调用 {@link #startActivity} 使用 {@link Intent#FLAG_ACTIVITY_SINGLE_TOP} flag
     * 时的 Activity 调用. 在任意情况下, 当 Activity 被重新启动在栈顶时(不是创建新的实例), 会在已存在的实例中调用 onNewIntent().
     * <p>
     * <p>Activity 在接收一个新的 Intent 之前总会被 paused, 所以你可以指望在此方法之后调用 {@link #onResume}.
     * <p>
     * <p>注意: {@link #getIntent} 方法仍会返回原始的 Intent. 你可以使用 {@link #setIntent} 去更新这个新的 Intent.
     *
     * @param intent 启动该 Activity 的新的 Intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /**
     * 当你启动的 Activity 退出时调用, 该方法返回你启动它时所用的请求码(requestCode), 它所返回的结果码(resultCode), 以及任何它额外添加
     * 的数据(data). 如果 Activity 明确返回 {@link #RESULT_CANCELED} , 不返回任何结果, 获取在操作期间崩溃了, 结果码(resultCode) 都
     * 将会是 {@link #RESULT_CANCELED}.
     * <p>
     * <p>在你的 Activity 重新启动时, 你将立即在 onResume() 之前收到该回调.
     * <p>
     * <p>如果 Activity 设置 {@link android.R.styleable#AndroidManifestActivity_noHistory} 为 true, 盖房将不再被调用.
     *
     * @param requestCode 请求码, 用于区分这个结果来源于谁
     * @param resultCode  结果码
     * @param data        数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 请求权限的结果回调. 该方法会在每次调用 {@link #requestPermissions(String[], int)} 时进行回调.
     * <p>
     * <p>注意: 有可能向用户请求的权限会被中断, 在这种情况下将会收到空的权限和结果数组, 这种情况应被视为取消.
     *
     * @param requestCode  请求码
     * @param permissions  请求的权限, 不为 null
     * @param grantResults 相应权限的授予结果, 为 {@link android.content.pm.PackageManager#PERMISSION_GRANTED} 或
     *                     {@link android.content.pm.PackageManager#PERMISSION_DENIED}. 不为 null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        return super.onCreatePanelView(featureId);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }
}

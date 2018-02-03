package com.linsh.code.nothing;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/15
 *    desc   :
 * </pre>
 */
public class Getter {

    public static int _int;
    public static boolean _boolean;
    public static String text;
    public static Drawable drawable;
    public static Context context;
    public static Bitmap bitmap;
    public static AccessibilityEvent accessibilityEvent;
    public static Parcel parcel;
    public static Rect rect;
    public static View view;
    public static AccessibilityNodeInfo accessibilitynodeinfo;
    public static Bundle bundle;
    public static AccessibilityNodeInfo.CollectionInfo collectionInfo;
    public static AccessibilityNodeInfo.RangeInfo rangeInfo;
    public static AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
    public static Intent intent;
    public static GestureDescription gestureDescription;
    public static AccessibilityService.GestureResultCallback gestureResultCallback;
    public static Handler handler;
}

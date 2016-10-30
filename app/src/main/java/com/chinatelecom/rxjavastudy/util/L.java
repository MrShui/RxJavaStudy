package com.chinatelecom.rxjavastudy.util;

import android.util.Log;

/**
 * Log统一管理类
 *
 * @author coco
 *         <p>
 *         打印时添加调用日志处的类名，函数名，行数信息
 *         modified by liu haonan
 */
public class L {

    public static boolean isDebug = false;

    /**
     * Log单次只能输出不多于4000字符，多于的要分次循环输出
     */
    private static final int MAX_LOG_LENGTH = 3000;

    private static final String TAG = "bestpay";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug && msg != null)
            Log.i(TAG, getStackTraceMsg() + msg);
    }

    public static void d(String tag, String msg, int element) {
        if (isDebug && msg != null) {

            for (int i = 0; i <= msg.length() / MAX_LOG_LENGTH; i++) {

                int startIndex = i * MAX_LOG_LENGTH;
                int endIndex = msg.length() <= (i + 1) * MAX_LOG_LENGTH ? msg.length() :
                        (i + 1) * MAX_LOG_LENGTH;

                Log.d(tag, getStackTraceMsg(element) + msg.substring(startIndex, endIndex));
            }
        }
    }

    public static void d(String tag, String msg) {
        d(tag, msg, 5);
    }

    public static void d(String msg) {
        d(TAG, msg, 5);
    }

    public static void e(String msg) {
        if (isDebug && msg != null)
            Log.e(TAG, getStackTraceMsg() + msg);
    }

    public static void v(String msg) {
        if (isDebug && msg != null)
            Log.v(TAG, getStackTraceMsg() + msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug && msg != null)
            Log.i(tag, getStackTraceMsg() + msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug && msg != null)
            Log.i(tag, getStackTraceMsg() + msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        if (isDebug && msg != null)
            Log.i(tag, msg, t);
    }

    public static void v(String tag, String msg) {
        if (isDebug && msg != null)
            Log.i(tag, getStackTraceMsg() + msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug && msg != null)
            Log.w(tag, getStackTraceMsg() + msg);
    }

    public static void w(String tag, String msg, Throwable t) {
        if (isDebug && msg != null)
            Log.w(tag, msg, t);
    }

    /**
     * 打印时添加调用日志处的类名，函数名，行数信息
     */
    private static String getStackTraceMsg() {
        return getStackTraceMsg(4);
    }

    private static String getStackTraceMsg(int element) {
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[element];
        return stackTrace.getFileName() + "(" + stackTrace.getLineNumber() + ") " + stackTrace.getMethodName() + ": ";
    }
}

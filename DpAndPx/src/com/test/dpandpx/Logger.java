package com.test.dpandpx;

import android.util.Log;

/**
 * 	Log工具,发布时关闭
* @ClassName: Logger 
* @Description: TODO
* @author pengbo
* @date 2014-4-9 上午11:17:38
 */
public class Logger {
	private static final int VERBOSE = 5;
	private static final int DEBUG = 4;
	private static final int INFO = 3;
	private static final int WARN = 2;
	private static final int ERROR = 1;

	private static int Log_LEVEL = 6;

	public static void v(String tag, String msg) {
		if (Log_LEVEL > VERBOSE) {
			Log.v(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (Log_LEVEL > DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (Log_LEVEL > INFO) {
			Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (Log_LEVEL > WARN) {
			Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (Log_LEVEL > ERROR) {
			Log.e(tag, msg);
		}
	}
}

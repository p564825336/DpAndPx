package com.test.dpandpx;

import android.content.Context;

public class DensityUtil {
	
	private static final String TAG = "DensityUtil";

	/**
	 * 根据手机的分辨率从px转为dp
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static float px2dip(Context context, float pxValue) {
		float density = context.getResources().getDisplayMetrics().density;
		return (float) (pxValue / density );
	}
	
	/**
	 * dp转为px
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static float dip2px(Context context, float dpValue){
		float density = context.getResources().getDisplayMetrics().density;
		return (float) (dpValue * density);
	}
	
	public static float px2dip(Context context, float pxValue, float density){
		return (float) (pxValue / density);
	}
	
	public static float dip2px(Context context, float dpValue, float density){
		return (float) (dpValue * density);
	}
	
	
	
}

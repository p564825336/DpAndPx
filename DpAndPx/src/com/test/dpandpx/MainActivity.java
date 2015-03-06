package com.test.dpandpx;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	// 基本变量
    private Context mContext = MainActivity.this;
	private TextView tv_density;
	private TextView tv_width_px;
	private TextView tv_width_dp;
	private TextView tv_height_px;
	private TextView tv_height_dp;
	private EditText et_input_value;
	private Button but_get_dp;
	private TextView tv_show_dp;
	private Button but_get_px;
	private TextView tv_show_px;
	private float density;
	private int widthPixels;
	private int heightPixels;
	private float heightDp;
	private float widthDp;
	private EditText et_input_value_density;
	private TextView tv_densityDpi;
	private int densityDpi;
	private float scaledDensity;
	private TextView tv_scaledDensity;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		
		initData();
		
		showData();
	}

	private void showData() {
		tv_density.setText("当前手机的density: " + density);
		tv_scaledDensity.setText("当前手机的scaledDensity: " + scaledDensity);
		tv_densityDpi.setText("当前手机的densityDpi: " + densityDpi);
		tv_width_px.setText("当前手机的宽是: " + widthPixels + "px");
		tv_width_dp.setText(widthDp + "dp");
		
		tv_height_px.setText("当前手机的高是: " + heightPixels + "px");
		tv_height_dp.setText(heightDp + "dp");
		
		but_get_dp.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				String input_value = et_input_value.getText().toString();
				String input_value_density = et_input_value_density.getText().toString();
				
				if (input_value != null && !input_value.equals("")) {	
					
					if(input_value_density != null && !input_value_density.equals("")){
						tv_show_dp.setText(input_value + "px   对应是: " + DensityUtil.px2dip(mContext, Float.parseFloat(input_value), Float.parseFloat(input_value_density)) + "dp");
					}else {
						tv_show_dp.setText(input_value + "px   对应是: " + DensityUtil.px2dip(mContext, Float.parseFloat(input_value)) + "dp");						
					}
				} else {
					Toast.makeText(mContext, "亲, 请输入数字", 0).show();
				}			
			}
		});
		
		but_get_px.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String input_value = et_input_value.getText().toString();
				String input_value_density = et_input_value_density.getText().toString();
				if (input_value != null && !input_value.equals("")) {
					if(input_value_density != null && !input_value_density.equals("")){
						tv_show_px.setText(input_value + "dp   对应是: " + DensityUtil.dip2px(mContext, Float.parseFloat(input_value), Float.parseFloat(input_value_density)) + "px");						
					}else {
						tv_show_px.setText(input_value + "dp   对应是: " +  DensityUtil.dip2px(mContext, Float.parseFloat(input_value)) + "px");											
					}
				}else {
					Toast.makeText(mContext, "亲, 请输入数字", 0).show();
				}
			}
		});
		
	}

	private void initData(){
		density = mContext.getResources().getDisplayMetrics().density;
		DisplayMetrics displayMetrics2 = mContext.getResources().getDisplayMetrics();
		densityDpi = displayMetrics2.densityDpi;
		scaledDensity = displayMetrics2.scaledDensity;
		
		
		
		Logger.i(TAG, "手机的density: " + density);
		Logger.i(TAG, "手机的densityDpi: " + densityDpi);
		Logger.i(TAG, "手机的scaledDensity: " + scaledDensity);
		 
		WindowManager windowManager = ((Activity) mContext).getWindowManager();
    	/*Display display = windowManager.getDefaultDisplay();
    	int height = display.getHeight();
    	int width = display.getWidth();
    	Logger.i(TAG, "①手机屏幕的宽度是: " + width);
    	Logger.i(TAG, "①手机屏幕的高度是: " + height);*/
    	
    	DisplayMetrics displayMetrics = new DisplayMetrics();
    	windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    	widthPixels = displayMetrics.widthPixels;
    	heightPixels = displayMetrics.heightPixels;
    	Logger.i(TAG, "②手机屏幕的宽度是: " + widthPixels);
    	Logger.i(TAG, "②手机屏幕的高度是: " + heightPixels);
    	
    	widthDp = DensityUtil.px2dip(mContext, widthPixels);
    	heightDp = DensityUtil.px2dip(mContext, heightPixels);
	}
	

	private void initView() {
		tv_density = (TextView) findViewById(R.id.tv_density);
		tv_scaledDensity = (TextView) findViewById(R.id.tv_scaledDensity);
		tv_densityDpi = (TextView) findViewById(R.id.tv_densityDpi);
		
		tv_width_px = (TextView) findViewById(R.id.tv_width_px);
		tv_width_dp = (TextView) findViewById(R.id.tv_width_dp);
		
		tv_height_px = (TextView) findViewById(R.id.tv_height_px);
		tv_height_dp = (TextView) findViewById(R.id.tv_height_dp);
		
		et_input_value = (EditText) findViewById(R.id.et_input_value);
		et_input_value_density = (EditText) findViewById(R.id.et_input_value_density);
		
		but_get_dp = (Button) findViewById(R.id.but_get_dp);
		tv_show_dp = (TextView) findViewById(R.id.tv_show_dp);
		
		but_get_px = (Button) findViewById(R.id.but_get_px);
		tv_show_px = (TextView) findViewById(R.id.tv_show_px);
	}
	
	

	
}

package com.fabao.burnscreen;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//屏幕常亮
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		Toast.makeText(this, "系统亮度: " + getScreenBrightness(this), Toast.LENGTH_SHORT).show();
		setAppScreenBrightness(255);
		
	}
	
	/**
	 * 1.获取系统默认屏幕亮度值 屏幕亮度值范围（0-255）
	 **/
	private int getScreenBrightness(Context context) {
		ContentResolver contentResolver = context.getContentResolver();
		int defVal = 125;
		return Settings.System.getInt(contentResolver,
			Settings.System.SCREEN_BRIGHTNESS, defVal);
	}
	
	/**
	 * 2.设置 APP界面屏幕亮度值方法
	 **/
	private void setAppScreenBrightness(int brightnessValue) {
		Window window = getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.screenBrightness = brightnessValue / 255.0f;
		window.setAttributes(lp);
		Toast.makeText(this, "修改软件亮度到最高", Toast.LENGTH_SHORT).show();
	}
}

package com.example.navigationdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class DrawerActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// don’t set any content view here, since its already set in
		// DrawerActivity
		FrameLayout frameLayout = (FrameLayout) findViewById(R.id.activity_frame);
		// inflate the custom activity layout
		LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View activityView = layoutInflater.inflate(R.layout.activity_main,
				null, false);
		// add the custom layout of this activity to frame layout.
		frameLayout.addView(activityView);
		// now you can do all your other stuffs
	}
}

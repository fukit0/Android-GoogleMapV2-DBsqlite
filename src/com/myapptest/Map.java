package com.myapptest;

import android.os.Bundle;

import com.google.android.maps.MapActivity;


public class Map extends MapActivity{

	@Override
	protected void onCreate(Bundle icicle) {
		// TODO Auto-generated method stub
		super.onCreate(icicle);
		setContentView(R.layout.activity_map);
	}
	
	@Override
	protected boolean isLocationDisplayed() {
		// TODO Auto-generated method stub
		return super.isLocationDisplayed();
	}

	

	@Override
	protected int onGetMapDataSource() {
		// TODO Auto-generated method stub
		return super.onGetMapDataSource();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}

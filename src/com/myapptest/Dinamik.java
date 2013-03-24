package com.myapptest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dinamik extends Activity implements android.view.GestureDetector.OnGestureListener {

	
	private LinearLayout lnr;
	private TextView X1,X2,Y1,Y2;
	private GestureDetector gestureScanner;
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		super.dispatchTouchEvent(ev);
		return gestureScanner.onTouchEvent(ev);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dinamik);
		
		gestureScanner = new GestureDetector((OnGestureListener) this);
		
		lnr = (LinearLayout)findViewById(R.id.lnrConteiner);
		
		 X1= getTextView();
		 X2= getTextView();
		
		 Y1= getTextView();
		 Y2= getTextView();
		
		 lnr.addView(X1);
		 lnr.addView(X2);
		 lnr.addView(Y1);
		 lnr.addView(Y2);
		 
	}

	private TextView getTextView()
	{
		TextView txt = new TextView(this);
		LayoutParams param = new LayoutParams();
		param.width=LayoutParams.FILL_PARENT;
		param.height=LayoutParams.WRAP_CONTENT;
		txt.setLayoutParams(param);
		txt.setText("Deðer yok.");
		
		return txt;
	}
	
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		
		X1.setText(String.valueOf(e1.getX()));
		X2.setText(String.valueOf(e2.getX()));
		Y1.setText(String.valueOf(e1.getY()));
		Y2.setText(String.valueOf(e2.getY()));
		
		
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}

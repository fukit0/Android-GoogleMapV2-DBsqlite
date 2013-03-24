package com.myapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		
		Intent i = this.getIntent();
		
		String gelenAd=i.getExtras().getString("kullaniciAdi");
		//Intent intent = getIntent();
		//String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		TextView l = (TextView)findViewById(R.id.lbl2);
		
		l.setText(gelenAd);		
		
		Button btnHarita=(Button)findViewById(R.id.btnHaritadaGoster);
		
		btnHarita.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(ThirdActivity.this,Map2.class);
				startActivity(i);
			}
		});
	}

	
}

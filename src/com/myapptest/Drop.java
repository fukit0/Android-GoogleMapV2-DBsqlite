package com.myapptest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Drop extends Activity {

	
	private Spinner spinner1,spinner2;
	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drop);
		
		
		addItemsOnSpinner2();
		addListenerOnButton();
		
	}

	
	public void addItemsOnSpinner2()
	{
		spinner2 = (Spinner)findViewById(R.id.spinner2);
		
		List<String> list = new ArrayList<String>();
		
		list.add("liste1");
		list.add("liste2");
		list.add("liste3");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
		
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner2.setAdapter(dataAdapter);
		
		
	}
	
	public void addListenerOnButton() {
		
		spinner1 = (Spinner)findViewById(R.id.spinner1);
		spinner2 = (Spinner)findViewById(R.id.spinner2);
		btn = (Button)findViewById(R.id.btnSubmit);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(Drop.this, 
						"Seçilen Deðerler : " + "\nülke : "
									+ String.valueOf(spinner1.getSelectedItem())
									+ "\nListe :"
									+ String.valueOf(spinner2.getSelectedItem()),
									Toast.LENGTH_SHORT).show();
				
			}
		});
	}

}

package com.myapptest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.layout2);
		
		Button btnKullaniciKaydet=(Button)findViewById(R.id.btnKullaniciKaydet);
		Button btnIleri=(Button)findViewById(R.id.third);
		final EditText kullaniciAdi=(EditText)findViewById(R.id.kulaniciAdi);
							
		btnKullaniciKaydet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText txtAdi = (EditText)findViewById(R.id.kulaniciAdi);
				EditText txtSifre = (EditText)findViewById(R.id.sifre);
				EditText txtMail = (EditText)findViewById(R.id.mail);
				EditText txtUyelýkno = (EditText)findViewById(R.id.uyelikNo);
				
				Kullanici entKullanici = new Kullanici();
				
				entKullanici.setAdi(txtAdi.getText().toString());
				entKullanici.setSifre(txtSifre.getText().toString());
				entKullanici.setePosta(txtMail.getText().toString());
				entKullanici.setKulaniciId(Integer.parseInt(txtUyelýkno.getText().toString()));
				
				KullaniciDAL dalKullanici = new KullaniciDAL(secondActivity.this);
				
				dalKullanici.KullaniciKaydet(entKullanici);
				
				@SuppressWarnings("unused")
				ArrayList<Kullanici> lst = dalKullanici.TumKayitlariGetir();
				
			}
		});
		
		
			btnIleri.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String girilenAd=kullaniciAdi.getText().toString();
				Intent i = new Intent(secondActivity.this, ThirdActivity.class);
				
				i.putExtra("kullaniciAdi", girilenAd);
				if(girilenAd.equals(""))
				{Toast.makeText(secondActivity.this, "Kullanici adi girmelisiniz", 200).show();
					
				}
				
				else
				{
					startActivity(i);
				}
			}
		});
		
		
		}
				
	}
	
	


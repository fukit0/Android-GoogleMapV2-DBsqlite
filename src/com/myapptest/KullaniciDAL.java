package com.myapptest;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class KullaniciDAL {

	
private Context context;
	
	public KullaniciDAL(Context context)
	{
		this.context=context;
	}
	
	private SQLiteDatabase getDatabase()
	{
		DBAccessFile newDB = new DBAccessFile(context);
		return newDB.getDB();
	}
	
	public ArrayList<Kullanici> TumKayitlariGetir()
	{
		ArrayList<Kullanici> kullanicilar;
		try {
		SQLiteDatabase db = getDatabase();
		SQLiteQueryBuilder sqb = new SQLiteQueryBuilder();
		
		db.execSQL("select * from Kullanicilar");
		
		Cursor c = sqb.query(db, null, null, null, null, null, null);
		
		kullanicilar = ConvertToEntity(c);
		
		c.close();
		
		return kullanicilar;
		
		}catch(Exception ex) {
			return null;
		}
		
	
		
	}
	
	public void KullaniciKaydet(Kullanici entKullanici)
	{
		try{
		ContentValues values = new ContentValues();
		
		values.put("KAdi",entKullanici.getAdi());
		values.put("KEPosta",entKullanici.getePosta());
	
		values.put("KSifre", entKullanici.getSifre());
		
		SQLiteDatabase db = getDatabase();
		db.insert("Kullanicilar", null, values);
		db.close();
		
		}catch (Exception ex)
		{
			Log.d("#ERROR KullaniciKayit", ex.getMessage());
		}
		
	}
	
	private ArrayList<Kullanici> ConvertToEntity(Cursor c)
	{
		ArrayList<Kullanici> lstKulanici = new ArrayList<Kullanici>();
		
		if(c.moveToFirst()){
			do{
				
				Kullanici entKullanici = new Kullanici();
				
				entKullanici.setAdi(getCursorStr(c, "adi"));
				entKullanici.setePosta(getCursorStr(c, "KEposta"));
				entKullanici.setSifre(getCursorStr(c, "KSifre"));
			
			//	entKonum.setTarih(getCursorStr(c, "tarih"));
				
				lstKulanici.add(entKullanici);
				
			}while (c.moveToNext());
		}
				
		return lstKulanici;
		
	}

	private String getCursorStr(Cursor c, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

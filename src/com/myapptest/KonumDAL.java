package com.myapptest;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class KonumDAL extends DAL{

	private Context context;
	
	public KonumDAL(Context context)
	{
		this.context=context;
	}
	
	private SQLiteDatabase getDatabase()
	{
		DBAccessFile newDB = new DBAccessFile(context);
		return newDB.getDB();
	}
	
	public Konum KayitGetir(int kayitId)
	{
		
		try {
		SQLiteDatabase db = getDatabase();
		SQLiteQueryBuilder sqb = new SQLiteQueryBuilder();
		
		String sql = "select * from Konumlar Where KonumID="+kayitId;
		
		sqb.setTables(sql);
					
		Cursor c = sqb.query(db, null, null, null, null, null, null);
		
		Konum entKonum = ConvertToEntity(c).get(0);
		c.close();
		return entKonum;
		
		}catch(Exception ex) {
			return null;
		}
		
	
		
	}
	
	public void KonumKaydet(Konum entKonum)
	{
		try{
		ContentValues values = new ContentValues();
		
		values.put("KullaniciID",entKonum.getKullaniciId());
		values.put("KonumID",entKonum.getKonumId());
		values.put("Latitude",String.valueOf(entKonum.getLatitude()));
		values.put("longitude",String.valueOf(entKonum.getLongitude()));
		
		SQLiteDatabase db = getDatabase();
		db.insert("Konumlar", null, values);
		db.close();
		}catch (Exception ex)
		{
			Log.d("#ERROR KonumKayit", ex.getMessage());
		}
		
	}
	
	private ArrayList<Konum> ConvertToEntity(Cursor c)
	{
		ArrayList<Konum> lstKonum = new ArrayList<Konum>();
		
		if(c.moveToFirst()){
			do{
				
				Konum entKonum = new Konum();
				entKonum.setKonumId(getCursorInt(c, "KonumID"));
				entKonum.setKullaniciId(getCursorInt(c, "KullaniciID"));
				entKonum.setLatitude(Double.parseDouble(getCursorStr(c, "Latitude")));
				entKonum.setLongitude(Double.parseDouble(getCursorStr(c, "longitude")));
			//	entKonum.setTarih(getCursorStr(c, "tarih"));
				
				lstKonum.add(entKonum);
				
			}while (c.moveToNext());
		}
				
		return lstKonum;
		
	}
}

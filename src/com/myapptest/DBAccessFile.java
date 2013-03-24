package com.myapptest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAccessFile extends SQLiteOpenHelper{

	private final static int DATABASE_VERSISON = 1;
	private final static String DATABASE_NAME = "MyAppTestDB";
	private static String TABLE_NAME = "";
	
	
	
	
	public DBAccessFile(Context context, String tabloAdi,
			int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSISON);
		// TODO Auto-generated constructor stub
		
		TABLE_NAME = tabloAdi;
	}
	
	public DBAccessFile(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSISON);
		// TODO Auto-generated constructor stub
		
		
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("CREATE TABLE Kullanicilar(KullaniciID INTEGER PRIMARY KEY , KAdi TEXT, KEposta TEXT, KSifre TEXT)");
		db.execSQL("CREATE TABLE Konumlar(KonumID INTEGER PRIMARY KEY , KullaniciID INTEGER, Latitude TEXT, longitude TEXT, terih TEXT)");	
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		if(newVersion > oldVersion){
		db.execSQL("DROP TABLE IF EXIST Kullanicilar");
		db.execSQL("DROP TABLE IF EXIST Konumlar");}
		onCreate(db);
		
	}
	
	
	public SQLiteDatabase getDB()
	{
		return this.getWritableDatabase();
		//return db;
		
	}

}

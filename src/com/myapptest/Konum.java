package com.myapptest;

import java.sql.Date;

public class Konum {

	private int konumId;
	private int kullaniciId;
	private double latitude;
	private double longitude;
	private Date tarih;
	public int getKonumId() {
		return konumId;
	}
	public void setKonumId(int konumId) {
		this.konumId = konumId;
	}
	public int getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	
	
}

package com.cvs.model;

public class Pos_boardVO {
	private int store_no;
	private int list_no;
	private int barcode_no;
	private int md_ea;
	private String sale_date;
	private String update_date;
	
	
	public int getMd_ea() {
		return md_ea;
	}
	public void setMd_ea(int md_ea) {
		this.md_ea = md_ea;
	}
	public int getBarcode_no() {
		return barcode_no;
	}
	public void setBarcode_no(int barcode_no) {
		this.barcode_no = barcode_no;
	}
	public int getStore_no() {
		return store_no;
	}
	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}
	public int getList_no() {
		return list_no;
	}
	public void setList_no(int list_no) {
		this.list_no = list_no;
	}
	
	
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	
	
	
}

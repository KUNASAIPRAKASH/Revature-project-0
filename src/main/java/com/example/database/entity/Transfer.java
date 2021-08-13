package com.example.database.entity;

import java.sql.Timestamp;

public class Transfer {
	
	private int trans_id;
	private int amount;
	private Timestamp date_time;
	private String debit_or_credit;
	
	
	public Transfer(int trans_id,int amount, String debit_or_credit,Timestamp date_time) {
		super();
		this.trans_id=trans_id;
		this.amount = amount;
		this.date_time = date_time;
		this.debit_or_credit = debit_or_credit;
	}


	public Transfer() {
		
	}
	
	public int getTrans_id() {
		return trans_id;
	}


	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Timestamp getDate_time() {
		return date_time;
	}


	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}


	public String getDebit_or_credit() {
		return debit_or_credit;
	}


	public void setDebit_or_credit(String debit_or_credit) {
		this.debit_or_credit = debit_or_credit;
	}


	@Override
	public String toString() {
		return "Transfer [trans_id=" + trans_id + ", amount=" + amount + ", date_time=" + date_time
				+ ", debit_or_credit=" + debit_or_credit + "]";
	}
	
}



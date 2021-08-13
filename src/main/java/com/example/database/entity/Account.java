package com.example.database.entity;

public class Account {
	
	private int ac_num;
	private int balance;
	

	public Account(int ac_num, int balance) {
		super();
		this.ac_num = ac_num;
		this.balance = balance;
	}
	
	public Account() {
		
	}
	
	
	public int getAc_num() {
		return ac_num;
	}
	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
		
	}

	@Override
	public String toString() {
		return "Account [ac_num=" + ac_num + ", balance=" + balance + "]";
	}
	
}

package com.example.database.repository;

import com.example.transfer.exception.InvalidAccountDetailsException;

public interface AccountRepositoryDatabase {

	boolean checks(int account);
	
	int balance(int account) ;
	void update(int ac_num,int balance);
	
	
}

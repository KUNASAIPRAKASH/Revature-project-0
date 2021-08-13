package com.example.transfer.repository;

//import com.example.database.entity.Account;
import com.example.transfer.exception.InsufficientAmountException;
import com.example.transfer.exception.InvalidAccountDetailsException;


public interface AccountRepository {

	
	void loadAccount(int ac_num) throws InvalidAccountDetailsException;
	void debit(int ac_num,double amount)throws InsufficientAmountException;
	void credit(int ac_num,double amount) throws InvalidAccountDetailsException;
	void updateAccount(int ac_num,double updatedAmount);
}

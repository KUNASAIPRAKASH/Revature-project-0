package com.example.transfer.repository;

import com.example.database.entity.Transfer;
import com.example.database.repository.AccountRepositoryDatabase;
import com.example.database.repository.AccountRepoDatabaseImpl;
import com.example.database.repository.TransferRespository;
import com.example.database.repository.TransferRepoImpl;
import java.sql.Timestamp;
import java.util.Date;
import java.lang.Math; 
import com.example.transfer.exception.InvalidAccountDetailsException;
import com.example.transfer.exception.InsufficientAmountException;

public class AccountRepositoryImpl implements AccountRepository{

	AccountRepositoryDatabase ac_db=new AccountRepoDatabaseImpl();
	TransferRespository tr_db=new TransferRepoImpl();
	int a=100;
	int b=300;
	
	private int transc_id = (int)(Math.random()*(b-a+1)+a);;
	
	public void loadAccount(int ac_num) throws InvalidAccountDetailsException{
		if(ac_db.checks(ac_num)) {
			
		}else {
			throw new InvalidAccountDetailsException();		
	}
}
	public void debit(int ac_num,double amount) throws InsufficientAmountException {
		
		try {
			if(ac_db.balance(ac_num) >= amount) {
				updateAccount(ac_num,ac_db.balance(ac_num)-amount);
				Timestamp time=new Timestamp(new Date().getTime());
				tr_db.save(new Transfer(transc_id,(int)amount,"Debit",time));
				
			}else {
				throw new InsufficientAmountException();
			}
		} catch (InsufficientAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void credit(int ac_num, double amount) throws InvalidAccountDetailsException {
		
		updateAccount(ac_num,ac_db.balance(ac_num)+amount);
		Timestamp time=new Timestamp(new Date().getTime());
		tr_db.save(new Transfer(transc_id,(int)amount, "Credit",time));
		transc_id+=1;
	}

	public void updateAccount(int ac_num, double updatedAmount) {
		// TODO Auto-generated method stub
	    ac_db.update(ac_num,(int)updatedAmount);	
	}
	


	
}
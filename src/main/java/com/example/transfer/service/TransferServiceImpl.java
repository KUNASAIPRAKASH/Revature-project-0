package com.example.transfer.service;
import com.example.database.entity.Transfer;
//import com.example.transfer.sevice.TransferService;
import com.example.database.repository.TransferRepoImpl;
import com.example.transfer.repository.AccountRepository;
import com.example.transfer.repository.AccountRepositoryImpl;
import com.example.database.repository.AccountRepoDatabaseImpl;
import com.example.database.repository.AccountRepositoryDatabase;
import com.example.transfer.exception.InsufficientAmountException;
import com.example.transfer.exception.InvalidAccountDetailsException;


public class TransferServiceImpl implements TransferService{
	

	private AccountRepository acrepo=new AccountRepositoryImpl();
	
	
	public void transfer(double amount,int from_ac,int to_ac) {
		try {
		acrepo.loadAccount(from_ac);
		acrepo.loadAccount(to_ac);
		acrepo.debit(from_ac,amount);
		acrepo.credit(to_ac,amount);
		
		}catch(InvalidAccountDetailsException e) {
			System.err.println(e.getMessage());
		}catch(InsufficientAmountException e) {
			System.err.println(e.getMessage());
		}
		
	}
	

	
	
	
	
	public void transactions() {
		new TransferRepoImpl().getTransfers().forEach(transaction->System.out.println(transaction));
	}
	
}
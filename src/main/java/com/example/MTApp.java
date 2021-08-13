package com.example;

import java.util.*;


//import com.example.database.repository.TransferRepository;
import com.example.database.repository.TransferRepoImpl;
//import com.example.transfer.exception.InsufficientAmountException;
import com.example.transfer.service.TransferService;
import com.example.transfer.service.TransferServiceImpl;
import com.example.database.repository.AccountRepoDatabaseImpl;
import com.example.database.repository.AccountRepositoryDatabase;

public class MTApp {
	
	public static void main(String[] args){
		
		int c;
		int from_ac=0;
		int to_ac=0;
		int amount = 0;
		String d1,d2;
		//TransferRepoImpl tr=new TransferRepoImpl();
		AccountRepositoryDatabase ac=new AccountRepoDatabaseImpl();
		System.out.println("*********Welcome To Money Transfer System********");
		System.out.println("choose the following options");
		while(true) {
		//read
		
		System.out.println("1.Account Balance ");
		System.out.println("2.Money Transfer ");
		System.out.println("3.check transaction between dates");
		System.out.println("4.Exit");
		Scanner sc=new Scanner(System.in);
		Scanner st=new Scanner(System.in);
		c = sc.nextInt();
		
		switch(c)
		{
		case 1:System.out.println("Enter the acount number");
		       from_ac=sc.nextInt();
		       int amt=ac.balance(from_ac);
		       System.out.println(" "+amt);
		       System.out.println("\n");
		       break;
		
		case 2: System.out.println("Enter the account number: ");
				 from_ac=sc.nextInt();
				System.out.println("Enter the recepient account number");
				 to_ac=sc.nextInt();
				System.out.println("Enter amount to transfer");
				 amount=sc.nextInt();
				 
				TransferService app1=new TransferServiceImpl();
					
				app1.transfer(amount, from_ac,to_ac);
				System.out.println("payment done");
				//app1.transactions();
				System.out.println("\n");
				break;
		case 4: System.out.println("closed");
		  	    System.exit(0);
				break;
			
		case 3: System.out.println("Enter the start date");
		        d1=st.nextLine();
		        System.out.println("Enter the end date");
		        d2=st.nextLine();
		  
		        new TransferRepoImpl().getDates(d1,d2).forEach(transaction->System.out.println(transaction));
		        break;
			
		default: System.out.println("Enter Again!!");
		}
		
	}
	
	}
	
}
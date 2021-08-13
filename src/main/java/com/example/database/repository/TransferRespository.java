package com.example.database.repository;


import java.util.List;

import com.example.database.entity.Transfer;

public interface TransferRespository {
	
	void save(Transfer transfer);
	
	List<Transfer> getTransfers();
	
	List<Transfer> getDates(String start,String end);
}

package com.example.database.repository;

import com.example.database.ConnectionFactory;
import com.example.database.entity.Transfer;
//import com.example.database.repository.TransferRespository;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class TransferRepoImpl implements TransferRespository{
	
	public void save(Transfer transfer) {

		Connection con=null;
		try {
			
			con=ConnectionFactory.getConnection();
			String sql="insert into transfer values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,transfer.getTrans_id());
			ps.setDouble(2,transfer.getAmount());
			ps.setString(3,transfer.getDebit_or_credit());
			ps.setTimestamp(4,transfer.getDate_time());
			
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<Transfer> getTransfers() {
		
		Connection con=null;
		
		List<Transfer> transferList= new ArrayList<Transfer>();
		
		try {
			
			con = ConnectionFactory.getConnection();
			
			String sql="select * from transfer";
			
			Statement smt= con.createStatement();
			ResultSet rs= smt.executeQuery(sql);
			while(rs.next()) {
				Transfer transfer = new Transfer();
				transfer.setTrans_id(rs.getInt(1));
				transfer.setAmount(rs.getInt(2));
				transfer.setDebit_or_credit(rs.getString(3));
				transfer.setDate_time(rs.getTimestamp(4));
				transferList.add(transfer);			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
						
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return transferList;
		
	}
	
	@Override
	public List<Transfer> getDates(String start, String end) {
		// TODO Auto-generated method stub
		String d="";
		Connection con=null;
		List<Transfer> transferList= new ArrayList<Transfer>();
		
		try {
		
			con=ConnectionFactory.getConnection();
			String s="select * from transfer where Date_time between '"+start+"' and '"+end+"'";
			Statement smt=con.createStatement();
			ResultSet rs =smt.executeQuery(s);
			while(rs.next()) {
				Transfer transfer = new Transfer();
				transfer.setTrans_id(rs.getInt(1));
				transfer.setAmount(rs.getInt(2));
				transfer.setDebit_or_credit(rs.getString(3));
				transfer.setDate_time(rs.getTimestamp(4));
				transferList.add(transfer);			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
						
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return transferList;
	
	
	}
	}

package com.example.database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.database.ConnectionFactory;
import com.example.transfer.exception.InvalidAccountDetailsException;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepoDatabaseImpl implements AccountRepositoryDatabase{
	
	public boolean checks(int account) {
		boolean flag=false;
		Connection con=null;
		try {
			con=ConnectionFactory.getConnection();
			String sql="select count(*) from account where ac_num ="+account;
			
			Statement smt=con.createStatement();
			ResultSet rs= smt.executeQuery(sql);
			rs.next();
			int count=rs.getInt(1);
			if(count==1) {
				flag=true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public void update(int ac_num, int balance) {
		Connection con=null;
		try {
			con=ConnectionFactory.getConnection();
			String sql1="update account set ac_bal=? where ac_num=?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setInt(1,balance);
			ps.setInt(2,ac_num);
			
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
	
	
	public int balance(int account) {
	
		int amount=0;
		Connection con=null;
		try {
			
			con=ConnectionFactory.getConnection();
			String sql2="select ac_bal from account where ac_num= "+account;
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(sql2);
			rs.next();
			amount=rs.getInt(1);		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
			
		}
		return amount;
	}

	
}
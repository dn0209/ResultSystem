package com.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Operation {

	public Connection connection()
	{
		Connection con=null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public int add(int yes,int no) {
		
		int x=0;
		int y=0;
		int n=0;
		int hitCount=0;
		try(Connection con=connection()) {
			
			PreparedStatement preparedStatement=con.prepareStatement("select *from answer");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				y=resultSet.getInt("yes");
				n=resultSet.getInt("no");
				hitCount=resultSet.getInt("hitcount");
			}
			PreparedStatement preparedStatement2=con.prepareStatement("update answer set hitcount=?,yes=?,no=? where id="+1+"");
			
			preparedStatement2.setInt(1, (hitCount+1));
			preparedStatement2.setInt(2, (yes+y));
			preparedStatement2.setInt(3, (no+n));
			x=preparedStatement2.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}
	public ArrayList<Integer> percentage() {
		
		ArrayList<Integer> list=new ArrayList();
		
		int yes=0;
		int no=0;
		int hitCount=0;
		int yp;
		int np;
		
		try(Connection con=connection()) {
			
			PreparedStatement preparedStatement=con.prepareStatement("select *from answer");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				yes=resultSet.getInt("yes");
				no=resultSet.getInt("no");
				hitCount=resultSet.getInt("hitcount");
			}
			yp=yes*100/hitCount;
			np=no*100/hitCount;
			list.add(yp);
			list.add(np);
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}

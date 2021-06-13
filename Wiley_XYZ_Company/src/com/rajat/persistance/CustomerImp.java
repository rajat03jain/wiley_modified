package com.rajat.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rajat.beans.Customer;
import com.rajat.helper.MySqlConnection;

public class CustomerImp implements CustomerDao {

	@Override
	public Customer getCustomerById(long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection = MySqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from Customer_table where phone_no=(?)");
		statement.setLong(1, id);
		ResultSet resultset = statement.executeQuery();
		Customer c=null;
		while (resultset.next()) {
			c = new Customer(resultset.getLong("phone_no"),resultset.getString("name"),resultset.getString("address"));
			
			
		}

		connection.close();

		return c;
		
		
		
	}

	@Override
	public boolean addCustomer(Customer c) throws ClassNotFoundException, SQLException {
		Connection connection = MySqlConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("insert into Customer_table values(?,?,?)");
		statement.setLong(1, c.getPhone_no());
		statement.setString(2, c.getName());
		statement.setString(3, c.getAddress());
		
		

		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();

		return false;
		
	}
	
	

}

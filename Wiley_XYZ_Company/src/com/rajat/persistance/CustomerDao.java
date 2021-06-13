package com.rajat.persistance;

import java.sql.SQLException;

import com.rajat.beans.Customer;

public interface CustomerDao {
	public Customer getCustomerById(long id) throws ClassNotFoundException, SQLException;
	public boolean addCustomer(Customer c)throws ClassNotFoundException, SQLException;

}

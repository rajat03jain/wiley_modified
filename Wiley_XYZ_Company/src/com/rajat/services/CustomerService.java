package com.rajat.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;

public interface CustomerService {
	public void addCustomer(Customer c) throws ClassNotFoundException, SQLException;
	public ArrayList<Items> getAllItems() throws ClassNotFoundException, SQLException;
	public ArrayList<Items> getAllCDs() throws ClassNotFoundException, SQLException;
	public ArrayList<Items> getAllCosmetics() throws ClassNotFoundException, SQLException;
	public ArrayList<Items> getAllBooks() throws ClassNotFoundException, SQLException;
	public void addItemtoBasket(Items item,Customer c,int quantity,String type) throws ClassNotFoundException, SQLException;
    public ArrayList<Items> displayShoppingBasket(Customer c)	throws ClassNotFoundException, SQLException;
    public double getTotalBill(Customer c)throws ClassNotFoundException, SQLException;
    public Customer getCustomerById(long id) throws ClassNotFoundException, SQLException;
    public void buy(int id,int quant,Customer c) throws ClassNotFoundException, SQLException;
    

}

package com.rajat.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;

public interface ShoppingBasketDao {
	public void addItemToBasket(Items item,Customer c,int quantity,String type)throws ClassNotFoundException, SQLException;
	
	ArrayList<Items> displayBasket(Customer c) throws ClassNotFoundException, SQLException;
	

}

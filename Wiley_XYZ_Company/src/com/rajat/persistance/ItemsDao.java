package com.rajat.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rajat.beans.Items;
import com.rajat.beans.Shopping_Basket;

public interface ItemsDao {
	
	public ArrayList<Items> getItemsinBasket() throws ClassNotFoundException, SQLException;
	 
	public ArrayList<Items> SearchItemByType(String type) throws ClassNotFoundException, SQLException;
	public Items SearchItemByID(int id) throws ClassNotFoundException, SQLException;
	

}

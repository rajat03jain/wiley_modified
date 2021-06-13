package com.rajat.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;
import com.rajat.beans.Shopping_Basket;
import com.rajat.helper.MySqlConnection;

public class ShoppingBasketImp implements ShoppingBasketDao {
	private Shopping_Basket sb=new Shopping_Basket();

	@Override
	public void addItemToBasket(Items item,Customer c,int quantity,String type) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = MySqlConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into Basket values(?,?,?,?,?,?) ");
		statement.setLong(1, c.getPhone_no());
		statement.setInt(2, item.getId());
		statement.setString(3,item.getName());
		statement.setInt(4, item.getPrice());
		statement.setInt(5,quantity);
		statement.setString(6, type);
		statement.executeUpdate();
		System.out.println("Inserted into basket");
		statement = connection.prepareStatement("update Items set  quantity=quantity-(?) where id=(?)");
		System.out.println("doing");
		statement.setInt(1,quantity);
		statement.setInt(2, item.getId());
		
		statement.executeUpdate();

		connection.close();

		
		
		
		
	}

	
	@Override
	public ArrayList<Items> displayBasket(Customer c) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = MySqlConnection.getConnection();
        ArrayList<Items> items=new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement("select * from Basket where c_id=(?) ");
		statement.setLong(1, c.getPhone_no());
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
		Items item=new Items();
		int id=resultset.getInt("item_id");
		item.setId(id);
		item.setName(resultset.getString("item_name"));
		item.setPrice(resultset.getInt("price"));
		item.setQty(resultset.getInt("quantity"));
		item.setType(resultset.getString("type"));
		
		
		items.add(item);
			
			
		}

		connection.close();

		return items;
		
		
		
	}

}

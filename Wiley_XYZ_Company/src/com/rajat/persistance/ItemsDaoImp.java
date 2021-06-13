package com.rajat.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;
import com.rajat.helper.MySqlConnection;

public class ItemsDaoImp  implements ItemsDao{

	@Override
	public ArrayList<Items> getItemsinBasket() throws ClassNotFoundException, SQLException {
		Connection connection = MySqlConnection.getConnection();
        ArrayList<Items> items=new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement("select * from Items");
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
		Items i = new Items();
		i.setId(resultset.getInt("id"));
		i.setPrice(resultset.getInt("price"));
		i.setQty(resultset.getInt("quantity"));
		i.setType(resultset.getString("type"));
		items.add(i);
			
			
		}

		connection.close();

		return items;
		
		
	}

	@Override
	public ArrayList<Items> SearchItemByType(String type) throws ClassNotFoundException, SQLException {
		Connection connection = MySqlConnection.getConnection();
        ArrayList<Items> items=new ArrayList<>();
		PreparedStatement statement = connection.prepareStatement("select * from Items where type=(?)");
		statement.setString(1, type);
		ResultSet resultset = statement.executeQuery();
		
		while (resultset.next()) {
		Items i = new Items();
		i.setId(resultset.getInt("id"));
		i.setPrice(resultset.getInt("price"));
		i.setQty(resultset.getInt("quantity"));
		i.setType(resultset.getString("type"));
		i.setName(resultset.getString("name"));
		items.add(i);
			
			
		}

		connection.close();

		return items;
	}
	public Items SearchItemByID(int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySqlConnection.getConnection();
        
		PreparedStatement statement = connection.prepareStatement("select * from Items where id=(?)");
		statement.setInt(1, id);
		ResultSet resultset = statement.executeQuery();
		
		Items i = new Items();
		while(resultset.next()) {
		
		i.setId(id);
		i.setPrice(resultset.getInt("price"));
		i.setQty(resultset.getInt("quantity"));
		i.setType(resultset.getString("type"));
		i.setName(resultset.getString("name"));
		}
		
			
			
		

		connection.close();

		return i;
	}

	
}

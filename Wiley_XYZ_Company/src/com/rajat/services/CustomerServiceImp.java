package com.rajat.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;
import com.rajat.persistance.CustomerImp;
import com.rajat.persistance.ItemsDao;
import com.rajat.persistance.ItemsDaoImp;
import com.rajat.persistance.ShoppingBasketDao;
import com.rajat.persistance.ShoppingBasketImp;

public class CustomerServiceImp implements CustomerService {
   CustomerImp ci=new CustomerImp();
   ItemsDao itemsdaoimp=new ItemsDaoImp();
  
   ShoppingBasketDao sb=new ShoppingBasketImp(); 
	
	

	@Override
	public void addCustomer(Customer c) throws ClassNotFoundException, SQLException {
		
		System.out.println(c);
		ci.addCustomer(c);
		
	}



	@Override
	public ArrayList<Items> getAllItems() throws ClassNotFoundException, SQLException {
		return itemsdaoimp.getItemsinBasket();
	}



	@Override
	public ArrayList<Items> getAllCDs() throws ClassNotFoundException, SQLException {
		return itemsdaoimp.SearchItemByType("cd");
	}



	@Override
	public ArrayList<Items> getAllCosmetics() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return itemsdaoimp.SearchItemByType("cosmetic");
	}



	@Override
	public ArrayList<Items> getAllBooks() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return itemsdaoimp.SearchItemByType("book");
	}



	@Override
	public void addItemtoBasket(Items item,Customer c,int quantity,String type) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sb.addItemToBasket(item,c,quantity,type);
		
	}



	@Override
	public ArrayList<Items> displayShoppingBasket(Customer c) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	   return sb.displayBasket(c);

}



	@Override
	public double getTotalBill(Customer c) throws ClassNotFoundException, SQLException {
		ArrayList<Items> items=sb.displayBasket(c); 
		double bill=0;		for(Items item:items) {
			String type=item.getType();
			if(type.equals("cd")) {
				bill+=(item.getPrice()*item.getQty())+(item.getPrice()*item.getQty())/10.0;
			}else if(type.equals("book")) {
				bill+=(item.getPrice()*item.getQty());
			}else {
				bill+=(item.getPrice()*item.getQty())+(item.getPrice()*item.getQty())*12.0/100.0;
			}
				
		}
		return bill;
	}



	@Override
	public Customer getCustomerById(long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ci.getCustomerById(id);
	}



	@Override
	public void buy(int id,int quant,Customer c) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
			Items i=itemsdaoimp.SearchItemByID(id);
			if(i.getQty()==0)
				System.out.println("Item is not in stock!!!");
			else if(quant<0) {
				System.out.println("Quantity Entered cannot be negative");
			}else {
				ShoppingBasketImp si=new ShoppingBasketImp();
				si.addItemToBasket(i, c, quant,i.getType());
			}
				
		}
	



	
}

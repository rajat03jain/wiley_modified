package com.rajat.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;
import com.rajat.services.CustomerService;
import com.rajat.services.CustomerServiceImp;

public class CustomerItemsPresentationImp implements CustomerItemsPresentation{
	private CustomerService cs=new CustomerServiceImp();
	Scanner scn=new Scanner(System.in);
	@Override
	public void displayALLCDs(Customer c) {
		// TODO Auto-generated method stub
		ArrayList<Items> cds;
		try {
			cds = cs.getAllCDs();
			for(Items cd:cds) {
				System.out.println(cd);
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				

				
			buy(c);
		
	}
	public void buy(Customer c) {
		System.out.println("***********************************");
		
		String str="yes";
		while(str.equals("yes")) {
			int id=0,quant=0;
			System.out.println("Item id: ");
			id=scn.nextInt();
			System.out.println("Quantity: ");
			quant=scn.nextInt();
			System.out.println("type yes to add more");
			
			str=scn.next();
			
			try {
				cs.buy(id, quant, c);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}

	@Override
	public void displayAllCosmetics(Customer c) {
		// TODO Auto-generated method stub
		ArrayList<Items> cosmetics;
		try {
			cosmetics = cs.getAllCosmetics();
			
			
			for(Items cosmetic:cosmetics) {
				System.out.println(cosmetic);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buy(c);
		
	}
	@Override
	public void displayAllItems() {
		
		try {
			ArrayList<Items> list=cs.getAllItems();
			for(Items i:list) {
				System.out.println(i);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void displayAllBooks(Customer c) {
		ArrayList<Items> books;
		try {
			books = cs.getAllBooks();
			for(Items book:books) {
				System.out.println(book);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buy(c);
		
		
	}

}

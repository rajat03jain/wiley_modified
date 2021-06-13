package com.rajat.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.rajat.beans.Customer;
import com.rajat.beans.Items;
import com.rajat.services.CustomerService;
import com.rajat.services.CustomerServiceImp;

public class CustomerBasketPresentationImp implements CustomerBasketPresentation {
	private CustomerService cs=new CustomerServiceImp();
	Scanner scn=new Scanner(System.in);

	@Override
	public void displayBasket(Customer c) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Items> list=cs.displayShoppingBasket(c);
			for(Items i:list)
				System.out.println(i);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public double getBill(Customer c) {
		// TODO Auto-generated method stub
		try {
			return cs.getTotalBill(c);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

	

}

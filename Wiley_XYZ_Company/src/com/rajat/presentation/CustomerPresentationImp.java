package com.rajat.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.rajat.beans.Customer;
import com.rajat.helper.CustomerInput;
import com.rajat.services.CustomerService;
import com.rajat.services.CustomerServiceImp;

public class CustomerPresentationImp implements CustomerPresentation {

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("============Welcome to Rajat Retail Shop========");
		System.out.println("1.New User");
		System.out.println("2. Existing User");
		System.out.println("3.Exit");
	}

	@Override
	public void performMenu(int choice) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		CustomerService cs= new CustomerServiceImp();
		switch(choice) {
		case 1:
			try {
				CustomerInput ci=new CustomerInput();
				Customer c=ci.input();
				System.out.println(c);
				cs.addCustomer(c);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Please Enter a valid Number/String");
			}
		System.out.println("Thank You for adding your details");
		
		case 2:
			
			
			
			System.out.println("Please enter your registered phone no");
			long phone_no=scn.nextLong();
			Customer c=null;
		
			try {
				c=cs.getCustomerById(phone_no);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Sorry You are not registered. Please Register Yourself");
				break;
			}
			loop1:while(true)
			{
				System.out.println("Welcome to Rajat Retail Shop");
				
				System.out.println("1. Buy Books");
				System.out.println("4. Buy Cds");
				System.out.println("3. Buy Cosmetics");
				System.out.println("4. See All Items");
				System.out.println("5. Exit");
				System.out.println("Enter your choice:");
			int ch=scn.nextInt();
			CustomerItemsPresentation cp=new CustomerItemsPresentationImp();
			switch(ch) {
			case 1:cp.displayAllBooks(c);
					break;
			case 2:cp.displayALLCDs(c);
					break;
			case 3:cp.displayAllCosmetics(c);
			break;
			case 4:cp.displayAllItems();
			break;
			case 5:break loop1;
			}
			
			
			
			}
			loop2:while(true)
			{
			System.out.println("Welcome to Rajat Retail Shop");
			System.out.println("1. Get bill");
			System.out.println("2. Display Basket");
			System.out.println("3. Exit");
			System.out.println("Enter your choice:");
			int ch=scn.nextInt();
			CustomerBasketPresentation cp=new CustomerBasketPresentationImp();
			switch(ch) {
			case 1:System.out.println("Bill:"+cp.getBill(c));
			break;
			case 2:cp.displayBasket(c);
					break;

			case 3:break loop2;
			}
			
			
			
			}
		case 3:System.exit(0);
		
		
		}
		
	}

}

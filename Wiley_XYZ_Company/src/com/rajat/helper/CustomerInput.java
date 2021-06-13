package com.rajat.helper;

import java.util.Scanner;

import com.rajat.beans.Customer;

public class CustomerInput {
	public Customer input() {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Your Name");
		String name=scn.next();
		System.out.println("Enter Your Mobile No");
		long number=scn.nextLong();
		System.out.println("Enter Your Address");
		String address=scn.next();
		Customer c=new Customer(number,name,address);
		return c;
	}

}

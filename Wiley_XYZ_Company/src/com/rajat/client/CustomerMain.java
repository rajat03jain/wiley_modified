package com.rajat.client;

import java.util.Scanner;

import com.rajat.presentation.CustomerPresentation;
import com.rajat.presentation.CustomerPresentationImp;



public class CustomerMain {
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		CustomerPresentation presentation=new CustomerPresentationImp();
		while(true) {
			presentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=sc.nextInt();
			presentation.performMenu(choice);
		}
		

	}
}

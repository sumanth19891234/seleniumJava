package com.crm.qa.testcases.Examples;

import com.crm.qa.base.BaseSetup;
import com.crm.qa.pages.Amazon;

public class TestCasesInClass  extends BaseSetup{
	 static Amazon amazon;

	public static void main(String[] args) throws InterruptedException{
		
		  initialization(); 
		  amazon= new Amazon();	 
		  // TestCase1 : Verify Search functionality by searching a muliplte products in 
		  // amazon website and add to cart		 
		  amazon.SearchAndAddToCart();
		  // TestCase2 : Verify delete cart functionality by deleting a muliplte products in 
		  // amazon cart
		  amazon.DeleteFromCart();
	}

}

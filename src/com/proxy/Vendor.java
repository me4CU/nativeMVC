package com.proxy;


/**
 * @author JoneM
 *
 */
public class Vendor implements Sell { 
	public void sell() { 
		System.out.println("In sell method"); 
	}
  
	public void ad() { 
		System.out.println("ad method");
	} 
  
} 
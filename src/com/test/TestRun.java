package com.test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.TestCase;

public class TestRun extends TestCase {
	
	static ExecutorService tps = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		String str = "url1 url2 url3" ; 
		System.out.println("request is coming ! ") ;
		
		boolean f = true ; 
		while(f){
			long begintime = System.currentTimeMillis() ;
			process(str);
			long endtime = System.currentTimeMillis() ; 
			System.out.println("total second is " + (endtime - begintime) /1000);
			
			try {
				Thread.sleep(1000*2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void process(String reqStr){
		
		
		Mythread t1 = new Mythread();
		Mythread t2 = new Mythread();
		Mythread t3 = new Mythread();
			t1.start();
			
			t2.start();
			
			t3.start();
			
			long begintime = System.currentTimeMillis() ;
			
			
			while(t1.state == 0 || t2.state == 0  || t3.state == 0){
				
				try {
					Thread.sleep(100);
					long endtime = System.currentTimeMillis() ; 
					if(endtime - begintime > 1800){
						break ; 
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		String rs = t1.name + t2.name + t3.name ;
	
			
		System.out.println("process end! rs is " + rs );
		
	}
	
	
}

class Mythread extends Thread{
	
	 int state = 0 ;
	String name  ; 
	
	@Override
	public void run() {
		try {
			
			
			int c = ((int)(Math.random()*10)) ;
			
			System.out.println(Thread.currentThread().getName() + " begin! sleep " + c);
			
			Thread.sleep(1000*c );
			
			name  = Thread.currentThread().getName() + "r" ;
			
			System.out.println(Thread.currentThread().getName() + " end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}

class MyMthread extends Thread{
	

	List<Thread> ts =  null  ; 
	
	@Override
	public void run() {
		
		
		
		try {
			System.out.println(Thread.currentThread().getName() + " begin!");
			
			Thread.sleep(1000* ((int)(Math.random()*10)));
		
			
			System.out.println(Thread.currentThread().getName() + " end!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}


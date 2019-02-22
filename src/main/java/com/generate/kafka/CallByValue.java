package com.generate.kafka;

public class CallByValue {
	
	
	public static void changea(int n[])
	{
		n[1]=10;
		
	}
	public static void main(String[] args) {
		int a[] = {1,2};
		changea(a);
		System.out.println(a[1]);

	}

}

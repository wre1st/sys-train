package com.fib;

import java.util.Stack;

public class StackPract {
	
	Stack<Integer> fibo=new Stack();
	
	public static void main(String[] args) {
	
		System.out.println("--------------- Stack Practise ---------------- ");
		

	
	}
	
	public void fibonacci(int value) {
		
		Stack<Integer> temp=new Stack();
		fibo.push(0);
		fibo.push(1);
		
		temp.push(0);
		temp.push(1);
		temp.push(1);
		
		// 0 1 1 2 3 5 8 13 21 34
		int counter=2;
		while(counter<value) {
			
			temp.push(temp.pop()+temp.pop());
			temp.push(fibo.pop());
			counter++;
		}
		
	}
	public void display() {
		
		 
		
	}
}

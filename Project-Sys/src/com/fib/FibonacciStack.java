package com.fib;

import java.util.Stack;

public class FibonacciStack {
	Stack<Integer> stack=new Stack();

	// 0 1 1 2 3 5 8 13 21 34
	public FibonacciStack() {
		fibonacci(10);
		
	}
	public int fibonacci(int fib) {
		int fibo=0;
		stack.push(0);
		stack.push(1);
		
		int counter=0;
//		System.out.println(stack.peek());
		while(fib!=counter) {
//			stack.push(stack.peek());
			int top=stack.pop();
			int prev=stack.pop();
			System.out.print(prev+ " ");
			stack.push(top);
			stack.push(top+prev);
			
			stack.push(top);
			stack.push(top+prev);
			counter++;
		}
		
		return stack.peek();
	}
	
	public static void main(String[] args) {

		new FibonacciStack();
	}

}
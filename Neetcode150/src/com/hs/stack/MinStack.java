package com.hs.stack;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);

		// The min stack may be empty, so we need to check it
		val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
		minStack.push(val);
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(34);
		stack.push(4);
		stack.push(21);
		stack.push(11);
		stack.push(0);
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());
	}
}
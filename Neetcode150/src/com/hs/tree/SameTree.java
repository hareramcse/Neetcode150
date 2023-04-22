package com.hs.tree;

public class SameTree {
	public boolean isSameTree(Node a, Node b) {
		if (a == null || b == null)
			return a == b;

		return (a.data == b.data) && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
	}
}

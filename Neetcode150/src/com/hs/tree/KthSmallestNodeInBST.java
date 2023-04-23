package com.hs.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestNodeInBST {
	public int kthSmallest(Node root, int k) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		return list.get(k - 1);
	}

	private void inorder(Node root, List<Integer> list) {
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}

	public static void main(String[] args) {
		KthSmallestNodeInBST tree = new KthSmallestNodeInBST();

		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);

		int kthSmallest = tree.kthSmallest(root, 4);
		System.out.println("4th smallest node is: " + kthSmallest);
	}
}
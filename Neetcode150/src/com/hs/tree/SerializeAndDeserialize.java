package com.hs.tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserialize {
	private int i;

	// Encodes a tree to a single string.
	public String serialize(Node root) {
		List<String> list = new ArrayList<>();
		serializeDFS(root, list);

		return String.join(",", list);
	}

	private void serializeDFS(Node root, List<String> list) {
		if (root == null) {
			list.add("N");
			return;
		}
		list.add(String.valueOf(root.data));
		serializeDFS(root.left, list);
		serializeDFS(root.right, list);
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		String[] tokens = data.split(",");
		return deserializeDFS(tokens);
	}

	private Node deserializeDFS(String[] tokens) {
		String token = tokens[this.i];
		if (token.equals("N")) {
			this.i++;
			return null;
		}
		var node = new Node(Integer.parseInt(token));
		this.i++;
		node.left = deserializeDFS(tokens);
		node.right = deserializeDFS(tokens);
		return node;
	}
}
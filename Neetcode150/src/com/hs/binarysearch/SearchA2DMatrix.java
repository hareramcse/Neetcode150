package com.hs.binarysearch;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (target == matrix[i][j])
				return true;
			else if (target < matrix[i][j])
				j--;
			else
				i++;
		}
		return false;
	}

	public static void main(String[] args) {
		SearchA2DMatrix obj = new SearchA2DMatrix();
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 16;
		boolean result = obj.searchMatrix(matrix, target);
		System.out.println(result);
	}
}
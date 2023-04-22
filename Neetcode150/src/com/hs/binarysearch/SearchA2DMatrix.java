package com.hs.binarysearch;

public class SearchA2DMatrix {
	public boolean searchMatrix2(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;

		int rows = matrix.length;
		int columns = matrix[0].length;

		int low = 0;
		int high = rows * columns;

		while (low < high) {
			int mid = (low + high) / 2;

			if (matrix[mid / columns][mid % columns] == target) {
				return true;
			} else if (matrix[mid / columns][mid % columns] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return false;
	}
}

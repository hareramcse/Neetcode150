package com.hs.bitmanipulation;

import java.util.Arrays;

public class CountingBits {
	public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int x) {
        int count = 0;
        while (x != 0) {
			x &= x - 1;
            count++;
        }
        return count;
    }

	public static void main(String[] args) {
		CountingBits obj = new CountingBits();
		int n = 5;
		int[] result = obj.countBits(n);
		System.out.println(Arrays.toString(result));
	}
}
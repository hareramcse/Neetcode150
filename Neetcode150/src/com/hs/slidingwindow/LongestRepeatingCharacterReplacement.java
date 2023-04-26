package com.hs.slidingwindow;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            
            // (windowSize - count of most frequent element) > k
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		String s = "AABABBA";
		int k = 1;
		int result = obj.characterReplacement(s, k);
		System.out.println(result);
	}
}
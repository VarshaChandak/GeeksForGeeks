class Solution {
    public int countSubstring(String s) {
         int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int count = 0;
        for (int f : freq) {
            count += f * (f + 1) / 2;
        }

        return count;
    
        
    }
}
class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        String[] map = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        help(str, ans, map, arr, 0);
        return ans;
    }

    public static void help(StringBuilder x, ArrayList<String> ans,
                            String[] map, int[] arr, int curr) {
        if (curr == arr.length) {
            if (x.length() > 0)  
                ans.add(x.toString());
            return;
        }

        int digit = arr[curr];

        if (map[digit].isEmpty()) {
            help(x, ans, map, arr, curr + 1);
            return;
        }

        int csize = map[digit].length();
        for (int i = 0; i < csize; i++) {
            x.append(map[digit].charAt(i));   
            help(x, ans, map, arr, curr + 1); 
            x.deleteCharAt(x.length() - 1);   
        }
    }
}

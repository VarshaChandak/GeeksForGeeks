class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, ArrayList<String> current, ArrayList<ArrayList<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int end = start + 1; end <= s.length(); end++){
            String substr = s.substring(start, end);
            if(isPalindrome(substr)){
                current.add(substr);
                backtrack(s, end, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--)) return false;
        }
        
        return true;
    }
}

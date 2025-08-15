class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] ni) {
        // code here
        
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        int arr[][]= new int[n+1][2];
        for(int i =0 ;i <n;i++){
            arr[i][0]=intervals[i][0];
            arr[i][1]=intervals[i][1];
        }
        arr[n][0]= ni[0];
        arr[n][1]= ni[1];
        Arrays.sort(arr, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
    } else {
        return Integer.compare(a[0], b[0]);
    }
        });
        int start = arr[0][0], end=arr[0][1];
        
        for(int i =0;i<n+1;i++){
            int s =arr[i][0];
            int e = arr[i][1];
            if(s<=end){
                end = Math.max(e,end);
            }else{
                ans.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }
        ans.add(new int[]{start,end});
        return ans;
        
    }
}

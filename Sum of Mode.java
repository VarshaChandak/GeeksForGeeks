class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(b[1],a[1]);
        });
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int sum=0;
        while(j<arr.length){
             map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
             pq.add(new int[]{arr[j],map.get(arr[j])});
             
             if(j-i+1>k){
                 map.put(arr[i],map.get(arr[i])-1);
                 if(map.get(arr[i])<=0) map.remove(arr[i]);
                 i++;
             }
             
             if(j-i+1 == k){
                 while(!pq.isEmpty() && (!map.containsKey(pq.peek()[0]) || 
                 map.get(pq.peek()[0])!=pq.peek()[1])){
                     pq.poll();
                 }
                 if(map.containsKey(pq.peek()[0]) && map.get(pq.peek()[0])==pq.peek()[1]){
                     sum+=pq.peek()[0];
                 }
             }
             j++;
        }
        return sum;
    }
    
}

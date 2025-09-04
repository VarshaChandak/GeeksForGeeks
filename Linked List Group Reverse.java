/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        Node temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp!=null){
            arr.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        int n = arr.size();
        for(int i =0;i+k<=n;i++){
    
            for(int j =0;j<k;j++){
                temp.data = arr.get(i+k-j-1);
                temp=temp.next;
               
            }
            i=i+k-1;
        }
        int rem = n%k;
        if(rem!=0){// reverse whole part
        // starting -> n-1-rem
        // ending -> r-1
        for(int i = n-1;i>=n-rem;i--){
            temp.data=arr.get(i);
            temp=temp.next;
        }
            
        }
        return head;
    }
}

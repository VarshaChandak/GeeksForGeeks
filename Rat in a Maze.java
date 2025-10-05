class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;
        if(maze[0][0]==0 || maze[n-1][n-1]==0) return ans;
       
        boolean[][] seen= new boolean[n][n];
        seen[0][0]=true;
        StringBuilder curr= new StringBuilder();
        
        help(0,0,n,curr,maze,ans,seen);
        return ans;
    }
    public static void help(int ci,int cj, int n ,StringBuilder curr , int[][]maze, 
    ArrayList<String>ans , boolean[][]seen){
        if(ci==n-1 && cj==n-1){
            ans.add(curr.toString());
            return;
        }
        if(ci<0 || ci>=n ||cj<0 || cj>=n){
            return;
        }
        if(ci<n-1 && maze[ci+1][cj]==1 && !seen[ci+1][cj]){
            seen[ci+1][cj]=true;
            curr.append('D');
            help(ci+1,cj,n,curr,maze,ans,seen);
            curr.deleteCharAt(curr.length()-1);
            seen[ci+1][cj]=false;
        }
        if(cj>0 && maze[ci][cj-1]==1 && !seen[ci][cj-1]){
            seen[ci][cj-1]=true;
            curr.append('L');
            help(ci,cj-1,n,curr,maze,ans,seen);
            curr.deleteCharAt(curr.length()-1);
            seen[ci][cj-1]=false;
        }
        if(cj<n-1 && maze[ci][cj+1]==1 && !seen[ci][cj+1]){
            seen[ci][cj+1]=true;
            curr.append('R');
            help(ci,cj+1,n,curr,maze,ans,seen);
            curr.deleteCharAt(curr.length()-1);
            seen[ci][cj+1]=false;
        }
        if(ci>0 && maze[ci-1][cj]==1 && !seen[ci-1][cj]){
            seen[ci-1][cj]=true;
            curr.append('U');
            help(ci-1,cj,n,curr,maze,ans,seen);
            curr.deleteCharAt(curr.length()-1);
            seen[ci-1][cj]=false;
        }
        
    }
}

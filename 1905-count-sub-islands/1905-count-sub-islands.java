class Solution {
    
    
    //graph implementation solution
    
    public boolean dfs(int[][] grid1, int[][] grid2, int i , int j , int n, int m)
    {
        boolean ans = true;
        if(grid1[i][j]!=grid2[i][j])
        {
            ans = false;
        }
        grid2[i][j] = 0;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir: dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && y<m && x<n && grid2[x][y]==1)
            {
                ans = dfs(grid1,grid2,x,y,n,m) && ans;
            }
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2)
    {
        int n = grid1.length;
        int m = grid2[0].length;
        
        int ans= 0;
        for(int i = 0; i < n ; i++)
        {
            for(int j = 0 ; j <m ; j++)
            {
                if(grid2[i][j]==1)
                {
                    boolean issub = dfs(grid1,grid2, i, j , n, m);
                    if(issub)
                    {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
//     /////////////////////////////////////////////////
    
    
//     int island;
//     public int countSubIslands(int[][] grid1, int[][] grid2) {
//         island = 0;
//         //System.out.println(1);
//         boolean[][] visited2 = new boolean[grid2.length][grid2[0].length];
//         for(int i = 0; i<grid2.length ;i++)
//         {
//             for(int j = 0 ;j<grid2[0].length ; j++)
//             {
//                 if (grid2[i][j]==1)
//                 {
//                     boolean assumption = true;
//                     island++;
//                     //System.out.println(i);
//                     assumption = islands(grid1,grid2,i,j,visited2,assumption);
//                     if(assumption==false) island--;
//                 }
                
//             }
//         }
//         return island;
//     }
    
//     public boolean islands(int[][] grid1, int[][] grid2 , int row, int col, boolean[][] visited, boolean assumption)
//     {
//         int n = grid2.length;
//         int m = grid2[0].length;
//         if (row<0 || row >=grid1.length || col<0 || col >= grid1[0].length || grid2[row][col]!=1 || visited[row][col] ==true)
//         {
//             return assumption;
//         }
//         if (grid1[row][col]!=1) 
//         {
//             //assumption = false;
//             return false;
//         }
//         grid2[row][col] = 2;
//         visited[row][col] = true;
//         assumption = islands(grid1,grid2,row+1,col,visited,assumption);
//         assumption = islands(grid1,grid2,row-1,col,visited,assumption);
//         assumption = islands(grid1,grid2,row,col+1,visited,assumption);
//         assumption = islands(grid1,grid2,row,col-1,visited,assumption);
//         return assumption;
        
//     }
}
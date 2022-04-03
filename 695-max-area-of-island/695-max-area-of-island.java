class Solution {
    
    
    //graph solution //********************************
    public int dfs (int i , int j , int [][] grid)
    {
        grid[i][j] = 0 ;
        int size = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : dirs)
        {
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1)
            {
                size+=dfs(x,y,grid);
            }
        }
        return size+1;
    }
    public int maxAreaOfIsland(int [][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0 ; i < n ; i++)
        {
            for (int j = 0 ; j < m ; j++)
            {
                if(grid[i][j]==1)
                {
                    int size = dfs(i,j,grid);
                    ans=Math.max(ans,size);
                }
            }
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
//*****************************************************
    
//     public int maxAreaOfIsland(int[][] grid) {
//         int ans = 0;
//         boolean[][] seen = new boolean[grid.length][grid[0].length];
        
//         for (int i = 0 ; i < grid.length ; i++)
//         {
//             for (int j = 0 ; j < grid[0].length ; j++)
//             {
//                 ans= Math.max(area(grid,i,j,seen),ans);
//             }
//         }
//         return ans;
//     }
    
    
//     public static int area (int [][] grid, int r , int c, boolean[][] seen)
//     {
//         if(r>=grid.length || c>=grid[0].length || r<0 || c<0 || seen[r][c]==true ||grid[r][c]==0)
//         {
//             return 0;
//         }
//         seen[r][c] = true;
//         return (1+area(grid,r+1,c,seen)+area(grid,r-1,c,seen)+area(grid,r,c+1,seen)+area(grid,r,c-1,seen));
//     }
}
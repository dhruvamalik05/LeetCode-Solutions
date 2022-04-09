class Solution {
    int island;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        island = 0;
        //System.out.println(1);
        boolean[][] visited2 = new boolean[grid2.length][grid2[0].length];
        for(int i = 0; i<grid2.length ;i++)
        {
            for(int j = 0 ;j<grid2[0].length ; j++)
            {
                if (grid2[i][j]==1)
                {
                    boolean assumption = true;
                    island++;
                    //System.out.println(i);
                    assumption = islands(grid1,grid2,i,j,visited2,assumption);
                    if(assumption==false) island--;
                }
                
            }
        }
        return island;
    }
    
    public boolean islands(int[][] grid1, int[][] grid2 , int row, int col, boolean[][] visited, boolean assumption)
    {
        int n = grid2.length;
        int m = grid2[0].length;
        if (row<0 || row >=grid1.length || col<0 || col >= grid1[0].length || grid2[row][col]!=1 || visited[row][col] ==true)
        {
            return assumption;
        }
        if (grid1[row][col]!=1) 
        {
            //assumption = false;
            return false;
        }
        grid2[row][col] = 2;
        visited[row][col] = true;
        assumption = islands(grid1,grid2,row+1,col,visited,assumption);
        assumption = islands(grid1,grid2,row-1,col,visited,assumption);
        assumption = islands(grid1,grid2,row,col+1,visited,assumption);
        assumption = islands(grid1,grid2,row,col-1,visited,assumption);
        return assumption;
        
    }
}
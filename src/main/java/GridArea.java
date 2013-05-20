
public class GridArea {

    final int grid[][];

    public GridArea(int rows,int cols)
    {
        grid = new int[rows][];
        for(int x=0;x<grid.length;x++)
        {
            grid[x] = new int[cols];
        }
    }

    public int[][] getGrid()
    {
        return grid;
    }
    
    public boolean containsCoords(int x, int y)
    {
        return (x<=grid.length) && (y<=grid[x].length) ? true : false;
    }

}

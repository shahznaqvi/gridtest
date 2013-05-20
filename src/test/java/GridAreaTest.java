import junit.framework.TestCase;

public class GridAreaTest extends TestCase {
    
    public void testGridCreated()
    {
        int rows = 5;int cols=5;

        GridArea gridArea = new GridArea(rows,cols);

        assertEquals(true, gridArea.getGrid()!=null);
    }

}

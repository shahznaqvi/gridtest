import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class GameTest extends TestCase {


    Game game;
    int gridRows = 5;
    int gridCols = 5;
    public void testGameReady()
    {
      initGame();
      
      Robot robot = game.getRobot(0);
        
      assertEquals(true,robot!=null);
      
      assertEquals(true, game.getGridArea()!=null);
    }
    
    public void testInvalidRobotInitLocation()
    {
        boolean added = false;
        initGame();
        Robot robot1 = new Robot();
        robot1.setX(gridRows);
        robot1.setY(gridCols);

        try {
            game.addRobot(robot1);
            added = true;
        } catch (Exception e) {                                                        
            assertEquals(e instanceof ArrayIndexOutOfBoundsException,true);
            throw new RuntimeException(e);
        }

    }

    /**
     *    testing the results...
     */
    public void testUpdateDirection()
    {
        initGame();

        String moves="lmlmlmlmm";

        Robot rbt = new Robot();
        rbt.setX(1);
        rbt.setY(2);
        rbt.setDirection('n');

        for(char ch:moves.toCharArray())
        {
            try {
                game.updateDirection(ch,rbt);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        assertEquals( rbt.getX(),1);
        assertEquals( rbt.getY(),3);
    }
    
    private void initGame()
    {
        game = new Game();
        GridArea gridArea1 = new GridArea(gridRows,gridCols);

        Robot robot = new Robot();
        robot.setX(1);
        robot.setY(2);
        robot.setDirection('n');

        game.setGridArea(gridArea1);

        try {
            game.addRobot(robot);
        } catch (Exception e) {
            throw new RuntimeException("Invalid robot location provided"); //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

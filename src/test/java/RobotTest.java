import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RobotTest extends TestCase {

    public RobotTest(){}

    Robot robot = new Robot();



    @Test
    public void testRobotCreated()
    {
        int x =2;
        int y =3;
        char direction = 'n';
        
        robot.initLocation(x,y,direction);

        assertEquals(x,robot.getX());
        assertEquals(y,robot.getY());
        assertEquals(direction,robot.getDirection());

    }
    
}

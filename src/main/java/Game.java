import java.util.ArrayList;
import java.util.List;


public class Game {

     private GridArea gridArea;
     private Robot robot;

     List<Robot> robotSquad = new ArrayList<Robot>();
    
    public GridArea getGridArea() {
        return gridArea;
    }

    public void setGridArea(GridArea gridArea) {
        this.gridArea = gridArea;
    }
   
    public void addRobot(Robot robot) throws Exception {

        if(gridArea.containsCoords(robot.getX(),robot.getY()))
        {
            robotSquad.add(robot);
        }
        else
        {
            throw new Exception("Location not exists:"+ robot.getX()+","+robot.getY());
        }
    }    
    

    /**
     * possible values r,l,m [right,left,move]
     * @param direction
     */
    public void updateDirection(char direction,Robot robot1) throws Exception {
        robot = robot1;
        
        if(direction=='m')
        {
            makeMove();
            return;
        }

       if(direction=='l' || direction=='r')
       {
          if(robot.getDirection()=='n')
          {
              robot.setDirection(direction=='l'?'w':direction=='r'?'e':robot.getDirection());
              return;
          }
            if(robot.getDirection()=='w')
            {
                robot.setDirection(direction=='l'?'s':direction=='r'?'n':robot.getDirection());
                return;
            }
    
            if(robot.getDirection()=='s')
            {
                robot.setDirection(direction=='l'?'e':direction=='r'?'w':robot.getDirection());
                return;
            }
    
            if(robot.getDirection()=='e')
            {
                robot.setDirection(direction=='l'?'n':direction=='r'?'s':robot.getDirection());
                return;
            }
       }
        else
       {
           throw new RuntimeException("Unexpected input: "+direction);
       }
    }
    
    private void makeMove() throws Exception {
        if(robot.getDirection()=='n')
        {
            if(validateNexMove(robot.getX() ,robot.getY()+1))
                robot.move();
        }
        if(robot.getDirection()=='s')
        {
            if(validateNexMove(robot.getX() ,robot.getY()-1))
                robot.move();
        }
        if(robot.getDirection()=='e')
        {
            if(validateNexMove(robot.getX()+1 ,robot.getY()))
                robot.move();
        }
        if(robot.getDirection()=='w')
        {
            if(validateNexMove(robot.getX()-1 ,robot.getY()))
                robot.move();
        }
    }        
    
    private boolean validateNexMove(int x, int y) throws Exception {
        boolean valid = false;
        if(robot!=null && gridArea!=null)
        if(x<=gridArea.getGrid().length)
        {
            if(y<=gridArea.getGrid()[x].length)
            {
                return valid=true;
            }
        }

        if(!valid)
        {
            throw new Exception("["+x+","+y+"] is not a valid location");
        }
        return valid;
    }
    
    public Robot getRobot(int i)
    {
         return robotSquad.size() <= i ? null: i<0 ? null : robotSquad.get(i);
    }
    

    
}

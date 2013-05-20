
public class Robot {
    private int x;
    private int y;
    private char direction;
    // direction n,s,e,w
    public void initLocation(int x,int y, char direction)
    {
        this.setX(x);
        this.setY(y);
        this.setDirection(direction);
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move()
    {
        if(direction=='n')
        {
            y=y+1;
        }
        if(direction=='s')
        {
            y=y-1;
        }
        if(direction=='e')
        {
            x=x+1;
        }
        if(direction=='w')
        {
            x=x-1;
        }
    }
}

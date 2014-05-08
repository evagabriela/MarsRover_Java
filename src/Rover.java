import java.io.PrintStream;

public class Rover {

    private PrintStream printStream;

    public void start() {
       System.out.println("1 3 N");

    }

    private int xCoordinate(int x) {
       return x;
    }

    private int yCoordinate(int y) {
        return  y;
    }

    private String loc(String loc) {
        return loc;
    }

    public void move() {
        int x = 1;
       xCoordinate(x + 1);
       yCoordinate(3);
       loc("N");
    }


}

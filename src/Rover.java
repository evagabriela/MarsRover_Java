public class Rover {


    public void start() {
       System.out.println("1 3 N");

    }

    private int xCoordinate(int x) {
        System.out.print(x + " ");
       return x;
    }

    private int yCoordinate(int y) {
        System.out.print(y + " ");
        return  y;
    }

    private String loc(String loc) {
        System.out.print(loc);
        return loc;
    }

    public void move() {
       int y = 3;
       xCoordinate( 1);
       yCoordinate(y + 1);
       loc("N");
    }

}

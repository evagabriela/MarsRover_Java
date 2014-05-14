import java.util.ArrayList;

public class Rover {
    private Integer x;
    private Integer y;
    private String direction;
    private ArrayList<String> instructions;

    public Rover(Integer x, Integer y, String direction, ArrayList<String> instructions) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.instructions = instructions;
    }

    public String currentPosition(){
        return x + " "+ y + " " + direction;
    }

    public String move() {
       if( direction.equals("N") ){
            y += 1;
        } else if(direction.equals("S")){
           y -= 1;
       } else if(direction.equals("E")){
           x += 1;
       } else{
           x -= 1;
       }
        return currentPosition();
    }

    public String turnLeft() {
        if( direction.equals("N")){
            direction = "W";
        } else if(direction.equals("S")){
            direction = "E";
        } else if(direction.equals("E")){
            direction = "N";
        } else{
            direction = "S";
        }
        return currentPosition();
    }

    public String turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("S")) {
            direction.equals("W");
        } else if (direction.equals("E")) {
            direction = "S";
        } else {
            direction = "N";
        }
        return currentPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (!direction.equals(rover.direction)) return false;
//        if (!instructions.equals(rover.instructions)) return false;
        if (!x.equals(rover.x)) return false;
        if (!y.equals(rover.y)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        result = 31 * result + direction.hashCode();
        result = 31 * result + instructions.hashCode();
        return result;
    }
}


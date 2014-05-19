import java.util.Arrays;

public class Rover {
    private int x;
    private int y;
    private String direction;
    private final char[] instructions;

    public Rover(int x, int y, String direction, String instructions) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.instructions =  instructions.toCharArray();
    }

    public String currentPosition(){
        return x + " "+ y + " " + direction;
    }

    public int xCoordinate(){
        return x;
    }

    public int yCoordinate(){
        return y;
    }

    public void move() {
//        here is where I need to check if valid space
       if( direction.equals("N") ){
            y += 1;
        } else if(direction.equals("S")){
           y -= 1;
       } else if(direction.equals("E")){
           x += 1;
       } else{
           x -= 1;
       }
    }

    public void turnLeft() {

        if( direction.equals("N")){
            direction = "W";
        } else if(direction.equals("S")){
            direction = "E";
        } else if(direction.equals("E")){
            direction = "N";
        } else{
            direction = "S";
        }
    }

    public void turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("E")) {
            direction = "S";
        } else {
            direction = "N";
        }
    }

    public void runInstruction() {
        for (Character instruction : instructions) {

            String instructionString = String.valueOf(instruction);

                  if (instructionString.equals("R")) {
                      turnRight();
                  } else if (instructionString.equals("L")) {
                      turnLeft();
                  } else {
                      move();
                  }
              }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (x != rover.x) return false;
        if (y != rover.y) return false;
        if (!direction.equals(rover.direction)) return false;
        if (!Arrays.equals(instructions, rover.instructions)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + direction.hashCode();
        result = 31 * result + Arrays.hashCode(instructions);
        return result;
    }
}



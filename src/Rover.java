import java.util.Arrays;

public class Rover {
    private final Plateau plateau;
    private int x;
    private int y;
    private String direction;
    private final char[] instructions;
    private boolean error;

    public Rover(int x, int y, String direction, String instructions, Plateau plateau) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.instructions =  instructions.toCharArray();
        this.plateau = plateau;
    }

    public String currentPosition(){
        return x + " "+ y + " " + direction;
    }

    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate(){
        return y;
    }

    public void move() {

        int roverXCor = getXCoordinate();
        int roverYCor = getYCoordinate();

        if (direction.equals("S") && plateau.isSpaceValid(roverXCor, roverYCor - 1)) {
            y -= 1;
        } else if (direction.equals("S") && !plateau.isSpaceValid(roverXCor, roverYCor - 1)) {
            error = true;
        } else if (direction.equals("W") && plateau.isSpaceValid(roverXCor - 1, roverYCor)) {
            x -= 1;
        } else if (direction.equals("W") && !plateau.isSpaceValid(roverXCor - 1, roverYCor)) {
            error = true;
        } else if (direction.equals("N") && plateau.isSpaceValid(roverXCor, roverYCor + 1)) {
            y += 1;
        } else if (direction.equals("N") && !plateau.isSpaceValid(roverXCor, roverYCor + 1)) {
            error = true;
        } else if(direction.equals("E")){
           x += 1;
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

            if (instructionString.equals("M")) {
                move();
            } else if (instructionString.equals("L")) {
                turnLeft();
            } else {
               turnRight();
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
        if (direction != null ? !direction.equals(rover.direction) : rover.direction != null) return false;
        if (!Arrays.equals(instructions, rover.instructions)) return false;
        if (plateau != null ? !plateau.equals(rover.plateau) : rover.plateau != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = plateau != null ? plateau.hashCode() : 0;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (instructions != null ? Arrays.hashCode(instructions) : 0);
        return result;
    }

    public boolean hasError() {
        if (error){
            return true;
        } else {
            return false;
        }
    }
}



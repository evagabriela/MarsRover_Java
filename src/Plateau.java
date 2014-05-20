import java.util.ArrayList;

public class Plateau {
    private final ArrayList<Rover> roverList;
    private final int height;
    private final int width;

    public Plateau(int height, int width){
        this.height = height;
        this.width = width;
        this.roverList = new ArrayList<Rover>();
    }

    public boolean isSpaceValid(int x, int y) {

        for (Rover rover: roverList) {
            int roverXCoordinate = rover.xCoordinate();
            int roverYCoordinate = rover.yCoordinate();

            if (x == roverXCoordinate && y == roverYCoordinate){
                return false;
            }
        }

        if ((x > height || y > width)) {
            return false;
        } else if ((x < 0 || y < 0)) {
            return false;
        }
        return true;
    }

    public boolean addRover(Rover rover) {
        int x = rover.xCoordinate();
        int y = rover.yCoordinate();
        if (isSpaceValid(x,y)){
            roverList.add(rover);
            return true;
        } else {
            return false;
        }

    }

    public void runRoverInstructions() {
        for (Rover rover: roverList) {
            rover.runInstruction();
        }
    }

    public String showRoverFinalPositions() {
        String finalPosRover = "";
        for (Rover rover : roverList){
            finalPosRover += (rover.currentPosition()) + "\n";
        }

        return finalPosRover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plateau plateau = (Plateau) o;

        if (height != plateau.height) return false;
        if (width != plateau.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        return result;
    }
}

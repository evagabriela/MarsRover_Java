import java.io.PrintStream;
import java.util.ArrayList;

public class Plateau {
    private final ArrayList<Rover> roverList;
    private final int height;
    private final int width;
    private PrintStream printStream;


    public Plateau(int height, int width, PrintStream printStream){
        this.height = height;
        this.width = width;
        this.roverList = new ArrayList<Rover>();
        this.printStream = printStream;

    }

    public boolean isSpaceValid(int x, int y) {

        for (Rover rover: roverList) {
            int roverXCoordinate = rover.getXCoordinate();
            int roverYCoordinate = rover.getYCoordinate();

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
        int x = rover.getXCoordinate();
        int y = rover.getYCoordinate();
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

    public void showRoverFinalPositions() {
        printStream.println("There are in total " + roverList.size() + " rovers: \n");

        for (Rover rover : roverList){
            if (!rover.getError()){
                printStream.println("Rover final position: "+(rover.currentPosition()) + "\n");
            } else {
                printStream.println("Rover final position: This rover has invalid instructions" + "\n");
            }

        }
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

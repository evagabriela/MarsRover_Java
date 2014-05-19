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
        String xCoordinate = String.valueOf(x);
        String yCoordinate = String.valueOf(y);

        for (int i = 0; i < roverList.size(); i++) {
            String roverPosition = roverList.get(i).currentPosition();

            if (roverPosition.contains(xCoordinate) || roverPosition.contains(yCoordinate)) {
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
            for (int i = 0; i < roverList.size(); i++){
                String roverPosition = roverList.get(i).currentPosition();
                if (roverPosition.equals(rover.currentPosition())){
                    return false;
                }
            }
            roverList.add(rover);
        }
        return true;
    }

    public void runRoverInstructions() {
        for (int i = 0; i<roverList.size(); i++){
            roverList.get(i).runInstruction();
        }
    }

    public String showRoverFinalPositions() {
        String finalPosRover = "";
        for (int i = 0; i<roverList.size(); i++){
            finalPosRover += (roverList.get(i).currentPosition()) + "\n";
        }

        return finalPosRover;
    }

    @Override
    public boolean equals(Object object){
        if (this == object && object != null) {
            return true;
        } else if ((this.height == ((Plateau) object).height && this.width == ((Plateau) object).width)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        return result;
    }
}

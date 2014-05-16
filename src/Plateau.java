import java.util.ArrayList;

/**
 * Created by gzamudio on 5/12/14.
 */
public class Plateau {
    ArrayList<Rover> roverList;
    private final int height;
    private final int width;

    public Plateau(int height, int width){
        this.height = height;
        this.width = width;
        this.roverList = new ArrayList<Rover>();
    }

    public boolean isSpaceValid(int x, int y) {
        if ((x > height || y > width) || (x < 0 || y < 0)){
            return false;
        } else {
            return true;
        }
    }

    public boolean addRover(Rover rover) {
        for (int i = 0; i < roverList.size(); i++){
            String roverPosition = roverList.get(i).currentPosition();

            if (roverPosition == rover.currentPosition()){
                return false;
            }
        }
        roverList.add(rover);
        return true;
    }

    public void runRoverInstructions() {
        for (int i = 0; i<roverList.size(); i++){
            roverList.get(i).runInstruction();
        }
    }

    public void showRoverFinalPositions() {
        for (int i = 0; i<roverList.size(); i++){

            System.out.println(roverList.get(i).currentPosition());
        }
    }

    @Override
    public boolean equals(Object object){
        if (this == object && object != null || (this.height == ((Plateau) object).height && this.width == ((Plateau) object).width )) {
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

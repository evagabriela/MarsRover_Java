import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "resources/sampleInput.txt";
        RoverParser roverParser = new RoverParser(fileName);
        Plateau plateau =  roverParser.openFile();

        plateau.runRoverInstructions();

        plateau.showRoverFinalPositions();

    }
}

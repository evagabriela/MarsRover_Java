import java.io.IOException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        String fileName = "resources/sampleInput.txt";
        RoverParser roverParser = new RoverParser(fileName, out);
        Plateau plateau =  roverParser.plateauSetUp();

        plateau.runRoverInstructions();

        plateau.showRoverFinalPositions();
    }
}

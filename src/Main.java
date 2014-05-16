import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "resources/sampleInput.txt";
        RoverParser roverParser = new RoverParser(fileName);

//      Calling this method also calls the parseFile which creates
//      the Plateau and the Rover
        roverParser.openFile();

//        roverParser.finalPositions();

//
//        System.out.println(finalPosition);

    }
}

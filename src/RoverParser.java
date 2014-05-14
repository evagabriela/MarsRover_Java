import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by gzamudio on 5/9/14.
 */
public class RoverParser {
    private String fileName;
    private Plateau plateau;
    private ArrayList<String> instructions;
    private Rover rover;

    public RoverParser(String fileName){
        this.fileName = fileName;
    }

    public void parseFile() {
        try {
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;
            line = bufferReader.readLine();
            createPlateau(line);

            while ((line = bufferReader.readLine()) != null) {
                String direction = bufferReader.readLine();
                createRover(line, direction);
            }
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:"
                    + e.getMessage());
        }
    }


    public Plateau createPlateau(String line){
        String[] linePlateauPieces = line.split(" ");

        String height = linePlateauPieces[1];
        String width = linePlateauPieces[0];

        int heightNum = parseInt(height);
        int widthNum = parseInt(width);

        plateau = new Plateau(widthNum, heightNum);
        return plateau;
    }

    public Rover createRover(String initialLocation, String direction) {
        String[] linePieces = initialLocation.split(" ");

        instructions = new ArrayList<String>(Arrays.asList(direction.split("")));

        rover = new Rover(parseInt(linePieces[0]), parseInt(linePieces[1]), linePieces[2],instructions);

        return rover;
    }
}

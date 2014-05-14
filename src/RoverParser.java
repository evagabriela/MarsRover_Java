import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class RoverParser {
    private String fileName;
    private Plateau plateau;
    private Rover rover;

    public RoverParser(String fileName){
        this.fileName = fileName;
    }

    public void openFile() throws IOException {
        FileReader inputFile = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(inputFile);
        parseFile(bufferReader);
        bufferReader.close();

    }

    public void parseFile(BufferedReader bufferReader) throws IOException {
        String line;
        line = bufferReader.readLine();
        createPlateau(line);

        while ((line = bufferReader.readLine()) != null) {
            String direction = bufferReader.readLine();
            createRover(line, direction);
        }
    }

    public Rover createRover(String initialLocation, String instructions) {
        String[] linePieces = initialLocation.split(" ");
        rover = new Rover(parseInt(linePieces[0]), parseInt(linePieces[1]), linePieces[2],instructions);
        return rover;
    }


    public Plateau createPlateau(String line)  {
        String[] linePlateauPieces = line.split(" ");

        String height = linePlateauPieces[1];
        String width = linePlateauPieces[0];

        int heightNum = parseInt(height);
        int widthNum = parseInt(width);

        plateau = new Plateau(widthNum, heightNum);
        return plateau;
    }



}

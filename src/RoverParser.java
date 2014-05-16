import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class RoverParser {
    private String fileName;

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
        Plateau plateau = createPlateau(line);

        while ((line = bufferReader.readLine()) != null) {
            String instructions = bufferReader.readLine();
            plateau.addRover(createRover(line, instructions));
        }
    }

    public Rover createRover(String initialLocation, String instructions) {
        String[] linePieces = initialLocation.split(" ");
        return new Rover(parseInt(linePieces[0]), parseInt(linePieces[1]), linePieces[2], instructions);
    }

    public Plateau createPlateau(String line)  {
        String[] linePlateauPieces = line.split(" ");

        String height = linePlateauPieces[1];
        String width = linePlateauPieces[0];

        int heightNum = parseInt(height);
        int widthNum = parseInt(width);

        return new Plateau(widthNum, heightNum);
    }

}

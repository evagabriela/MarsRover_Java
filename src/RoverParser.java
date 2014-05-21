import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class RoverParser {
    private final String fileName;
    private PrintStream out;

    public RoverParser(String fileName, PrintStream printStream){
        this.fileName = fileName;
        this.out = printStream;

    }

    public Plateau plateauSetUp() throws IOException {
        FileReader inputFile = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(inputFile);
        Plateau plateau = parseFile(bufferReader);
        bufferReader.close();
        return plateau;
    }

    public Plateau parseFile(BufferedReader bufferReader) throws IOException {
        String line;
        line = bufferReader.readLine();
        Plateau plateau = createPlateau(line);

        while ((line = bufferReader.readLine()) != null) {
            String instructions = bufferReader.readLine();
            plateau.addRover(createRover(line, instructions, plateau));
        }
        return plateau;
    }

    public Rover createRover(String initialLocation, String instructions, Plateau plateau) {
        String[] linePieces = initialLocation.split(" ");

        return new Rover(parseInt(linePieces[0]), parseInt(linePieces[1]), linePieces[2], instructions, plateau);
    }

    public Plateau createPlateau(String line)  {
        String[] linePlateauPieces = line.split(" ");

        String height = linePlateauPieces[1];
        String width = linePlateauPieces[0];

        int widthNum = parseInt(width);
        int heightNum = parseInt(height);

        return new Plateau(heightNum, widthNum, out);
    }

}

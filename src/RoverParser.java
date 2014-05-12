import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzamudio on 5/9/14.
 */
public class RoverParser {
    private List<Coordinate> coordinates = new ArrayList<Coordinate>();

    public RoverParser(String fileName) {
//        System.out.println("Reading File from Java code");
        //Name of the file
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
//                System.out.println(line);

//                Adding each element to an array of Strings call linePieces
                String[] linePieces = line.split(" ");

                Coordinate coordinateArray = new Coordinate(linePieces[0], linePieces[1], linePieces[2]);
                coordinates.add(coordinateArray);
//             Above code is same as: coordinates.add(new Coordinate(linePieces[0], linePieces[1], linePieces[2]));

            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:"
                    + e.getMessage());
        }
    }

    public Integer getXCoordinate(){
        String xCoordinate = coordinates.get(0).x;
        Integer xCoordinateNum = Integer.parseInt(xCoordinate);
        return xCoordinateNum;
    }

    public Integer getYCoordinate(){
        String yCoordinate = coordinates.get(0).y;
        Integer yCoordinateNum = Integer.parseInt(yCoordinate);
        return yCoordinateNum;
    }

    public String getDirection(){
        return coordinates.get(0).direction;
    }
}

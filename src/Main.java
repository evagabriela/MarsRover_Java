import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Need to create a class call grid or plateau that will handle the input from the file

         List<Coordinate> coordinates = new ArrayList<Coordinate>();

        String fileName = "resources/sampleInput.txt";

         coordinates = new RoverParser(fileName).getCoordinates();

        String xCoordinate = coordinates.get(0).x;
        Integer xCoordinateNum = Integer.parseInt(xCoordinate);

        String yCoordinate = coordinates.get(0).y;
        Integer yCoordinateNum = Integer.parseInt(yCoordinate);


        String direction = coordinates.get(0).direction;


        Rover rover = new Rover(xCoordinateNum,yCoordinateNum, direction);

        System.out.println("**** Current Position ****");
        System.out.println(rover.currentPosition());

//        **** Temporal code for testing purposes *****
        System.out.println("**** Move Rover ****");
        System.out.println(rover.move());

        System.out.println("**** Rover Turn Left****");

        System.out.print(rover.turnLeft());


    }
}

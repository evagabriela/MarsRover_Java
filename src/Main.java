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


////        **** Temporal code for checking code purposes *****
        System.out.println("**** Move Rover Forward ****");
        System.out.println(rover.move());

//
        System.out.println("**** Rover Turn Left****");
////        Problem:  Its not recognizing "N" direction and therefore its not changing direction when turned left.  Why is not recognizing direction to be "N"?
        System.out.println(rover.turnLeft());

    }
}

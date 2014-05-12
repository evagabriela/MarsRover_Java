public class Main {

    public static void main(String[] args) {

        String fileName = "resources/sampleInput.txt";

         String directionRover = new RoverParser(fileName).getDirection();
         Integer xCoordinate = new RoverParser(fileName).getXCoordinate();
         Integer yCoordinate = new RoverParser(fileName).getYCoordinate();

        Rover rover = new Rover(xCoordinate,yCoordinate, directionRover);

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

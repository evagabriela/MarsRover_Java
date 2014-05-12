public class Main {

    public static void main(String[] args) {

        String fileName = "resources/sampleInput.txt";

         String directionRover = new RoverParser(fileName).getDirection();
         Integer xCoordinate = new RoverParser(fileName).getXCoordinate();
         Integer yCoordinate = new RoverParser(fileName).getYCoordinate();

        Rover rover = new Rover(xCoordinate,yCoordinate, directionRover);

        System.out.println("**** Rover Current Position ****");
        System.out.println(rover.currentPosition());

 //        **** Temporal code for checking code purposes *****

        System.out.println("**** Move Rover Forward ****");
        System.out.println(rover.move());

        System.out.println("**** Rover Turn Left****");
        System.out.println(rover.turnLeft());

        System.out.println("**** Rover Multiple Move and new position after****");
        System.out.println("Rover starting position: ");
        System.out.println(rover.currentPosition());
        rover.move();
        rover.turnLeft();
        rover.move();
        System.out.println(rover.currentPosition());
    }
}

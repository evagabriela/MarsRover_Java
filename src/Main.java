public class Main {

    public static void main(String[] args) {

        String fileName = "resources/sampleInput.txt";
        RoverParser roverParser = new RoverParser(fileName);

         String directionRover = roverParser.getDirection();
         Integer xCoordinate = roverParser.getXCoordinate();
         Integer yCoordinate = roverParser.getYCoordinate();

        Rover rover = new Rover(xCoordinate,yCoordinate, directionRover);

    }
}

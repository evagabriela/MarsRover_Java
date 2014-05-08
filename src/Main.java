public class Main {

    public static void main(String[] args) {
//        Need to add file to get the input
//        Need to create a class call grid or plateau that will handle the input from the file

        Rover rover = new Rover(1, 3, "N");

        System.out.println(rover.currentPosition());

//        **** Temporal code for testing purposes *****
        System.out.print(rover.move());
         System.out.print(rover.turnLeft());


    }
}

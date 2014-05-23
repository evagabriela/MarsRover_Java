/**
 * Created by gzamudio on 5/23/14.
 */
public class MoveCommand implements Command {

    private Rover rover;

    public MoveCommand(Rover rover){
        this.rover = rover;
    }

    @Override
    public void execute(){
        rover.move();
    }
}

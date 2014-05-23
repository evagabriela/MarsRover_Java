/**
 * Created by gzamudio on 5/23/14.
 */
public class TurnLeftCommand implements Command {

    private Rover rover;

    public TurnLeftCommand(Rover rover){
        this.rover = rover;
    }

    @Override
    public void execute(){
        rover.turnLeft();
    }
}

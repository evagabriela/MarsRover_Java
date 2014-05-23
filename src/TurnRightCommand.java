/**
 * Created by gzamudio on 5/23/14.
 */
public class TurnRightCommand implements Command {

    private Rover rover;

    public TurnRightCommand(Rover rover){
        this.rover = rover;
    }

    @Override
    public void execute(){
        rover.turnRight();
    }
}

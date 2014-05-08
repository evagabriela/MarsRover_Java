public class Rover {
    private  Integer x;
    private Integer y;
    private final String direction;

    public Rover(Integer x, Integer y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String currentPosition(){
        return x + " "+ y + " " + direction;
    }

    public String  move() {

       if( direction == "N"){
            y += 1;
        } else if(direction == "S"){
           y -= 1;
       } else if(direction == "E"){
           x += 1;
       } else{
           x -= 1;
       }
        return currentPosition();
    }


}

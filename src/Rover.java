public class Rover {
    private  Integer x;
    private Integer y;
    private String direction;

    public Rover(Integer x, Integer y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String currentPosition(){
        return x + " "+ y + " " + direction;
    }

    public String move() {

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


    public String turnLeft() {
        if( direction == "N"){
            direction = "W";
        } else if(direction == "S"){
            direction = "E";
        } else if(direction == "E"){
            direction = "N";
        } else{
            direction = "S";
        }
        return currentPosition();
    }
}

public class Rover {
    public   Integer x;
    public Integer y;
    public String direction;

    public Rover(Integer x, Integer y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String currentPosition(){
        return x + " "+ y + " " + direction;
    }

    public String move() {
       if( direction.equals("N") ){
            y += 1;
        } else if(direction.equals("S")){
           y -= 1;
       } else if(direction.equals("E")){
           x += 1;
       } else{
           x -= 1;
       }
        return currentPosition();
    }

    public String turnLeft() {
        if( direction.equals("N")){
            direction = "W";
        } else if(direction.equals("S")){
            direction = "E";
        } else if(direction.equals("E")){
            direction = "N";
        } else{
            direction = "S";
        }
        return currentPosition();
    }

    public String turnRight() {
        if( direction == "N"){
            direction = "E";
        } else if(direction == "S"){
            direction = "W";
        } else if(direction == "E"){
            direction = "S";
        } else{
            direction = "N";
        }
        return currentPosition();
    }

}

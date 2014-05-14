/**
 * Created by gzamudio on 5/12/14.
 */
public class Plateau {

    private final int height;
    private final int width;

    public Plateau(int height, int width){
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object object){
        if (this == object && object != null){
            return true;
        } else if (this.height == ((Plateau) object).height && this.width == ((Plateau) object).width ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        return result;
    }


}

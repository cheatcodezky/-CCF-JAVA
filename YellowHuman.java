/**
 * Created by 95112 on 2/3/2018.
 */
public class YellowHuman implements Human {
    @Override
    public String getColor() {
        System.out.println("Yellow people`s skin is yellow");
        return "Yellow";
    }

    @Override
    public void talk() {
        System.out.println("Yellow man`s speaking we can understand");
    }
}

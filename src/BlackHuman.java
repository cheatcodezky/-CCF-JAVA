/**
 * Created by 95112 on 2/3/2018.
 */
public class BlackHuman implements Human {
    @Override
    public String getColor() {
        System.out.println("Black Hunman`s skin is black!");
        return "Black";
    }

    @Override
    public void talk() {
        System.out.println("Black`s speaking no one understand.");
    }
}

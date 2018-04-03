/**
 * Created by 95112 on 2/3/2018.
 */
public class WhiteHuman implements Human {
    @Override
    public String getColor() {
        System.out.println("WhiteHuman`s skin is white");
        return "White";
    }

    @Override
    public void talk() {
        System.out.println("WhiteHuman speaks English");
    }
}

/**
 * Created by 95112 on 2/2/2018.
 */
public class PettyGirl implements IGoodBodyGirl,IGreatTemperamentGirl {
    private String name;
    public PettyGirl (String _name)
    {
        this.name = _name;
    }
    @Override
    public void goodLooking() {
        System.out.println(this.name + "-- has beautiful face.");
    }

    @Override
    public void niceFigure() {
        System.out.println(this.name + "-- has hot figure.");
    }

    @Override
    public void greatTemperament() {
        System.out.println(this.name + "-- has greate temperament.");
    }

}

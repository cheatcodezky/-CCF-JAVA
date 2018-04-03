/**
 * Created by 95112 on 2/3/2018.
 */
public abstract class AbstractHumanFactory  {
    public abstract <T extends Human> T  createHuman(Class<T> c);
}

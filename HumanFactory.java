/**
 * Created by 95112 on 2/3/2018.
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try{
            human = (Human)Class.forName(c.getName()).newInstance();
        }catch(Exception e){
            System.out.println("Error");
        }
        return (T) human;
    }
}

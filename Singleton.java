/**
 * Created by 95112 on 2/3/2018.
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();
    private Singleton(){
    }
    public static Singleton getSingleton(){
        return singleton;
    }
    public static void doSomething(){
    }
}

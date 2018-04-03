/**
 * Created by 95112 on 2/3/2018.
 */
public class Emperor {
    private static final Emperor emperor = new Emperor();
    private Emperor(){
    }
    public static Emperor getInstance(){
        return emperor;
    }
    public static void say(){
        System.out.println("I am Emperor.");
    }
}

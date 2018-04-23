import java.text.NumberFormat;

/**
 * Created by 95112 on 2/3/2018.
 */
public class Ministers {
    public static void main(String[] args){
        int ministerNum = 5;
        for (int i = 0; i < ministerNum ; i++){
            NumberEmperor emperor = NumberEmperor.getInstance();
            System.out.print("minister "+i+" see ");
            emperor.say();
        }
    }
}

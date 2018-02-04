import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 95112 on 2/3/2018.
 */
public class NumberEmperor {
    private static int maxNumOfEmperor = 2;
    private static ArrayList <String> nameList = new ArrayList<>();
    private static ArrayList<NumberEmperor> emperorList = new ArrayList<>();
    private static int countNumOfEmperor = 0;
    static{
        for(int i=0; i < maxNumOfEmperor; i++){
            emperorList.add(new NumberEmperor("Empeor "+i));
        }
    }
    private NumberEmperor(String name){
        nameList.add(name);
    }
    public static NumberEmperor getInstance(){
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperorList.get(countNumOfEmperor);
    }
    public static void say(){
        System.out.println(nameList.get(countNumOfEmperor));
    }

}

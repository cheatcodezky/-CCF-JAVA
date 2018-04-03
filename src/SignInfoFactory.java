import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by 95112 on 2/19/2018.
 */
public class SignInfoFactory {
    private static HashMap<String,SignInfo> pool = new HashMap<>();
    protected Client client = new Client();
    protected ArrayList<String> answer = new ArrayList<>();
    public static SignInfo getSignIfo(String key){
        SignInfo result = null;
        if(!pool.containsKey(key)){
            result = new SignInfo4Pool(key);
            pool.put(key,result);
        }
        else{
            result  = pool.get(key);
        }
        Random random = new Random();
        random.nextInt(100);
        double i = Math.random();
        return result;
    }
}

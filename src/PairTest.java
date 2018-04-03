/**
 * Created by 95112 on 2018/4/3.
 */
import animals.Pair;
public class PairTest {
    public static void main(String[] args)
    {
        String[] words =    {"Mary","had","a","little","lamb"};
        Pair<String>  mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst()+"  "+mm.getSecond());


    }

}
class ArrayAlg{
    public static Pair<String> minmax(String[] a)
    {
        if(a==null||a.length==0)return null;
        String min =a[0];
        String max =a[0];
        for(int i =0 ; i<a.length;i++){
            if (min.compareTo(a[i]) > 0)min=a[i];
            if (max.compareTo(a[i]) < 0)max=a[i];
        }
        return new Pair<>(min,max);
    }
}


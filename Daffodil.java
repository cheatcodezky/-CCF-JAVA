/**
 * Created by 95112 on 1/24/2018.
 */
public class Daffodil {
    public static void main(String[] args){
        int a,b,c;
        for (int i = 100; i < 1000;i++){
            a = i/100;
            b = i/10%10;
            c = i%10;
            if (i == Math.pow(a,3)+ Math.pow(b,3)+Math.pow(c,3))
                System.out.println(i);
        }
    }
}

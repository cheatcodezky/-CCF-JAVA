import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 10/22/2017.
 */
public class Molecule {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] atoms = new int[3];
        int[] storageAtoms = new int[3];
        int[] answer = new int[3];
        for (int i =0 ; i< 3 ; i++) {
            atoms[i] = scanner.nextInt();
            storageAtoms[i] = atoms[i];
        }
        Arrays.sort(atoms);
        if (atoms[0] <= 0 )
        {
            System.out.println("Impossible");
            return;
        }
        if (atoms[2] > atoms[1]+atoms[0]){
            System.out.println("Impossible");
            return;
        }
        int dValue = atoms[1] - atoms[0];
        if ((atoms[2] - dValue)%2 == 1)
        {
            System.out.println("Impossible");
            return;
        }
        else {
            int tmpDValue = storageAtoms[1] - storageAtoms[2];
           if (tmpDValue < 0 ){
               answer[0] =( storageAtoms[0] + tmpDValue)/2;
               answer[2] = answer[0] - tmpDValue;
               answer[1] = storageAtoms[1] - answer[0];
           }
           else {
               answer[0] = (storageAtoms[0] - tmpDValue)/2 + tmpDValue;
               answer[2] = (storageAtoms[0] - tmpDValue)/2;
               answer[1] = storageAtoms[1] - answer[0];
           }
        }

        for (int ans : answer)
            System.out.print(ans+" ");

    }

}

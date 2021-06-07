import java.util.*;

public class FindAlphabet {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        for(int i=97; i<123; i++){

            System.out.print(s.indexOf(i) + " ");

        }
    }
}

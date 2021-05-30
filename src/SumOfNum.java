import java.util.Scanner;

public class SumOfNum {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();
        scan.nextLine();
        String num = scan.nextLine();

        int sum = 0;
        for(int i=0; i<total; i++){

            sum += num.charAt(i) -'0';
        }

        System.out.println(sum);
    }
}

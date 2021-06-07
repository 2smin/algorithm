import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11653 {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bf.readLine());
        int loop = num+1;

        for(int i=2; i<loop; i++){

            while(num%i == 0){
                num = num/i;
                System.out.println(i);
            }

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2581 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.valueOf(bf.readLine());
        int max = Integer.valueOf(bf.readLine());

        int sum = 0;
        int fin = 0;

        int loop = max-min > 0 ? max-min : 1;

        for(int t=0; t <= loop; t++) {

            int num = max - t;

            for(int i=num-1; i>0; i--){

                if(i==1){
                    sum += num;
                    fin = num;
                    break;
                }

                if((num/i > 0) && (num%i == 0)){ break;}
            }
        }

        if(sum > 0){
            System.out.println(sum);
            System.out.println(fin);
        }else{
            System.out.println(-1);
        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(bf.readLine());

        int i = 0;
        int j=0;

        boolean isTrue = true;

        while(isTrue){

            i+=j;

            if(6*i + 1 >= num){
                System.out.println(j+1);
                isTrue = false;
                break;
            }

            j++;
        }
    }
}

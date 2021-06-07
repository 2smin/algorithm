import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());

        String input = bf.readLine();
        String[] nums = input.split(" ");

        int count = total;

        for(int t=0; t<total; t++) {

            int num = Integer.valueOf(nums[t]);

            if(num == 1){
                count--;
            }

            for(int i=num-1; i>1; i--){

                if((num/i > 0) && (num%i == 0)){
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2869 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] nums = input.split(" ");


        int distance = Integer.valueOf(nums[0]);
        int fall = Integer.valueOf(nums[1]);
        int height = Integer.valueOf(nums[2]);

        int i = 0;
        while(true){
            i++;
            height -= distance;

            if(height <= 0){
                break;
            }
            height += fall;
        }

        System.out.println(i);

    }
}

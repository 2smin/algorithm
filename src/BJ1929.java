import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        String[] nums = input.split(" ");

        int min = Integer.valueOf(nums[0]);
        int max = Integer.valueOf(nums[1]);

        int[] list = new int[max+1];

        for(int i=2; i<=max; i++){
            list[i] = i;
        }

        for(int i=2; i<=max; i++){

            if(list[i] == 0){
                continue;
            }

            for(int j=i+i; j<=max; j+=i){
                list[j] = 0;
            }
        }

        //반복 출력 시 Stringbuilder 쓰면 효과적
        StringBuilder sb = new StringBuilder();
        for(int i=min; i<=max; i++){
            if(list[i] != 0){
                sb.append(list[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1011 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());

        int[] output = new int[total];

        for(int t=0; t<total; t++){

            String input = bf.readLine();
            String[] nums = input.split(" ");

            double distance = Double.valueOf(nums[1]) - Double.valueOf(nums[0]);
            double loop = distance;
            int count = 0;

            for(double i=1; i<=loop; i++) {

                if(distance==0){
                    output[t] = count;
                    break;

                }else if(0 < distance && distance <= i){
                    count++;
                    output[t] = count;
                    break;

                }else if(i < distance && distance < i*2) {
                    count += 2;
                    output[t] = count;
                    break;

                }else{
                    distance = distance - i*2;
                    count += 2;
                }

            }
        }

        for(int i=0; i<total; i++){
            System.out.println(output[i]);
        }
    }
}

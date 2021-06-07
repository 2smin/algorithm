import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());
        // 1 5 15 35 70
        // 1 4 10 20 35
        // 1 3 6 10 15
        // 1 2 3 4 5
        int[] output = new int[total];

        for(int t=0; t<total; t++){

            int floor = Integer.valueOf(bf.readLine());
            int room = Integer.valueOf(bf.readLine());
            int[] rf = new int[room];

            for(int r=0; r<room; r++){
                rf[r] = r+1;
            }

            for(int i=1; i<floor+1; i++){
                for(int j=1; j<room; j++){
                    rf[j] = rf[j] + rf[j-1];
                }
            }
            output[t] = rf[room-1];
        }

        for(int i=0; i<total; i++){
            System.out.println(output[i]);
        }
    }

}

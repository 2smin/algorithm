import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());

        // 층수 방수 손님번호
        String[] output = new String[total];

        for(int t=0; t<total; t++){

            String input = bf.readLine();

            String[] hotel = input.split(" ");

            int floor = Integer.valueOf(hotel[0]);
            int room = Integer.valueOf(hotel[1]);
            int custNo = Integer.valueOf(hotel[2]);

            for(int i=1; i<room+1; i++){

                for(int j=1; j<floor+1; j++){

                    custNo--;

                    if(custNo ==0){
                        output[t] = j + (i < 10 ? "0":"") + i;
                    }
                }
            }
        }

        for(int i=0; i<total; i++){
            System.out.println(output[i]);
        }
    }

}

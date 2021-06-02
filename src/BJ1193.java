import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(bf.readLine());

        boolean isTrue = true;
        int head = 0;
        int tail = 0;

        for(int i=1; isTrue; i++){

            if(num - i > 0){
                num = num -i;
            }else{
                if(i%2==0){
                    head = num;
                    tail = i - (num-1);
                }else{
                    tail = num;
                    head = i - (num-1);
                }
                break;
            }
        }

        System.out.println(head +"/" + tail);

    }
}

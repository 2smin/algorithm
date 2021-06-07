import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4948 {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bf.readLine());

        while(num!=0){

            int[] list = new int[num*2+1];

            for(int i=2; i<=num*2; i++){
                list[i] = i;
            }

            for(int i=2; i<=num*2; i++){

                if(list[i] == 0){
                    continue;
                }

                for(int j=i+i; j<=num*2; j+=i){
                    list[j] = 0;
                }
            }

            int count = 0;
            for(int i=num+1; i<=num*2; i++){

                if(list[i] != 0){
                    count++;
                }
            }
            sb.append(count).append("\n");
            num = Integer.valueOf(bf.readLine());
        }
        System.out.print(sb);
    }
}

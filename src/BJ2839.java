import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());
        int dept3 = 0;
        int dept5 = 0;
        int loop = total/3;

        for(int i=0; i<loop; i++){

            if(total%5==0){
                dept5 = total/5;
                total = 0;
                break;
            }

            total = total - 3;
            dept3++;
        }

        if(total!=0){
            System.out.println(-1);
        }else{
            System.out.println(dept3+dept5);
        }

    }
}

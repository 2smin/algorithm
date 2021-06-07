import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());

        ArrayList strList = new ArrayList();

        for(int i=0; i<total; i++){
            int[] list = new int[3];
            String str = bf.readLine();
            String[] arr = str.split(" ");

            for(int a=0; a < arr.length; a++){
                list[a] = Integer.valueOf(arr[a]);
            }

            for(int j=0; j<list[1]; j++){

            }
        }


    }
}

package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2792 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int childNum;
    static int colorNum;
    static int[] colorArr;

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        childNum = Integer.valueOf(settings[0]);
        colorNum = Integer.valueOf(settings[1]);
        colorArr = new int[colorNum];

        for(int i=0; i<colorNum; i++){
            colorArr[i] = Integer.valueOf(bf.readLine());
        }

        int max = Arrays.stream(colorArr).max().getAsInt();
        int min = 1;

        search(min,max);

    }

    public static void search(int min, int max){

        int start = min;
        int end = max;

        int currentCount =0;
        while(start <= end){
            currentCount = childNum;
            int mid = (start + end)/2;

            for(int i=0; i<colorArr.length; i++){
                currentCount -= colorArr[i]/mid;
                if(colorArr[i]%mid > 0) currentCount--;
            }

            if(currentCount < 0){
                //보석이 남아있으므로 숫자를 올린다
                start = mid +1;
            }else {
                end = mid -1;
            }
        }

        System.out.println(start);
    }
}

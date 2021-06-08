package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1085 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[4];
        int i = 0;

        while (st.hasMoreTokens()) {
            arr[i] = Integer.valueOf(st.nextToken());
            i++;
        }

        int distanceX = arr[2] - arr[0] < arr[0] ? arr[2] - arr[0] : arr[0];
        int distanceY = arr[3] - arr[1] < arr[1] ? arr[3] - arr[1] : arr[1];

        System.out.println(distanceX > distanceY ? distanceY : distanceX);
    }
}

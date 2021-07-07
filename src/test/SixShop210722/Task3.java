package test.SixShop210722;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {

        int answer = sol(6);

        System.out.println(answer);

    }

    public static int sol(int n) {

        int[] count = new int[n + 1];
        Arrays.fill(count, 1000000001);

        count[3] = 1;

        if(n>=5){
            count[5] = 1;
        }

        for (int i = 3; i <= n; i++) {

            if (i % 3 == 0) {
                count[i] = Math.min(count[i - 3] + 1, count[i]);
            }

            if (i % 5 == 0) {
                count[i] = Math.min(count[i - 5] + 1, count[i]);
            }


        }
        return count[n] == 1000000001 ? -1 : count[n];
    }


}

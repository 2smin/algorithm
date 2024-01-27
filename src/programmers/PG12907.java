package programmers;

public class PG12907 {

    static int[][] dp;

    public int solution(int n, int[] money) {

        dp = new int[money.length+1][n+1];

        // Arrays.sort(money,Collections.reverseOrder());

        //money 갯수만큼 돌릴건데,
        for(int i=1; i<money.length+1; i++){ //1~3
            for(int j=0; j<n+1; j++){ // 0~5
                if(j==0){
                    dp[i][j] = 1;
                }else{

                    int coin = money[i-1];
                    if(j < coin){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-coin];
                    }
                }
            }

        }

//         for(int i=0; i<dp.length; i++){
//             for(int j=0; j<dp[0].length; j++){
//                 System.out.printf(dp[i][j] + " ");
//             }
//             System.out.println();
//         }

        int answer = dp[money.length][n];
        // System.out.println("answer :" + answer);
        return (int)(answer%1000000007);
    }


}

package programmers;

public class PG1832 {

    class Solution {
        int MOD = 20170805;

        int[][] traffic;
        int[][] map;

        public int solution(int m, int n, int[][] cityMap) {


            map = new int[m+1][n+1];
            traffic = new int[m+1][n+1];
            map[1][1] = 1;

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    traffic[i+1][j+1] = cityMap[i][j];
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){

                    if(i == 1 && j == 1){
                        map[i][j] = 1;
                    }else{
                        if(traffic[i][j] == 0){
                            map[i][j] = (getLeft(i,j) + getTop(i,j)) % MOD;
                        }else{
                            map[i][j] = 0;
                        }
                    }

                }
            }

            return map[m][n];
        }

        public int getLeft(int i, int j){
            for(int k=j-1; k>0; k--){
                if(traffic[i][k] != 2){
                    return map[i][k];
                }
            }
            return 0;
        }

        public int getTop(int i, int j){
            for(int k=i-1; k>0; k--){
                if(traffic[k][j] != 2){
                    return map[k][j];
                }
            }
            return 0;
        }
        public int overPosition(int i, int j, int flag){

            int pos = traffic[i][j];
            int cnt = 0;

            if(flag == 0){
                //왼쪽 쭉 가는데 0이나 1 나올떄까지
                while(pos == 2){
                    cnt++;
                    pos = traffic[i][j-cnt];
                }
                return j-cnt;
            }else{
                while(pos == 2){
                    cnt++;
                    pos = traffic[i-cnt][j];
                }
                return i-cnt;
            }
        }
    }
}

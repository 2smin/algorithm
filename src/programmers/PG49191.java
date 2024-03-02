package programmers;

public class PG49191 {

        static int[][] map;

        public int solution(int n, int[][] results) {

            map = new int[n+1][n+1];

            for(int[] result : results){
                int x = result[0];
                int y = result[1];
                map[x][y] = 1;
                map[y][x] = -1;
            }

        /*
        x 부터 y 까지 순회,
        */
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    for(int k=1; k<=n; k++){
                        //이길떄
                        if(map[i][k] == 1 && map[k][j] == 1){
                            map[i][j] = 1;
                            map[j][i] = -1;
                        }

                        if(map[i][k] == -1 && map[k][j] == -1){
                            map[i][j] = -1;
                            map[j][i] = 1;
                        }
                    }
                }
            }

            int answer = 0;
            for(int[] arr : map){
                int cnt = 0;
                for(int i : arr){
                    // System.out.printf(i + " ");
                    if(i != 0) cnt++;
                }
                if(cnt == n-1) answer++;
                // System.out.println();
            }

            return answer;
        }
    }
}

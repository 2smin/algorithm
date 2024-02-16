package programmers;

public class PG42898 {

    static int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        if(m == 1 || n == 1){
            return 1;
        }
        map = new int[m+1][n+1];

        for(int[] puddle : puddles){
            int x = puddle[0];
            int y = puddle[1];
            map[x][y] = -1;

        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==1 && j ==1){
                    map[i][j] = 1;
                    continue;
                }
                if(map[i][j] == -1) continue;
                int up = map[i-1][j] == -1 ? 0 : map[i-1][j];
                int left = map[i][j-1] == -1 ? 0 : map[i][j-1];
                map[i][j] = (up + left)  % 1000000007;
            }
        }

        // for(int i=0; i<=m; i++){
        //     for(int j=0; j<=n; j++){
        //         System.out.printf(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int answer = map[m][n];
        return answer;
    }
}

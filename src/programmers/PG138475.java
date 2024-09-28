package programmers;

public class PG138475 {

    public static void main(String[] args) {

        int e = 8
                ;
        int[] starts =
                {1,3,7}
                ;

        PG138475 sol = new PG138475();
        int[] answer = sol.solution(e,starts);

        for(int i : answer){
            System.out.printf(i + " ");
        }
    }

    int[] count;
    int[] pos;

    public int[] solution(int e, int[] starts) {
        int[] answer = {};
        count = new int[e+1];
        pos = new int[e+1];
        answer = new int[starts.length];

        count(e);

            int max = 0;
            int minAddr = 0;
            for(int j=e; j>=0; j--){
                //max가 최고인 위치를 찾아서 max 저장
                max = max > count[j] ? max : count[j];
                //현재 max보다 count 중인 위치가 더 작으면 minAddr 갱신
                minAddr = max > count[j] ? minAddr : j;
                pos[j] = minAddr;
            }

        for(int i=0; i<starts.length; i++){
            answer[i] = pos[starts[i]];
        }

        return answer;
    }

    public void count(int n ){

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n/i; j++){
                count[i*j]++;
            }
        }
    }
}

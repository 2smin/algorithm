package programmers;

public class PG150369 {

    public static void main(String[] args) {
        PG150369 pg = new PG150369();

        int cap = 2
                ;
        int n =
                2
                ;
        int[] deliveries =
                {0, 6}
                ;

        int[] pickUps =
                {0,0}
                ;

        long answer = pg.solution(cap,n,deliveries,pickUps);
        System.out.println("answer : " + answer);
    }

    static int[] deliSum;
    static int[] pickSum;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        deliSum = new int[n];
        pickSum = new int[n];

        int max = cap;
        int pos = n-1;


        check(n,deliveries,deliSum,cap);
        check(n,pickups,pickSum,cap);

        for(int i=0; i<deliSum.length; i++){
            System.out.printf(deliSum[i] + " ");
        }

        System.out.println();
        for(int i=0; i<pickSum.length; i++){
            System.out.printf(pickSum[i] + " ");
        }
        System.out.println();


        long answer = 0;
        pos = n-1;
        while(pos >= 0){
            int type = 0;
            int deli = 0;
            int pick = 0;
            if(deliSum[pos] > 0) {
                deli = deliSum[pos];
            }
            if(pickSum[pos] > 0){
                pick = pickSum[pos];
            }
            if(deli == 0 && pick == 0){
                pos--;
                continue;
            }
            if(deli > pick){
                type = 1;
            }else{
                type = 2;
            }

            switch (type){
                //delivery 가 큰 경우
                case 1 : {
                    int count = deliSum[pos];
                    answer += (pos + 1) * 2 * count; //거리 더하기
                    //정보 갱신
                    for (int j = pos; j >= 0; j--) {
                        int remain = count - pickSum[j];
                        if (remain < 0) {
                            pickSum[j] -= Math.abs(remain);
                            break;
                        } else if (remain == 0) {
                            pickSum[j] = 0;
                            break;
                        } else {
                            count -= pickSum[j];
                            pickSum[j] = 0;
                        }
                    }
                }
                break;
                case 2 : {
                    int count = pickSum[pos];
                    answer += (pos+1) * 2 * count; //거리 더하기
                    //정보 갱신
                    for(int j=pos; j>=0; j--){
                        int remain = count - deliSum[j];
                        if(remain < 0){
                            deliSum[j] -= Math.abs(remain);
                            break;
                        }else if (remain == 0){
                            deliSum[j] = 0;
                            break;
                        }else {
                            count -= deliSum[j];
                            deliSum[j] = 0;
                        }
                    }
                }
            }
            pos--;
        }

        return answer;
    }

    public void check(int n, int[] map, int[] sum, int cap){
        int pos = n-1;
        int max = cap;
        while(pos >= 0){
            int curDeliv = map[pos];
            if(curDeliv == 0){ //빈곳이면 넘김
                pos--;
                continue;
            }
            if(max == cap){ //새로 시작인경우
                if(max > curDeliv){ //가방에 충분한경우
                    max -= curDeliv;
                    sum[pos]++;
                    pos--;
                }else if(max == curDeliv){ //딱 떨어지면
                    max = cap;
                    sum[pos]++;
                    pos--;
                }else{ //부족하면
                    map[pos] -= max;
                    sum[pos]++;
                    max = cap;
                }
            }else{ //하던중
                if(max > curDeliv){
                    max -= curDeliv;
                    pos--;
                }else if(max == curDeliv){
                    max = cap;
                    pos--;
                }else {
                    map[pos] -= max;
                    max = cap;
                }
            }
        }

    }

}

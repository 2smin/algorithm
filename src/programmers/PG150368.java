package programmers;

public class PG150368 {

    public static void main(String[] args) {

        PG150368 pg = new PG150368();

        int[][] users =
                {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}
                ;
        int[] emoticons =
                {1300, 1500, 1600, 4900}
                ;

        int[] answer = pg.solution(users,emoticons);

        System.out.println("ansewr : " + answer[0] + ", " + answer[1]);

    }
    static int[] sales;
    static int[] rate;
    static int[] emo;
    static int[][]  userArr;
    static int[][] checkout;

    static int maxPlus = 0;
    static int maxSell;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        sales =  emoticons.clone();
        emo = emoticons.clone();
        rate = new int[emoticons.length];
        userArr =users;
        checkout = new int[users.length][2];
        maxPlus = 0;
        maxSell = 0;

        /*
        돌때마다 rate와 sales를 갱신
        다 순회하는법? 7중 for문???/

         */
        int start = 0;
        DFS(start);

        answer[0] = maxPlus;
        answer[1] = maxSell;
        return answer;
    }

    public void DFS(int pos){

        if(pos == emo.length){
            //구매계산
            calculate();
            result();
            return;
        }
        for(int i=10; i<=40; i+=10){

            //할인비율을 넣고 다음 탐색
            rate[pos] = i;
            sales[pos] = emo[pos] / 100 * (100-i);
            DFS(pos+1);
        }
    }

    public void calculate(){

        for(int i=0; i<userArr.length; i++){

            int ratio = userArr[i][0];
            int max = userArr[i][1];
            int sum = 0;
            for(int j=0; j<sales.length; j++){
                if(rate[j] >= ratio){
                    sum += sales[j];
                }
            }
            if(sum >= max){
                checkout[i][0] = 1;
                checkout[i][1] = 0;
            }else{
                checkout[i][0] = 0;
                checkout[i][1] = sum;
            }
        }
    }

    public void result(){

        int curPlus = 0;
        int curSell = 0;

        for(int i=0; i<checkout.length; i++){
            if(checkout[i][0] == 1) curPlus++;
            else curSell+=checkout[i][1];
        }

        if(maxPlus < curPlus){
            maxPlus = curPlus;
            maxSell = curSell;
        }else if (maxPlus == curPlus && maxSell < curSell){
            maxSell = curSell;
        }
    }
}


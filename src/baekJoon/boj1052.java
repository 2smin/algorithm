package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class boj1052 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int K;

    static int answer;
    static int totalBottle;
    static Map<Integer,Integer> bottles = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        K = Integer.valueOf(settings[1]);

        /*
        우선 최대한 /2로 해준다.

        map으로 해서 key는 용량 value는 갯수
        총 갯수가 k이하가 될때까지
        가장 작은애를 엎애는걸로 시작한다. 작은애만큼 cnt에다 더해준다 더해주면 다음 용량으로 올린다
         */

        // n을 2로 나눠서 최대한 압축시킨다. 2로 한번 나눌때마다 나머지는 해당 용량에서 남은갯수
        // n이 1이 될때까지 해보자 하던도중에 k 이하로 떨어지면 0 반환하고 끝
        int remained;
        int opt = N;
        int key = 1;
        int start = 0;
        while(opt != 1){
            remained = opt%2;
            opt = opt/2;

//            System.out.println(" cnt : " + key + ", remained :  " + remained);
            if(remained != 0){
                if(start == 0){
                    start = key;
                }
                bottles.put(key, remained);
                totalBottle++;
            }
            key*=2;
        }
        bottles.put(key, opt);
        totalBottle++;
        if(totalBottle <= K) {
            System.out.println(-1);
            return;
        };


//        System.out.println(bottles.toString());
//        System.out.println(totalBottle);

        find(start);
        System.out.println(answer);

    }

    private static void find(int num){
        int bottleCnt = bottles.get(num);

        //1개있는 경우 size 업 해서 다음 bottle에 추가
        if(bottleCnt == 1){
            answer+= num;
            bottles.remove(num);
            if(bottles.containsKey(num*2)){
                bottles.put(num*2, bottles.get(num*2)+1);
            }else{
                bottles.put(num*2, 1);
            }

            find(num*2);
        }else if(bottleCnt == 2){ //2개가 된 경우 바로 없애고 다음 size로 올린다.
            bottles.remove(num);
            if(bottles.containsKey(num*2)){
                bottles.put(num*2, bottles.get(num*2)+1);
            }else{
                bottles.put(num*2, 1);
            }
            totalBottle--;
        }
        //2개 이상인 경우는 없다
        //하면서 계속 총 물병이 k개 넘는지 체크한다.
        if(totalBottle <= K){
            return;
        }else{
            find(num*2);
        }
    }
}

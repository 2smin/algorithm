package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1976 {

    static StringBuffer sb = new StringBuffer();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr;
    public static void main(String[] args) throws IOException {

        int cityTotal = Integer.valueOf(bf.readLine());
        int tripTotal = Integer.valueOf(bf.readLine());
        arr = new int[cityTotal+1];

        for(int i=0; i<cityTotal+1; i++){
            arr[i] = i;
        }

        for(int i=0; i<cityTotal; i++){
            String[] input = bf.readLine().split(" ");

            for(int j=i+1; j<input.length; j++){
                if(input[j].equals("1")){
                    linkCities(i+1,j+1);
                }
            }

        }

        String[] input = bf.readLine().split(" ");
        visitable(input);

    }

    //도시를 연결한다 / 가장 순위가 높은 도시로 압축
    static int getRoad(int a){
        if(arr[a] == a){ return a;}
        return arr[a] = getRoad(arr[a]);
    }

    //도시 우선순위를 보고 우선순위 높은애로 parent 설정
    static void linkCities(int a, int b){

        a = getRoad(arr[a]);
        b = getRoad(arr[b]);

        if(a<b){arr[b] = a;}else{arr[a] = b;}
    }

    //방문계획도시 리스트를 받아서 리스트 상의 모든 도시의 parent가 하나의 우선순위를 공유하는지 체크
    static void visitable(String[] visitPlan){

        int parent = getRoad(Integer.valueOf(visitPlan[0]));

        for(int i=0; i<visitPlan.length; i++){

            if(getRoad(Integer.valueOf(visitPlan[i])) != parent){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}

package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG42861 {

    public static void main(String[] args) {
        PG42861 pg = new PG42861();
        int n =
                5
                ;
        int[][] costs =
                {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}}

                ;
        System.out.println(pg.solution(n,costs));
    }
    static int[] parents;
    static int[] summary;
    static int mainNode;
    static int sum;
    public int solution(int n, int[][] costs) {

        parents = new int[n];
        summary = new int[n];

        for(int i=0; i<n; i++){
            parents[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });


//        Arrays.stream(costs).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
//            System.out.println();});
        //최초 노드 잇기
        mainNode = costs[0][0];
//        int childNode = costs[0][1];
//        parents[childNode] = mainNode;

        //이제 시작
        for(int i=0; i<costs.length; i++){

            int leftNode = costs[i][0];
            int rightNode = costs[i][1];
            int length = costs[i][2];

            //둘다 main이면 skip
            if(parents[leftNode] == mainNode && parents[rightNode] == mainNode) {
                continue;
            }else if (parents[leftNode] == parents[rightNode]){
                continue;
            }else if (parents[leftNode] != mainNode && parents[rightNode] != mainNode){
                //둘다 아직 연결 안됐으면
                int changeNodeNum = parents[rightNode];
                changeAll(changeNodeNum, parents[leftNode]);
                summary[parents[leftNode]] += (summary[changeNodeNum] + length);
                summary[changeNodeNum] = 0;
            }else{
                //한쪽만 main
                if(parents[leftNode] == mainNode){
                    int changeNodeNum = parents[rightNode];
                    changeAll(changeNodeNum, mainNode);
                    summary[mainNode] += (summary[changeNodeNum] + length);
                    summary[changeNodeNum] = 0;
                }else if (parents[rightNode] == mainNode){
                    int changeNodeNum = parents[leftNode];
                    changeAll(changeNodeNum, mainNode);
                    summary[mainNode] += (summary[changeNodeNum]  + length);
                    summary[changeNodeNum] = 0;
                }
            }

        }


        for (int i=0 ;i<parents.length; i++){
            System.out.printf("[" + i + " : " + parents[i] + "] ");

        }

        System.out.println("summary");
        for (int i=0 ;i<summary.length; i++){
            System.out.printf("[" + i + " : " + summary[i] + "] ");

        }
//        System.out.printf("sum : " + sum);
        return  summary[mainNode];
    }

    public void changeAll(int before, int after){
        for(int i=0; i< parents.length; i++){
            if(parents[i] == before){
                parents[i] = after;
            }
        }
    }


    /*
    main node 기준으로 하나씩 탐색해간다
    섬을 방문할수 있을때만 방문한다

    오름차순으로 정렬이 되어있지만, visited 체크가 안된 노드를 방문할때만 길이를 더해준다
    이건 한쪽은 visited 이고 한쪽은 visited가 아닌 경우만 length를 더해준다.
    모든 node가 visited가 될 때 까지 반복
    사용한 다리는 제거
     */
}

package programmers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Test3 {

    public static void main(String[] args) {

        Test3 test3 = new Test3();
        String[][] qr =
                {{"###..#", "#.#.#.", "###.#.", "...###", ".###..", ".#.#.."}, {"###..#", "#...#.", "###...", ".....#", ".##.##", ".#.##."}, {"...###", "##.#.#", ".#.#.#", "#.....", "##..#.", ".##..#"}, {".##.#.", "##.##.", "#.....", "...###", ".#...#", "#..###"}, {"#..##.", ".#..##", ".....#", "#.#.#.", "#.#.##", "###..."}, {"##....", "##...#", "#####.", ".#..#.", "#..#.#", "....##"}}
                ;
;
        int[] ans = test3.solution(6, qr);
        System.out.println(Arrays.toString(ans));
    }

    static double[][] map;
    static String[][] qrs;

    static TreeSet<List<Integer>> tree = new TreeSet<>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if(o1.size() > o2.size()){
                return -1;
            }else if(o1.size() < o2.size()){
                return 1;
            }else{
                return o1.get(0) - o2.get(0);
            }
        }
    });

    public int[] solution(int n, String[][] qr) {

        map = new double[n][n];
        qrs = qr;

        for(int i=0; i<qr.length; i++){
            //1번부터 전체랑 비교
            String[] qr1 = qr[i];
            for(int j=0; j<qr.length; j++){
                if(i == j) continue;

                //4방향 검사
                String[] qr2 = qr[j];
                for(int k=0; k<4; k++){
                    double matchRate = check(qr1, qr2);
                    map[i][j] = Math.max(map[i][j], matchRate);
                    qr2 = rotate(qr2);
                }
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0; i<map.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            for(int j=0; j<map.length; j++){
                if(i == j) continue;
                if(map[i][j] <= 50){
                    list.add(j);
                }
            }
            boolean[] visited = new boolean[list.size()];
            visited[0] = true; //여기 틀린듯
            dfs(list, visited);
        }

        List<Integer> firstNode = tree.pollFirst();


        int[] answerArr = new int[firstNode.size()];
        for(int i=0; i<firstNode.size(); i++){
            answerArr[i] = firstNode.get(i);
        }

        return answerArr;
    }

    public double check(String[] qr1, String[] qr2){
        int count = 0;
        for(int i=0; i<qr1.length; i++){
            for(int j=0; j<qr1.length; j++){
                if(qr1[i].charAt(j) == qr2[i].charAt(j)){
                    count++;
                }
            }
        }

        double div1 = count / 36.0;
        BigDecimal div;
        if(div1 < 0.5){ //50%미만이면 내림
            div = new BigDecimal(div1).setScale(3, RoundingMode.DOWN);
        }else{
            div = new BigDecimal(div1).setScale(3, RoundingMode.UP);
        }
//        BigDecimal div = new BigDecimal(count).divide(new BigDecimal(36),4, RoundingMode.HALF_UP);
        double match = div.multiply(new BigDecimal(100)).doubleValue();
        return match;
    }

    public String[] rotate(String[] qr){
        String[] temp = new String[qr.length];
        for(int l=0; l<qr.length; l++){
            StringBuilder sb = new StringBuilder();
            for(int m=0; m<qr.length; m++){
                sb.append(qr[m].charAt(qr.length-1-l));
            }
            temp[l] = sb.toString();
        }
        return temp;
    }

    public void dfs(List<Integer> list, boolean[] visited){

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<visited.length; i++){
            if(!visited[i]) continue;
            queue.offer(list.get(i)+1);
        }
        List<Integer> node = new ArrayList<>();
        while(!queue.isEmpty()){
            node.add(queue.poll());
        }
        tree.add(node);

        for(int i=0; i<list.size(); i++){
            if(visited[i]) continue; // 선택한거면 패스

            boolean flag = true;
            for(int j=0; j<visited.length; j++){
                //현재 선택된 애들이랑 퍼센티지 비교한다
                if(visited[j]){
                    if(map[list.get(i)][list.get(j)] > 50){ //하나라도 유사도 50이상이면 패스
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag) continue;

            boolean[] nextVisited = visited.clone();
            nextVisited[i] = true;

            dfs(list, nextVisited);
        }
    }
}

package programmers;

public class PG172927 {

    public static void main(String[] args) {

        int[] picks =
                {1,2,3}
                ;

        String[] minerals =
                {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
                ;
        PG172927 pg = new PG172927();
        pg.solution(picks,minerals);
    }

    int diaPck;
    int irnPck;
    int stnPck;

    int[][] cost = {{1,1,1},{5,1,1,},{25,5,1}};
    int[][] map;
    int[] current;
    int[] needCount = new int[3];
    public int solution(int[] picks, String[] minerals) {

        int answer = 0;
        int column = minerals.length/5;
        int remain = minerals.length%5;
        map = new int[column + (remain == 0 ? 0 : 1)][3];

        for(int i=0; i< minerals.length; i+=5){
            //5개씩 잘라서 안에서 3번 돌린다
            int ndCost = 0;
            current = new int[3];
            for(int k=0; k<5; k++){ //5개
                if(i+k > minerals.length-1) break;
                if(minerals[i+k].equals("diamond")){
                    map[i/5][0]+=1;
                    map[i/5][1]+=5;
                    map[i/5][2]+=25;
                }
                else if(minerals[i+k].equals("iron")){
                    map[i/5][0]+=1;
                    map[i/5][1]+=1;
                    map[i/5][2]+=5;
                }
                else if(minerals[i+k].equals("stone")){
                    map[i/5][0]+=1;
                    map[i/5][1]+=1;
                    map[i/5][2]+=1;
                }
            }


            //needCount 중에 피로도가 가장
        }

        for(int i=0; i<map.length; i++){
            System.out.println();
            for(int j=0; j<map[i].length; j++){
                System.out.printf(map[i][j] + " ");
            }
        }
        return answer;
    }


}

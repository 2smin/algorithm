package programmers;

public class PG1835 {

    static String[] name = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
    static int[] visited;
    static int answer;

    public static void main(String[] args) {

        PG1835 pg = new PG1835();

        String[] data =
                {"N~F=0", "R~T>2"}
                ;
        int n =
                2
                ;

        int answer = pg.solution(n,data);
        System.out.println("ans: " + answer );
    }

    public int solution(int n, String[] data) {

        for(int i=0; i<8; i++){
            dfs(name[i], data);
        }

        return answer;
    }

    public void dfs(String curLine, String[] data){

        if(curLine.length() == 8){
            boolean pos = check(curLine, data);
            if(pos) answer++;
            return;
        }

        for(int i=0; i<8; i++){

            if(curLine.contains(name[i])) continue;
            String nexline = curLine + name[i];
            dfs(nexline, data);
        }
    }

    public boolean check(String str, String[] data){
         System.out.println("str: " + str);
        for(String con : data){

            String per1 = Character.toString(con.charAt(0));
            String per2 = Character.toString(con.charAt(2));
            String ch = Character.toString(con.charAt(3));
            int num = Character.getNumericValue(con.charAt(4));

            System.out.println("ch :" + ch);
            int per1Pos = str.indexOf(per1);
            int per2Pos = str.indexOf(per2);
            int interval = Math.abs(per1Pos - per2Pos) - 1;
            System.out.println("interval : " + num + ", " + interval);
            if(ch == "<"){
                if(num <= interval) return false;
                System.out.println(" <= true");
            }else if (ch == ">"){
                if(num >= interval) return false;
                System.out.println(" >= true");
            }else {
                if(num != interval) return false;
                System.out.println(" == true");
            }

        }
        System.out.println("done");
        return true;
    }

}

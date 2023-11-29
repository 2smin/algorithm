package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//FIXME : use node and dummy
public class PG81303 {

    public static void main(String[] args) {
        PG81303 pg = new PG81303();

        String[] cmd = new String[]
                {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}
                ;
        System.out.println(pg.solution(8,2, cmd));
    }
    public class Link {
        public int before;
        public int after;
        public String str;
        public Link(int before, int after) {
            this.before = before;
            this.after = after;
            this.str = "O";
        }

        @Override
        public String toString() {
            return "Link{" +
                    "before=" + before +
                    ", after=" + after +
                    '}';
        }
    }

    public static List<Link> linkList = new ArrayList<>();
    public static Stack<Integer> recycleBin = new Stack<>();

    public String solution(int n, int k, String[] cmd) {


        for(int i=0; i<n; i++){
            linkList.add(i,new Link(i-1,i+1));
        }

        linkList.set(0, new Link(-1,1));
        linkList.set(n-1, new Link(n-2,-1));


        for(String str : cmd){
            char command = str.charAt(0);
            int move = 0;
            if(command == 'U'){
                move = -Integer.valueOf(str.split(" ")[1]);
            }else if(command == 'D'){
                move = Integer.valueOf(str.split(" ")[1]);
            }else if(command == 'C'){
                //링크 끊고 앞으로 1 혹은 마지막인 경우 뒤로 1
                recycleBin.push(k);
                if(linkList.get(k).after == -1){
                    //마지막인 경우
                    linkList.get(linkList.get(k).before).after = -1;
                    move = -1;
                }else if(linkList.get(k).before == -1) {
                    //처음인경우
                    linkList.get(linkList.get(k).after).before = -1;
                    move = 1;
                }else{
                    linkList.get(linkList.get(k).before).after = linkList.get(k).after;
                    linkList.get(linkList.get(k).after).before = linkList.get(k).before;
                    move = +1;
                }
            }else if(command == 'Z'){
                int restoreIndex = recycleBin.pop();
                if(linkList.get(restoreIndex).after == -1){
                    //마지막인 경우
                    int before = linkList.get(restoreIndex).before;
                    linkList.get(before).after = restoreIndex;
                }else if(linkList.get(restoreIndex).before == -1){
                    //처음인경우
                    int after = linkList.get(restoreIndex).after;
                    linkList.get(after).before = restoreIndex;
                }else{
                    linkList.get(linkList.get(restoreIndex).before).after = restoreIndex;
                    linkList.get(linkList.get(restoreIndex).after).before = restoreIndex;
                }
            }
            k = move(k,move);
        }

        while(!recycleBin.isEmpty()){
            int num = recycleBin.pop();
            linkList.get(num).str = "X";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(linkList.get(i).str);
        }

        String answer = sb.toString();
        return answer;
    }

    public int move(int k, int move){
        if(move == 0) return k;
        boolean front = move > 0 ? true : false;
        move = Math.abs(move);
        for(int i=0; i<move; i++){
            if(front){
                Link link = linkList.get(k);
                if(link.after != -1){
                    k = link.after;
                }else{
                    break;
                }
            }else{
                Link link = linkList.get(k);
                if(link.before != -1){
                    k = link.before;
                }else{
                    break;
                }
            }
        }
        return k;
    }




}

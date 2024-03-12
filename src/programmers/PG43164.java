package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PG43164 {

    static List<String> answers = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        //dfs를 진행해야하는데, icn부터 시작한다.
    /*
    icn리스트만 따로 뽑아서 돌리고, 이후는 method 재귀로 하자
    */
        List<String[]> ticketList = new ArrayList<>();
        ticketList.addAll(Arrays.asList(tickets));
        List<String[]> icnStarts = new ArrayList<>();

        for(String[] ticket : ticketList){
            if(ticket[0].equals("ICN")) icnStarts.add(ticket);
        }

    /*
    1. boolean arr (티켓사용여부) 모든 티켓을 사용하면 모두 방문하게 된다.
    2.
    */


        for(String[] starts : icnStarts){
            String visited = "";
            visited = starts[0];
            searchPath(new ArrayList<String[]>(ticketList), starts, visited);
        }

        Collections.sort(answers);
        return splitStr(answers.get(0));
    }


    public void searchPath(List<String[]> ticketList, String[] ticket, String visited){

        visited += ticket[1];
        int index = ticketList.indexOf(ticket);
        ticketList.remove(index);

        if(ticketList.size() == 0){
            // for(String airport : visited){
            //     System.out.printf(airport + ", ");
            // }
            answers.add(visited);
            return; //다 돌은 경우
        }

        for(String[] nextTicket : ticketList){
            String dest = ticket[1];
            if(nextTicket[0].equals(dest)){
                // System.out.println("visited : " + visited.toString() + " | next: " + nextTicket[0] + " -> " + nextTicket[1]);
                searchPath(new ArrayList<String[]>(ticketList), nextTicket, visited);
            }
        }

        //길을 잘못들어서 더 갈수있는곳이 없는 경우는???

    }

    public String[] splitStr(String str){
        String[] strArr = new String[str.length()/3];
        for(int i=0; i<str.length(); i+=3){
            strArr[i/3] = str.substring(i,i+3);
        }
        return strArr;
    }


}

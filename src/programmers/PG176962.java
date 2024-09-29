package programmers;

import java.util.*;

public class PG176962 {


    /*
    못끝낸 과제는 queue에 넣는다
    끝낸 과제는 list에 넣는다.
    현재 시간 업데이트 친다
     */

    public static void main(String[] args) {

        PG176962 pg = new PG176962();
        String[][] plans =
                {{"aaa", "12:00", "30"}, {"bbb", "12:10", "30"}, {"ccc", "14:00", "30"}}
                ;

        pg.solution(plans);

        List<Report> done = pg.done;

        for(Report re : done){
            System.out.println(re.name + " ");
        }
    }





    int curTime;
    Stack<Report> unSolved = new Stack<>();
    Queue<Report> wait = new PriorityQueue<>();
    List<Report> done = new ArrayList<>();

    public String[] solution(String[][] plans) {

        for(String[] str : plans){
            Report report = new Report();
            report.name = str[0];
            String[] startStr = str[1].split(":");
            int startTime = Integer.valueOf(startStr[0]) * 60 + Integer.valueOf(startStr[1]);
            int remained = Integer.valueOf(str[2]);
            report.startTime = startTime;
            report.remain = remained;
            wait.offer(report);
        }

        Report curRe = wait.poll();
        Report nextRe = wait.poll();

        int remainedTime = 0;
        while(curTime < 86400){

            if(nextRe == null){ //다음게 없으면 다 끝내버릴수 있음
                done.add(curRe);
                while(!unSolved.isEmpty()){
                    done.add(unSolved.pop());
                }
                break;
            }

            curTime = curRe.startTime;
            remainedTime = nextRe.startTime - curTime;

            if(remainedTime > curRe.remain){ // 풀고도 시간이 남으면

                curTime = curTime + curRe.remain;
                curRe.remain = 0;
                done.add(curRe);

                if(unSolved.isEmpty()){
                    curRe = nextRe;
                    nextRe = wait.poll();
                    continue;
                }
                curRe = unSolved.pop();
                curRe.startTime = curTime;

            }else if (remainedTime < curRe.remain){ //시간이 부족하면
                curRe.remain -= remainedTime;
                unSolved.push(curRe); // 완료 안된거에 넣기

                curRe = nextRe; //우선 다음거 하기
                nextRe = wait.poll();

            }else if (remainedTime == curRe.remain){ //시간이 딱 맞으면
                curRe.remain = 0;
                done.add(curRe);
                curRe = nextRe;
                nextRe = wait.poll();
            }

        }
        String[] answer = new String[done.size()];
        for(int i=0; i<done.size(); i++){
            answer[i] = done.get(i).name;
        }
        return answer;
    }
}

class Report implements Comparable<Report>{
    public String name;
    public int startTime;
    public int remain;

    @Override
    public int compareTo(Report o) {
        return this.startTime - o.startTime;
    }
}

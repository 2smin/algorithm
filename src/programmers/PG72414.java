package programmers;

public class PG72414 {

    public static void main(String[] args) {
        PG72414 sol = new PG72414();
        String answer = sol.solution("02:03:55","00:00:01",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
        System.out.println(answer);
    }

    int[] dp;

    public String solution(String play_time, String adv_time, String[] logs) {

        /*
        1. 시간을 다 초단위로 변경
        2. 초단위 최대길이만큼 list 생성
        3. log보면서 걸치는 시간에 +1씩 해주기
        4. 0 -> 마지막 시간까지 돌면서 광고시간의 max값 구하기 max인 시간대의 i값 기록
        5. 시간으로 다시 변환
         */

        String[] timeUnits = play_time.split(":");

        int playTimeToFullSecond = getAsSecond(timeUnits);
//        System.out.println("playTimeToFullSecond : " + playTimeToFullSecond);
        int[] playList = new int[playTimeToFullSecond+1];
        dp = new int[playTimeToFullSecond+1];
        for(String log : logs){
            String[] start = log.split("-")[0].split(":");
            String[] end = log.split("-")[1].split(":");
            int startFullSecond = getAsSecond(start);
            int endFullSecond = getAsSecond(end);

            for(int i=startFullSecond; i<endFullSecond+1; i++){
                playList[i]++;
            }
        }

//        for(int i : playList){
//            System.out.print(i + " ");
//        }
//        System.out.println();

        String[] advTimeUnits = adv_time.split(":");
        int advFullSecond = getAsSecond(advTimeUnits);
//        System.out.println("advFullSecond : " + advFullSecond);

        int max = 0;
        int startPoint = 0;
        for(int i=0; i<advFullSecond+1; i++){
            dp[0] += playList[i];
            max = dp[0];
        }

        for(int i=1; i<playList.length-advFullSecond; i++){
            dp[i] = dp[i-1] - playList[i-1] + playList[i+advFullSecond];
            if(max < dp[i]){
                max = dp[i];
                startPoint = i;
            }
        }

        int hour = startPoint/(60*60);
        int min = startPoint%(60*60)/(60);
        int second = startPoint%(60*60)%(60);

        String formattedHour = String.format("%02d", hour);
        String formattedMin = String.format("%02d", min);
        String formattedSec = String.format("%02d", second);
        return new StringBuilder().append(formattedHour).append(":").append(formattedMin).append(":").append(formattedSec).toString();
    }

    public int getAsSecond(String[] timeUnits){
        return (Integer.valueOf(timeUnits[0]) * 60 * 60) +
                (Integer.valueOf(timeUnits[1]) * 60) +
                (Integer.valueOf(timeUnits[2]));
    }
}

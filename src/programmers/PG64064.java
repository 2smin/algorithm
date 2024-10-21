package programmers;

import java.util.HashSet;
import java.util.Set;

public class PG64064 {

    public static void main(String[] args) {

            PG64064 pg = new PG64064();

            String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
            String[] banned_id = new String[]{"*rodo", "*rodo", "******"};

            int ans = pg.solution(user_id, banned_id);
            System.out.println(ans);
    }

    static Set<String> set = new HashSet<>();
    static String[] banIdArr;
    static String[] userIdArr;
    static String[] regex;

    public int solution(String[] user_id, String[] banned_id) {
        //걍 dfs로 하자
        banIdArr= banned_id;
        userIdArr = user_id;
        regex = new String[banned_id.length];

        for(int i=0; i<banned_id.length; i++){
            String ban = banned_id[i];
            ban = ban.replace("*",".");
            regex[i] = ban;
        }

        boolean[] checked = new boolean[user_id.length];
        boolean[] banId = new boolean[banned_id.length];

        dfs(checked, banId,0);

        return set.size();
    }

    public void dfs(boolean[] checked, boolean[] banId, int cnt){

        //종료 조건
        //banId가 모두 true
        //이 경우 checked의 true 갯수
        if(cnt == banId.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<checked.length; i++){
                if(checked[i]) sb.append(userIdArr[i]);
            }
            set.add(sb.toString());
            return;
        }

        //다음 banId 고르기
        for(int i=0; i<banIdArr.length; i++){
            if(banId[i]) continue;

            //다음 userId 고르기
            for(int j=0; j<userIdArr.length; j++){
                if(checked[j]) continue;
                String userStr = userIdArr[j];
                if(regex[i].length() != userStr.length()) continue;

                //가능한 문자인지 체크
                if(!userStr.matches(regex[i])) continue;

                //가능하니까 checkd랑 baned 배열 새로만들어서 다음 단계로
                boolean[] newChecked = checked.clone();
                boolean[] newBaned = banId.clone();
                newChecked[j] = true;
                newBaned[i] = true;

                dfs(newChecked, newBaned,cnt+1);
            }
        }
    }
}

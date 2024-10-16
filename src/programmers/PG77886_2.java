package programmers;

import java.util.Stack;

public class PG77886_2 {

    public static void main(String[] args) {

        PG77886_2 pg = new PG77886_2();

        String[] s = new String[]{"1110"};
        String[] ans = pg.solution(s);
        for(String a : ans){
            System.out.println(a);
        }
    }


    static String[] str;

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i=0; i<s.length; i++){
            String str = s[i];
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<str.length(); j++){

                char z = str.charAt(j);

                if(stack.size() > 1){

                    char y = stack.pop();
                    char x = stack.pop();

                    if(x == '1' && y == '1' && z == '0'){
                        cnt++;
                    }else{
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                }else{
                    stack.push(z);
                }
            }

            String newStr = "";
            boolean flag = false;
            int stackSize = stack.size();
            int index = -1;
            StringBuilder sb = new StringBuilder();

            for(int k=0; k<stackSize; k++){
                char ch = stack.pop();
                if(ch == '0' && !flag){
                    index = stackSize - k - 1;
                    flag = true;
                }
                sb.append(ch);
            }
            newStr = sb.reverse().toString();
            if(index != -1){
                newStr = newStr.substring(0,index+1) + "110".repeat(cnt) + newStr.substring(index+1);
            }else{
                newStr = "110".repeat(cnt) + newStr;
            }
            answer[i] = newStr;
        }
        return answer;
    }
}

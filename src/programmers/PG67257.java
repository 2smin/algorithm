package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG67257 {

    public static void main(String[] args) {

            PG67257 pg = new PG67257();
            String expression = "100-200*300-500+20";
            long ans = pg.solution(expression);
            System.out.println(ans);
    }

        static ArrayList<String> list = new ArrayList<>();
        static List<List<Character>> exps = new ArrayList<>();
        static long max = 0;
        public long solution(String expression) {

            List<Character> l1 = List.of('+','-','*');
            List<Character> l2 = List.of('+','*','-');
            List<Character> l3 = List.of('-','+','*');
            List<Character> l4 = List.of('-','*','+');
            List<Character> l5 = List.of('*','+','-');
            List<Character> l6 = List.of('*','-','+');
            exps.add(l1);
            exps.add(l2);
            exps.add(l3);
            exps.add(l4);
            exps.add(l5);
            exps.add(l6);

            //1. expression을 자른다, 이걸 연산자의 위치로 분리한다.
            int idx = 0;
            String str = "";
            for(int i=0; i<expression.length(); i++){
                char ch = expression.charAt(i);
                if(ch == '+' || ch == '-' || ch == '*'){
                    if(str != ""){
                        list.add(str);
                        str = "";
                    }
                    list.add(ch+"");
                }else{
                    str += (ch+"");
                }
            }
            list.add(str);
            for(String st : list){
                System.out.printf(st +" ");
            }

            for(List<Character> exs : exps){

                ArrayList<String> l = (ArrayList<String>)list.clone();
                ArrayList<String> cache = (ArrayList<String>)l.clone();

                for(int j=0; j<exs.size(); j++){

                    Character ch = exs.get(j);

                    int k = 0;
                    while(k <cache.size()){
                        if(cache.get(k).equals(ch+"")){

                            long p1 = Long.valueOf(cache.get(k-1));
                            long p2 = Long.valueOf(cache.get(k+1));
                            long p3 = 0;
                            switch(ch){
                                case '+' : {
                                    p3 = p1+p2;
                                    break;
                                }
                                case '-' : {
                                    p3 = p1-p2;
                                    break;
                                }
                                case '*' : {
                                    p3 = p1*p2;
                                    break;
                                }
                            }
                            cache.set(k-1,p3+"");
                            cache.remove(k+1);
                            cache.remove(k);
                        }else{
                            k++;
                        }

                    }

                }

                max = Math.max(max,Math.abs(Long.valueOf(cache.get(0))));
            }

            long answer = max;
            return answer;
        }
    }
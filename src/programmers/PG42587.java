package programmers;

import java.util.ArrayList;

public class PG42587 {

    public static void main(String[] args){

        ArrayList<Integer> priorities = new ArrayList<>();

        for(int num : priorities){
            priorities.add(num);
        }
        int location = 0;
        int count = 0;

        loop1: while(true){

                int remove = priorities.remove(0); //맨앞에꺼 뺀다
                location--;                             //하나 뺐으니 위치도 조정

                int tmp = 0;
                if(priorities.size()!=0){
                    for(int i=0; i<priorities.size(); i++){if(priorities.get(i) > tmp){tmp = priorities.get(i);} }
                }

                if(remove < tmp){     //배열의 다른게 순서가 더 크다면
                    priorities.add(remove);         //뒤로 넣고

                    if (location < 0) {location = priorities.size()-1;}
                }else{ //순서가 젤 크다면
                    count++;    //count 하나 추가
                    if(location<0){ // 뺸게 찾던거면
                        break loop1; //끝낸다
                    }

                }
        }

        System.out.println(count);
    }
}

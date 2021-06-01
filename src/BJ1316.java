import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1316 {

    public static void main(String[] args) throws IOException {

        //input 방식을 여러개 쓰면 안된다!! 하나만쓰자
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        int total = Integer.parseInt(num);
        int count = total;

        for(int i=0; i<total; i++){

            char word = '0';
            String str = bf.readLine();
            ArrayList list = new ArrayList();

            for(int j=0; j<str.length(); j++){
                if(!list.contains(str.charAt(j))){
                    list.add(str.charAt(j));
                    word = str.charAt(j);

                }else{
                    if(word != str.charAt(j)){
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

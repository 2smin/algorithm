import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class BJ1157_2 {

    public static void main(String[] args) throws IOException {

        int arr[] = new int[26];

        int word = System.in.read();

        while(word>64){

            if(word<91){
                arr[word-65]++;
            }else{
                arr[word-97]++;
            }

            word = System.in.read();
        }

        int max = -1;
        int ch = -2;

        for(int i=0; i<26; i++){

            if(arr[i] > max){
                max = arr[i];
                ch = i;
            }else if(arr[i] == max){
                ch = -2;
            }
        }
        System.out.println((char)(ch + 65));
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1152 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine();

        String[] wordList = line.split(" ");

        int length = wordList.length;

        if(wordList.length>0){
            if(wordList[0].equals("")){
                length--;
            }
        }

        System.out.println(length);
    }
}

import java.util.*;

public class BJ1157 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();

        word.toUpperCase();

        String[] wordList = word.split("");

        Arrays.sort(wordList);
        //가장 많은 알파벳 저장
        String alphabet = wordList[0];

        int count = 1;

        int max = 0;

        boolean same = false;

        for(int i=0; i< wordList.length-1; i++) {

            if (wordList[i].equals(wordList[i + 1])) {
                count++;
            } else {
                count = 1;
            }
            System.out.println(wordList[i] + ": " + count);
            if (count > max) {
                alphabet = wordList[i];
                same = false;
                max = count;
                count = 1;
            } else if (count == max) {
                same = true;
            } else {

            }

            System.out.println("max: " + max);
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();

        int count = 0;

        for (int i = 0; i < word.length(); i++) {

            try {

                if ((word.charAt(i) == 'c' || word.charAt(i) == 'd')
                        && word.charAt(i + 1) == '-') {
                    i++;
                }

                if ((word.charAt(i) == 'c' || word.charAt(i) == 's' || word.charAt(i) == 'z')
                        && word.charAt(i + 1) == '=') {
                    i++;
                }

                if ((word.charAt(i) == 'l' || word.charAt(i) == 'n')
                        && word.charAt(i + 1) == 'j') {
                    i++;
                }


                if (word.charAt(i) == 'd') {
                    if (word.charAt(i + 1) == 'z' && word.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }

            } catch (StringIndexOutOfBoundsException e) {

            }
            count++;
        }

        System.out.println(count);
    }
}

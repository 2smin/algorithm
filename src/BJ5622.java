import java.io.IOException;

public class BJ5622 {

    public static void main(String[] args) throws IOException {

        int word = System.in.read();
        int count = 0;

        while(true){

            if(word>64 && word<=79){
                for(int i=1; i<6; i++){
                    if(word < 65+(3*i)){
                        count += 2 + i;
                        break;
                    }
                }
            }

            if(word>79 && word<=83){
                count += 2 + 6;
            }

            if(word>83 && word<=86){
                count += 2 + 7;
            }

            if(word>86 && word<=90){
                count += 2 + 8;
            }

            if(word == 10){break;}

            word = System.in.read();
        }

        System.out.println(count);
    }
}

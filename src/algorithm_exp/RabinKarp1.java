package algorithm_exp;

public class RabinKarp1 {

    public static void main(String[] args) {

        String T = "abcddefderwwbbfsfderww";
        String P = "derww";

        int textSize = T.length();
        int patternSize  = P.length();
        int textHash = 0, patternHash = 0, power = 1;



        for(int i=0; i<=textSize-patternSize; i++){

            if(i==0){
                for(int j=0; j<patternSize; j++){
                    textHash += (T.charAt(patternSize - (1+j)) * power);
                    patternHash += P.charAt(patternSize - (1+j)) * power;
                    if(j < patternSize-1) power = power * 2;
                }

            }else{
                textHash = (2 * (textHash - ((T.charAt(i-1) * power)))) + T.charAt(patternSize - 1 + i);
            }

            if(textHash == patternHash){
                System.out.println("at index : " + i);
            }
        }
    }
}

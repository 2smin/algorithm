import java.io.IOException;
import java.util.ArrayList;

public class BJ2908 {

    public static void main(String[] args) throws IOException {

        int a = System.in.read();

        ArrayList num = new ArrayList();

        while(true){

            if(a>48){ num.add(a); }

            if(a==10){ break; }

            a = System.in.read();
        }

        int from = 2;

        for(int i=0; i<3; i++){
            if((int)num.get(i) > (int)num.get(i+3)){
                from = 2;
            }else if ((int)num.get(i) == (int)num.get(i+3)){

            }else{
                from = 5;
            }
        }

        for(int i=from; i>=from-2; i--){
            System.out.print((int)num.get(i)-48);
        }
    }
}

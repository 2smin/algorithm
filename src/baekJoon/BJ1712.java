import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1712 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        String[] inputList = input.split(" ");

        double holdCost = Integer.valueOf(inputList[0]);
        double varCost = Integer.valueOf(inputList[1]);
        double price = Integer.valueOf(inputList[2]);

        double quantity = holdCost / (price - varCost);

        if(varCost >= price){
            System.out.println(-1);
        }else{
            System.out.println((long)quantity+1);
        }

    }
}

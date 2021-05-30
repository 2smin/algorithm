import java.util.Scanner;

public class BJ2675 {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();

        scan.nextLine();

        String[] quest = new String[total];

        for(int i=0; i<total; i++){
            quest[i] = scan.nextLine();
        }

        for(int i=0; i< quest.length; i++){
            newString(quest[i]);
        }


    }

    public static void newString(String args){

        String[] arrays = args.split(" ");

        String fin = "";
        for(String word : arrays[1].split("")){
            for(int i=0; i<Integer.parseInt(arrays[0]); i++){
                fin += word;
            }
        }

        System.out.println(fin);
    }
}

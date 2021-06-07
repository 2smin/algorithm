import java.util.Scanner;

public class AsciiCode {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int output = Ascii(input.charAt(0));

        System.out.println(output);
    }

    public static int Ascii (char input){

        return (int)input;
    }
}

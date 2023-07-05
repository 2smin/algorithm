package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ11718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        List<String> list = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            list.add(str);
            System.out.println(str);
        }
    }

}

package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class boj1339 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] designated = new int[122];
    static String nums[];
    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());
        nums = new String[N];

        for(int i=0; i<N; i++){
            nums[i] = bf.readLine();
        }
        for(int i=0; i<N; i++){
           String str = nums[i];
           int length = str.length();
           for(int j=0; j<length; j++){
               char alphabet = (char)str.charAt(j);
               designated[alphabet] += (Math.pow(10,(length-1)-j));
           }
        }

        List<Node> nodeList = new ArrayList<>();
        for(int i=0; i<designated.length; i++){
            if(designated[i]!=0){
                nodeList.add(new Node((char)i,designated[i]));
            }
        }

        nodeList.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.count > o2.count){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        int count = 9;
        int sum = 0;

        for(Node node : nodeList){
            sum += (node.count * count--);
        }

        System.out.println(sum);
    }

}

class Node {
    public char alphabet;
    public int count;

    public Node(char alphabet, int count) {
        this.alphabet = alphabet;
        this.count = count;
    }

    @Override
    public String toString() {
        return "alphabet : " + alphabet + "/ count : " + count;
    }
}

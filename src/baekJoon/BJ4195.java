package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4195 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] parent;
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        int loop = Integer.valueOf(bf.readLine());

        while(loop-- > 0){

            int total = Integer.valueOf(bf.readLine());
            StringTokenizer st;

            HashMap<String,Integer> map = new HashMap<>();
            parent = new int[total*2+1];
            cnt = new int[total*2+1];

            for(int i=1; i<parent.length; i++){
                parent[i] = i;
                cnt[i] = 1;
            }

            int idx = 1;
            while(total-- > 0){

                st = new StringTokenizer(bf.readLine());

                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if(!map.containsKey(name1)){ map.put(name1, idx++); }
                if(!map.containsKey(name2)){ map.put(name2,idx++); }

                union(map.get(name1),map.get(name2));
                sb.append(cnt[find(map.get(name1))]).append("\n");

            }

        }
        System.out.println(sb);
    }

    static int find(int x){

        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            parent[b] = a;
            cnt[a] += cnt[b];
        }
    }

}

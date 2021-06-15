package programmers;

import java.util.Arrays;

public class PG42862 {

    public static void main(String[] args) {

        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int[] students = new int[n];
        for(int i=0; i<n; i++){
            students[i] = 1;
        }

        for(int i=0; i<reserve.length; i++){
            students[reserve[i]-1]++;
        }

        for(int i=0; i<lost.length; i++){
            students[lost[i]-1]--;
        }

        System.out.println(Arrays.toString(students));
        for(int i=0; i<students.length-1; i++){

            if(students[i] == 2 && students[i+1] == 0){
                students[i]--;
                students[i+1]++;
            }

            if(students[i] == 0 && students[i+1] == 2){
                students[i]++;
                students[i+1]--;
            }
            System.out.println(Arrays.toString(students));
        }
        int count = 0;
        for(int i=0; i<students.length; i++){
            if(students[i]!=0){ count++;}
        }
        System.out.println(Arrays.toString(students));

        System.out.println(count);
    }
}

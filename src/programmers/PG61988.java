package programmers;

public class PG61988 {

    public static void main(String[] args) {
        PG61988 pg = new PG61988();
        System.out.println(pg.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));

    }

    static long[] dp1;
    static long[] dp2;

    public long solution(int[] sequence) {

        dp1 = new long[sequence.length];
        dp2 = new long[sequence.length];

        int[] reverse = sequence.clone();

        for(int i=0; i< sequence.length; i++){
            if(i%2 == 1){
                sequence[i] = sequence[i] * -1;
            }else{
                reverse[i] = reverse[i] * -1;
            }
        }
        dp1[0] = sequence[0];
        dp2[0] = reverse[0];

        long max = Math.abs(dp1[0]);

        for(int i=1; i< sequence.length; i++){
            long current1 = dp1[i-1] + sequence[i];
            long current2 = dp2[i-1] + reverse[i];

            dp1[i] = Math.max(sequence[i],current1);
            dp2[i] = Math.max(reverse[i],current2);
        }

        for(int i=0; i<sequence.length; i++){
            long dpMax = Math.max(dp1[i],dp2[i]);
            max = Math.max(max,dpMax);
        }
//        for(long num : sequence){
//            System.out.print(num + " ");
//        }
//        System.out.println();
//        for(long num : reverse){
//            System.out.print(num + " ");
//        }
//        System.out.println();
//        for(long num : dp1){
//            System.out.print(num + " ");
//        }
//        System.out.println();
        return max;
    }
}

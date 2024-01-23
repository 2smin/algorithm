package programmers;

public class PG68646 {

    public static int[] rightMinArr;
    public int solution(int[] a) {

        int pos = 0;
        int answer = a.length;
        //leftMin을 정하고, 돌때마다 leftMin 갱신후 피벗이랑 비교
        int leftMin = a[0];
        int rightMin = a[0];
        rightMinArr = new int[a.length];
        calculateRight(a);

        // for(int i=0; i<rightMinArr.length; i++){
        //     System.out.printf(rightMinArr[i] + " ");
        // }
        while(pos != a.length){
            int pivot = a[pos];
            boolean isLeft = false;
            boolean isRight = false;
            //왼쪽 계산
            if(leftMin < pivot){
                isLeft = true;
            }else{
                leftMin = pivot;
            }

            //오른쪽 계산
            //오른쪽 min의 pos까지 저장해놓고, 그때까지는 다 true
            //거길 넘어가면 다시 min을 구하고 거길 넘어갈때까지 다시 true
            if(rightMinArr[pos] < pivot){
                isRight = true;
            }

            if(isLeft && isRight){
                answer--;
            }
            pos++;
        }

        return answer;
    }

    private void calculateRight(int[] a){
        rightMinArr[rightMinArr.length-1] = a[a.length-1];
        for(int i=a.length-2; i>0; i--){
            rightMinArr[i] = Math.min(rightMinArr[i+1],a[i]);
        }
    }
}
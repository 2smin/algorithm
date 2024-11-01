package programmers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();
        String[] ledge = {"01/01 4 99999", "01/11 6 3555", "02/01 0 -23555"};
        int ans = test2.solution(ledge);
        System.out.println(ans);
    }

    static Stack<Deposit> stack = new Stack<>();
    static int sum;

    public class Deposit{
        int money;
        int rate;
        int day;
    }

    public int solution(String[] ledgers) {

        //파싱하기 입금의 경우만 deposit으로 변경
        for(String ledger : ledgers){
            String[] arr = ledger.split(" ");

            //MM/DD를 int 형식의 날짜의 수로 변경
            int month = Integer.valueOf(arr[0].split("/")[0]);
            int day = Integer.valueOf(arr[0].split("/")[1]);

            //month 계산
            for(int i=1; i<month; i++){
                if(i == 2){
                    day += 28;
                }else if(i == 4 || i == 6 || i == 9 || i == 11){
                    day += 30;
                }else{
                    day += 31;
                }
            }

            int rate = Integer.parseInt(arr[1]);
            int money = Math.abs(Integer.parseInt(arr[2]));

            if(rate > 0){ //입금
                Deposit deposit = new Deposit();
                deposit.day = day;
                deposit.rate = rate;
                deposit.money = money;
//                System.out.println(deposit.day + " " + deposit.rate + " " + deposit.money);
                stack.push(deposit);
            }else{
                int withdraw = 0;
                while(withdraw != money){
                    long curWithdraw = 0;
                    Deposit deposit = stack.pop();
                    rate = deposit.rate;
                    if(deposit.money >= money-withdraw){ // 더 많이 꺼낼수 있으면
                        int temp = deposit.money - (money-withdraw);
                        deposit.money = temp;
                        curWithdraw = money-withdraw;
                        stack.push(deposit);
                    }else{ // 부족하면
                        curWithdraw += deposit.money;
                    }

                    //이자 계산
                    double r = rate / 100d;
                    int interest = calculateInterest(curWithdraw, r, deposit.day, day);
//                    System.out.println("interest : " + interest);
                    sum += interest;
                    withdraw += curWithdraw;
                }
            }
        }

        while(!stack.isEmpty()){
            Deposit deposit = stack.pop();
            double r = deposit.rate / 100d;
            int interest = calculateInterest(deposit.money, r, deposit.day, 365);
//            System.out.println("interest : " + interest);
            sum += interest;
        }
        return sum;
    }

    public int calculateInterest(long money, double r, int from, int to){
        BigDecimal rate = new BigDecimal(r);
        BigDecimal num1 = BigDecimal.valueOf(money).multiply(rate);
        int days = to - from;
        BigDecimal num2 = BigDecimal.valueOf(days).divide(BigDecimal.valueOf(365),10, BigDecimal.ROUND_HALF_UP);

        int interest = num1.multiply(num2).setScale(0, RoundingMode.DOWN).intValue();
        return interest;
    }
}

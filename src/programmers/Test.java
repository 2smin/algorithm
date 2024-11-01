package programmers;

public class Test {

    public static void main(String[] args) {

        String rid = "111111-3234567";
        String birth = rid.split("-")[0];
        String personal = rid.split("-")[1];

        int year = Integer.valueOf(birth.substring(0, 2));
        int gender = Character.getNumericValue(personal.charAt(0));
        String answer = "";

        if (gender > 3) year += 2000;
        else year += 1900;

        answer += year;
        answer += "/";

        if (gender % 2 == 1) answer += "M";
        else answer += "F";

        System.out.println(answer);
    }


}
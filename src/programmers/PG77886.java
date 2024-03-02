package programmers;

public class PG77886 {

    public static void main(String[] args) {
        PG77886 pg = new PG77886();
        String[] s =
                {"1110","100111100","0111111010"};

        pg.solution(s);

    }

    public String[] solution(String[] s) {
        /*
        1. 포인터를 3개씩 끊어서 문자열 비교
        2. 같거나 높아지면 교체, 아니면 포인터 3개 뒤로 해서 다시 비교

        110 가져오기 -> 일일히 읽는건 낭비일텐데 110이 계속나오면 이걸 어케 할수 없다
        우선 포인터를 높일수록 그 포인터 기준은 높이는게 맞다 어차피 더 작은값이 못나온다
        해당 포인터 뒤에서부터 110을 계속 찾기

        백만 * 백만이라 이거 다 못함.
        */
        String[] answer = new String[s.length];

        for(int i=0; i<s.length; i++){
            String str = s[i];
            StringBuffer origin = new StringBuffer();
            origin.append(str);
            StringBuffer sf = new StringBuffer();

            int indexOf1 = origin.indexOf("1");
            if(indexOf1 > 0){
                sf.append(origin.substring(0,indexOf1));
                origin.delete(0,indexOf1);
            }
            while(origin.capacity() != 0){
                int index110 = origin.indexOf("110");
                String head = origin.length() >= 3 ? origin.substring(0,3) : origin.toString();
                if(index110 == -1){
                    sf.append(origin);
                    break;
                }
                if(head.compareTo("110") > 0){
                    sf.append("110");
                    origin.replace(index110,index110+3,"");
                }else{
                    sf.append(head);
                    origin.replace(0,3,"");
                }
            }
//            System.out.println("sf" + sf.toString());
            answer[i] = sf.toString();
        }

        return answer;
    }
}

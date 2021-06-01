import java.util.*;
import java.util.Map.Entry;

public class BJ1157{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine().toUpperCase();

        Map wordMap = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            if(!wordMap.containsKey(word.charAt(i))){
                wordMap.put(word.charAt(i), 1);
            }else{
                wordMap.put(word.charAt(i), (int)wordMap.get(word.charAt(i)) +1);
            }
        }

        List<Entry<Character,Integer>> valueList = new ArrayList<Entry<Character, Integer>>(wordMap.entrySet());
        Collections.sort(valueList, new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        if(valueList.size() == 1){
            System.out.println(valueList.get(0).getKey());
        }else{
            if(valueList.get(0).getValue().equals(valueList.get(1).getValue())){
                System.out.println("?");
            }else{
                System.out.println(valueList.get(0).getKey());
            }
        }
    }
}

package test.DeliveryHero210620;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class Task2 {

    public static void main(String[] args) {

        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";

        //1. 이름을 배열로 나눈다 ( 2차원 배열을 주고 미들네임 삭제)
        String[] names = S.split("; ");

        String[] sepNames = new String[names.length]; //최종이름이 담길 배열

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i< names.length; i++){

            String[] splitName = names[i].split(" ");
            splitName[splitName.length-1] = splitName[splitName.length-1].replace("-","");
            String finName = splitName[splitName.length-1].toLowerCase(Locale.ROOT) + "_" + splitName[0].toLowerCase(Locale.ROOT);

            //이름있는것 찾기 있으면 +1 없으면 0으로
            if(map.containsKey(finName)){
                map.put(finName,map.get(finName)+1);
            }else{
                map.put(finName,1);
            }

            int count = map.get(finName);

            if(count > 1){
                finName += count+"";
            }
            sepNames[i] = finName;
        }

       StringBuilder output = new StringBuilder();

       for(int i=0; i< sepNames.length; i++){
           output.append(names[i]);
           output.append(" <" + sepNames[i] + "@" + C.toLowerCase(Locale.ROOT) + ".com>; ");
       }
        output.deleteCharAt(output.lastIndexOf(";"));

    }

    public static String done(){
        String a = "{asda ";
        StringBuilder sb = new StringBuilder();

        sb.append("asd ");
        sb.deleteCharAt(sb.lastIndexOf("d"));
        return sb.toString().trim();
    }

}

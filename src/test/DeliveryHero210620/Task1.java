package test.DeliveryHero210620;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {

        String S = "2000-08-29        956 system.zip\n" +
                "1976-09-16     126976 old-photos.tgz\n" +
                "1987-02-03     118784 logs.rar\n" +
                "1961-12-04  703594496 very-long-filename.rar\n" +
                "1980-08-03          2 DELETE-THIS.TXT\n" +
                "1995-08-23        138 important.rar\n" +
                "2001-08-26     595968 MOONLIGHT-SONATA.FLAC\n" +
                "1967-11-30     245760 archive.rar\n" +
                "1995-10-13        731 file.tgz";

        String[] splited = S.split("\n");
        String[][] dataTrimed = new String[splited.length][3];

        for(int i=0; i<splited.length; i++){
            String[] datas = splited[i].split(" ");
            String[] finData = new String[3];

            finData[0] = datas[0];
            finData[1] = datas[datas.length-2];
            finData[2] = datas[datas.length-1];

            dataTrimed[i] = finData;
        }

        double sizeLimit = 240 * (Math.pow(2,10));
        String[] code = {"zip","rar","tgz"};
        String date = "1995-10-13";

        int count = 0;
        for(int i=0; i<dataTrimed.length; i++){
            boolean isCorrect = true;

            if(date.compareTo(dataTrimed[i][0]) <= 0){
                isCorrect = false;
            }

            if(Double.valueOf(dataTrimed[i][1]) >= sizeLimit){
                isCorrect = false;
            }

            if(!dataTrimed[i][2].contains(code[0]) && !dataTrimed[i][2].contains(code[1]) && !dataTrimed[i][2].contains(code[2])){
                isCorrect = false;
            }

            if(isCorrect){
                count++;
            }
        }

        System.out.println(count);
    }


}

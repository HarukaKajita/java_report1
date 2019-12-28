package java11;

import java.util.HashMap;

public class Population_type2 extends Population_basic{
    HashMap<String, Double> genderRatioMap = new HashMap<>();
    HashMap<String, Double> changeRatioMap = new HashMap<>();

    Population_type2(){

    }

    @Override
    public void printData() {
        //H21向けの処理。他の年度ではオーバーライドして実装。
        System.out.println("データ名：H21年度");
        for (String place : placeList) {
            String placeStr = getPrefixStr(place);
            System.out.print(placeStr);
            System.out.print("人口：" + jinkoMap.get(place) + "　");
            System.out.print("人口性比：" + genderRatioMap.get(place) + "　");
            System.out.print("増減率：" + changeRatioMap.get(place) + "　");
            System.out.println("");
        }
    }
}

package java11;

import java.util.HashMap;

public class Population_type1 extends Population_basic {
    HashMap<String, Integer> shuchuMap = new HashMap<>();
    HashMap<String, Double> densityMap = new HashMap<>();
    HashMap<String, Double> changeRatioMap = new HashMap<>();
    Population_type1(){

    }

    @Override
    public void printData() {
        //H17向けの処理。他の年度ではオーバーライドして実装。
        System.out.println("データ名：H17年度");
        for (String place : placeList) {
            //出力を整形する為にString.formatを使用
            String placeStr = "都道府県名：" + String.format("%-5s", place);
            System.out.print(placeStr + "　");
            System.out.print("人口：" + jinkoMap.get(place) + "　");
            System.out.print("集中地区：" + shuchuMap.get(place) + "　");
            System.out.print("人口密度：" + densityMap.get(place) + "　");
            System.out.print("増減率：" + changeRatioMap.get(place) + "　");
            System.out.println("");
        }
    }
}

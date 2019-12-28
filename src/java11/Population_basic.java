package java11;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

interface PopulationAnalyzer{
        void printData();
        void populationGraph_all();
}

public class Population_basic implements PopulationAnalyzer{
        String name = "";
        ArrayList<String> placeList = new ArrayList<>();
        HashMap<String, Integer> jinkoMap = new HashMap<>();

        Population_basic(){

        }

        public void printTopN(int n, ArrayList<String> plist, HashMap<String, Double> map){
                ArrayList<Integer> topIndexes = new ArrayList<Integer>();
                //トップn個を降順に並べたリストを作る
                for (int i = 0; i < plist.size(); i++) {
                        if(i == 0) {
                                topIndexes.add(i);
                                continue;
                        }
                        double bottomOfTop = map.get(plist.get(topIndexes.size()-1));
                        double ration = map.get(plist.get(i));

                        if(bottomOfTop < ration || topIndexes.size() < n){
                                //降順になるような適切な位置に挿入
                                for (int j = 0; j < topIndexes.size(); j++){
                                        int index = topIndexes.get(j);
                                        String p = plist.get(index);
                                        double r = map.get(p);
                                        if(r < ration){
                                                topIndexes.add(j, i);
                                                break;
                                        }else if(j == topIndexes.size()-1){
                                                //最後尾に挿入
                                                topIndexes.add(i);
                                                break;
                                        }
                                }
                                //不要な要素を削除
                                if(topIndexes.size() > n)topIndexes.remove(n);
                        }

                }
                //出力
                for (int index : topIndexes) {
                        String place = plist.get(index);
                        String placeStr = getPrefixStr(place);
                        System.out.print(placeStr);
                        Double value = map.get(place);
                        System.out.println(value);
                }
        }

        //レポートの課題内容で使用定義されていなかったが配布されたコード内で使用していたので実装
        //単純にデータを一覧出力
        @Override
        public void printData() {
                //H12向けの処理。他の年度ではオーバーライドして実装。
                System.out.println("データ名：H12年度");
                for (String place : placeList) {
                        String placeStr = getPrefixStr(place);
                        System.out.print(placeStr + "　");
                        System.out.println("人口：" + jinkoMap.get(place));
                }
        }

        public void printGraph(String place) {
                // TODO:文字列整形 https://qiita.com/Lilly008000/items/00876d8c61ce36bd5fba
                //100人につき"*"を1つ出力するグラフ
                int scaledPopulation = jinkoMap.get(place) / 100;
                for (int i = 0; i < scaledPopulation; i++) System.out.print("*");
                System.out.println("");
        }

        @Override
        public void populationGraph_all() {
                for (String place: placeList) {
                        // TODO:文字列整形 https://qiita.com/Lilly008000/items/00876d8c61ce36bd5fba
                        //文字列整形
                        String placeStr = getPrefixStr(place);
                        System.out.print(placeStr);
                        //100人につき"*"を1つ出力するグラフ
                        printGraph(place);
                }
        }

        //"都道府県名：○○__："になるように文字列整形
        protected String getPrefixStr(String place){
                String placeStr = format(place, 10);
                placeStr = "都道府県名：" + placeStr;
                return  placeStr;
        }

        protected String format(String target, int length){
                int byteDiff = (getByteLength(target, Charset.forName("UTF-8"))-target.length())/2;
                return String.format("%-"+(length-byteDiff)+"s", target);
        }

        protected int getByteLength(String string, Charset charset) {
                return string.getBytes(charset).length;
        }
}

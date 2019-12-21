package java11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PopulationStats {
	Population_basic h12 = new Population_basic ();
	Population_type1 h17 = new Population_type1();
	Population_type2 h21 = new Population_type2();

	void readFile(String filename){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			h12.name="H12 年度";
			h17.name="H17 年度";
			h21.name="H21 年度";
			reader.readLine();
			while ((line=reader.readLine())!=null) {
				String[] items = line.split(",");
				h12.placeList.add(items[0]);
				h17.placeList.add(items[0]);
				h21.placeList.add(items[0]);
				h12.jinkoMap.put(items[0],Integer.parseInt(items[1]));
				h17.jinkoMap.put(items[0], Integer.parseInt(items[2]));
				h17.shuchuMap.put(items[0], Integer.parseInt(items[3]));
				h17.densityMap.put(items[0], Double.parseDouble(items[4]));
				h17.changeRatioMap.put(items[0], Double.parseDouble(items[5]));
				h21.jinkoMap.put(items[0], Integer.parseInt(items[6]));
				h21.genderRatioMap.put(items[0], Double.parseDouble(items[7]));
				h21.changeRatioMap.put(items[0], Double.parseDouble(items[8]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileReaderから投げられた例外"+e);
		} catch (IOException e) {
			System.out.println("readLineから投げられた例外"+e);
		}

	}

	public static void main(String[] args) {
		PopulationStats ps = new PopulationStats();
		//ny通緑ファイルを読み込み、年度別に格納
		ps.readFile(args[0]);
		ps.h12.printData();
		ps.h17.printData();
		ps.h21.printData();

		System.out.println("=====H12 年度の全都道府県の人口グラフ=====");
		//100,000人を*として棒グラフで人口を表現
		ps.h12.populationGraph_all();
		System.out.println("=====H17 年度人口増加率トップ10=====");
		ps.h17.printTopN(10,ps.h17.placeList,ps.h17.changeRatioMap);
		System.out.println("=====H21 年度人口増加率トップ10=====");
		ps.h21.printTopN(10,ps.h21.placeList,ps.h21.changeRatioMap);

		System.out.println("人口分析ツール");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				System.out.println("都道府県を入力->");
				String place = reader.readLine();
				ps.printJinko(place);
			}catch (Exception e){
			}
		}

	}

	void printJinko(String place) {
		System.out.println("====="+place+"の人口グラフ=====");
		System.out.print("H12 年度:");
		h12.printGraph(place, h12.jinkoMap.get(place));
		System.out.print("H17 年度:");
		h17.printGraph(place, h17.jinkoMap.get(place));
		System.out.print("H21 年度:");
		h21.printGraph(place, h21.jinkoMap.get(place));
	}
}


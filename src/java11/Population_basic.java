package java11;

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

        }

        void printGraph(String place, Integer integer){

        }


        @Override
        public void printData() {

        }

        @Override
        public void populationGraph_all() {

        }
}

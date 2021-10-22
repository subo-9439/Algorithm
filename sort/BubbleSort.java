package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){

        for(int cnt=0; cnt<dataList.size()-1; cnt++){
            boolean swap=false;
            for(int idx=0; idx<dataList.size()-1-cnt;idx++){
                if(dataList.get(idx)>dataList.get(idx+1)){
                    Collections.swap(dataList, idx, idx+1);
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for(int i=0; i<100; i++){
            testData.add((int)(Math.random()*100));
        }
        BubbleSort test = new BubbleSort();
        test.sort(testData);
        System.out.println(testData);
    }
}

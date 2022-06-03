package al_22_06;

import java.util.*;

public class Comparator사용 {
    ArrayList<String[]> ans = new ArrayList<>();
    ArrayList<String[]> realAns = new ArrayList<>();
    String[] str;
    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        int size = sideDishes.length;
        ans.add(new String[]{});
        Arrays.sort(sideDishes);

        for (int i = 0; i< size; i++){
            str = new String[i+1];
            combination(0,0,i+1,-1,sideDishes,size);
        }
        ans.sort(nComparator);
        for (String[] a : ans){
            System.out.println(Arrays.toString(a));
        }
        return ans;

    }
    //comparTo를 해서 양수값이 나오면 오름차순
    //음수 값이 나오면 내림차순이다.
    Comparator<String[]> nComparator = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            if(o1.length==0) return 1;
            int min = Math.min(o1.length,o2.length);
            int i = -1;
            while (++i < min){
                if(o1[i].compareTo(o2[i]) > 0){
                    return 1;
                }else if(o1[i].compareTo(o2[i]) < 0){
                    return -1;
                }
                if(i == min-1){
                    if(o1.length > o2.length){
                        return  -1;
                    }else {
                        return  1;
                    }
                }
            }
            return 0;
        }
    };

    public void combination(int idx,int cnt, int len ,int start,String[] sideDishes,int size ){
        if(cnt == len){
            ans.add(str.clone());
        }else {

            for (int i = start+1; i < size; i++){
                str[idx] = sideDishes[i];
                combination(idx+1,cnt+1, len,i,sideDishes,size);

            }
        }
    }
}

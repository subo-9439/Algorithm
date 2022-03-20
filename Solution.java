import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<Integer> solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        //색인 집어넣기 1~26

        for(int i = 65; i <=90;i++){
            String s =Character.toString(i);
            map.put(s, i-64);
        }
        //
        boolean zip = false;
        int num = -1;
        int i = 1;

        // 마지막 인덱스 

        for(int idx = 0; idx < msg.length();){
            for(int inc = 1; inc <= msg.length()-idx; inc++){
                //KA
                String a = msg.substring(idx, idx+inc);
                if(map.get(a) != null){
                    num = map.get(a);
                    if(idx+inc == msg.length()) zip = true;
                }else{
                    i = inc-1;
                    // idx += inc;
                    map.put(a,map.size()+1);
                    break;
                }
            }
            list.add(num);
            if(zip) break;

        }

        for(i = 1; i <= msg.length(); i++){
            
        }
        return list;
    }
}
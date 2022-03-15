package kakao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class 튜플 {
    public int[] solution(String s) {
        int[] answer = {};
        int start = 1;
        int end = s.charAt(s.length()-1);
        //리스트의 사이즈, 그 리스트
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        ArrayList<Integer> list =new ArrayList<>();


        // "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        int pos = 0;
        String num = "";
        while(pos<s.length()-2){
            pos++;
            if(s.charAt(pos) == '{'){

            }else if (s.charAt(pos) == ','){
                //만약 괄호사이면
                if(s.charAt(pos-1) =='}'){
                }else{
                    list.add(Integer.parseInt(num));
                }
                num="";
                //값넣기

            }else if(s.charAt(pos)=='}'){
                //맵에 넣기
                list.add(Integer.parseInt(num));
                map.put(list.size(), list);
                list = new ArrayList<>();
            }else {
                // 숫자 이어붙이기
                num+= s.charAt(pos);
            }
        }

        Map<Integer,Integer> m = new HashMap<>();

        // "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        for(Integer key: map.keySet()){
            for(Integer n : map.get(key)){
                m.put(n, m.getOrDefault(n, 0)+1);
            }
            // System.out.println(map.get(key));
        }
        answer = new int[m.size()];

        for(Integer key: m.keySet()){
            answer[m.size() - m.get(key)] = key;
        }

        return answer;
    }
}
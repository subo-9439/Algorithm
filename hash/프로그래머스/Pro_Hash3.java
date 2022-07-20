package hash.프로그래머스;

import java.util.HashMap;
import java.util.Map;

//프로그래머스 해시Lv3
//위장
public class Pro_Hash3 {
    class Solution{
        public int solution(String[][] clothes){
            int answer = 1;
            //1.옷을 종류별로 구분하기
            Map<String, Integer> map = new HashMap<>();
            for(String[] cloth : clothes){
                String type = cloth[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            //2. 입지 않는 경우를 추가하여 모든 조합 계산하기
            for(String cloth : map.keySet()){
                answer *= map.get(cloth)+1;
            }

            return answer-1;
        }
    }    
}

package kakao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pro_메뉴리뉴얼 {

class Solution {
    static char[] food;
    static Map<Integer,Map<String,Integer>> group;
    static Map<String,Integer> map;
    static StringBuilder sb = new StringBuilder();
    


    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();      //음식 , 해당음식개수  
        group = new HashMap<>();    //코스요리수 , map

        ArrayList<String> res = new ArrayList<>();

        //orders내에있는문자를 알파벳 순으로 정렬한다 
        for(int i = 0; i < orders.length; i++){
            char[] a = orders[i].toCharArray();
            Arrays.sort(a);
            orders[i] = new String(a);
            System.out.println(orders[i]);
        }

        // course[i]에 있는 count
        // 값으로 food배열 초기화
        for(int i = 0; i<course.length; i++){
            int count = course[i];
            food = new char[count];

            for(int j = 0; j < orders.length; j++){
                dfs(0, -1, orders[j], count);
            }
            group.put(count, map);
            map = new HashMap<>();
        }

        //count 별 로 해당 map 꺼내기
        for(int i = 0; i < course.length; i++){
            Map<String, Integer> temp = group.get(course[i]);
            int max = temp.isEmpty()? -1 : Collections.max(temp.values());

            for(String key : temp.keySet()){
                if(temp.get(key) == max && max >1) res.add(key);
            }
        }

        // arrayList to String
        String[] answer = res.toArray(new String[res.size()]);
        Arrays.sort(answer);
        return answer;
    }

    //조합
    void dfs(int k, int idx, String order,int count){
        if(k == count){
            for(int i = 0 ; i < count; i++){
                sb.append(food[i]);
            }
            String menu = sb.toString();
            sb.setLength(0);
            map.put(menu, map.getOrDefault(menu, 0) + 1 );

        }else{
            for(int i = idx+1; i < order.length(); i++){
                food[k] = order.charAt(i);
                dfs(k+1, i ,order, count);
            }
        }
    }
}

}

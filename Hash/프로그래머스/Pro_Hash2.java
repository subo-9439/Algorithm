package Hash.프로그래머스;
import java.util.HashMap;
import java.util.Map;

//프로그래머스 Hash Lv2
//전화번호 목록

public class Pro_Hash2 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0 ; i < phone_book.length; i++){
                map.put(phone_book[i], i);
            }

            for(int i = 0; i < phone_book.length; i++)
                for(int j = 0; j < phone_book[i].length(); j++)
                    if(map.containsKey(phone_book[i].substring(0,j)))
                    return false;
            
            return answer;
        }
    }
}

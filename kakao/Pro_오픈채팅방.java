package kakao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro_오픈채팅방 {
  class Solution {
      public ArrayList<String> solution(String[] record) {
          HashMap<String,String> map = new HashMap<>();
          ArrayList<String> answer = new ArrayList<>();

          for(int i = 0; i < record.length; i++){
              StringTokenizer st = new StringTokenizer(record[i]);

              String behavior = st.nextToken();
              String id = st.nextToken();
              if(behavior.equals("Leave")) continue;
              String name = st.nextToken();
              map.put(id, name);
          }

          for(int i = 0; i< record.length;i++){
              StringTokenizer st = new StringTokenizer(record[i]);
              String behavior = st.nextToken();
              String id = st.nextToken();
              if(behavior.equals("Enter")){
                  answer.add(map.get(id)+"님이 들어왔습니다.");
              }
              if(behavior.equals("Leave")){
                  answer.add(map.get(id)+"님이 나갔습니다.");
              }
          }
          return answer;
  
      }
  }
}

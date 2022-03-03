import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k ){
        int[] answer = new int[id_list.length];
        Map<String, Integer> count = new HashMap<>();       //신고당한횟수
        Map<String, Set<String>> singo = new HashMap<>();   //신고한사람 리스트들

        //초기화
        for(String id : id_list){
            count.put(id, 0);
            singo.put(id, new HashSet<>());
        }

        //신고한사람 from 신고당한사람 to
        for(String str : report){
            StringTokenizer st = new StringTokenizer(str);
            String from = st.nextToken();
            String to = st.nextToken();

            if(singo.get(from).add(to)){//set에 처음신고한 사람이면  값증가
                count.put(to, count.get(to)+1);// 나중에 바꿔보기 getordefault
            }
        }

        for(String str : report){
            StringTokenizer st = new StringTokenizer(str);
            String from = st.nextToken();
            String to = st.nextToken();

            if(count.get(to)<k){
                singo.get(from).remove(to);     //신고조건 불충분으로 지우기
            }
        }

        //이제 신고 했으면 그사람이게 메세지보내기
        for(int i =0 ; i<id_list.length; i++){
            answer[i] = singo.get(id_list[i]).size();
        }
        return answer;


    }

}
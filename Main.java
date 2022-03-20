import java.util.*;

class Solution {
    HashMap<String,Integer> hm = new HashMap<String,Integer>();
    ArrayList<Integer> solution(String msg) {


        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=1; i<=26; i++) {
            String alphabet = Character.toString(i+64);
            hm.put(alphabet,i);

        }

        char[] src = msg.toCharArray();
        int head = 0;
        int cnt = 26;
        for(int tail = 1; tail<src.length+1; tail++) {
            String str = msg.substring(head,tail);

            if(!hm.containsKey(str)) {   // 없으면

                cnt = cnt + 1;
                hm.put(str,cnt);
                int ans = hm.get(msg.substring(head,tail-1));
                answer.add(ans);
                head = tail-1;
            }

            if(tail == src.length) {
                answer.add(hm.get(msg.substring(head, tail)));
            }

        }




        return answer;

    }
}
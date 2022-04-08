package al_22_03;

import java.util.HashMap;
import java.util.Map;

public class Pro_다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        //enroll 이름  referral 추천인 seller 판매원 amount 판애원이 판량 * 100

        Map<String, Integer> cashMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        //초기화
        for(int i = 0 ; i < enroll.length; i++){
            nameMap.put(enroll[i],referral[i]);
            cashMap.put(enroll[i],0);
        }
        for(int i = 0; i< seller.length; i++){
            String name = seller[i];
            int curCash = amount[i]*100;
            cashMap.put(name,cashMap.get(name)+curCash);
            while (nameMap.containsKey(name)){
                cashMap.put(name, cashMap.get(name) - (int) (curCash*0.1) );
                String next = nameMap.get(name);
                if(nameMap.containsKey(next)){
                    cashMap.put(next, cashMap.get(next) + (int) (curCash*0.1));
                }
                curCash *=0.1;
                if(curCash == 0) break;;
                name = next;
            }
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = cashMap.get(enroll[i]);
        }

        return answer;
    }
}

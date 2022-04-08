package al_22_03;

import java.util.HashMap;
import java.util.Map;
//프로그래머스 2021 Dev-matching: 웹 백엔드 개발자(상반기)
public class Pro_로또의최고순위와최저순위 {
        public int[] solution(int[] lottos, int[] win_nums) {
            Map<Integer,Integer> map = new HashMap<>(){{
                put(0,6);
                put(1,6);
                put(2,5);
                put(3,4);
                put(4,3);
                put(5,2);
                put(6,1);
            }};

            int[] answer = new int[2];
            // lottos 정렬하기 win_nums 정렬하기
            int cnt = 0, min = 0, max = 0;
            int zeroCnt = 0;
            for(int i = 0 ; i<lottos.length; i++){
                if(lottos[i] == 0) zeroCnt++;
                for(int j = 0; j <win_nums.length; j++){
                    if (lottos[i] == win_nums[j]) cnt++;
                }
            }
            if(zeroCnt==0) max = min;
            else max = cnt+zeroCnt;
            answer[0] = map.get(max);
            answer[1] = map.get(cnt);
            return answer;
        }
}

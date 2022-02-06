package Queue.프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//프로그래머스 큐Lv2
//기능개발 
public class Pro_Queue1 {
    class Solution{
        public int[] solution(int[] progresses, int[] speeds){
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<progresses.length; i++){
                //나머지가 있으면 + 1 해야하므로 올림
                queue.add((int)(Math.ceil((100.0 - progresses[i]) / speeds[i])));
            }

            List<Integer> answer = new ArrayList<>();
            while(!queue.isEmpty()){
                int day = queue.poll();
                int cnt = 1;

                while(!queue.isEmpty() && day >= queue.peek()){
                    cnt++;
                    queue.remove();
                }
                answer.add(cnt);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

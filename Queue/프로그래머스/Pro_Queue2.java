package Queue.프로그래머스;

import java.util.Collections;
import java.util.PriorityQueue;

//프로그래머스 큐Lv2
//프린터 
//우선순위 큐 이용
public class Pro_Queue2 {
  class Solution{
      public int solution(int[] priorities, int location) {
          int answer = 0;
          PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
          for(int i = 0; i < priorities.length; i++){
              pq.add(priorities[i]);
          }

          while(!pq.isEmpty()){
              for(int i = 0; i < priorities.length; i++){
                  if(pq.peek() == priorities[i]){
                      if(i == location){
                          answer++;
                          return answer;
                      }
                      pq.poll();
                      answer++;
                  }
              }
          }
          return answer;

      }
  }
}

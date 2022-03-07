package kakao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//프로그래머스 2019 kakao blind
//실패율
public class Pro_실패율 {

  class Solution {
      public int[] solution(int N, int[] stages) {
          int[] answer = new int[N];
          
          //정렬
          Arrays.sort(stages);
          double failure = 0;
          ArrayList<Info> order = new ArrayList<>();
          int[] cnt = new int[502];//

          //해당스테이지 개수 증가
          for(int stage: stages)  cnt[stage]++;

          //각 스테이지별 실패율 기록
          int player = stages.length;
          order.add(new Info(0, 0));
          for(int i = 1; i <= N; i++){
              if(player==0){
                  order.add(new Info(i, 0));
              }else{
                  failure = (double)cnt[i]/player;
                  order.add(new Info(i, failure));
                  player-=cnt[i];
              }
          }

          //0번은 필요없으므로 지워주고 정렬 순서대로 입력
          order.remove(0);
          Collections.sort(order);
          for(int i = 0; i<N; i++) answer[i] = order.get(i).idx;
          

          return answer;
      }

      class Info implements Comparable<Info>{
          int idx;
          double failure;
          public Info(int idx, double failure){
              this.idx = idx;
              this.failure = failure; 
          }
          @Override
          public int compareTo(Solution.Info o) {
              if(this.failure - o.failure >0) return -1;
              else if(this.failure - o.failure <0) return 1;
              else {
                  return 0;
              }
          }
      }
  }
}

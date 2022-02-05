import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds){
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
            
        for(int i = 0; i < progresses.length; i++){
            int quotient = (100-progresses[i])/speeds[i];
            //나머지가 있으면 몫 + 1
            if( (100-progresses[i]) % speeds[i] != 0) quotient++;
            Q.add(quotient);
        }
            
            //기준
        int cnt = 0;
        int standard = Q.peek();

        while(!Q.isEmpty()){
            int x = Q.poll();

            if(x <= standard){
                cnt++;
            }else{
                standard = x;
                Q.add(x);
                answer.add(cnt);
                cnt = 0;
            }
                
        }

        return answer;
    }
 }


package sort;
import java.util.Comparator;
import java.util.PriorityQueue;
//프로그래머스 정렬 Lv2 
//가장 큰수
//힙을 사용하여 가장 큰수 찾기
public class Prog_Sort2 {

class Solution {
    class Info implements Comparable<Info>{
        public int idx;
        public int value;

        public Info(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
        
        @Override
        public int compareTo(Info o) {
            String a = Integer.toString(this.value);
            String b = Integer.toString(o.value);
            return Integer.parseInt(a+b) > Integer.parseInt(b+a) ? 1:-1;
        }
    }

    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int zeroCnt =  0;
        for(int i = 0; i <numbers.length; i++){
            if(numbers[i] == 0) zeroCnt++;
            pq.add(new Info(i,numbers[i]));
        }
        if(zeroCnt == numbers.length){
            return "0";
        }
        while(!pq.isEmpty()){
            int idx = pq.poll().idx;
            answer += Integer.toString(numbers[idx]);
        }
        return answer;
    }
}
}

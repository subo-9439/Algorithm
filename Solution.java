import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : scoville) pq.add(n);

        int hot = 0 ;int cnt = 0;
        while(pq.peek() < K){
            if(pq.size() == 1) return -1;
            hot = pq.poll() + pq.poll()*2;
            pq.add(hot);
            cnt++;
        }
        return cnt;
    }
}
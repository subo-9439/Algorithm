<<<<<<< HEAD
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다.
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public ArrayList<String> solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);

            String behavior = st.nextToken();
            String id = st.nextToken();
            if(behavior.equals("Leave")) continue;
            String name = st.nextToken();
            map.put(id, name);
        }

        for(int i = 0; i< record.length;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String behavior = st.nextToken();
            String id = st.nextToken();
            if(behavior.equals("Enter")){
                answer.add(map.get(id)+"님이 들어왔습니다.");
            }
            if(behavior.equals("Leave")){
                answer.add(map.get(id)+"님이 나갔습니다.");
>>>>>>> ad49a0ff178f8a776ca84ec4c2193539fa01ebd1
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){ // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식}
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
<<<<<<< HEAD
=======
 
>>>>>>> ad49a0ff178f8a776ca84ec4c2193539fa01ebd1
    }



}
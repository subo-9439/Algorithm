package stack;

import java.util.Stack;

//프로그래머스 Lv2
//주식가격
public class Pro_Stack1 {
  class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < prices.length; i++){
          while(!stack.isEmpty() && prices[i] < stack.peek()){
            answer[stack.peek()] = i - stack.peek();
            stack.pop();
          }
          stack.push(i);
        } 
        
        while(!stack.isEmpty()){
          answer[stack.peek()] = prices.length - stack.peek() - 1;
          stack.pop();
        }
        
        return answer;
    }
}
  
}

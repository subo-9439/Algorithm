package kakao;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Pro_크레인_인형뽑기_게임 {

//프로그래머스 2019 카카오
//크레인 인형뽑기 게임
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Queue<Integer> idx_list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[][] visited = new boolean[board.length][board.length];
        //idx값 넣기
        for(int i : moves){
            idx_list.add(i-1);
        }
        //[x][col] x값만 바꿔주기
        while(!idx_list.isEmpty()){
            int idx = idx_list.poll();
            for(int x = 0; x < board.length; x++ ){
                if(board[x][idx]==0) continue;
                else{//값만 넣고 break;
                    if(visited[x][idx]) continue;
                    if(stack.size()!=0 && stack.peek() == board[x][idx]){
                        answer+=2;//터뜨린개수 세기
                        stack.pop();
                    }else{
                        stack.add(board[x][idx]);
                    }        
                    visited[x][idx] =true;
                    break;
                }
            }
        }
        return answer;
    }
}
}

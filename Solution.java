
class Solution{
    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, answer, 0, target);
        answer = cnt;
        return answer;
    }
    public void dfs(int[] numbers, int answer,int k, int target){
        if(k == numbers.length){
            if(answer == target) cnt++;
            return;
        }else{
            answer += numbers[k];
            dfs(numbers, answer, k+1, target);
            answer -= 2*numbers[k];
            dfs(numbers, answer, k+1, target);
        }
        
    }
 
}
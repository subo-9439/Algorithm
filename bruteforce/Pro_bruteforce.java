package bruteforce;

//프로그래머스 Lv2
//브르투포스 
public class Pro_bruteforce {
  class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int multiple = 0;
        //가로 2x 세로 2y  = 10+4
        //x <=7
        //y <= 7-x
        
        for(int i = 1; i <= brown/2 + 2; i++){
            for(int j = 1; j <= brown/2 - i + 2; j++){

                if(i*j == (brown+yellow)) {
                    answer[0] = i; answer[1] = j;
                }
            }
        }
        return answer;
    }
}
}

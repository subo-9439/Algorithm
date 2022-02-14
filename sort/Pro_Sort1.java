package sort;
import java.util.Arrays;

//프로그래머스 Sort Lv1
//K번째수

public class Pro_Sort1 {


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        // arr.sort((a,b) -> a.compareTo(b));
        return answer;
    
    }
}
}

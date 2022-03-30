package 날짜별.a220329;

import java.util.ArrayList;
import java.util.Collections;

//프로그래머스 2021 Dev-matching: 웹 백엔드 개발자(상반기)
// 달팽이문제
// 2차원 배열 깊은 복사
// System.arraycopy(복사할배열, 시작번호, 복사본을 담을 배열, 시작번호, 얼마큼 읽어올것인가)

public class Pro_행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];;
        int[][] temp = new int[rows+1][columns+1];

        int num = 1;
        for(int i = 1; i<rows+1; i++){
            for(int j = 1; j<columns+1; j++){
                map[i][j] = num;
                temp[i][j] = num++;
            }
        }
        int drawCount = 0,idx=0;
        for(int i = 0; i < queries.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            drawCount = x2 - x1;
            for(int k = 1; k <=drawCount; k++){
                temp[x2-k][y1] = map[x2+-k+1][y1];
                list.add(temp[x2-k][y1]);
            }
            drawCount = y2 - y1;
            for(int k = 1; k <= drawCount; k++){
                temp[x1][y1+k] = map[x1][y1+k-1];
                list.add(temp[x1][y1+k]);
            }
            drawCount = x2 - x1;
            for(int k = 1; k <=drawCount; k++){
                temp[x1+k][y2] = map[x1+k-1][y2];
                list.add(temp[x1+k][y2]);

            }
            drawCount = y2 - y1;
            for(int k = 1; k <= drawCount; k++){
                temp[x2][y2-k] = map[x2][y2-k+1];
                list.add(temp[x2][y2-k]);

            }
            //깊은 복사
            for(int j = 0; j < map.length; j++){
                System.arraycopy(temp[j],0,map[j],0,temp[0].length);
            }
            answer[idx++]= Collections.min(list);
        }
        return answer;
    }
}

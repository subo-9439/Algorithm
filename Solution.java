import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited;
    static int row_length, col_length;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visited = new boolean[m][n];
        row_length = m;
        col_length = n;


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) continue;
                if(picture[i][j] == 0) continue;
                //방문한적도 없고 값이 0이아닌 구간만 bfs
                int size = bfs(i, j, picture);
                numberOfArea++;
                if(maxSizeOfOneArea < size){//사이즈가 더크면 바꾸기
                    maxSizeOfOneArea = size;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static int bfs(int i, int j,int[][] picture){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);//x
        queue.add(j);//y
        visited[i][j] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int k = 0; k < 4; k++){
                int dx = x + dir[k][0];
                int dy = y + dir[k][1];
                
                if(dx >= row_length || dy >= col_length || dx < 0 || dy < 0) continue;
                if(visited[dx][dy]) continue;
                if(picture[dx][dy] != picture[x][y])continue;
                cnt++;
                visited[dx][dy] = true;
                queue.add(dx);
                queue.add(dy);
            }
        }
        return cnt;
    }

}    

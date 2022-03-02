package graph.프로그래머스;
import java.util.LinkedList;
import java.util.Queue;
public class Pro_BFS2 {

  static boolean[] visited;
class Solution {
    //1,1,0,
    //1,1,0,
    //0,0,1
    public int solution(int n, int[][] computers) {
        int answer=0;
        visited = new boolean[n];
        for(int x = 0; x < n; x++){
            if(visited[x]) continue;
            bfs(x,n, computers);
            answer++;
        }
        return answer;
    }

    public void bfs(int node,int n,int[][] computers){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int y = 0; y <n; y++){
                if(visited[y]) continue;
                if(computers[x][y] == 1){
                    visited[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
}

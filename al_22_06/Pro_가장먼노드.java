package al_22_06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_가장먼노드 {
    static boolean[] visted;
    static int[] dist;
    static int max;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visted = new boolean[n+1];
        dist = new int[n+1];
        ArrayList<Integer>[] map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            map[x].add(y);
            map[y].add(x);
        }

        bfs(map);
        for (int i = 1; i <= n; i++){
            if(dist[i] == max) {
                answer++;
            }
        }
        return answer;
    }
    public void bfs(ArrayList<Integer>[] map){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visted[1] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (Integer y : map[x]){
                if(visted[y]) continue;
                visted[y] = true;
                dist[y] = dist[x]+1;
                max = Math.max(dist[y],max);
                queue.add(y);
            }
        }

    }
}

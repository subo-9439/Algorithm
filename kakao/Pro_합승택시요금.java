package kakao;

//프로그래머스 카카오
//합승 택시 요금 
public class Pro_합승택시요금 {
  class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 200 * 100000 + 1; //최단거리가 될수 있는 최대값은 n * fares값 + 1;
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){        //map 초기화
            for(int j=1; j<=n; j++){
                if(i==j)map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for(int i = 0; i < fares.length; i++){
            for(int j = 0; j < 3; j++){
                int from = fares[i][0];
                int to = fares[i][1];
                int weight = fares[i][2];
                map[from][to] = weight;
                map[to][from] = weight;
            }
        }

        // s => k 플로이드 와샬
        for(int k = 1; k <= n; k++){
            for(int start = 1; start <= n; start++){
                if(start == k ) continue;
                for(int end = 1; end <= n; end++) {
                    if(start == end || k == end) continue;
                    map[start][end] = Math.min(map[start][end], map[start][k] + map[k][end]);
                }
            }
        }

        // s => k => a,b
        for(int k=1; k<=n; k++){
            if(map[s][k] == INF || map[k][a] == INF || map[k][b] == INF) continue;
            answer = Math.min(answer, map[s][k] + map[k][a] + map[k][b]);
        }
        

        return answer;
    }

}
}

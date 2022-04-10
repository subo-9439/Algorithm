package al_22_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//Boj 15685
//
public class Boj_치킨배달 {
	static FastReader scan = new FastReader();
	static int N,M;
	static int[][] map;
	static ArrayList<Pos> home;
	static ArrayList<Pos> chickens;
	static int ans;
	static boolean[] visited;
	static void input(){
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][N];
		home = new ArrayList<>();
		chickens = new ArrayList<>();
	}
	static void pro(){
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();

				if(map[i][j] == 1){
					home.add(new Pos(i, j));
				}
				if(map[i][j] == 2){
					chickens.add(new Pos(i, j));
				}
			}
		}
		ans = Integer.MAX_VALUE;
		visited = new boolean[chickens.size()];
		dfs(0,0);
	}
	static void dfs(int start, int cnt){
    //M만큼 선택된다면
		if(cnt == M){
			int res = 0;
      //각 집에서 
			for(int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
        // M만큼 선택된 치킨집까지 거리를 계산한다.
        // ex) M = 2라면 각집에서 두집까지의 최소거리 = res
				for(int j = 0; j < chickens.size(); j++){
					if(visited[j]) {
						int dist = Math.abs(home.get(i).x - chickens.get(j).x)+ Math.abs(home.get(i).y - chickens.get(j).y);
						temp = Math.min(temp, dist);
					}
				}
				res += temp;
			}
      // 여러 치킨집을 돌면서 두집거리중 가장 작은 ans를 구함
			ans = Math.min(ans, res);
			return;
		}
    //치킨집을 개수 만큼 선택한다.
		for(int i = start; i< chickens.size(); i++){
			visited[i] = true;
			dfs(i + 1, cnt+ 1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		input();
		pro();
		System.out.println(ans);
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while(st== null || !st.hasMoreTokens()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
	}
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

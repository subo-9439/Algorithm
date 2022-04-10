import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
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
		if(cnt == M){
			int res = 0;

			for(int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for(int j = 0; j < chickens.size(); j++){
					if(visited[j]) {
						int dist = Math.abs(home.get(i).x - chickens.get(j).x)
						+ Math.abs(home.get(i).y - chickens.get(j).y);
						temp = Math.min(temp, dist);
					}
				}
				res += temp;
			}
			ans = Math.min(ans, res);
			return;
		}
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
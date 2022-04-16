import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
dp[N][0] => dp[N][0] or dp[N][1] => 자식노드의 수중 가장 큰수
dp[N][1] => 자기자신과 + dp[N][0] or dp[N][1] 중 작은 수
 */
public class Main{
	static FastReader scan = new FastReader();
	static int N;
	static int[] towns;
	static ArrayList<Integer>[] lists;
	static int[][] dp;
	static void input(){
		N = scan.nextInt();
		towns = new int[N+1];
		lists = new ArrayList[N+1];

		for(int i = 1; i<=N; i++){
			towns[i] = scan.nextInt();
		}
		for(int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
		for(int i = 0; i < N-1; i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			lists[x].add(y);
			lists[y].add(x);
		}
	}
	static void pro(){
		dp = new int[N+1][2];
		dfs(1,-1);
		System.out.println(Math.max(dp[1][0],dp[1][1]));
	}
	static void dfs(int x, int par){
		dp[x][1] = towns[x];
		for(int y: lists[x]){
			if(y == par)continue;
			dfs(y,x);
			dp[x][0] += Math.max(dp[y][0],dp[y][1]);
			dp[x][1] += dp[y][0];
		}

	}
	public static void main(String[] args) {
		input();
		pro();
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while (st==null || !st.hasMoreTokens()){
				try {
					st = new StringTokenizer(br.readLine());
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
	}
}
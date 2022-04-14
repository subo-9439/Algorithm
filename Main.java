import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static FastReader scan = new FastReader();
	static int N,R,Q;
	static ArrayList<Integer>[] list;
	static int[] dp;
	static ArrayList<Integer> queries;
	static void input(){
		N = scan.nextInt();
		R = scan.nextInt();
		Q = scan.nextInt();
		//리스트 정보
		list = new ArrayList[N+1];
		dp = new int[N+1];
		queries = new ArrayList<>();

		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();

		for(int i = 0; i < N-1; i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		for(int i = 0; i < Q; i++) queries.add(scan.nextInt());

	}
	static void pro(){
		dfs(R,-1);

	}
	static void dfs(int x, int par){
		dp[x] = 1;
		for(int y : list[x]){
			if(y == par) continue;
			dfs(y,x);
			dp[x] += dp[y];
		}
	}
	public static void main(String[] args) {
		input();
		pro();
		StringBuilder sb = new StringBuilder();
		for(int i : queries)
			sb.append(dp[i]).append('\n');
		System.out.println(sb);
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
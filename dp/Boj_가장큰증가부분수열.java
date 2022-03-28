package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//가장 큰 증가 부분 수열 백준_11055
public class Boj_가장큰증가부분수열 {
	static FastReader scan = new FastReader();
	static int N, max;
	static int[] A;
	static int[] dp;
// 1, 100, 2, 50, 60, 3, 5, 6, 7, 8
	static void input(){
		N = scan.nextInt();
		A = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++){
			A[i] = scan.nextInt();
		}
		dp[0] = A[0];
	}
	static void pro(){
		for(int i = 1; i < N ; i++){
			dp[i] = A[i];
			for(int j = 0; j < i; j++){
				if(A[i] > A[j]){
					dp[i] = Math.max(A[i]+dp[j],dp[i]);
				}
			}
		}
		for(int i = 0; i <N; i++){
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
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
			while(st==null||!st.hasMoreTokens()){
				try{
					st=new StringTokenizer(br.readLine());
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
}

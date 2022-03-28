package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Boj 11053번 LIS
public class Boj_가장긴증가하는부분수열 {
  static FastReader scan = new FastReader();
	static int N, max;
	static int[] arr;
	static int[] dp;
	static void input(){
		N = scan.nextInt();
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = scan.nextInt();
			dp[i] = 1;
		}
	}
	static void pro(){
		for(int i = 1; i < N; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i] && dp[j]+1>dp[i]){
					dp[i] = dp[j]+1;
				}
			}
		}
		for(int i = 0; i <N ; i++) {
			max = dp[i] > max? dp[i] : max;
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

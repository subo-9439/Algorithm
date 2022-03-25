package binarysearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 6236 실버2
public class Boj_용돈관리 {
	static FastReader scan = new FastReader();
	static int N,M;
	static int[] arr;
	static int max=0;
	static void input(){
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = scan.nextInt();
			max = Math.max(max, arr[i]);
		}
	}
	static void pro(){
		int L = arr[0], R = 1000000000;
		int ans =0;
		while(L<=R){
			int mid = (L+R)/2;
			if(determination(mid)){
				R = mid-1;
				ans = mid;
			}else{
				L = mid+1;
			}
		}
		System.out.println(ans);
	}
	static boolean determination(int coin){
		if(coin < max) return false;
		int cur = coin;
		int cnt = 1;
		
		for(int i = 0 ; i < N; i++){
			if(cur-arr[i] < 0) {
				cur = coin-arr[i];
				cnt++;
			}else{
				cur -= arr[i];

			}
		}
		return cnt<=M;
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
					st = new StringTokenizer(br.readLine());
				}catch(IOException e)
				{
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

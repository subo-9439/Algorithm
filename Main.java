import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static FastReader scan = new FastReader();
	static int T;
	static int[] arr;
	public static void main(String[] args) {
		T = scan.nextInt();
		arr = new int[10];
		int t=0;
		while (T-- >0) {
			int sum = 0;

			for(int i = 0; i < 10; i++){
				arr[i] = scan.nextInt();
				if (arr[i] % 2 != 0) sum += arr[i];
			}
		}
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
			return Integer.parseInt(next());asdfasf
		}
	}
}
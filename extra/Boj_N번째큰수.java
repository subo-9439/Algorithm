import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//백준 2075 
public class Boj_N번째큰수{
	static FastReader scan = new FastReader();
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	static void input(){
		N = scan.nextInt();

		for(int i = 0 ; i < N; i++){
			for(int j = 0; j < N; j++){
				pq.add(scan.nextInt() );
			}
		}
	}
	static void pro(){
		int cnt = 0;
		int ans = 0;
		while(cnt < N){
			ans = pq.poll();
			cnt++;
		}
		System.out.println(ans);

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
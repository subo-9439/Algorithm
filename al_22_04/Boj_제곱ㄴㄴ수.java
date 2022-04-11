package al_22_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1016
// long타입 
// 범위정할때 생각한번더하기
public class Boj_제곱ㄴㄴ수 {

	static FastReader scan = new FastReader();
	static long min,max;
	static int result,sqrt;
	static boolean[] checks;
	static long[] num;

	static void input() {
		min = scan.nextLong();
		max = scan.nextLong();
		//범위만큼 
		result = (int) (max-min + 1);
		sqrt = ((int) Math.sqrt(max));
		checks = new boolean[result];	//제곱ㄴㄴ수체크
		num = new long[result];
	}
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro(){
		//ex 1 , 10
		//sqrt 2~3
		for(long i = 2; i <= sqrt; i++){
			long square = i*i; // 4 9

			//min % 4 ==0? 나누어떨어지면 그자체로 아닐땐 +1
			//시작지점을 정해주기 위해
			long start = min % square == 0 ? min/square : (min / square) + 1;
			// 1~ 10
			for(long j = start; j * square <= max; j++){
				//몫 * (i*i) - min 을 가지는 boolean 배열원소를 true
				checks[(int) ((j * square) - min)] = true;
			}
		}
		//제곱 ㄴㄴ 수 counting
		int count = 0;
		for(int i = 0; i < result; i++) {
			if(!checks[i]) count++;
		}
		System.out.println(count);
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;

		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while(st==null || !st.hasMoreTokens()){
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
		long nextLong(){
			return Long.parseLong(next());
		}
	}
}

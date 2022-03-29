package 날짜별.a220329;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*백준 12015 가장 긴 증가하는 부분 수열2
 이분탐색
*/
public class Boj_가장긴증가하는부분수열 {
	static FastReader scan = new FastReader();
	static int N;
	static int[] A;
	static List<Integer>list;
	static void input(){
		N = scan.nextInt();
		A = new int[N];
		list = new ArrayList<>();
		list.add(0);
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
	}
	static void pro(){
		for(int i = 0; i < N; i++){
			int val = A[i];
			if(val > list.get(list.size()-1)) list.add(val);
			else {
				int left = 0;
				int right = list.size()-1;
				while (left<right) {
					int mid = (left+right) / 2;
					if(list.get(mid) >= val){
						right = mid;
					}else{
						left = mid + 1;
					}
				}
				list.set(right,val);
			}
		}
		System.out.println(list.size()-1);
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
			while (st==null||!st.hasMoreTokens()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt(){
			return  Integer.parseInt(next());
		}
	}
}

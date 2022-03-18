import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main{
	static int N, M;
	static String[] board;
	static FastReader scan = new FastReader();
	static void input(){
		N = scan.nextInt();
		M = scan.nextInt();
		board = new String[N];
	}
	static  int getSolution(int startRow, int startCol, String[] board){
		String[] compare = {"WBWBWBWB","BWBWBWBW"};
		int whiteCnt = 0;
		for(int i = 0; i < 8 ; i++){
			int row = startRow + i;
			for(int j = 0; j < 8; j++){
				int col = startCol + j;
				if (board[row].charAt(col) != compare[row % 2].charAt(j))
					whiteCnt++;
			}
		}
		return Math.min(whiteCnt,64-whiteCnt);
	}
	static int pro(){

		for(int i = 0; i < N; i++) board[i] = scan.nextLine();

		int res = Integer.MAX_VALUE;
		for(int i = 0 ; i <= N-8; i++){
			for(int j = 0; j <= M-8; j++){
				int curRes = getSolution(i, j, board);
				if(res > curRes) res = curRes;
			}
		}
		return res;
	}
	public static void main(String[] args){
		input();
		System.out.println(pro());
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next(){
			while(st==null || !st.hasMoreTokens()){
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			return  st.nextToken();
		}
		String nextLine(){
			String str = "";
			try {
				str = br.readLine();
			}catch (IOException e){
				e.printStackTrace();
			}
			return str;
		}

		int nextInt(){
			return Integer.parseInt(next());
		}
	}
}
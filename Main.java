import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static FastReader scan = new FastReader();
	static char[] str1,str2;
	static Integer[][] dp;
	static void input(){
		str1 = scan.nextLine().toCharArray();
		str2 = scan.nextLine().toCharArray();
		dp = new Integer[str1.length][str2.length];
	}

	static int LCS(int x, int y){
		//인덱스 밖(공집합)일 경우 0 반환
		if(x == -1 || y == -1) {
			return 0;
		}
		// 만약 탐색하지 않은 인덱스라면?
		if(dp[x][y] == null) {
			dp[x][y] = 0;
			// str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
			if(str1[x] == str2[y]) {
				dp[x][y] = LCS(x-1,y-1)+1;
			}
			//같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 값으로 초기화
			else{
				dp[x][y] = Math.max(LCS(x-1,y),LCS(x,y-1));
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) {
		input();
		System.out.println(LCS(str1.length-1,str2.length-1));
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while (st==null || !st.hasMoreTokens()){
				try{
					st=new StringTokenizer(br.readLine());
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		String nextLine(){
			String str = "";
			try{
				str = br.readLine();
			}catch (IOException e){
				e.printStackTrace();
			}
			return str;
		}
	}
}
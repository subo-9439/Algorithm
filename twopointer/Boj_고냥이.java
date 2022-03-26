package twopointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 고냥이 16472 골드4
//투포인터
public class Boj_고냥이 {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N,kind;
	static int[] cnt;
	static String a;
	static void input(){
		N = scan.nextInt();
		a = scan.nextLine();
		cnt = new int[26];
	}
	static void add(char x) {//x라는 알파벳 추가
		cnt[x-'a']++;
		if(cnt[x - 'a'] == 1) //새롭게 나타낸 알파벳
			kind++;
	}
	static void erase(char x) { //x라는 알파벳 제거
		cnt[x-'a']--;
		if(cnt[x-'a'] == 0) //인식해야하는 알파벳에서 빠짐
			kind--;
	}

	static void pro(){
		int len = a.length(), ans =0;
		for(int R = 0, L = 0; R < len; R++){
			//R번째 문자를 오른족에 추가
			add(a.charAt(R));

			//불가능하면 , 가능할 때 까지 L을 이동
			while(kind > N) {
				erase(a.charAt(L++));
			}

			ans = Math.max(ans, R-L+1);
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
		String nextLine(){
			String str="";
			try{
				str = br.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			return str;
		}
	}
}

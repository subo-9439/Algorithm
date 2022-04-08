import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
Boj_스택 10828
 */
public class Main{
	static FastReader scan = new FastReader();
	static int N;
	static void input(){
		N = scan.nextInt();
	}
	static void pro(){
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < N; i++){
			String str = scan.next();
			switch (str){
				case "push":
					stack.add(scan.nextInt());
					break;
				case "pop":
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.pop());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if(stack.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
				case "top":
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.peek());
					break;
			}

		}
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
			while (st == null || !st.hasMoreTokens()){
				try {
					st = new StringTokenizer(br.readLine());
				}catch (IOException e){
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
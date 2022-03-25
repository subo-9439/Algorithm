package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Boj BFS 스페셜 저지 16940 골드 3
public class Boj_BFS스페셜저지 {
  static FastReader scan = new FastReader();
	static int N,idx;
	static ArrayList<Integer>[] list;
	static boolean flag;
	static boolean[] visited;
	static int[] ans;
	static Queue<Integer> queue;
	static void input(){
		N = scan.nextInt();
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		ans = new int[N];
		for(int i = 1; i<=N; i++) list[i] = new ArrayList<>();
		idx = 1;
		flag = true;
		for(int i = 1; i<N; i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		for(int i = 0; i<N; i++) ans[i] = scan.nextInt();
	}
	static void pro(){
		if(ans[0] != 1){
			System.out.println(0);
			return;
		}

		queue = new LinkedList<>();
		queue.add(1);
		bfs();
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	static void bfs(){
		HashSet<Integer> set = new HashSet<>();
		
		while(!queue.isEmpty()){
			int x = queue.poll();
			visited[x] = true;
			set.clear();
			for(int y : list[x]){
				if(visited[y]) continue;
				set.add(y);
				visited[y] = true;
			}

			int size = set.size();
			for(int i = idx; i<idx+size; i++){
				if(set.contains(ans[i])){
					queue.add(ans[i]);
				}else{
					flag = false;
					return;
				}
			}
			idx+=size;
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
			while(st == null || !st.hasMoreElements()){
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

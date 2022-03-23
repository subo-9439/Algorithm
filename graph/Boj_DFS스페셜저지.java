package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
//DFS 스페셜 저지 Boj 16964

public class Boj_DFS스페셜저지{
	static FastReader scan = new FastReader();
	static int N, idx;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean flag;
	static int[] judge;

	static void input(){
		N = scan.nextInt();
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		flag=true;
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		for(int i = 1; i < N ;i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		judge = new int[N];
		for(int i = 0; i<N; i++){
			judge[i] = scan.nextInt();
		}
	}

	static void pro(){
		if(judge[0] != 1) {
			System.out.println(0);
			return;
		}
		idx=1;
		dfs(1);
		if(flag) System.out.println(1);
		else System.out.println(0);
	}

	static void dfs(int x){
		if(visited[x]) return;
		visited[x] = true;
		HashSet<Integer> set = new HashSet<>();

		for(int y : list[x]){
			if(visited[y]) continue;
			set.add(y);
		}

		if(set.size() == 0) return;

		if(set.contains(judge[idx])){
			dfs(judge[idx++]);
		}else{
			flag=false;
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
			while(st ==null || !st.hasMoreTokens()){
				try{
					st= new StringTokenizer(br.readLine());
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
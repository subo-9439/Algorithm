import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Boj_1068 트리
public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input(){
        n = sc.nextInt();
        child = new ArrayList[n];
        leaf = new int[n];
        for(int i=0;i<n;i++) child[i] = new ArrayList<>();
        for(int i=0;i<n;i++){
            int par = sc.nextInt();
            //root 노드 찾기
            if(par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        erased = sc.nextInt();
    }
    static void dfs(int x){
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }
        for (int y: child[x]){
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
    static void pro(){  
        for(int i=0;i<n;i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if (root != erased) dfs(root);
        System.out.println(leaf[root]);
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
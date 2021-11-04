import java.util.ArrayList;

public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input(){
        n = sc.nextInt();
        adj = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        
    }
}
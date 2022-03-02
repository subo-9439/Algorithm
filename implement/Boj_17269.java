package implement;
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.Map;
  import java.util.StringTokenizer;
  
//Boj 17269
//이름 궁합 테스트
public class Boj_17269{

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static char[] nameA;
  static char[] nameB;
  static Map<Character,Integer> map = new HashMap<>();
  static ArrayList<Integer> result = new ArrayList<>();
  static void input(){
    map.put('A',3);    map.put('B',2);    map.put('C',1);    map.put('D',2);    map.put('E',4);    map.put('F',3);    map.put('G',1);    map.put('H',3);    map.put('I',1);    map.put('J',1);    map.put('K',3);    map.put('L',1);    map.put('M',3);    map.put('N',2);    map.put('O',1);    map.put('P',2);    map.put('Q',2);    map.put('R',2);    map.put('S',1);    map.put('T',2);    map.put('U',1);    map.put('V',1);    map.put('W',1);    map.put('X',2);    map.put('Y',2);   map.put('Z',1);
  }
  public static void main(String[] args) {
    input();
    N = scan.nextInt();
    M = scan.nextInt();
    nameA = new char[N];
    nameB = new char[M];
    String name = scan.next();
    nameA = name.toCharArray();
    name = scan.next();
    nameB = name.toCharArray();
    
    char[] names = new char[N+M];
    int x = 0;
    int y = 0;
    int index = 0;
    while(x < N ||y < M){
      if(x < N){
        names[index] = nameA[x];
        index++;
        x++;
      }

      if(y < M){
        names[index] = nameB[y];
        index++;
        y++;
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0 ; i < names.length; i++){
      list.add(map.get(names[i]));
    }
    pro(list);
  }
  static void pro(ArrayList list){
    ArrayList<Integer> result = new ArrayList<>();

    for(int i = 0 ; i < list.size()-1; i++){
      int a = (int)list.get(i) + (int)list.get(i+1);
      if(a >= 10){
        a %= 10;
      }
      result.add(a);
    }

    if(result.size()>2){
      pro(result);
    }else{
      System.out.println(result.get(0)*10 + result.get(1)+"%");
    }

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
    String nextLine(){
      String str = "";
      try{
        str = br.readLine();
      }catch(IOException e){
        e.printStackTrace();
      }
      return str;
    }
    int nextInt(){
      return Integer.parseInt(next());
    }
  }
}
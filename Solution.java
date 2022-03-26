
class Solution {
  static String[][] map;
  static boolean[][] checkmate;
  static char[] count;
  static int[][] dir = {{1,0},{0,1},{1,1}};
  static boolean process = true;
  public static void main(String[] args) {
    int m =4;
    int n =5;
    String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    System.out.println(solution(m,n,board));
  }

  public static int solution(int m, int n, String[] board) {
    int answer = 0;
    int cnt = 0;
    map = new String[m][n];
    checkmate = new boolean[m][n];
    for(int i = 0; i<board.length; i++){
      for(int j = 0; j<board[i].length(); j++){
        map[i][j] = Character.toString(board[i].charAt(j));
      }
    }
    while(process){
      process = false;
      System.out.println(3);
      for(int x = 0; x<m-1; x++){
        for(int y = 0; y<n-1; y++){
//          pro(i,j,m,n);
          String block = map[x][y];
            if(!block.equals("0") && block.equals(map[x+1][y]) && block.equals(map[x+1][y+1]) && block.equals(map[x][y+1])){
              process = true;
              checkmate[x][y] = true;
              checkmate[x+1][y] = true;
              checkmate[x+1][y+1] = true;
              checkmate[x][y+1] = true;
            }
        }
      }
      int c;
      for(int j = 0; j < n; j++){
        c = m-1;
        for(int i = m-1; i >=0; i--){
          if(!checkmate[i][j]){
            String temp = map[i][j];
            map[i][j]= "0";
            map[c][j] = temp;
            c--;
            //위또한 있으면안됨
          }else{
            map[i][j] = "0";
          }
        }
      }
      checkmate = new boolean[m][n];

    }



    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(map[i][j].equals("0"))answer++;
        
      }
      
    }
    return answer;
  }
//  static void pro(int x,int y,int m, int n ){
//
//
//  }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static Queue<Node> queue = new LinkedList<>();
    static ArrayList<Node> list;
    static int[][] dir = {{1,0},{0,1},
    {-1,0},{0,-1},
    {1,1},{-1,-1},
    {1,-1},{-1,1},
    {0,2},{2,0},
    {-2,0},{0,-2}
    };  //12개 2개

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        char[][] map = new char[5][5];
        
        
        //i = 테스트케이스 개수
        for(int t = 0; t < 5; t++){
            //테스트케이스 시작
            list = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    map[i][j] = places[t][i].charAt(j);
                    if(places[t][i].charAt(j) == 'P'){
                        Node n = new Node(i, j);
                        list.add(n);
                        queue.add(n);
                    }
                }
            }
            //조건ㅊ자기
            boolean distance = false;
            System.out.println("test"+t);
            for(int i = 0 ; i<list.size();i++){

                Node pos = list.get(i);
                int x = pos.x;
                int y = pos.y;
                
                for(int j = 0; j <list.size(); j++){
                    if( i== j) continue;
                    Node another = list.get(j);
                    int nx = another.x;
                    int ny = another.y;
                    //2이상이면 거리두기 성공
                    if(Math.abs(nx-x)+Math.abs(ny-y) > 2) continue;
                    //아니면 조건 찾아봐야함
                    else{
                        System.out.println("x,y:"+x+", "+y+"nx,ny:"+nx+", "+ny);
                       //가로 세로 1일때
                       if(nx == x+1 && ny == y) distance = true;
                       else if(nx == x-1 && ny == y) distance =true;
                       else if(nx == x && ny == y-1) distance = true;
                       else if(nx == x && ny == y+1) distance = true;
                       
                       //대각선
                       if(nx == x+1 && ny == y+1) {
                           if(map[x+1][y] =='X' && map[x][y+1]== 'X') distance= false;
                           else   distance = true;
                       }
                       else if(nx == x-1 && ny== y+1) {
                            if(map[x-1][y] =='X' && map[x][y+1]== 'X') distance= false;
                            else   distance = true;
                       }
                       else if(nx == x-1 && ny== y-1) {
                            if(map[x-1][y] =='X' && map[x][y-1]== 'X') distance= false;
                            else   distance = true;
                       }
                       else if(nx == x+1 && ny == y-1) {
                            if(map[x+1][y] =='X' && map[x][y-1]== 'X') distance= false;
                             else   distance = true;
                       }

                       //두개 가로 세로 2
                       if(nx == x+2 && ny == y) {
                           if(map[x+1][y] == 'X') distance = false;
                           else distance =true;
                       }
                       else if(nx == x-2 && ny == y) {
                            if(map[x-1][y] == 'X') distance = false;
                            else distance =true;
                       }
                       else if(ny == x && ny == y-2) {
                            if(map[x][y-1] == 'X') distance = false;
                            else distance =true;
                       }
                       else if(nx == x && ny == y+2) {
                            if(map[x][y+1] == 'X') distance = false;
                            else distance =true;
                       }


                    }
                    if(distance) break;
                }
                if(distance) break;

            }
            if(distance) answer[t] = 0;
            else answer[t] = 1;
        }
        return answer;
    }

    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
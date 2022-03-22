import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int rowLen = 0;
    static int colLen = 0;
    static boolean[][] visited;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        rowLen = board.length;
        colLen = board[0].length;
        visited = new boolean[rowLen][colLen];
        //int[][] skill 1, 0 0 , 3 4 , 4 개씩
        Queue<Skill> list = new LinkedList<>();
        for(int i = 0; i < skill.length; i++){//250000
            list.add(new Skill(skill[i][0],skill[i][1],skill[i][2],skill[i][3],skill[i][4],skill[i][5]));
        }
        
        // // System.out.println("보드 바뀌고 난후");
        for(int i = 0 ; i < visited.length; i++){//100 0000
            for(int j = 0; j < visited[i].length; j++){
                visited[i][j] = false; 
            }
        // System.out.println();
        }

        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j <colLen; j++){
                if(board[i][j] >=1) answer++;
                // System.out.print(board[i][j]);
            }

        }
        return answer;

        
    }
    void pro(int type, int startX, int startY, int endX, int endY, int degree,int[][] board){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        if(type == 1){
            visited[startX][startY] = true;
            board[startX][startY] -= degree;
        }else{
            visited[startX][startY] = true;
            board[startX][startY] += degree;
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx >endX || ny >endY || nx <startX || ny < startY) continue;
                // if(visited[nx][ny]) continue;
                if(type == 1){
                    visited[nx][ny] = true;
                    board[nx][ny] -= degree;
                }else{
                    visited[nx][ny] = true;
                    board[nx][ny] += degree;
                }
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    class Skill{
        int type;
        int r1;
        int c1;
        int r2;
        int c2;
        public Skill(int type, int r1, int c1, int r2, int c2,int degree){
            this.type = type;
            this.r1 = r1;
            this.r2 = r2;
            this.c1 = c1;
            this.c2 = c2;
        }
    }
}
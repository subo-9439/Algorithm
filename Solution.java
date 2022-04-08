class Solution {
    static int answer = -1;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n,m;
    public static boolean OOB(int x, int y){
        return x<0 || x>=n || y<0 || y>=m;
    }
    //방문 여부(0일 경우 해당 칸이 아직 남아있음을 의미)
    static boolean[][] visited = new boolean[5][5];
    static int[][] block = new int[5][5];

    //현재 상태에서 둘 다 최적의 플레이를 할 때 남은 이동 횟수
    //반환값이 짝수 : 플레이어가 패배함을 의미
    // 홀수 : 플레이어가 승리함을 의미
    // curx, cury : 현재 플레이어의 좌표, opx, opy: 상대플레이어의 좌표
    public static int solve(int curx, int cury, int opx, int opy){
        //플레이어가 밟고 있는 발판이 사라졌다면
        if(visited[curx][cury]) return 0;
        int ret = 0;
        //플레이어를 네방향으로 이동시켜 다음단계로 진행할 예정
        for(int dir = 0; dir < 4; dir++){
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];
            if(OOB(nx,ny) || visited[nx][ny] || block[nx][ny] == 0)
                continue;
            //플레이어가 있던 곳에 방문포시를함
            visited[curx][cury] = true;

            //플레이어를 dir방향으로 이동시켰을 때 턴의 수 다음 함수를 호출할 때
            //opx,opy,nx,ny 순으로 호출해야함
            int val = solve(opx,opy,nx,ny)+1;

            //방문 표시 해제
            visited[curx][cury] = false;
            //1. 현재 저장된 턴은 패배인데 새로 계산된 턴은 승리인 경우우
            if(ret % 2 == 0&& val % 2 == 1)ret = val;
            else if(ret % 2 == 0 && val % 2 == 0)
                ret = Math.max(ret,val); //최대한 늦게 지는걸 선택
            else if(ret % 2 == 1 && val % 2 == 1)
                ret = Math.min(ret,val); //최대한 빨리 이기는걸 선택
        }
        return ret;
    }
    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        for(int i = 0; i < n ; i++)
            for(int j = 0; j < m; j++)
                block[i][j] = board[i][j];

        return solve(aloc[0],aloc[1], bloc[0],bloc[1]);
    }

    public static void main(String[] args) {
        solution(new int[][]{{1,1,1},{1,1,1},{1,1,1}}, new int[]{1, 0}, new int[]{1, 2});
    }
}
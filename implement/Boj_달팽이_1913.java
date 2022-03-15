package implement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Boj_달팽이_1913 {
  // 달팽이
  // 구현
	static int startValue = 1;
	static int[] moveX = {1, 0, -1, 0};	// 우하좌상
	static int[] moveY = {0, 1, 0, -1};
	static int kX, kY;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int k = Integer.valueOf(br.readLine());
  //		int[][] result = getSnail(0, 0, 1, n, k);
		int[][] result = getSnail(n, k);
		
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				int ele = result[y][x];
				sb.append(ele).append(" ");
				
				if(ele == k) {
					kX = x;
					kY = y;
				}
			}
			
			sb.append("\n");
		}
		
		// (1, 1) 부터 시작하기 때문에
		System.out.print(sb.toString());
		System.out.println((kY + 1) + " " + (kX + 1));
	}
	
	static int[][] getSnail(int len, int k) {
		int[][] arr = new int[len][len];
		int x = len / 2;
		int y =  len / 2;
		arr[y][x] = startValue++;
		int endX = 0;
		int endY = 0;
		int drawCount = 1;
		
		while(true) {
			// 상
			for(int i = 0; i < drawCount; i++) {
				arr[--y][x] = startValue++;
				if(y == endY && x == endX) {
					return arr;
				}
			}
			
			// 우
			for(int i = 0; i < drawCount; i++) {
				arr[y][++x] = startValue++;
			}
			
			drawCount++;
			
			// 하
			for(int i = 0; i < drawCount; i++) {
				arr[++y][x] = startValue++;
			}
			
			// 좌
			for(int i = 0; i < drawCount; i++) {
				arr[y][--x] = startValue++;
			}
			
			drawCount++;
		}
	}
}

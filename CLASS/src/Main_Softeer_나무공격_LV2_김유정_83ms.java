import java.io.*;
import java.util.*;

public class Main_Softeer_나무공격_LV2_김유정_83ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int L;
	private static int R;
	private static int[][] map;
	private static int m;
	private static boolean[] isDead;
	private static int cnt = 0;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cnt++;
			}
		}
		
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken()) - 1;
			R = Integer.parseInt(st.nextToken()) - 1;
			
			isDead = new boolean[n];
			attack(L, R);
		}
		
		System.out.println(cnt);
		
	} // end of main


	private static void attack(int start, int end) {
		int c = -1;
		while(++c <= m-1) {
			for(int r = start; r <= end; r++) {
				if(map[r][c] == 1 && !isDead[r]) {
					map[r][c] = 0;
					cnt--;
					isDead[r] = true;
				}
			}
		}
	}
	
	
} // end of class

import java.io.*;
import java.util.*;

public class Test3_서울_11_김유정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb  = new StringBuilder();
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 영토의 세로 길이
			M = Integer.parseInt(st.nextToken()); // 영토의 가로 길이
			
			isVisited = new boolean[N][M]; // 방문 체크, true면 하늘색 구획, false면 주황색 구획
			map = new int[N][M]; // 영토를 저장하기 위한 배열
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 영토 입력 받기
				}
			}

			powerset();
			
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void powerset() {
		
		
		
	}

	private static void BFS(int i, int j) {
	
	}
} // end of class

package 월말평가3회차;

import java.io.*;
import java.util.*;

public class Solution_월말평가3_영토분할하기_김유정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M, blue, orange, minDiff;
	static int[][] map;
	static boolean[][] divideArea;
	
	static boolean[] isSelected; // 좌표의 부분집합을 나눌 때 사용하는 1차원 배열
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			String str = br.readLine();
			N = str.charAt(0) - '0'; // 2 ≤ N ≤ 5
			M = str.charAt(2) - '0'; // 1 ≤ M ≤ 4
			
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minDiff = Integer.MAX_VALUE;
			isSelected = new boolean[N*M+1];
			powerset(0); // 부분집합으로 영토를 분할하자
			
			sb.append("#" + testCase + " " + minDiff + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void powerset(int idx) {
		if(idx >= N*M) {
			divideArea = new boolean[N][M];
			blue = -1;
			orange = -1;
			
			int blueSum = 0;
			int orangeSum = 0;
			
			for(int i = 0; i < N*M; i++) {
				if(isSelected[i]) {
					divideArea[i/M][i%M] = true;
					blueSum += map[i/M][i%M];
					if(blue == -1) blue = i; // blue 영토 좌표 아무 곳이나 한 군데 저장
				} else {
					orangeSum += map[i/M][i%M];
					if(orange == -1) orange = i;
				}
			}
			
			if(blue != -1 && orange != -1 && BFS(blue, orange)) {
				minDiff = Math.min(minDiff, Math.abs(orangeSum-blueSum));
			}
			
			return;
		}
		
		isSelected[idx] = true;
		powerset(idx+1);
		isSelected[idx] = false;
		powerset(idx+1);
	}

	private static boolean BFS(int b, int o) { // true가 blue, false가 orange
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(b);
		queue.add(o);
		
		boolean[][] isVisited = new boolean[N][M];
		isVisited[b/M][b%M] = true;
		isVisited[o/M][o%M] = true;
		
		int notVisited = N*M-2;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			int r = curr/M;
			int c = curr%M;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc] && divideArea[nr][nc] == divideArea[r][c]) {
					isVisited[nr][nc] = true;
					queue.add(nr*M + nc%M);
					notVisited--;
				}
			}
		}
		
		if(notVisited <= 0) return true;
		else return false;
		
	}
	
} // end of class

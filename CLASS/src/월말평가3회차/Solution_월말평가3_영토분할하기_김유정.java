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
			blue = 0;
			orange = N*M;
			
			int blueSum = 0;
			int orangeSum = 0;
			
			for(int i = 0; i < N*M; i++) {
				if(isSelected[i]) {
					divideArea[i/M][i%M] = true;
					blueSum += map[i/M][i%M];
					blue++;
					orange--;
				} else {
					orangeSum += map[i/M][i%M];
				}
			}
			
			if(BFS()) {
				minDiff = Math.min(minDiff, Math.abs(orangeSum-blueSum));
			}
			
			return;
		}
		
		isSelected[idx] = true;
		powerset(idx+1);
		isSelected[idx] = false;
		powerset(idx+1);
	}

	private static boolean BFS() { // true가 blue, false가 orange
		Queue<Integer> queue = new LinkedList<>();
		
		boolean flag;
		int leftPoint;
		
		queue.add(0);
		if(divideArea[0][0]) { // true라면, 즉 blue라면
			flag = true;
			divideArea[0][0] = !flag;
			leftPoint = blue - 1;
		} else { // false라면, 즉 orange라면
			flag = false;
			divideArea[0][0] = !flag;
			leftPoint = orange - 1;
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr/M + dir[d][0];
				int nc = curr%M + dir[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && divideArea[nr][nc] == flag) {
					divideArea[nr][nc] = !flag;
					queue.add(nr*M + nc%M);
					leftPoint--;
				}
			}
		}
		
		if(leftPoint <= 0) return true;
		else return false;
		
	}
	
} // end of class

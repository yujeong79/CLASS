package 월말평가3회차;

import java.io.*;
import java.util.*;

public class Solution_월말평가2_고양이의얼룩무늬_김유정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int N, M;
	static char[][] pattern;
	static boolean[][] isVisited;
	static int whiteArea, blackArea, orangeArea;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 무늬의 높이
			M = Integer.parseInt(st.nextToken()); // 무늬의 너비
			
			pattern = new char[N][M]; // 고양이의 얼룩 무늬를 저장할 2차원 배열
			isVisited = new boolean[N][M]; // 방문 체크
			
			for(int i = 0; i < N; i++) {
				pattern[i] = br.readLine().toCharArray(); // 고양이 무늬 입력 받기
			}
			
			whiteArea = blackArea = orangeArea = 0; // 색깔별 영역의 수 0으로 초기화
			
			for(int i = 0; i < N; i++) { // 모든 행과
				for(int j = 0; j < M; j++) { // 열을 순회하면서
					if(!isVisited[i][j]) { // 아직 방문하지 않았으면, 즉 영역에 포함되지 않았으면
						BFS(i, j); // BFS
						switch(pattern[i][j]) { // 해당 영역의 색이 
						case 'W': // white이었으면
							whiteArea++; // white 영역 1 증가
							break;
						case 'B': // black이었으면
							blackArea++; // black 영역 1 증가
							break;
						case 'O': // orange이었으면
							orangeArea++; // orange 영역 1 증가
							break; 
						}
					}
				}
			}
			sb.append("#" + testCase + " " + blackArea + " " + orangeArea + " " + whiteArea + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>(); // 방문한 지점을 담을 queue
		
		queue.add(new int[] {i, j}); // 탐색을 시작하는 첫번째 지점을 queue에 담기
		isVisited[i][j] = true; // 해당 지점 방문 체크
		char color = pattern[i][j]; // 해당 지점의 색 저장
		
		while(!queue.isEmpty()) { // 큐가 빌 때까지 반복
			int[] curr = queue.poll(); // 큐에서 하나씩 뽑아서
			 
			for(int d = 0; d < 4; d++) { // 인접 지점 탐색
				int r = curr[0] + dir[d][0];
				int c = curr[1] + dir[d][1];
				
				if(r >= 0 && r < N && c >= 0 && c < M && !isVisited[r][c] && pattern[r][c] == color) { // 인접 지점이 범위 내에 있고 방문하지 않았으며, 색이 같다면 이동 가능
					queue.add(new int[] {r, c}); // 큐에 담기
					isVisited[r][c] = true; // 방문 체크
				}
			}
		}
	}
	
} // end of class

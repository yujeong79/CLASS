import java.io.*;
import java.util.*;

/**
 * 최대한 많은 코어에 전원 연결하기, 전선의 최소 길이 출력
 * 가장자리에 놓여있는 코어는 고려 대상에서 제외
 * 각 코어를 상하좌우로 연결 가능하면 연결해보기 => 맵에 표시를 남기고, 이후에 제거
 */

public class Solution_SWEA_1767_프로세서연결하기_강사님 {
	// 좌표를 저장할 클래스
	private static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static List<Point> coreList = new ArrayList<>(); // 전원이 연결되지 않은 코어(가장자리가 아닌 코어)의 위치 저장
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int totalCore;
	private static int maxCoreCnt;
	private static int minWireLength;
	
	private static int[][] map;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			totalCore = 0;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0, index = 0; j < N; j++, index += 2) {
					map[i][j] = s.charAt(index);
					// 코어가 있는 위치를 한 번에 관리해보자잇~!
					if(map[i][j] == '1') {
						if(i == 0 || i == N-1 || j == 0 || j == N-1) { // 가장자리가 아닌 경우에만 저장, 왜냐!! 가장자리는 전원을 연결할 필요가 없으니까ㅋ							
							totalCore++; // 가장자리에 있는 코어는 따로 그 수를 세어주기
						} else {
							coreList.add(new Point(i, j));							
						}
					}
				}
			}
			
			totalCore += coreList.size();
			maxCoreCnt = 0;
			minWireLength = Integer.MAX_VALUE;
			DFS(0, totalCore - coreList.size(), 0, 0);
			
			sb.append("#" + testCase + " " + minWireLength + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void DFS(int index, int connected, int wireLength, int unConnected) {
		if(index == coreList.size()) {
			if(maxCoreCnt < connected) {
				maxCoreCnt = connected;
				minWireLength = wireLength;
			} else if(maxCoreCnt == connected) {
				minWireLength = Math.min(wireLength, minWireLength);
			}
			return;
		}
		
		Point core = coreList.get(index);
		DFS(index+1, connected, wireLength, unConnected + 1); // 연결 안하는 경우
		for(int d = 0; d < 4; d++) {
			if(check(core.r, core.c, d)) { // 해당 방향으로 연결이 가능한지 체크
				int cnt = install(core.r , core.c, d, '-');
				DFS(index+1, connected+1, wireLength+cnt, unConnected);
				install(core.r, core.c, d, '0');
			}
		}
	}

	private static boolean check(int r, int c, int d) {
		for(int i = 1; ; i++) {
			int nr = r + dr[d] * i;
			int nc = c + dc[d] * i;
			if(0 > nr || nr >= N || 0 > nc || nc >= N) {
				return true;
			}
			
			if(map[nr][nc] != '0') {
				return false;
			}
		}
	}

	private static int install(int r, int c, int d, char e) {
		int cnt = 0;
		for(int i = 1; ; i++) {
			int nr = r + dr[d] * i;
			int nc = c + dc[d] * i;
			
			if(0 > nr || nr >= N || 0 > nc || nc >= N) {
				return cnt;
			}
			
			map[nr][nc] = e;
			cnt++;
			
		}
	}
	
} // end of class

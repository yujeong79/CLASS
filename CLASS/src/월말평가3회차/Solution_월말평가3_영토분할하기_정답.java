package 월말평가3회차;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_월말평가3_영토분할하기_정답 {

	static int N, M, answer;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] board;
	static boolean[][] selected;
	static boolean[][] visit;
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	
	    int T = sc.nextInt();
	
	    for (int tc = 1; tc <= T; tc++) {
	        N = sc.nextInt();
	        M = sc.nextInt();
	        board = new int[N][M];
	
	        for (int r = 0; r < N; r++) {
	            for (int c = 0; c < M; c++) {
	                board[r][c] = sc.nextInt();
	            }
	        }
	
	        selected = new boolean[N][M];
	
	        answer = Integer.MAX_VALUE;
	
	        choose(0, 0, 0, 0);
	
	        System.out.println("#" + tc + " " + answer);
	
	    }
	}

	static void dfs(int r, int c) {
		
	
	    for (int d = 0; d < 4; d++) {
	        int nr = r + dr[d];
	        int nc = c + dc[d];
	        if (0 <= nr && nr < N && 0 <= nc && nc < M && !visit[nr][nc] && selected[r][c] == selected[nr][nc]) {
	            visit[nr][nc] = true;
	            dfs(nr, nc);
	        }
	    }
	}

	static boolean check() {
	    visit = new boolean[N][M];
	
	    int cnt = 0;
	
	    for (int r = 0; r < N; r++) {
	        for (int c = 0; c < M; c++) {
	            if (visit[r][c])
	                continue;
	            if (cnt == 2) // 구역이 3개 이상으로 나뉘어져 있으면 false
	                return false;
	
	            visit[r][c] = true; // (0, 0)을 true라고 두고 dfs를 돌게 되면 (0,0)과 같은 팀이 다 true로 바뀌게 됨
	            dfs(r, c);
	            cnt++; 
	
	        }
	    }
	
	    return true;
	}

	static void choose(int r, int c, int A, int B) {
	    if (c == M) {
	        c = 0;
	        ++r;
	    }
	
	    if (r == N) {
	        if (check()) {
	            answer = Math.min(answer, Math.abs(A - B));
	        }
	        return;
	    }
	
	    selected[r][c] = true;
	    choose(r, c + 1, board[r][c] + A, B);
	
	    selected[r][c] = false;
	    choose(r, c + 1, A, board[r][c] + B);
	
	}
}

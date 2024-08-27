import java.io.*;
import java.util.*;

public class 월말평가2회차_문제3_그물펼치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 어장의 한 변의 길이
			int M = Integer.parseInt(st.nextToken()); // 그물의 한 변의 길이
			
			int[][] fish = new int[N+1][N+1]; // 누적합을 구하기 쉽도록 맨 첫 행과 맨 첫 열을 0으로 만들기
			for(int i = 1; i <= N; i++) { 
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) {
					fish[i][j] = Integer.parseInt(st.nextToken()); // (1,1)부터 (N,N)까지 채우기
				}
			}
			
			//System.out.println(Arrays.deepToString(fish)); // 최초 입력 받은 어항
			
			// 누적합 구하기
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					fish[i][j] = fish[i-1][j] + fish[i][j-1] - fish[i-1][j-1] + fish[i][j];
				}
			}
			
			//System.out.println(Arrays.deepToString(fish)); // 누적합 어항
			
			int max = 0;
			
			// M*M만큼의 어획량 구하기
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					int cnt = 0;
					int r = i; int c = j; // 현재 위치
					int sr = i-M; int sc = j-M; // M*M만큼의 어획량을 구하기 위해서 빼줘야할 블록의 행과 열
					
					if(sr >= 1 && sc >= 1) {
						cnt = fish[r][c] - fish[sr][c] - fish[r][sc] + fish[sr][sc]; 
					} else if(sc >= 1 && sr <= 0) {
						cnt = fish[r][c] - fish[r][sc];
					} else if(sc <= 0 && sr >= 1) {
						cnt = fish[r][c] - fish[sr][c];
					} else cnt = fish[r][c];
					
					max = Math.max(max, cnt); // 어획량 업데이트
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class

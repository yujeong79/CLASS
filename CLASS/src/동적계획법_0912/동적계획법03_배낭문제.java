package 동적계획법_0912;

import java.util.Scanner;

public class 동적계획법03_배낭문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] cost = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][N+1]; // i번째 물건까지 고려
		
		// 물건은 한 개씩만 존재
		for(int i = 1; i <= N; i++) {
			for(int w = 0; w <= W; w++) { // w는 임시무게, 0 ~ W까지의 무게의 부분 문제로 고려
				if(weights[i] <= w) { // 
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]); // 위에서 가져온 값과 
					
				} else { // 아니라면 이전까지 고민한게 베스트
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		System.out.println(dp[N][W]);
		
	} // end of class
}

package 동적계획법_0912;

import java.util.Scanner;

public class 동적계획법02_동전거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt(); // 해당 거스름돈의 최소 동전개수를 구해보자
		int[] dp = new int[money+1];
		
		// 동전의 종류 : 1원, 4원, 6원
		
		for(int i = 1; i <= money; i++) {
			int minCnt = Integer.MAX_VALUE;
			
			minCnt = Math.min(dp[i-1]+1, minCnt); // 이전 돈의 거스름돈에서 1원을 더 추가하는 것과 minCnt를 고려
			
			if(i >= 4) minCnt = Math.min(minCnt, dp[i-4]+1); // 4원 하나를 더 추가하는 것을 고려
			if(i >= 6) minCnt = Math.min(minCnt, dp[i-6]+1); // 6원 하나를 더 추가하는 것을 고려
			dp[i] = minCnt;
		}
		
		System.out.println(dp[money]);
		
	} // end of main
} // end of class

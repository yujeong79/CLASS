package 동적계획법_0912;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법01_피보나치 {
	static int[] callFibo = new int[100]; // fibo1(n)이 몇 번 호출되는지 알아보자
	static int[] memo; // 계산 값을 저장하기 위한 공간을 할당
	
	static {
		memo = new int[1000]; // 일단 크게 만들어놓고
		memo[0] = 0; // 최초의 값 두 개는 미리 설정
		memo[1] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo1(N));
		//System.out.println(Arrays.toString(callFibo));
		
		System.out.println(fibo2(N));
		
		System.out.println(fibo3(N));
	}
	
	/** 동적 계획법 */
	public static int fibo3(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		return dp[n];
	}
	
	/** Memoization */
	public static int fibo2(int n) {
		if(n >= 2 && memo[n] == 0)
			memo[n] = fibo2(n-1) + fibo2(n-2);
		return memo[n];
	}
	
	/** 재귀 함수 */
	public static int fibo1(int n) {
		callFibo[n]++; // fibo1(n)에 대한 무수히 많은 중복 호출이 발생한다.
		
		// 기저 조건 
		// n == 0 : 0 반환, n == 1 : 1 반환 => 최초의 두 개의 값은 미리 알고 있어야 하니까
		if(n <= 1) return n;
		
		return fibo1(n-1) + fibo1(n-2);
	}
}

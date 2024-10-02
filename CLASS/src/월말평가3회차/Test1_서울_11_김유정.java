package 월말평가3회차;

import java.io.*;
import java.util.*;

public class Test1_서울_11_김유정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] stairs = {1, 3, 4};
	static int H;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			H = Integer.parseInt(br.readLine());
			
			long[] dp = new long[H+1];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 2;
			
			for(int i = 4; i <= H; i++) {
				dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
			}
			
			sb.append("#" + testCase + " " + dp[H] + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class

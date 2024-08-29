import java.io.*;
import java.util.*;

public class Solution_SWEA_10726_이진수표현_D3_강사님 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= TC) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 30
			int M = Integer.parseInt(st.nextToken()); // 0 ≤ M ≤ 10^8
			
			/**
			 * 비트 마스킹
			 * 
			 * 2진수로 표현한 수 M이 있을 때, 뒤에서부터 N만큼 1로 채워져있는지 확인하고 싶으면
			 * N만큼 1로 채워진 2진수와 & 연산을 해주면 된다.
			 * 
			 * 만약 N = 3이라고 하면 111로 채워진 2진수를 구하고 싶으면
			 * 1000 - 1 를 하면 된다.
			 * 2진수 2000은 2^3 이니까
			 * 2^3 - 1을 하면 된다.
			 * 
			 * 1<<N 즉, 1<<3 이라면 1을 3번 왼쪽으로 이동해주는 것이므로
			 * 1000이 된다.
			 */
			
			int mask = (1<<N) - 1; // 마지막 N개 비트가 1로 채워진 2진수, mask = 2^3 - 1 
			String result = (M & mask) == mask ? " ON\n" : " OFF\n";
			
			sb.append("#").append(testCase).append(result);
		
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class

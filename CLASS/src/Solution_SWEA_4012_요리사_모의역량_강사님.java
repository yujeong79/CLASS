import java.io.*;
import java.util.*;

public class Solution_SWEA_4012_요리사_모의역량_강사님 {
	private static int N;
	private static int[][] S;
	
	private static boolean[] isSelected;
	private static int minDiff;
	private static int halfN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			halfN = N/2;
			
			S = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			isSelected = new boolean[N]; // 부분 집합으로 선택한 음식 재료 체크
			minDiff = Integer.MAX_VALUE; // 두 음식 차이의 최솟값
			
			subset(0, 0, 0); // 부분 집합으로 N/2개를 원소로 하는 부분 집합을 구하자
			
			sb.append("#").append(testCase).append(" ").append(minDiff).append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	/**
	 * N/2개 원소를 선택하는 부분 집합을 구하는 메서드
	 * @param cnt : 현재 단계
	 * @param selCnt : 선택한 재료의 개수
	 * @param unselCnt : 선택되지 않은 재료의 개수
	 */
	static void subset(int step, int selCnt, int unselCnt) {
		if(selCnt > halfN || unselCnt > halfN) return; // A or B 음식 재료가 N/2개를 초과한 경우 
		
		if(step == N) {
			check(); // A 음식 재료의 맛의 시너지 합, B 음식의 재료의 맛의 시너지 합의 차를 구해서 minDiff에 업데이트
			return;
		}
		
		isSelected[step] = true; // cnt번째 원소를 A 음식으로 선택한 경우
		subset(step+1, selCnt+1, unselCnt);
		isSelected[step] = false; // cnt번째 원소를 A 음식으로 선택 안한 경우 => B 음식 재료
		subset(step+1, selCnt, unselCnt+1);
	}
	
	// A 음식 재료의 맛의 시너지 합, B 음식의 재료의 맛의 시너지 합의 차를 구해서 minDiff에 업데이트
	static void check() {
		int diff = 0; // 두 음식의 차이를 저장
		int A = 0;
		int B = 0;
		
		for (int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(isSelected[i] && isSelected[j]) // 둘 다 A 음식 재료
					A += S[i][j] + S[j][i];
				else if(!isSelected[i] && !isSelected[j]) // 둘 다 B 음식 재료
					B += S[i][j] + S[j][i];
			}
		}
		diff = Math.abs(A-B);
		minDiff = Math.min(minDiff, diff);
	}
	
} // end of class

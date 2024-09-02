package 과목평가5회차.src.과목평가5회차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_11반_김유정 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
	private static StringBuilder sb = new StringBuilder(); // 각 테스트케이스의 출력을 한 번에 모아서 출력하기 위한 StringBuilder
	
	private static int N; // 마라톤에 출전한 N명의 선수
	private static int M; // 선물을 받는 M명의 선수
	private static int K; // M명의 등번호의 합
	
	private static int[] nums; // N명의 선수의 등번호
	private static int[] result; // N명의 선수 중 M명의 선수의 조합을 임시로 저장하기 위한 배열
	private static boolean[] isSelected; // 각각의 선수가 조합에 들어갔는지 확인하기 위한 배열
	 
	private static int answer; // 등번호의 합이 K가 되는 M명의 선수 조합의 경우의 수를 저장하기 위한 변수
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 전체 테스트케이스의 수
		int testCase = 0; // 각 테스트케이스
		while(++testCase <= T) { // 각 테스트케이스가 전체 테스트케이스 수만큼 진행됐으면 종료
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // N, M, K를 한 번에 받기 위한 StringTokenizer, 공백을 기준으로 나눔
			N = Integer.parseInt(st.nextToken()); // 마라톤에 출전한 N명의 선수
			M = Integer.parseInt(st.nextToken()); // 선물을 받는 M명의 선수
			K = Integer.parseInt(st.nextToken()); // M명의 등번호의 합
			
			nums = new int[N]; // 마라톤의 출전한 선수들의 등번호를 저장하기 위한 배열의 크기를 N으로 할당
			st = new StringTokenizer(br.readLine(), " "); // 선수들의 등번호를 한 번에 받기 위한 StringTokenizer
			for(int i = 0; i < N; i++) { // 선수들의 수 만큼 순회를 돌며
				nums[i] = Integer.parseInt(st.nextToken()); // 배열에 선수들의 등번호를 저장
			} 
			
			answer = 0; // 0으로 초기화
			isSelected = new boolean[N]; // 선수가 조합에 들어갔는지 확인하기 위한 배열도 N 크기로 초기화
			result = new int[M]; // 조합을 임시로 저장하기 위한 배열도 조합의 크기인 M으로 초기화
			perm(0); // 순열
			
			answer = answer == 0 ? -1 : answer; // 등번호의 합 K에 해당하는 어떠한 경우의 수도 없다면 answer에 -1 저장
			sb.append("#" + testCase + " " + answer + "\n"); // 각 테스트케이스의 출력값 저장
		} // end of testCase
		System.out.println(sb); // 모든 테스트케이스의 출력값 출력
	} // end of main

	/**
	 * N명의 선수 중 M명의 선수 조합 뽑기
	 * 같은 선수로 구성된 조합이어도 순위에 따라 다른 경우의 수로 판단되기 때문에 순열로 동작
	 * @param cnt : 뽑힌 선수의 수
	 */
	private static void perm(int cnt) { 
		if(cnt == M) { // M명의 선수들이 뽑혔으면
			int sum = 0; // 뽑힌 M명의 선수들의 등번호의 합을 저장하기 위한 변수
			for(int n : result) sum += n; // M명의 선수들의 등번호를 sum에 누적
			if(sum == K) answer++; // sum이 K와 같으면 answer를 1 증가
			return; // 종료
		}
		
		for(int i = 0; i < N; i++) { // N명의 선수들을 순회하며
			if(!isSelected[i]) { // i번째 선수가 선택되지 않았으면
				isSelected[i] = true; // 선택하고
				result[cnt] = nums[i]; // M명의 선수들 조합에 넣어주기
				perm(cnt+1); // 다음 선수 뽑기
				isSelected[i] = false; // 다시 다른 조합을 뽑기 위해서 해당 선수를 다시 false로 바꿔주기
			}
		}
	}
} // end of class


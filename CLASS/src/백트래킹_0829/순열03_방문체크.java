package 백트래킹_0829;

import java.util.Arrays;

public class 순열03_방문체크 {
	static int[] nums;
	static int N;
	
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
		
	} // end of main
	
	static void perm(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(result));
		}
		
		for(int i = 0; i < N; i++) {
			// 사용하지 않은 원소를 가지고 만들어야해!
			// 1. 사용했으면 넘어가
			if(visited[i]) continue;
			// 2. 사용하지 않았다면 
			result[cnt] = nums[i];
			visited[i] = true; // 해당 i번째 원소는 사용했습니다.
			perm(cnt+1); // 다음 자리 판단
			visited[i] = false; // result는 덮어버리니까 굳이 초기화 할 필요는 없음.
		}
	}
}

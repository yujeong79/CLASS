package 백트래킹_0829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열04_비트마스킹 {
	static int[] nums;
	static int N;
	
	// 기존의 boolean으로 사용했던 방문 체크 배열을 비트마스킹으로 대체할 수 있다.
	static int[] result;
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		result = new int[N];
		perm(0, 0);
		
		// 한 번에 보고 싶다고 이렇게 하자나? 그러면 잘 출력 안됨
		for(int[] arr : list) {
			System.out.println();
		}
		
	} // end of main
	
	// visited : 사용한 원소를 기록하기 위한 정수
	static void perm(int cnt, int visited) {
		// 기저조건
//		if(visited == (1<<N)-1) return;
		
		if(cnt == N) {
			System.out.println(Arrays.toString(result));
			list.add(result); // 여기서 얕은 복사했기 때문에 제대로 복사가 안됨 => 깊은 복사하기!!
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((visited & (1<<i)) != 0) continue; // 1이면, 즉 사용했으면 continue
			
			result[cnt] = nums[i];
			perm(cnt+1, visited | (1<<i)); // i번째 요소를 사용했다는 의미
		}
	}
}

package 백트래킹_0829;

import java.util.Arrays;

/*
 * 단, swap 방식은 사전순으로 순열이 되지 않는다.
 */

public class 순열01_반복문 {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		
		perm(0);
	}
	
	// idx : 현재 판단 위치
	static void perm(int idx) {
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx); // 다음 과정을 위해서 원상 복구
		}
	}
	
	// 바꾸고 싶은 배열이 static으로 선언했으니 위치 2개만 인자로 보내자
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}

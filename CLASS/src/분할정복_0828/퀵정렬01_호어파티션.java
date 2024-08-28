package 분할정복_0828;

import java.util.Arrays;

public class 퀵정렬01_호어파티션 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length; // 배열의 길이
	
	public static void main(String[] args) {
		quickSort(0, N-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	// 반환값은 피봇의 위치
	static int partition(int left, int right) {
		int pivot = arr[left]; // 맨 처음에는 arr의 첫번째 요소를 기준으로 정렬
		
		int L = left + 1, R = right; // 그리고 왼쪽 시작점은 피벗의 다음, 오른쪽은 right 지점 
		
		while(L <= R) {
			// L : pivot 보다 큰 값을 찾을 때까지 이동을 하겠다.
			while(L <= R && arr[L] <= pivot) L++;
			// R : pivot 보다 작거나 같은 값을 만날 때까지 이동을 하겠다.
			while(arr[R] > pivot) R--;
			
			if(L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// R의 위치는 사실 피봇이 가야할 위치이다.
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R; // 피봇의 위치
	}
}

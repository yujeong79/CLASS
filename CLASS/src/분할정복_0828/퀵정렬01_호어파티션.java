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
			int pivot = partition(left, right); // 파티션을 하고 다시 새로 기준이 된 피봇을 기준으로
			quickSort(left, pivot-1); // 왼쪽을 다시 퀵정렬
			quickSort(pivot+1, right); // 오른쪽을 다시 퀵정렬
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
			
			// 다 찾았어, 왼쪽 구간에서 pivot보다 큰 값과 오른쪽 구간에서 pivot보다 작은 값을 다 찾았어
			
			// 그러면 그 둘의 값을 서로 바꿔
			if(L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// L과 R이 역전되면 R을 기준으로 왼쪽은 다 pivot보다 작은 상태, 오른쪽은 다 pivot보다 큰 상태가 된다.
		
		// 그러면 이제 R의 위치는 사실 피봇이 가야할 위치이다.
		int tmp = arr[left]; // pivot을 임시변수에 저장
		arr[left] = arr[R]; // 오른쪽 구간에서 작았던 값을 저장
		arr[R] = tmp;
		
		return R; // 피봇의 위치
	}
}

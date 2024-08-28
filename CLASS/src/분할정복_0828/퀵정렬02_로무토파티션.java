package 분할정복_0828;

import java.util.Arrays;

public class 퀵정렬02_로무토파티션 {
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
		int pivot = arr[right]; // 배열의 맨 마지막 요소가 pivot
		int i = left-1; // i는 정렬을 해야하는 부분의 왼쪽 끝보다 -1
		
		// for문을 돌리다보면 i는 pivot보다 작은 값에 위치하게 되어 있고
		// j는 계속 한 칸씩 이동한다.
		// 만약 j가 pivot보다 작으면 둘이 바꿔서 앞쪽에는 작은 값들만 모여있고 뒤에는 큰 값들만 보여있게 된다.
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) { // j가 pivot 이하이면 
				i++; // i를 1 증가하고 
				int tmp = arr[i]; // i와 j의 값을 바꿈
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		// 정렬이 다 끝나고 나면
		// 작은 값들이 모여있는 i까지의 구간에서 i+1에 피벗을 넣어준다.
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		return i + 1;
		
	}
}

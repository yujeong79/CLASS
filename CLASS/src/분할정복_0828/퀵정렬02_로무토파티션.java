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
		int pivot = arr[right];
		int i = left-1;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		return i + 1;
		
	}
}

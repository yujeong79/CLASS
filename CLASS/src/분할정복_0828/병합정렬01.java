package 분할정복_0828;

import java.util.Arrays;

public class 병합정렬01 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	// left : 구간의 시작 위치, right : 구간의 끝
	static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left+right)/2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
		merge(left, mid, right);
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 시작 포인트
		int R = mid+1; // 오른쪽 구간의 시작 포인트
		
		int idx = left; // tmp 배열의 인덱스
		
		while(L <= mid && R <= right) { // 가운데 mid를 중심으로 아직 왼쪽도 왼쪽 구간 끝에 도달하지 못했고, 오른쪽도 오른쪽 구간의 끝에 도달하지 않았다는 의미, 정렬할 것이 남아있다는 의미
			if(arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++]; // idx에 arr[L]을 넣고 idx와 L을 1씩 증가
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		
		// 한쪽 구간은 이제 정렬할 원소가 없으면 다른 구간 다 털기
		// 왼쪽 구간의 값이 남았어!
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else { // 오른쪽 구간의 값이 남았어!
			for(int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		// 원본 배열에 반영하자
		for(int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
}


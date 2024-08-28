package 분할정복_0828;

import java.util.Arrays;

public class 이진검색02_재귀 {
	
	static int[] arr = {9, 88, 17, 21, 8, 23, 35, 369};
	static int key = 19; // 찾고자 하는 값
	
	
	public static void main(String[] args) {
		
		Arrays.sort(arr); // 이진 탐색은 무조건 정렬된 배열에서만 사용!
		System.out.println(binarySearch(0, arr.length-1));
		
		// 그런데 사실~ Arrays 안에 binarySearch 메소드가 이미 있어~
		Arrays.binarySearch(arr, 0); // 배열과 key 값을 넘겨주면 반환해줘
	}
	
	static boolean binarySearch(int left, int right) {
		if(left > right) return false; // 교차가 되는 순간 못 찾은거니까 더 이상 하지마!!!
		
		int mid = (left+right)/2;
		// 같다면
		if(arr[mid] == key) return true;
		// 중앙값이 더 크다면
		else if(arr[mid] > key) 
			return binarySearch(left, mid-1);
		// 중앙값이 더 작다면
		else
			return binarySearch(mid+1, right);
	}
}

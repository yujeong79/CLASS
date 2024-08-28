<<<<<<< HEAD
package 분할정복_0828;

import java.util.Arrays;

public class 이진검색01_반복 {
	public static void main(String[] args) {
		int[] arr = {9, 88, 17, 21, 8, 23, 35, 369};
		
		Arrays.sort(arr); // 이진 탐색은 무조건 정렬된 배열에서만 사용!
		
		System.out.println(binarySearch(arr, 19));
	}
	
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) { // left와 right가 겹치면 봐야하는 요소가 하나만 남은거지
			int mid = (left+right) / 2; // 만약 left와 right가 11억이면 int형 mid에 못 담겨서 운이 안좋으면 값이 잘못 나올 수 있음
			
			if(arr[mid] == key)
				return true;
			else if(arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}
}
=======
package 분할정복_0828;

import java.util.Arrays;

public class 이진검색01_반복 {
	public static void main(String[] args) {
		int[] arr = {9, 88, 17, 21, 8, 23, 35, 369};
		
		Arrays.sort(arr); // 이진 탐색은 무조건 정렬된 배열에서만 사용!
		
		System.out.println(binarySearch(arr, 19));
	}
	
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) { // left와 right가 겹치면 봐야하는 요소가 하나만 남은거지
			int mid = (left+right) / 2; // 만약 left와 right가 11억이면 int형 mid에 못 담겨서 운이 안좋으면 값이 잘못 나올 수 있음
			
			if(arr[mid] == key)
				return true;
			else if(arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}
}
>>>>>>> branch 'main' of https://github.com/yujeong79/CLASS.git

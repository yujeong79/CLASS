package 분할정복_0828;

public class 병합정렬01 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		
	}
	
	// left : 구간의 시작 위치, right : 구간의 끝
	static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int mid = (left+right)/2;
		mergeSort(left, mid);
		mergeSort(mid+1, right);
	}

}

package 과목평가5회차.src.과목평가5회차;

/**
 * 1) 병합 정렬의 pseudocode 또는 java 코드를 작성하시오.
 */

import java.util.Arrays;

public class Algo3_서울_11반_김유정 {
	private static int[] nums = {6, 8, 1, 10, 3, 5, 7, 4, 9, 2}; // 정렬하고자 하는 배열
	private static int[] temp = new int[nums.length]; // 병합 정렬을 위한 임시 배열

	public static void main(String[] args) {
		mergeSort(0, nums.length-1); // 병합 정렬 메소드 호출
		
		System.out.println(Arrays.toString(nums)); // 오름차순으로 정렬된 배열 호출
	}

	/**
	 * 병합 정렬 메소드
	 * @param left : 정렬하고자 하는 구간의 가장 왼쪽 인덱스
	 * @param right : 정렬하고자 하는 구간의 가장 오른쪽 인덱스
	 */
	private static void mergeSort(int left, int right) { 
		if(left >= right) return; // left >= right가 되면 더 이상 정렬할 수가 없다는 뜻이므로 return 
		
		int mid = (left+right)/2; // 정렬하고자 하는 구간의 가운데 인덱스를 저장
		mergeSort(left, mid); // 가운데 인덱스를 기준으로 왼쪽 구간을 병합 정렬
		mergeSort(mid+1, right); // 가운데 인덱스를 기준으로 오른쪽 구간을 병합 정렬
		merge(left, mid, right); // mergeSort로 정렬된 왼쪽 구간과 오른쪽 구간을 병합
	}

	/**
	 * 정렬된 왼쪽 구간과 오른쪽 구간을 병합
	 * @param left : 합치고자 하는 구간의 가장 왼쪽 인덱스
	 * @param mid : 합치고자 하는 구간의 가운데 인덱스
	 * @param right : 합치고자 하는 구간의 가장 오른쪽 인덱스
	 */
	private static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 가장 왼쪽 인덱스
		int R = mid+1; // 오른쪽 구간의 가장 왼쪽 인덱스
		
		int idx = left; // 병합을 위한 임시 배열 temp의 인덱스, 초기에는 정렬하고자 하는 구간의 맨 왼쪽 인덱스로 초기화
		
		while(L <= mid && R <= right) { // 왼쪽 구간과 오른쪽 구간 모두 아직 다 정렬이 안되었으면
			if(nums[L] <= nums[R]) temp[idx++] = nums[L++]; // 왼쪽 구간의 수가 오른쪽 구간의 수보다 작으면 임시배열에 왼쪽 구간의 수를 넣고 idx와 L을 한 칸 이동
			else temp[idx++] = nums[R++]; // 오른쪽 구간의 수가 더 작으면 임시배열에 오른쪽 구간의 수를 넣고 idx와 R을 한 칸 이동
		}
		
		// 왼쪽 구간이나 오른쪽 구간 둘 중 한 구간의 정렬이 다 완료 되었으면
		// 나머지 구간의 원소를 다 털기
		
		if(L <= mid) { // 아직 왼쪽이 남았으면
			for(int i = L; i <= mid; i++) { // 남은 왼쪽 구간의 수를 다 순회하며
				temp[idx++] = nums[i]; // temp에 넣기
			}
		} else { // 아직 오른쪽이 남았으면
			for(int i = R; i <= right; i++) { // 남은 오른쪽 구간의 수를 다 순회하며
				temp[idx++] = nums[i]; // temp에 넣기
			}
		}
		
		for(int i = left; i <= right; i++) { // 정렬된 수를 임시로 저장한 완성된 temp를
			nums[i] = temp[i]; // 기존의 nums 배열에 옮기기
		}
	}
}

/**
 * 2) 병합 정렬의 특징을 아는 대로 서술하시오. (시간 복잡도, 공간 복잡도, 다른 정렬과의 비교, 구현상에 있어서의 특징 등)
 * 	병합 정렬의 시간 복잡도는 O(NlogN)이다.
 * 
 * 	병합 정렬은 정렬 시에 정렬하고자 하는 구간의 정렬된 원소를 임시로 저장할 임시 배열이 필요하다. 
 * 
 * 	다른 정렬과 비교 했을 때 병합 정렬은 평균 O(NlogN)이지만 최악에는 O(N^2)의 시간 복잡도를 보여주는 퀵 정렬과 달리 
 * 	최악의 상황에서도 시간 복잡도가 O(NlogN)이라는 점에서 최악의 상황에서도 빠르게 정렬할 수 있다는 장점이 있다.
 * 
 *  병합 정렬은 정렬하고자 하는 배열을 가운데를 기준으로 왼쪽 구간과 오른쪽 구간으로 나눌 수 없을 때까지 나눈 뒤 각 구간을 정렬하고,
 *  정렬된 왼쪽 구간과 오른쪽 구간을 다시 정렬하면서 합치는 방식으로 동작한다. 
 */


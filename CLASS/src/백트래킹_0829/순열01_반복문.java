package 백트래킹_0829;

public class 순열01_반복문 {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		
		// 중복 순열
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
				}
			}
		}
	}
}

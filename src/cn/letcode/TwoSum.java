package cn.letcode;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={1,2, 7,8, 11, 15};
		int[]  result=twoSum(array, 26);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] nums, int target) {

		int a, b;

		int[] twoSum = new int[2];

		for (int i = 0; i < nums.length-1; i++) {

			a = target - nums[i];

			if (a != nums[i]) {

				for (int j=i+1; j < nums.length; j++) {

					if (a == nums[j]) {

						twoSum[0] = nums[i];

						twoSum[1] = nums[j];

					}

				}

			}

		}

		return twoSum;

	}
}

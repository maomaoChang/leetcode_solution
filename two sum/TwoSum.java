/**
 * 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

	Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].

 */

public class TwoSum{
	public static void main(String[] args) {
		int[] arr = {6,3,4,8,9,1,2,11,13};

		int TargetNum = 12;

		Sum ts = new Sum();

		ts.twoSum(arr,TargetNum);
	}	
}

class Sum {

	Sum(){	}

    public int[] twoSum(int[] nums, int target) {
        int i,j=0;
		int L = nums.length;
		int[] ans = new int[2];
		for(i=0;i<L-1;i++){
			for(j=i+1;j<L;j++){
				if(nums[i]+nums[j]==target){
					ans[0]=i;
					ans[1]=j;
				}
						
			}
		}
		//打印输出调试
		System.out.print("Answers are: ");
		for(int k = 0; k < ans.length; k++){
			System.out.print(ans[k] + "  ");
		}
		return ans;
    }
}
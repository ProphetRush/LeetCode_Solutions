/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

package com.company;

public class L_53_maxSubArray {


    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum<0) sum=nums[i];
            else sum += nums[i];
            if(sum>maxSum ){
                maxSum = sum;
            }

        }
        return maxSum;
    }
	//update maxSum when sum is greater.
	//Accepted, 14ms

    public static void main(String[] args) {
	// write your code here
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}

/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

*/

package com.company;
import java.util.List;

public class Main L_26_removeDuplicates{


    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int len = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]>nums[len-1]){
                nums[++len-1] = nums[i+1];
            }
        }
        return len;
    }
	//Accepted, 13ms
	//Insertion, because this array is sorted, so we can simply loop while read a new number than put it on the front.

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        System.out.println(removeDuplicates(arr));
    }
}

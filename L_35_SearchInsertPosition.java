/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0*/


class L_35_SearchInsertPosition {
    
	public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=target) return i;
        }
        return nums.length;
    }
	//Direct iteractive the search
	
	public int searchInsert(int[] nums, int target) {
        int key = Arrays.binarySearch(nums, target);
        if(key < 0) key = -(key+1);
        return key;
    }
	//Using Binary Search
}
/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class L_1_TwoSum {

    //Basic way using iteration twice

    public int[] twoSum_basic(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j] == target){
                    int[] arr = {i,j};
                    return arr;
                }
            }
        }
        return null;
    }
    //Accepted 41ms




    //use a hashmap to store the difference between target and nums[i], what we need is only one iteration.

    public int[] twoSum_HashMap_Difference(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> arr = new HashMap();
        for(int i=0; i<nums.length;i++){
            arr.put(target-nums[i],i);
        }
        for(int j=0; j<nums.length;j++){
            if(arr.containsKey(nums[j])){
                if(arr.get(nums[j]) == j) continue;
                result[0]=arr.get(nums[j]);
                result[1]=j;
                Arrays.sort(result);
                return result;
            }
        }
        return null;
    }
    //Accepted, 10ms


    //sorted than use two-way search to find the index
    public static int[] twoSum_sorted(int[] nums, int target) {
        int[] arrCopied = new int[nums.length];
        System.arraycopy(nums,0,arrCopied,0,nums.length);
        int[] result = new int[2];
        Map<Integer, Integer> arr = new HashMap();
        for(int i=0; i<nums.length;i++){
            arr.put(nums[i],i);
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        for(int i=0; i<nums.length-1;i++){
            if(nums[start]+nums[end] == target){
                if(!(arr.get(nums[start]) == arr.get(nums[end]))){
                    result[0] = arr.get(nums[start]);
                    result[1] = arr.get(nums[end]);
                    Arrays.sort(result);
                    return result;
                }else break;
            }else if(nums[start]+nums[end]>target){
                end = end - 1;
            }else{
                start = start +1;
            }
        }
        int s=0;
        int tmp = nums[start];
        for(; s<arrCopied.length; s++){
            if(arrCopied[s] == tmp){
                result[0]=s;
                s++;
                break;
            }
        }
        for (;s<arrCopied.length;s++){
            if(arrCopied[s] == tmp){
                result[1]=s;
                return result;
            }
        }
        return null;
    }
    //Accepted, but runtime is 13ms, more than expected.




    //Use sorted array and two-way search. arrCopied is used to save the origin array, especially the indexes,
    //Compare to above method, it cancels the operations that it has to check the map on every iterations(arr.get()).
    public static int[] twoSum_sorted_improved(int[] nums, int target) {
        int[] arrCopied = new int[nums.length];
        System.arraycopy(nums, 0, arrCopied, 0, nums.length);
        int[] result = new int[2];
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[start] + nums[end] == target) {
                result[0] = nums[start];   //use the existing result array to store the value for following search process.
                result[1] = nums[end];
                break;
            } else if (nums[start] + nums[end] > target) {
                end = end - 1;
            } else {
                start = start + 1;
            }
        }

        // if two values are equal, then we can search them in order.
        if (result[0] == result[1]) {
            for (int i = 0; i < arrCopied.length; i++) {
                if (arrCopied[i] == result[0]) {
                    result[0] = i;
                    for (int j = i+1; j < arrCopied.length; j++) {
                        if (arrCopied[j] == result[1]) {
                            result[1] = j;
                            return result;
                        }
                    }
                }
            }

        } else {
            //Here are two circumstances, one is the result[0] in arrCopied is on the left of result[1]'s, one is  on the right
            //so if both value are being changed then the searching process is done, return result array.
            boolean change0 = false;
            boolean change1 = false;
            for (int i = 0; i < arrCopied.length; i++) {

                if (arrCopied[i] == result[0]) {
                    result[0] = i;
                    change0 = true;
                }
                if (arrCopied[i] == result[1]) {
                    result[1] = i;
                    change1 = true;
                }
                if (change0&&change1) return result;
            }
        }
        return null;
    }
    //Accepted, 5ms, beyond 99.55% java submissions?


//    public static void main(String[] args) {
//        int[] arr = {1,3,2,3};
//        int[] arr = {3,3};
//        int[] arr = {3,2,4}
//        int[] i = twoSum_sorted_improved(arr,6);
//    }


}
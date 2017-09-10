/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

*/

public int climbStairs(int n) {
        if (n > 2) {
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 2;
            for(int i=2; i<n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            return arr[n-1];
        }else{
            return n;
        }
    }
	
	//This problem can treat as Fibonacci list using DP.
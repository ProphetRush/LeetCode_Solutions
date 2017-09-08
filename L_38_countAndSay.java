/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"
*/

package com.company;

public class L_38_countAndSay {


    public static String countAndSay(int n) {
        if (n==1) return "1";
        String start = "11";
        int count = 1;
        for (int i = 0; i < n-2; i++) {
            char[] arr = start.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < start.length()-1; j++) {
                if(arr[j] == arr[j+1]){
                    count++;
                }else{
                    sb.append(count).append(arr[j]);
                    count = 1;
                }
            }
            sb.append(count).append(arr[arr.length-1]);
            start = sb.toString();
            count=1;
        }
        return start;
    }

    //NOTE: For string data types, use StringBuilder instead of +, and use toCharArray() instead of String.charAt,
    //Optimize the runtime from 38ms to 5ms

    public static void main(String[] args) {
	// write your code here
        System.out.println(countAndSay(5));
    }
}

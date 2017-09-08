/*Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

*/

package com.company;

import java.util.ArrayList;

public class L_9_isPalindrome {

    public static boolean isPalindrome(int x) {
        String str = x + "";
        StringBuilder num = new StringBuilder(str);
        return str.equals(num.reverse().toString());
    }
    //Accepted, 203ms


    //first reverse the number then directly compare to numbers
    public static boolean isPalindrome2(int x) {
        if(x<0) return false;
       int rx=0;
       int temp = x;
       while(temp!=0){
           rx = rx*10 + temp%10;
           temp = temp/10;
       }
       return rx == x;

    }
    //Accepted, 179ms

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12321));
    }
}

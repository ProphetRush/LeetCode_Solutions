/*Implement strStr().


Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.
*/





package com.company;

public class L_28_Implenment_strStr {


    public static int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        char[] str = needle.toCharArray();
        char[] STR = haystack.toCharArray();
        int index = -1;
        for (int i = 0; i <= STR.length-str.length; i++) {
            if(str[0] == STR[i]){
                index = i;
                for (int j = 1; j < str.length; j++) {
                    if(str[j] != STR[i+j]){
                        index = -1;
                    }
                }
                if(index!=-1) return index;
            }
        }
        return index;
    }
	//Accepted, 8ms, compare str and STR while read the first str char in STR, when not equal then reset index to -1;
	
	//Use the package inside java may let the code short and, elegent?
	public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
	
	//or we don't use toCharArrayArray(), use substring instead of it.
	public int strStr3(String haystack, String needle) {
        int s1 = haystack.length();
        int s2 = needle.length();
        
        for (int i=0; i<s1-s2+1; i++) {
            if (haystack.substring(i, i+s2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

	//The overall runtime of this 3 way is all short.
	
    public static void main(String[] args) {
	// write your code here
        System.out.println(strStr("", ""));
    }
}

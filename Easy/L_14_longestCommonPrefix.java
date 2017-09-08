//Write a function to find the longest common prefix string amongst an array of strings.

package com.company;

public class Main {

    public static String longestCommonPrefix(String[] strs) {
        float f = -412;
        System.out.println(f);
        int shortest = 0;
        if(strs.length > 0){
            for (int i = 0; i < strs.length; i++) {
                if(strs[i].length() < strs[shortest].length()) shortest=i;
            }
            for (int i = strs[shortest].length(); i > 0; i--) {    //using the shortest string as the maximum possible prefix, if not match then shorten the prefix from the end.
                boolean match = true;                              //The status variable, store the status that if this prefix is match, if it still match then it means it is the longest common prefix
                String prefix = strs[shortest].substring(0,i);     //The use of substring to solve prefix problem
                for (int j = 0; j < strs.length; j++) {
                    if(!strs[j].startsWith(prefix)) {
                        match = false;
                        break;
                    }
                }
                if(match) return prefix;
            }
        }else {
            return "";
        }
        return "";
    }
    //Accepted, 9ms
    public static void main(String[] args) {
        String[] strs = {"a","b"};
        System.out.println(longestCommonPrefix(strs));

        // write your code here
    }
}

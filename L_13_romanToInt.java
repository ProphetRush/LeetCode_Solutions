/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

package com.company;

import java.util.HashMap;
import java.util.Map;

public class L_13_romanToInt {


    public static int romanToInt(String s) {

        Map r = new HashMap();
        r.put('I', 1);
        r.put('V', 5);
        r.put('X', 10);
        r.put('L', 50);
        r.put('C', 100);
        r.put('D', 500);
        r.put('M', 1000);

        char[] c = s.toCharArray();
        int num = 0;
        for (int i = 0; i < c.length; i++) {
            if (i == c.length-1) num = num + ((int) r.get(c[i]));
            else{
                if((int) r.get(c[i+1])<=(int) r.get(c[i])) num = num + ((int) r.get(c[i]));
                else {
                    num = num + ((int) r.get(c[i+1])) - ((int) r.get(c[i]));
                    i++;
                }
            }

        }
        return num;

    }
    //Accepted, 103ms



    public static void main(String[] args) {
	// write your code here
        System.out.println(romanToInt("MMMDLXXXVI"));

    }
}

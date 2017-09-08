/*Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
 
 
class L_7_ReverseInteger {

    //first version of answer, traditional mathematical way
    public static int reverse(int x) {
        int sum=0;
        long result;
        boolean isNegative = false;
        if(x<0){
            x=-x;
            isNegative = true;
        }
        while(x>=10){
            sum = sum*10 + x%10;
            x /= 10;
            
        }
        result =  isNegative ? -(((long) sum)*10 +x) : ((long) sum)*10+x;
        if(result<0x80000000 || result>0x7fffffff) return 0;
        return ((int) result);
        
    }
    //Accepted, 42ms

    //StringBuffer way, but cost is too high
    public static int reverse_string(int x){
        if(x==0x80000000) return 0;
        int x_org =x;
        if (x<0)
            x=(-x);

        StringBuffer num = new StringBuffer(Integer.toString(x));
        String tmp = num.reverse().toString();
        long resultTmp = Long.parseLong(tmp);
        if(resultTmp<0x80000000 || resultTmp>0x7fffffff) return 0;
        return x_org>=0 ? ((int) resultTmp) : -((int) resultTmp);


    }
    //Accepted, 69ms


//Just improve some redundant procedure
    public static int reverse_improve(int x) {
        long result=0;
        int tmp = Math.abs(x);
        while(tmp>0){
            result = result*10;
            result = result + tmp%10;
            tmp /= 10;
            if(result>Integer.MAX_VALUE) return 0;
        }
        return (int)(x>=0 ? result : -result);
    }
//Accepted, and runtime is reduced to 36ms, beats 93.03 submissions?


//    public static void main(String[] args) {
//        System.out.println(reverse_improve(123));
//    }
}
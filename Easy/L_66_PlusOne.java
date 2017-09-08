/*Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

*/


class L_66_PlusOne{
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9){
            digits[digits.length-1]++;
            return digits;
        }else{
            for(int i=digits.length-1; i>=0; i--){
                if(digits[i]==9){
                    digits[i] = 0;
                }else{
                    digits[i]++;
                    return digits;
                }
            }
        }
        if(digits[0] == 0){
            int[] arr = new int[digits.length+1];
            arr[0]=1;
            System.arraycopy(digits,0,arr,1,digits.length);
            return arr;
        }
        return digits;
    }
}
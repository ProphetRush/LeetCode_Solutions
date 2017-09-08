public class L_67_AddBinary {

    public static String addBinary(String a, String b) {
        int[] aa = new int[a.length()];
        int[] bb = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            aa[i] = a.charAt(i)-'0';
        }
        for (int i = 0; i < b.length(); i++) {
            bb[i] = b.charAt(i)-'0';
        }
        int carry = 0, alen = aa.length, blen = bb.length, len = alen>blen?alen:blen, sum=0;
        int[] result = new int[len];

        while(alen>0 || blen>0){
            sum = carry+(alen>0?aa[alen---1]:0)+(blen>0?bb[blen---1]:0);
            result[len---1] = sum%2;
            carry = sum/2;
        }
        StringBuilder sb = new StringBuilder();
        if (carry!=0) {
            sb.append(carry);
        }
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
    //Accepted, 2ms. use a int carry to record the carry of the addition for each num.

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/


class L_20_ValidParentheses {
    public boolean isValid(String s) {
           Map map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        char[] str = s.toCharArray();
        if(map.get(str[0]) == null) return false;
        char[] stack = new char[str.length];
        int count=0;
        try{
            stack[0] = str[0];
            for (int i = 0; i < str.length; i++) {
                if(str[i] == ((char) map.get(stack[count]))){
                    count--;
                }else{
                    stack[++count] = str[i];
                }
            }
        }catch (Exception e){
            return false;
        }

        if(count == 0) return true;
        return false;
    }
}
//Accepted, 8ms, using stack to read and match.
//using hashmap to record the matching.
/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

class L_58_LengthOfLastWord {
    
	public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = -1;
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++){
            if(str[i] == ' ') index=i;
        }
        if(index == -1) return str.length;
        else return str.length-1-index;        
    }
	//Remember to use trim() first to eliminate the starting and endin ' '.
	
	public int lengthOfLastWord2(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
        
    }
	//Using inner package, lastIndexOf().
}
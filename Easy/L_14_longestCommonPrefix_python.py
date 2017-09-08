class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        s = ''
        shortest = 0
        if len(strs) > 0 and strs[0] != '':
            for m in range(len(strs)):
                if len(strs[m]) < len(strs[shortest]):
                    shortest = m
            for i in range(len(strs[shortest])):
                for j in range(len(strs) - 1):
                    if strs[j][i] != strs[j+1][i]:
                        return s
                s = s + strs[0][i]
            return s
        else:
            return ''
#Accepted, 49ms, much longer then java


    def longestCommonPrefix2 (self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ''
        s = ''
        for i in zip(*strs):
            if len(set(i)) != 1:
                return s
            s += i[0]
        return s
    #the use of zip() and set() function， Accepted, 32ms
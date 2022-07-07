"""
problem: given a binary string s with no leading zeros, return true if s has at most one continuous interval of ones.
"""

class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        i = 0
        ones_count = 0
        ones = False
        
        while i < len(s):
            if s[i] == '1' and ones == False:
                ones = True
                ones_count += 1
            elif s[i] == '0':
                ones = False
            i += 1
        return (ones_count <= 1)
        
S = Solution()
print("input: 1001 --> " + str(S.checkOnesSegment("1001")))
print("input: 011100 --> " + str(S.checkOnesSegment("011100")))
print("input: 1011 --> " + str(S.checkOnesSegment("1011")))

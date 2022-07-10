"""
problem: You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.
"""

class Solution:
    def lastStoneWeight(self, stones):
        
        stones.sort()
        
        for i in range(len(stones)-2):
            if len(stones) < 2:
                if len(stones) > 0:
                    return stones[0]
                else:
                    return 0
            
            y = stones[-1]
            x = stones[-2]
            
            if x == y:
                stones.remove(x)
                stones.remove(y)
            else:
                stones[-1] = y-x
                stones.remove(x)
                stones.sort()
        
        if len(stones) == 1:
            return stones[0]
        
        if len(stones) == 2:
            if stones[0] == stones[1]:
                return 0
            else:
                return stones[1] - stones[0]
        
        if len(stones) == 0:
            return 0
                

def main():
    stones = [2,7,4,1,8,1]
    S = Solution()
    
    print("input: " + str(stones))
    print("last weight: " + str(S.lastStoneWeight(stones)))
    
main()

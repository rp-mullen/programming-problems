class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        # if 'D', remove next 'R'
        # if 'R', remove next 'D'
        
        # if 'RD', radiant
        # if 'DR', dire
        win = False
        
        while not win:
            for i in range(len(senate)):
                if senate[i] == 'D' and senate != 'D':
                    try:
                        index = senate.index('R')
                        senate = senate[0:index :] + senate[index+1:]
                    except:
                        return 'Dire'
                elif senate[i] == 'R' and senate != 'R':
                    try:
                        index = senate.index('D')
                        senate = senate[0:index :] + senate[index+1:]
                    except:
                        return 'Radiant'
                    
                    
                if senate == 'D':
                    win = True
                    return 'Dire'
                if senate == 'R':
                    win = True
                    return 'Radiant'

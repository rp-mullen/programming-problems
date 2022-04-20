
"""
problem: Senators are 'D'(Dire Party) or 'R' (Radiant Party). Starting in order, each senator will vote to block
the next senator of the opposite party until only one remains. That senator determines the winner of the motion. 
Determine from a string of senators which party will win.
"""
def predictPartyVictory(senate):
        win = False
        i = 0
        
        while len(senate) != 0:
            if 'R' not in senate:
                return 'Dire'
            
            if 'D' not in senate:
                return 'Radiant'
        
            if i > len(senate)-1:
                i = 0
            print(str(i) + " : " + senate )
            if senate[i] == 'D':
                # check ahead first
                if 'R' in senate[i:]:
                    index = senate[i:].index('R')
                    index = index + i
                    senate = senate[0:index :] + senate[index+1:]
                    i += 1
                else:
                    index = senate.index('R')
                    senate = senate[0:index :] + senate[index+1:]
            
            elif senate[i] == 'R':
                # check ahead first
                if 'D' in senate[i:]:
                    index = senate[i:].index('D')
                    index = index + i
                    senate = senate[0:index :] + senate[index+1:]
                    i += 1
                else:
                    index = senate.index('D')
                    senate = senate[0:index :] + senate[index+1:]
                    i += 1
                           
senate = "DDRRR"
# should be 'Dire'
print(predictPartyVictory(senate))
                

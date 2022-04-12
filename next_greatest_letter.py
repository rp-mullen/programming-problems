# problem: given a list of letters and a target, return the next greatest alphabetical character from 
# target that is an element of the list. note: the alphabet wraps around, so for ['a','b'] with a 
# target of 'z', the answer would be 'a'.

def nextGreatestLetter(self, letters: List[str], target: str) -> str:
    alpha = "abcdefghijklmnopqrstuvwxyz"
    ch = target
    ch_i = alpha.index(ch)
    found = False
    
    # traverse the wrapping alphabet until you find the included character ahead of target
    while not found:
        if alpha[ch_i] in letters and (alpha[ch_i] != target):
            found = True
            return alpha[ch_i]
        else:
            ch_i = (ch_i + 1) % 26

inpt = ['c','f','j']
target = 'a'

# test case
print(inpt)
print(target)
print("output: " + nextGreatestLetter)

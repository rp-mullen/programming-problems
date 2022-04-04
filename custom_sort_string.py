"""
problem: given a string of unique chars (order) and an input string (s), permute the characters of (s) so that
they match the order in which the chars of (order) are sorted.
"""

def customSortString(order, s):
    orderMap = {}       # create a map of ordered chars with their relative counts in the input string
    result = ""         # empty result string
    unordered = ""      # number of orderless characters
    
    for char in order:
        orderMap[char] = 0
    for ch in s:
        try:
            orderMap[ch] += 1
        except:
            unordered += ch
    
    for char in order:
        #print the duplicated chars by count according to the order map
        result += charDuplicate(char,orderMap[char])
    result += unordered
        
    return result


# given a char, produce a string of that char repeated n times        
def charDuplicate(ch,n):
    st = ""
    for i in range(n):
        st += ch
    return st


# test code
order = "hbacd"
inpt = "hdshbdhshsjhdnbcacgdfjhdbfd"
print("Input: " + inpt)
print("Order: " + order)

print(" ")

out = customSortString(order, inpt)
print("Output: " + out)

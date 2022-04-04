"""
problem: given an array of integers of size n, return the list of integers in the range [1,n] that are missing in the array.  
"""
def findMissingNumbers(nums):
    # get maximum value
    maxNum = len(nums)
    
    # range of possible inputs
    arr = [i for i in range(1,maxNum+1)]
    
    # if the array element is in the list of possible inputs,
    # remove it from that list. what's left over will be the missing elements.
    for i in range(maxNum):
        try:
            arr.remove(nums[i])
        except:
            pass
    return arr
        
testList = [1,4,3,3,2,5,7,1,2,3,4,5,6,8]
print("Input: " + str(testList))
print("Input Size: " + str(len(testList)))
print("Output: " + str(findMissingNumbers(testList)))

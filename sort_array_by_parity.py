def sortArrayByParity(nums):
    evens = []
    odds = []
    for e in nums:
        if e % 2 == 0:
            evens.append(e)
        else:
            odds.append(e)
    return evens + odds

# test
nums = [1,2,3,4,5,6,7,8,9,10]
print("input: " + str(nums))
print("output: " + str(sortArrayByParity(nums)))

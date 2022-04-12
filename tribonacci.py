# problem: find the nth element of the tribonacci sequence
#       defined by T(n+3) = T(n) + T(n+1) + T(n+2)
#       where      T(0) = 0, T(1) = 1, T(2) = 1

def tribonacci(n):
    t = []
    t.append(0)
    t.append(1)
    t.append(1)
        
    for i in range(n):
        t.append((t[-1]+t[-2]+t[-3]))
    return t[n]

# test case
n = 13
print("Term: " + str(n))
print("Value: " + str(tribonacci(n)))

"""
interview prep: solution to study guide problems
"""

def give_missing(L):
    tmp = []
    for i in range(1,1001):
        if i not in L:
            tmp.append(i)
    return tmp

L = [i for i in range(1,1001)]

L.remove(2)
L.remove(5)
L.remove(10)
L.remove(122)

#=====================================================================
# def run_rules(s) to determine whether a given string passes a set of rules.

def run_rules(s,a=""):
    digits = "0123456789"
    comparison = 100
    
    # 1. is (a) a substring of (s)?
    if a in s:
        print(a + " is a substring of " + s + "!")
    else:
        print(a + " is not a substring of " + s + ".")
    
    # 2. are there digits in the string? if so, how do they compare to a given number?
    d = ""
    for i in range(len(digits)):
        if digits[i] in s:
            d += digits[i]
    if d == "":
        print("No digits found in " + s)
    elif int(d) > comparison:
        print(d + " is greater than " + str(comparison))
    elif int(d) == comparison:
        print(d + " is equal to " + str(comparison))
    else:
        print(d + "is less than " + str(comparison))

    # 3. is the length of the string even or odd?
    if len(s)%2 == 0:
        print(s + ": length is Even!")
    else:
        print(s + ": length is Odd!")
    
s = "waldo1234"
run_rules(s,"wal")

# Determine if a string has all unique characters.
# Takeaway: use int as a bit vector to save space.

# O(n) time, O(1) space
def isAllUnique(str):
    ascii = 128
    seen = [0 for i in range(0, ascii)]
    for c in str:
        index = ord(c)
        if seen[index]:
            return False
        else:
            seen[index] = 1
    return True

# O(n) time, O(n) space
def isAllUniqueWorse(str):
    seen = set()
    for c in str:
        if seen.__contains__(c):
            return False
        else:
            seen.add(c)
    return True


if __name__ == '__main__':
    # Print shit
    print "Determines whether a string is all unique characters"
    while True:
        print "Input string: "
        strIn = raw_input()
        # print "received: ", strIn
        result1 = isAllUnique(strIn)
        result2 = isAllUniqueWorse(strIn)
        assert result1 == result2
        print "Result: ", result1
        print



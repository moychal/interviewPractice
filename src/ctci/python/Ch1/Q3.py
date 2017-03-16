# Decide if one string is a permutation of the other

def isPermutation(str1, str2):
    ascii = 128 # assume ascii, or use the size of possible chars in whatever set you're interested in
    counter = [0 for i in range(0, ascii)]
    if len(str1) != len(str2):
        return False
    for c in str1:
        index = ord(c)
        counter[index] += 1
    for c in str2:
        index = ord(c)
        counter[index] -= 1
        if counter[index] < 0:
            return False
    return True


if __name__ == '__main__':
    print "Decide if one string is a permutation of the other"
    while True:
        print "Input string: "
        strIn = raw_input().split()
        str1 = strIn[0]
        str2 = strIn[1]
        print "received: ", strIn
        result1 = isPermutation(str1, str2)
        print "Result: ", result1
        print
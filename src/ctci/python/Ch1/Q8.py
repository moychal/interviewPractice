# Determine if string s2 is a "rotated" substring of s1
# With 1 call to a isSubstring method
# e.g: bottlewater is a rotated substring of waterbottle
# Takeaway: isSubstring/contains -> double s1, thus if s2 is a substring it will always be in s1

def isRotatedSubstring(s1, s2):
    if (len(s1) != len(s2) or len(s1) == 0):
        return False
    bigS1 = s1 + s1
    return bigS1.__contains__(s2)





if __name__ == '__main__':
    print "Determine whether 1 string is a rotated substring of another"
    while True:
        print "Input string 1: "
        input1 = raw_input()
        print "Input string 2: "
        input2 = raw_input()
        result = isRotatedSubstring(input1, input2)
        print input2, " is a rotated substring of ", input1, " ?: ", result
        print


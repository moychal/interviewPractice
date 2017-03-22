# Replace all spaces in a string with '%20'
# Given true length of string, string has enough space to hold additional characters
# Takeaway, can't assume the string "buffer" is the perfect size.  If we do replaceSpaces, then the resulting
# string can be malformed at the front, some/all characters in the string unchanged and offset

def replaceAllSpaces(str, trueLength):
    backwardsIndex = len(str) - 1
    for i in range(0, trueLength):
        if str[trueLength - 1 - i] != ' ':
            str[backwardsIndex] = str[trueLength - 1 - i]
            backwardsIndex -= 1
        else: # is a space, replace
            str[backwardsIndex] = '0'
            str[backwardsIndex - 1] = '2'
            str[backwardsIndex - 2] = '%'
            backwardsIndex -= 3
    return str

def replaceAllSpacesCorrect(str, trueLength):
    whiteSpaceCount = 0
    for i in range(trueLength):
        if str[i] == ' ':
            whiteSpaceCount += 1
    backwardsIndex = trueLength + whiteSpaceCount * 2 - 1
    for i in range(0, trueLength):
        if str[trueLength - 1 - i] != ' ':
            str[backwardsIndex] = str[trueLength - 1 - i]
            backwardsIndex -= 1
        else: # is a space, replace
            str[backwardsIndex] = '0'
            str[backwardsIndex - 1] = '2'
            str[backwardsIndex - 2] = '%'
            backwardsIndex -= 3
    return str

if __name__ == '__main__':
    print "Replace all spaces in a string with '%20'"
    while True:
        print "Input string: "
        str = list(raw_input())
        print "True length: "
        length = int(raw_input())
        result = replaceAllSpacesCorrect(str, length)
        print "Result: ", result
        print "result as string: ", ''.join(result)
        print
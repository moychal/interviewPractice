# Basic string compression  using counts of repeated adjacent characters
# Return original string if new one is not smaller
# TODO: optimize the string concatenation

def stringCompress(input):
    prevChar = input[0]
    prevNumb = 1
    result = ""

    for i in range(1, len(input)):
        if input[i] != prevChar: # output when reach differing adjacent characters
            result = result + prevChar + str(prevNumb)
            prevChar = input[i]
            prevNumb = 1
        else: # while reaching same adjacent, jsut keep track of numbers
            prevNumb += 1
    result += prevChar + str(prevNumb)
    return result




if __name__ == '__main__':

    print "Basic string compression  using counts of repeated adjacent characters"
    while True:
        print "Input string: "
        input = list(raw_input())
        result = stringCompress(input)
        if len(result) < len(input):
            print "Result is smaller: ", result
        else:
            print "Result not smaller: ", result
        print "result as string: ", ''.join(result)
        print
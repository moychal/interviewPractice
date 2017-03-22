# Rotate a NxN matrix 90 degrees clockwise.
# In place and out of place

# Helper func to print matrix
def printMatrix(input):
    for x in input:
        print x

def createNewRotatedMatrix(input):
    size = len(input)
    newMatrix = [[None for x in range(size)] for y in range(size)]
    for row in range(size):
        for col in range(size):
            newMatrix[col][size - 1 - row] = input[row][col]
    return newMatrix


def rotateMatrixInPlace(input):
    lastEltIndex = len(input) - 1; # the N-1th index
    thickness = len(input) / 2
    for i in range(thickness): # completely turn a whole layer at a time
        for j in range(i, lastEltIndex - i): # shrinks from both sides by i
            # we are exclusive on lastEltIndex, because the first rotation in a given layer moves
            # both the first and last element of that row
            top = input[i][j]

            # top = left
            input[i][j] = input[lastEltIndex - j][i];

            # left = bot
            input[lastEltIndex - j][i] = input[lastEltIndex - i][lastEltIndex - j];

            # bot = right
            input[lastEltIndex - i][lastEltIndex - j] = input[j][lastEltIndex - i];

            # right = top
            input[j][lastEltIndex - i] = top;


if __name__ == '__main__':
    print "Rotate a NxN matrix 90 degrees clockwise."
    # input = [
    #     ["a", "b", "c"],
    #     ["d", "e", "f"],
    #     ["g", "h", "i"]
    # ]
    input = [
        ["a", "b", "c", "1"],
        ["d", "e", "f", "2"],
        ["g", "h", "i", "3"],
        ["j", "k", "l", "4"]
    ]
    # input = [
    #     ["a", "b"],
    #     ["d", "e"]
    # ]
    # input = [
    #     ["a"]
    # ]

    print "input: "
    printMatrix(input)

    result1 = createNewRotatedMatrix(input)
    rotateMatrixInPlace(input)
    print "create rotated: "
    printMatrix(result1)
    print "rotated in place: "
    printMatrix(input)

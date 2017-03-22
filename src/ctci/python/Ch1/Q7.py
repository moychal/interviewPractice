# Change a MxN matrix so that if an elt is 0, all elts in that row/column are 0
# Assume size > 1

# Helper func to print matrix
def printMatrix(input):
    for x in input:
        print x


def helpFillOutZeroes(input, row, col, ignoreThisPosit):
    # remove all in the same row
    for j in range(len(input[0])):
        if input[row][j] != 0:
            ignoreThisPosit[row][j] = True
        input[row][j] = 0
    for i in range (len(input)):
        if input[i][col] != 0:
            ignoreThisPosit[i][col] = True
        input[i][col] = 0


def fillOutZeroes(input):
    # fill the set
    ignoreThisPosit = [[False for y in range(len(input[0]))] for x in range(len(input))]
    for i in range(len(input)):
        for j in range(len(input[0])):
            if input[i][j] == 0 and not ignoreThisPosit[i][j]:
                helpFillOutZeroes(input, i, j, ignoreThisPosit)




if __name__ == '__main__':
    print "Decide if one string is a permutation of the other"
    input = [
        [0, 1, 3, 4, 5],
        [3, 5, 2, 5, 6],
        [3, 4, 0, 0, 3]
    ]
    # input = [
    #     [1, 3, 4, 56, 4],
    #     [3, 1, 3, 0, .2]
    # ]
    # input = [
    #     [0, 0, 3, 0,2],
    #     [1, 2, 0, 3, 2]
    # ]
    # input = [
    #     [0, 4]
    # ]

    print "input: "
    printMatrix(input)

    print "result: "
    fillOutZeroes(input)
    printMatrix(input)


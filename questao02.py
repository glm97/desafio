def isPartiallyPermuted(astr, bstr):
    # verify if the first letter is the same in both strings
    if(astr[0] == bstr[0]):
        # verify if the word has more than 3 letters
        if (len(astr) > 3):
            # counter to check if up to 2/3 of the word was permuted
            count = 0
            # compare each position of the strings to check if they're equal, if they're not it's because they've been permuted so we add 1 to the counter
            for i in range(len(astr)):
                if(astr[i] != bstr[i]):
                    count += 1
            if (count > 0):
                if (count < ((len(astr) * 2) / 3)):
                    partialPermutation = True
                else:
                    partialPermutation = False
            else:
                partialPermutation = False
        else:
            if(astr[1] == bstr[2]):
                partialPermutation = True
            else:
                partialPermutation = False
    else:
        partialPermutation = False
    print(partialPermutation)

print('Say something: ')
astr = input()
print('Say something: ')
bstr = input()
isPartiallyPermuted(astr, bstr)

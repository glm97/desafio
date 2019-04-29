def isPartiallyPermuted(astr, bstr):
    typo = False
    partialPermutation = False
    # We verify if the first letter and length of both strings are the same, if not, then it's not partially permuted. 
    if(astr[0] == bstr[0] and len(astr) == len(bstr)):
        # Then we check if the word has more than 3 letters.
        if (len(astr) > 3):
            # We use this counter to check if up to 2/3 of the word is permuted.
            count = 0
            # Here we verify if all the characters in the first string are in the second string by
            # rearranging a copry of the second string according to the first one.
            auxl = bstr.copy()
            for x in range(len(astr)):
                for y in range(len(auxl)):
                    if(astr[x] == auxl[y] and x != y):
                        aux = auxl[x]
                        auxl[x] = auxl[y]
                        auxl[y] = aux
            # If after the rearrangment, the lists are not equal, then it's because it's not partially permuted.
            for z in range(len(astr)):
                    if(astr[z] != auxl[z]):
                        typo = True
            if(typo != True):
                # Then we check if the word has duplicated characters.
                eq = 0
                for a in range(len(astr)):
                    for b in range(a, len(bstr)):
                        if (astr[a] == astr[b] and a != b):
                            eq += 1
                # Now we compare the first and second strings to check how many characters are out of their place.
                for i in range(len(astr)):
                    for j in range(len(bstr)):
                        if(astr[i] == bstr[j] and i != j):
                            count += 1
                # Then we set the counter value to the difference between the number of characters that were supposedly
                # misplaced and the number of duplicated characters.
                count = count - (eq * 2)    
                # Finally we check if the counter if bigger than 0 but still smaller than 2/3 of the word.
                if((count > 0) and (count < ((len(astr) * 2) / 3))):
                    partialPermutation = True
        else:
            # If the word is equal to 3 letters we check if the last 2 characters have been swapped.
            if(astr[1] == bstr[2]):
                partialPermutation = True
    print(partialPermutation)

print('Say something: ')
astr = list(input())
print('Say something: ')
bstr = list(input())
isPartiallyPermuted(astr, bstr)

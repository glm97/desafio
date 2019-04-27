def isTypo(astr, bstr):
    # First we calculate the difference between the lengths of the strings to choose which case the typo might be (case 1: replaced a character, case 2: removed a character, case 3: inserted a character).
    lenDiff = len(astr) - len(bstr)
    if((lenDiff == 0) or (lenDiff == 1) or (lenDiff == -1)):
        c = 0
        # Case 1: we compare each character at the same position in the strings and we accept if there's at most 1 different character at the same position, otherwise it's not a typo 
        if(lenDiff == 0):
            for i in range(len(astr)):
                if(astr[i] != bstr[i]):
                    c += 1
            # If the counter = 0, it's because it didn't find any mismatch between the characters of each string, so it's not a typo
            if((c > 1) or (c == 0)):
                typo = False
            else:
                typo = True
        # Case 2: we compare each character of the second string with the character at the same position in the first string, if they don't match it might be because the character at that positon in the first string might have been removed. So we compare the character at that position in the second string with the character at the next position in the first string, if they also don't match, it's not a typo. 
        if(lenDiff == 1):
            for i in range(len(bstr)):
                if(bstr[i] != astr[i]):
                    if(bstr[i] != astr[i + 1]):
                        c += 1
            if(c > 0):                
                typo = False
            else:
                typo = True
        # Case 3: we compare each character of the first string with the character at the same position in the second string. If they don't match, it might be because the character at the position in the second string was inserted. Then, we compare the character at that position in the first string with the character at the next position in the second string, if they too don't match, then it's not a typo.
        if(lenDiff == -1):
            for i in range(len(astr)):
                if(astr[i] != bstr[i]):
                    if(astr[i] != bstr[i+1]):
                        c += 1
            if(c > 0):
                typo = False
            else:
                typo = True
    else:
        typo = False
    print(typo)


print('Say something: ')
astr = input()
print('Say something: ')
bstr = input()
isTypo(astr, bstr)
        
